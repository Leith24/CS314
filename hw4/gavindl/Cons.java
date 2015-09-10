/**
 * this class Cons implements a Lisp-like Cons cell
 * 
 * @author  Gordon S. Novak Jr.
 * @version 29 Nov 01; 25 Aug 08; 05 Sep 08; 08 Sep 08; 12 Sep 08; 24 Sep 08
 *          02 Oct 09; 12 Feb 10; 04 Oct 12
 */
//Gavin Leith gdl386
interface Functor { Object fn(Object x); }

interface Predicate { boolean pred(Object x); }

public class Cons
{
    // instance variables
    private Object car;
    private Cons cdr;
    private Cons(Object first, Cons rest)
       { car = first;
         cdr = rest; }
    public static Cons cons(Object first, Cons rest)
      { return new Cons(first, rest); }
    public static boolean consp (Object x)
       { return ( (x != null) && (x instanceof Cons) ); }
// safe car, returns null if lst is null
    public static Object first(Cons lst) {
        return ( (lst == null) ? null : lst.car  ); }
// safe cdr, returns null if lst is null
    public static Cons rest(Cons lst) {
      return ( (lst == null) ? null : lst.cdr  ); }
    public static Object second (Cons x) { return first(rest(x)); }
    public static Object third (Cons x) { return first(rest(rest(x))); }
    public static void setfirst (Cons x, Object i) { x.car = i; }
    public static void setrest  (Cons x, Cons y) { x.cdr = y; }
   public static Cons list(Object ... elements) {
       Cons list = null;
       for (int i = elements.length-1; i >= 0; i--) {
           list = cons(elements[i], list);
       }
       return list;
   }

    // convert a list to a string for printing
    public String toString() {
       return ( "(" + toStringb(this) ); }
    public static String toString(Cons lst) {
       return ( "(" + toStringb(lst) ); }
    private static String toStringb(Cons lst) {
       return ( (lst == null) ?  ")"
                : ( first(lst) == null ? "()" : first(lst).toString() )
                  + ((rest(lst) == null) ? ")" 
                     : " " + toStringb(rest(lst)) ) ); }

    public static int square(int x) { return x*x; }

    // iterative destructive merge using compareTo
public static Cons dmerj (Cons x, Cons y) {
  if ( x == null ) return y;
   else if ( y == null ) return x;
   else { Cons front = x;
          if ( ((Comparable) first(x)).compareTo(first(y)) < 0)
             x = rest(x);
            else { front = y;
                   y = rest(y); };
          Cons end = front;
          while ( x != null )
            { if ( y == null ||
                   ((Comparable) first(x)).compareTo(first(y)) < 0)
                 { setrest(end, x);
                   x = rest(x); }
               else { setrest(end, y);
                      y = rest(y); };
              end = rest(end); }
          setrest(end, y);
          return front; } }

public static Cons midpoint (Cons lst) {
  Cons current = lst;
  Cons prev = current;
  while ( lst != null && rest(lst) != null) {
    lst = rest(rest(lst));
    prev = current;
    current = rest(current); };
  return prev; }

    // Destructive merge sort of a linked list, Ascending order.
    // Assumes that each list element implements the Comparable interface.
    // This function will rearrange the order (but not location)
    // of list elements.  Therefore, you must save the result of
    // this function as the pointer to the new head of the list, e.g.
    //    mylist = llmergesort(mylist);
public static Cons llmergesort (Cons lst) {
  if ( lst == null || rest(lst) == null)
     return lst;
   else { Cons mid = midpoint(lst);
          Cons half = rest(mid);
          setrest(mid, null);
          return dmerj( llmergesort(lst),
                        llmergesort(half)); } }


    // ****** your code starts here ******
    // add other functions as you wish.

public static Cons union (Cons x, Cons y) {
	x=llmergesort(x);
	y=llmergesort(y);
	return mergeunion(x,y);
}

    // following is a helper function for union
public static Cons mergeunion (Cons x, Cons y) {
	if(x==null) return y;
	else if(y==null) return x;
	else if(first(x).equals(first(y))){
		return cons(first(x), mergeunion(rest(x),rest(y)));
	}
	else if(((Comparable)first(x)).compareTo(first(y))<0){
		return cons(first(x),mergeunion(rest(x),y));		}
	else{
		return cons(first(y),mergeunion(x,rest(y)));
	}
}

public static Cons setDifference (Cons x, Cons y) {
	x=llmergesort(x);
	y=llmergesort(y);
	return mergediff(x,y);
}

    // following is a helper function for setDifference
public static Cons mergediff (Cons x, Cons y) {
	if(x==null||y==null) return null;
	else if(first(x).equals(first(y))){
		return mergediff(rest(x),rest(y));
	}
	else{
		return cons(first(x),mergediff(rest(x),y));
	}
}

public static Cons bank(Cons accounts, Cons updates) {
	updates =llmergesort(updates);
	System.out.println("sorted updates = "+updates);
	return bankb(accounts, updates);
}

public static Cons bankb(Cons accounts, Cons updates){
	if(updates==null) return accounts;
	int amnt =0;
	if(assoc((((Account)first(updates)).name()),accounts)==null){
		Account z = (Account) first(updates);
		amnt = z.amount();
		if(amnt<0){
			System.out.println("No account "+z.name()+" "+amnt);
			return bankb(accounts,rest(updates));
		}
		else{
			System.out.println("New account "+z.name()+" "+amnt);
			Account acc = new Account(z.name(),amnt);
			return cons(acc,bankb(accounts,rest(updates)));			
		}
	}
	else{
		Account x = (Account)first(accounts);
		amnt = x.amount();
		if(x.name().equals(((Account)first(updates)).name())){
		while(updates!=null&&(x.name().equals(((Account)first(updates)).name()))){
			Account y = (Account)first(updates);
			amnt+=y.amount();
			if(amnt<0){
				amnt=amnt-30;
				System.out.println("Overdraft "+x.name()+" "+amnt);
			}
			updates=rest(updates);
			}	
		}
		Account acc=new Account(x.name(),amnt);
		return llmergesort(cons(acc,bankb(rest(accounts),updates)));
	}
}

public static Object assoc(Object key, Cons lst){
	if(lst==null) return null;
	else if (key.equals(((Account)first(lst)).name())){
		return (first(lst));
	}
	else return assoc(key,rest(lst));
}

public static String [] mergearr(String [] x, String [] y) {	
	String[] arr = new String[x.length+y.length];
	return mergearrb(x,y,arr,0,0,0);
}
public static String[] mergearrb(String [] x, String [] y, String [] arr, int i, int j,int k){
	if(k>=arr.length) return arr;
	else if (i>=x.length){
		arr[k]=y[j];
		return mergearrb(x,y,arr,i,j+1,k+1);
	}
	else if(j>=y.length){
		arr[k]=x[i];
		return mergearrb(x,y,arr,i+1,j,k+1);
	}
	if(x[i].compareTo(y[j])<0){
		arr[k]=x[i];
		return mergearrb(x,y,arr,i+1,j,k+1);
	}
	else if(x[i].compareTo(y[j])>0){
		arr[k]=y[j];
		return mergearrb(x,y,arr,i,j+1,k+1);
	}
	else{
		arr[k]=x[i];
		arr[++k]=y[j];
		return mergearrb(x,y,arr,i+1,j+1,k+2);
	}
}

public static boolean markup(Cons text) {
	boolean okay = true;
	Cons lst = reverse(tester(text));
	Stack mystack = new Stack(lst);
//	mystack.push("asdf");
//	System.out.println("Pushed \"asdf\" popped: "+mystack.pop());
	okay = balanceTester(mystack,lst,false);
	return okay;
}

public static Cons tester(Cons text){
	String s = (String) first(text);
	if(text==null) return null;
	if(s.startsWith("<")){
		return cons(s,tester(rest(text)));
	}
	return tester(rest(text));
}

static class Stack{
	Cons lst;
	
	public Stack(Cons mylst){
		lst=mylst;
	}
	public Stack(){
		lst=null;
	}
	public void push(String s){
		lst=cons(s,lst);
	}
	public String pop(){
		String s = (String)first(lst);
		lst=rest(lst);
		return s;
	}
	public boolean isEmpty(){
		return(lst==null);
	}
}

public static boolean balanceTester(Stack mystack,Cons lst,boolean okay){
	
	if(mystack.isEmpty()){
		return okay;
	}
	Stack stack = new Stack(lst);
	String s = mystack.pop();
//	System.out.println("first String "+s);
	while(mystack.isEmpty()==false&&s.startsWith("</")){
		String r = mystack.pop();
		if(r==null) break;
	//	System.out.println("Second string "+r);
		if(s.substring(2,s.length()-1).compareTo(r.substring(1,r.length()-1))!=0){
			okay=false;
		}
		else{
			okay=true;
			break;
		}
	}
	if(okay){
		stack.pop();
		return balanceTester(stack,rest(lst),okay);
	}
	else{
		System.out.println("Bad tag "+s);
		return false;
	}
}


public static Cons reverse(Cons lst){
	Cons answer = null;
	for(;lst!=null;lst=rest(lst)){
	answer=cons(first(lst),answer);
	}
	return answer;
}

    // ****** your code ends here ******

    public static void main( String[] args )
      { 
        Cons set1 = list("d", "b", "c", "a");
        Cons set2 = list("f", "d", "b", "g", "h");
        System.out.println("set1 = " + Cons.toString(set1));
        System.out.println("set2 = " + Cons.toString(set2));
        System.out.println("union = " + Cons.toString(union(set1, set2)));

        Cons set3 = list("d", "b", "c", "a");
        Cons set4 = list("f", "d", "b", "g", "h");
        System.out.println("set3 = " + Cons.toString(set3));
        System.out.println("set4 = " + Cons.toString(set4));
        System.out.println("difference = " +
                           Cons.toString(setDifference(set3, set4)));

        Cons accounts = list(
               new Account("Arbiter", new Integer(498)),
               new Account("Flintstone", new Integer(102)),
               new Account("Foonly", new Integer(123)),
               new Account("Kenobi", new Integer(373)),
               new Account("Rubble", new Integer(514)),
               new Account("Tirebiter", new Integer(752)),
               new Account("Vader", new Integer(1024)) );

        Cons updates = list(
               new Account("Foonly", new Integer(100)),
               new Account("Flintstone", new Integer(-10)),
               new Account("Arbiter", new Integer(-600)),
               new Account("Garble", new Integer(-100)),
               new Account("Rabble", new Integer(100)),
               new Account("Flintstone", new Integer(-20)),
               new Account("Foonly", new Integer(10)),
               new Account("Tirebiter", new Integer(-200)),
               new Account("Flintstone", new Integer(10)),
               new Account("Flintstone", new Integer(-120))  );
        System.out.println("accounts = " + accounts.toString());
        System.out.println("updates = " + updates.toString());
        Cons newaccounts = bank(accounts, updates);
        System.out.println("result = " + newaccounts.toString());

        String[] arra = {"a", "big", "dog", "hippo"};
        String[] arrb = {"canary", "cat", "fox", "turtle"};
        String[] resarr = mergearr(arra, arrb);
        for ( int i = 0; i < resarr.length; i++ )
            System.out.println(resarr[i]);

        Cons xmla = list( "<TT>", "foo", "</TT>");
        Cons xmlb = list( "<TABLE>", "<TR>", "<TD>", "foo", "</TD>",
                          "<TD>", "bar", "</TD>", "</TR>",
                          "<TR>", "<TD>", "fum", "</TD>", "<TD>",
                          "baz", "</TD>", "</TR>", "</TABLE>" );
        Cons xmlc = list( "<TABLE>", "<TR>", "<TD>", "foo", "</TD>",
                          "<TD>", "bar", "</TD>", "</TR>",
                          "<TR>", "<TD>", "fum", "</TD>", "<TD>",
                          "baz", "</TD>", "</WHAT>", "</TABLE>" );
        Cons xmld = list( "<TABLE>", "<TR>", "<TD>", "foo", "</TD>",
                          "<TD>", "bar", "</TD>", "", "</TR>",
                          "</TABLE>", "</NOW>" );
        Cons xmle = list( "<THIS>", "<CANT>", "<BE>", "foo", "<RIGHT>" );
        Cons xmlf = list( "<CATALOG>",
                          "<CD>",
                          "<TITLE>", "Empire", "Burlesque", "</TITLE>",
                          "<ARTIST>", "Bob", "Dylan", "</ARTIST>",
                          "<COUNTRY>", "USA", "</COUNTRY>",
                          "<COMPANY>", "Columbia", "</COMPANY>",
                          "<PRICE>", "10.90", "</PRICE>",
                          "<YEAR>", "1985", "</YEAR>",
                          "</CD>",
                          "<CD>",
                          "<TITLE>", "Hide", "your", "heart", "</TITLE>",
                          "<ARTIST>", "Bonnie", "Tyler", "</ARTIST>",
                          "<COUNTRY>", "UK", "</COUNTRY>",
                          "<COMPANY>", "CBS", "Records", "</COMPANY>",
                          "<PRICE>", "9.90", "</PRICE>",
                          "<YEAR>", "1988", "</YEAR>",
                          "</CD>", "</CATALOG>");
        System.out.println("xmla = " + xmla.toString());
        System.out.println("result = " + markup(xmla));
        System.out.println("xmlb = " + xmlb.toString());
        System.out.println("result = " + markup(xmlb));
        System.out.println("xmlc = " + xmlc.toString());
        System.out.println("result = " + markup(xmlc));
        System.out.println("xmld = " + xmld.toString());
        System.out.println("result = " + markup(xmld));
        System.out.println("xmle = " + xmle.toString());
        System.out.println("result = " + markup(xmle));
        System.out.println("xmlf = " + xmlf.toString());
        System.out.println("result = " + markup(xmlf));

      }

}

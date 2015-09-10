/**
 * this class Cons implements a Lisp-like Cons cell
 * 
 * @author  Gordon S. Novak Jr.
 * @version 29 Nov 01; 25 Aug 08; 05 Sep 08; 08 Sep 08; 12 Sep 08; 16 Feb 09
 *          01 Feb 12; 08 Feb 12; 22 Sep 13; 26 Dec 13
 */
//Gavin Leith gdl386
interface Functor { Object fn(Object x); }

interface Predicate { boolean pred(Object x); }

public class Cons
{
    // instance variables
    private Object car;   // traditional name for first
    private Cons cdr;     // "could-er", traditional name for rest
    private Cons(Object first, Cons rest)
       { car = first;
         cdr = rest; }

    // Cons is the data type.
    // cons() is the method that makes a new Cons and puts two pointers in it.
    // cons("a", null) = (a)
    // cons puts a new thing on the front of an existing list.
    // cons("a", list("b","c")) = (a b c)
    public static Cons cons(Object first, Cons rest)
      { return new Cons(first, rest); }

    // consp is true if x is a Cons, false if null or non-Cons Object
    public static boolean consp (Object x)
       { return ( (x != null) && (x instanceof Cons) ); }

    // first returns the first thing in a list.
    // first(list("a", "b", "c")) = "a"
    // safe, first(null) = null
    public static Object first(Cons lst) {
        return ( (lst == null) ? null : lst.car  ); }

    // rest of a list after the first thing.
    // rest(list("a", "b", "c")) = (b c)
    // safe, rest(null) = null
    public static Cons rest(Cons lst) {
      return ( (lst == null) ? null : lst.cdr  ); }

    // second thing in a list
    // second(list("+", "b", "c")) = "b"
    public static Object second (Cons x) { return first(rest(x)); }

    // third thing in a list
    // third(list("+", "b", "c")) = "c"
    public static Object third (Cons x) { return first(rest(rest(x))); }

    // destructively change the first() of a cons to be the specified object
    // setfirst(list("a", "b", "c"), 3) = (3 b c)
    public static void setfirst (Cons x, Object i) { x.car = i; }

    // destructively change the rest() of a cons to be the specified Cons
    // setrest(list("a", "b", "c"), null) = (a)     
    // setrest(list("a", "b", "c"), list("d","e")) = (a d e)
    public static void setrest  (Cons x, Cons y) { x.cdr = y; }

    // make a list of the specified items
    // list("a", "b", "c") = (a b c)
    // list() = null
   public static Cons list(Object ... elements) {
       Cons list = null;
       for (int i = elements.length-1; i >= 0; i--) {
           list = cons(elements[i], list);
       }
       return list;
   }

    // convert a list to a string in parenthesized form for printing
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

    // ****** your code starts here ******


    // add up elements of a list of numbers
public static int sum (Cons lst) {
	if(lst==null){
		return 0;
	}
	else{
		return (Integer) first(lst)+sum(rest(lst));
	}
}

    // mean = (sum x[i]) / n  
public static double mean (Cons lst) {
	double sum=0;
	int n =0;
	while(lst!=null){
		sum+=(Integer)first(lst);
		n++;
		lst=rest(lst);
	}
	return sum/n;
}

    // square of the mean = mean(lst)^2  

    // mean square = (sum x[i]^2) / n  
public static double meansq (Cons lst) {
	double sum = 0;
	int n = 0;
	double x = 0;
	while (lst!=null){
		x = (Integer) first(lst);
		x= x*x;
		sum+=x;
		n++;
		lst=rest(lst);
	}
	return sum/n;
}

public static double variance (Cons lst) {
	double meansq = meansq(lst);
	double sqmean = mean(lst)*mean(lst);
	return meansq-sqmean;
}

public static double stddev (Cons lst) {
	return Math.sqrt(variance(lst));
}

public static double sine (double x) {
	return sineb(x,1);
}

public static double sineb (double x, int factoral){
	double sum =0.0;
	for(int num=1;factoral<=21;num++){
		if(num%2==0){
			sum-=(Math.pow(x,factoral))/factor(factoral);
		}
		else{
			sum+=(Math.pow(x,factoral))/factor(factoral);
		}
		factoral+=2;	
	}
	return sum;
	
}

public static int factor(int x){
	if(x==1){
		return 1;
	}
	return x*(factor(x-1));
}

public static Cons nthcdr (int n, Cons lst) {
	if(n>length(lst)){
		return null;
	}
	else
		return nthcdrb(n,lst,0);
}

public static Cons nthcdrb(int n, Cons lst, int current){
	if(current==n){
		return lst;
	}
	else{
		return lst=nthcdrb(n,rest(lst),current+1);
	}
}

public static int length( Cons arg){
	int n =0;
	for(Cons lst=arg; lst!=null;lst=rest(lst)){
		n++;
	}
	return n;
}

public static Object elt (Cons lst, int n) {
	for(int i =0;i<n;i++){
		lst=rest(lst);
	}
	return first(lst);
}

public static double interpolate (Cons lst, double x) {
	if(x%1.0==0){
		return (double) elt(lst, (int)x);
	}
	else{
		return (Integer) elt(lst,(int)(x/1.0))+((x%1.0)*((Integer)elt(lst,(int)(x+1))-(Integer)elt(lst,(int)x)));
	}
}

public static int sumtr (Cons lst) {
	if(lst==null){
		return 0;
	}		
	if(consp(first(lst))){
		return sumtrb((Cons)first(lst))+sumtr(rest(lst));
	}
	return (Integer)first(lst)+sumtr(rest(lst));
}
public static int sumtrb(Cons lst){
	if(lst==null){
		return 0;
	}
	if(consp(first(lst))){
	//	System.out.println(rest(lst));
		return sumtrb((Cons)first(lst))+sumtrb(rest(lst));
	}
	else{	
		return (Integer)first(lst)+ sumtrb(rest(lst));
	}
}

    // use auxiliary functions as you wish.
public static Cons subseq (Cons lst, int start, int end) {
	Cons lstb = null;
	for(int i =end-1;i>=start;i--){
		lstb=cons(elt(lst,i),lstb);
	}
	return lstb;
}

public static Cons posfilter (Cons lst) {
	Cons lstb = null;
	return reverse(posfilterb(lst, lstb));	
}

public static Cons posfilterb (Cons lst, Cons lstb){
	if(lst==null){
		return lstb;
	}
	if((Integer)first(lst)>=0){
		lstb=cons(first(lst),lstb);
	}
	return posfilterb(rest(lst),lstb);
}


public static Cons subset (Predicate p, Cons lst) {
	Cons lstb = null;
	return reverse(subsetb(p,lst,lstb));
}

public static Cons subsetb(Predicate p, Cons lst, Cons lstb){
	if(lst==null){
		return lstb;
	}
	else if(p.pred(first(lst))){
		lstb=cons(first(lst),lstb);
	}
	return subsetb(p,rest(lst),lstb);
}

public static Cons mapcar (Functor f, Cons lst) {
	Cons lstb = null;
	return reverse(mapcarb(f,lst,lstb));
}

public static Cons mapcarb (Functor f, Cons lst, Cons lstb){
	if(lst==null){
		return lstb;
	}
	else{
		lstb=cons(f.fn(first(lst)),lstb);
		return mapcarb(f,rest(lst),lstb);
	}
}

public static Object some (Predicate p, Cons lst) {
	if(lst==null){
		return null;
	}
	if(p.pred(first(lst))==true){
		return first(lst);
	}
	else{
		return some(p,rest(lst));
	}
}
public static boolean every(Predicate p, Cons lst){
	if(lst==null){
		return true;
	}
	if(!p.pred(first(lst))){
		return false;
	}
	return every(p,rest(lst));
}
public static Cons reverse(Cons lst){
	Cons answer = null;
	for(;lst!=null;lst=rest(lst)){
		answer=cons(first(lst),answer);
	}
	return answer;
}
public static Cons binomial(int x){
	return list(1,12,66,220,495,792,924,792,495,220,66,12,1);
}

public static void main(String[] args){
        Cons mylist =list(95,72,86,70,97,72,52,88,77,94,91,79,61,77,99,70,91);
	System.out.println("sum = " + sum(mylist));
        System.out.println("mean = " + mean(mylist));
        System.out.println("meansq = " + meansq(mylist));
        System.out.println("variance = " + variance(mylist));
        System.out.println("stddev = " + stddev(mylist));
        System.out.println("sine(0.5) = " + sine(0.5));  // 0.47942553860420301
        System.out.print("nthcdr 5 = ");
        System.out.println(nthcdr(5, mylist));
        System.out.print("nthcdr 18 = ");
        System.out.println(nthcdr(18, mylist));
        System.out.println("elt 5 = " + elt(mylist,5));

        Cons mylistb = list(0, 30, 56, 78, 96);
        System.out.println("mylistb = " + mylistb.toString());
        System.out.println("interpolate(3.4) = " + interpolate(mylistb, 3.4));
        Cons binom = binomial(12);
        System.out.println("binom = " + binom.toString());
        System.out.println("interpolate(3.4) = " + interpolate(binom, 3.4));

        Cons mylistc = list(1, list(2, 3), list(list(list(list(4)),
                                                     list(5)),
                                                6));
        System.out.println("mylistc = " + mylistc.toString());
        System.out.println("sumtr = " + sumtr(mylistc));
        Cons mylistcc = list(1, list(7, list(list(2), 3)),
                             list(list(list(list(list(list(list(4)))), 9))),
                             list(list(list(list(5), 4), 3)),
                             list(6));
        System.out.println("mylistcc = " + mylistcc.toString());
        System.out.println("sumtr = " + sumtr(mylistcc));

        Cons mylistd = list(0, 1, 2, 3, 4, 5, 6 );
        System.out.println("mylistd = " + mylistd.toString());
        System.out.println("subseq(2 5) = " + subseq(mylistd, 2, 5));

        Cons myliste = list(3, 17, -2, 0, -3, 4, -5, 12 );
        System.out.println("myliste = " + myliste.toString());
        System.out.println("posfilter = " + posfilter(myliste));

        final Predicate myp = new Predicate()
            { public boolean pred (Object x)
                { return ( (Integer) x > 3); }};

        System.out.println("subset = " + subset(myp, myliste).toString());

        final Functor myf = new Functor()
            { public Integer fn (Object x)
                { return  (Integer) x + 2; }};

        System.out.println("mapcar = " + mapcar(myf, mylistd).toString());

        System.out.println("some = " + some(myp, myliste).toString());

        System.out.println("every = " + every(myp, myliste));
      }

}

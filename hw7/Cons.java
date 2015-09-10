/**
 * this class Cons implements a Lisp-like Cons cell
 * 
 * @author  Gordon S. Novak Jr.
 * @version 29 Nov 01; 25 Aug 08; 05 Sep 08; 08 Sep 08; 12 Sep 08; 24 Sep 08
 *          06 Oct 08; 07 Oct 08; 09 Oct 08; 23 Oct 08; 27 Mar 09; 06 Aug 10
 *          30 Dec 13
 */
//Gavin Leith gdl386
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
    // access functions for expression representation
    public static Object op  (Cons x) { return first(x); }
    public static Object lhs (Cons x) { return first(rest(x)); }
    public static Object rhs (Cons x) { return first(rest(rest(x))); }
    public static boolean numberp (Object x)
       { return ( (x != null) &&
                  (x instanceof Integer || x instanceof Double) ); }
    public static boolean integerp (Object x)
       { return ( (x != null) && (x instanceof Integer ) ); }
    public static boolean floatp (Object x)
       { return ( (x != null) && (x instanceof Double ) ); }
    public static boolean stringp (Object x)
       { return ( (x != null) && (x instanceof String ) ); }

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

    public boolean equals(Object other) { return equal(this,other); }

    // tree equality
public static boolean equal(Object tree, Object other) {
    if ( tree == other ) return true;
    if ( consp(tree) )
        return ( consp(other) &&
                 equal(first((Cons) tree), first((Cons) other)) &&
                 equal(rest((Cons) tree), rest((Cons) other)) );
    return eql(tree, other); }

    // simple equality test
public static boolean eql(Object tree, Object other) {
    return ( (tree == other) ||
             ( (tree != null) && (other != null) &&
               tree.equals(other) ) ); }

// member returns null if requested item not found
public static Cons member (Object item, Cons lst) {
  if ( lst == null )
     return null;
   else if ( item.equals(first(lst)) )
           return lst;
         else return member(item, rest(lst)); }

public static Cons union (Cons x, Cons y) {
  if ( x == null ) return y;
  if ( member(first(x), y) != null )
       return union(rest(x), y);
  else return cons(first(x), union(rest(x), y)); }

public static boolean subsetp (Cons x, Cons y) {
    return ( (x == null) ? true
             : ( ( member(first(x), y) != null ) &&
                 subsetp(rest(x), y) ) ); }

public static boolean setEqual (Cons x, Cons y) {
    return ( subsetp(x, y) && subsetp(y, x) ); }

    // combine two lists: (append '(a b) '(c d e))  =  (a b c d e)
public static Cons append (Cons x, Cons y) {
  if (x == null)
     return y;
   else return cons(first(x),
                    append(rest(x), y)); }

    // look up key in an association list
    // (assoc 'two '((one 1) (two 2) (three 3)))  =  (two 2)
public static Cons assoc(Object key, Cons lst) {
  if ( lst == null )
     return null;
  else if ( key.equals(first((Cons) first(lst))) )
      return ((Cons) first(lst));
          else return assoc(key, rest(lst)); }

    public static int square(int x) { return x*x; }
    public static int pow (int x, int n) {
        if ( n <= 0 ) return 1;
        if ( (n & 1) == 0 )
            return square( pow(x, n / 2) );
        else return x * pow(x, n - 1); }

public static Cons formulas = 
    list( list( "=", "s", list("*", new Double(0.5),
                               list("*", "a",
                                list("expt", "t", new Integer(2))))),
          list( "=", "s", list("+", "s0", list( "*", "v", "t"))),
          list( "=", "a", list("/", "f", "m")),
          list( "=", "v", list("*", "a", "t")),
          list( "=", "f", list("/", list("*", "m", "v"), "t")),
          list( "=", "f", list("/", list("*", "m",
                                         list("expt", "v", new Integer(2))),
                               "r")),
          list( "=", "h", list("-", "h0", list("*", new Double(4.94),
                                               list("expt", "t",
                                                    new Integer(2))))),
          list( "=", "c", list("sqrt", list("+",
                                            list("expt", "a",
                                                 new Integer(2)),
                                            list("expt", "b",
                                                 new Integer(2))))),
          list( "=", "v", list("*", "v0",
                               list("-", new Double(1.0),
                                    list("exp", list("/", list("-", "t"),
                                                     list("*", "r", "c"))))))
          );

    // Note: this list will handle most, but not all, cases.
    // The binary operators - and / have special cases.
public static Cons opposites = 
    list( list( "+", "-"), list( "-", "+"), list( "*", "/"),
          list( "/", "*"), list( "sqrt", "expt"), list( "expt", "sqrt"),
          list( "log", "exp"), list( "exp", "log") );
public static Cons opprec = list(list("=",1),list("+",5),list("-",5),list("*",6),list("/",6));
public static void printanswer(String str, Object answer) {
    System.out.println(str +
                       ((answer == null) ? "null" : answer.toString())); }

    // ****** your code starts here ******


public static Cons findpath(Object item, Object cave) { 
//	System.out.println(first((Cons)cave)+" "+rest((Cons)cave));
	
	 if(consp(cave)){
		if(item.equals(first((Cons)cave))){
			return list("first","done");
		}
		else if (consp(first((Cons)cave))&&rest((Cons)cave)==null){
			return cons("first",findpath(item,first((Cons)cave)));
		}
		else return cons("rest",findpath(item,rest((Cons)cave)));		
	}
	else if(item.equals(cave)){
		return list("done");
	}
	else if(!(item.equals(first((Cons)cave)))&&rest((Cons)cave)!=null){
	 return cons("rest",findpath(item,rest((Cons)cave)));
	}
	else return null;
 }
public static Object follow(Cons path, Object cave) { //works
	if(first(path).equals("done")){
		return cave;
	} 
	else if(first(path).equals("first")){
		return follow(rest(path),first((Cons)cave));
	}
	else if(first(path).equals("rest")){
		return follow(rest(path),rest((Cons)cave));
	}
	else{
		return null;
	}
}

public static Object corresp(Object item, Object tree1, Object tree2) { //should work
	return follow(findpath(item,tree1),tree2);
}

public static Cons solve(Cons e, String v) {//almost done 2 equations to go
	//System.out.println(v);
	if(lhs(e)==null||rhs(e)==null) return null;
	if(lhs(e).equals(v)){
		return e;
	}
	else if(rhs(e).equals(v)){
		return list(op(e),rhs(e),lhs(e));
	}
	if(consp(rhs(e))){
		Cons lista =null;
		Cons listb=null;
		lista = list(op(e),list(lhs(assoc(op((Cons)rhs(e)),opposites)),lhs(e),lhs((Cons)rhs(e))),rhs((Cons)rhs(e)));
		listb = list(op(e),list(lhs(assoc(op((Cons)rhs(e)),opposites)),lhs(e),rhs((Cons)rhs(e))),lhs((Cons)rhs(e)));
		//System.out.println("lista "+lista+"     "+"listb "+listb);
		/*if(rhs((Cons)rhs(e))==null||lhs((Cons)rhs(e))==null){
			lista = list(op(e),list(lhs(assoc(op((Cons)rhs(e)),opposites)),lhs(e),lhs((Cons)rhs(e))));
			listb = list(op(e),list(lhs(assoc(op((Cons)rhs(e)),opposites)),lhs(e),rhs((Cons)rhs(e))));
			System.out.println("lista: "+lista+"\nlistb: "+listb);
		}*/
		if(op((Cons)rhs(e)).equals("sqrt")){
			lista=list(op(e),list(lhs(assoc(op((Cons)rhs(e)),opposites)),lhs(e),lhs((Cons)rhs(e))),2);
			listb=list(op(e),list(lhs(assoc(op((Cons)rhs(e)),opposites)),lhs(e),2),lhs((Cons)rhs(e)));
		}
		//System.out.println("lista: "+lista+"\nlistb: "+listb);
		if(op((Cons)rhs(e)).equals("-")&&rhs((Cons)rhs(e))==null){
			lista = list(op(e),list(op((Cons)rhs(e)),lhs(e),lhs((Cons)rhs(e))),rhs((Cons)rhs(e)));
			listb = list(op(e),list(op((Cons)rhs(e)),lhs(e),rhs((Cons)rhs(e))),lhs((Cons)rhs(e)));	
		}
		if(op((Cons)rhs(e)).equals("exp")){
			lista = list(op(e),list(lhs(assoc(op((Cons)rhs(e)),opposites)),lhs(e)),lhs((Cons)rhs(e)));
			listb = list(op(e),list(lhs(assoc(op((Cons)rhs(e)),opposites)),lhs(e)),lhs((Cons)rhs(e)));	
		}
		if(solve(lista,v)!=null){
			return solve(lista,v);//firstequation
		}
		else if(solve(listb,v)!=null){
			return solve(listb,v); //second equation
		}
		else return null;
	}
	else return null;
}

public static Double solveit (Cons equations, String var, Cons values) {//need work
	Cons variable =llmergesort(cons(var,vars(values)));
	//System.out.println(variable);
	for(;equations!=null;equations=rest(equations)){
		Cons e=(Cons)first(equations);
		Cons e1=llmergesort(vars(e));
	//	System.out.println(e);
		if(e1.equals(variable)){
			Cons e2 = solve(e,var);
	//		System.out.println(e2);
			return eval(rhs((Cons)e2),values);
		}
	}
	return 0.0;
}
public static Cons llmergesort(Cons lst){
	if(lst==null||rest(lst)==null) return lst;
	else{
		Cons mid = midpoint(lst);
		Cons half = rest(mid);
		setrest(mid,null);
		return dmerj(llmergesort(lst),llmergesort(half));
	}
}
public static Cons midpoint(Cons lst){
	Cons current = lst;
	Cons prev = current;
	while(lst!=null&&rest(lst)!=null){
		lst=rest(rest(lst));
		prev = current;
		current = rest(current);
	}
	return prev;
}

public static Cons dmerj (Cons x, Cons y){
	if(x==null) return y;
	else if(y==null) return x;
	else{
		Cons front = x;
		if(((Comparable) first(x)).compareTo(first(y))<0){
			x=rest(x);	
		}
		else{
			front = y;
			y=rest(y);
		}
		Cons end = front;
		while(x!=null){
			if(y==null||(((Comparable)first(x)).compareTo(first(y)))<0){
				setrest(end,x);
				x=rest(x);
			}
			else{
				setrest(end,y);
				y=rest(y);
			}
			end =rest(end);
		}
		setrest(end,y);
		return front;
	}
}
 
    // Include your functions vars and eval from the previous assignment.
    // Modify eval as described in the assignment.
public static Cons vars (Object expr) { //works with modification
	if(consp(expr)){
		return union(vars(first((Cons)expr)),vars(rest((Cons)expr)));
	}
	else if(stringp(expr)&&assoc(expr,opposites)==null&&assoc(expr,opprec)==null){
		return list(expr);
	}
	else return null;
}
public static Double eval (Object tree, Cons bindings) { //returns wrong number
//	System.out.println(tree);
	if(consp(tree)){
		if(op((Cons)tree)=="+"){
			return eval(lhs((Cons)tree),bindings)+eval(rhs((Cons)tree),bindings);
		}
		else if(op((Cons)tree)=="*"){
			Double d =eval(lhs((Cons)tree),bindings)*eval(rhs((Cons)tree),bindings);
//			System.out.println(d);
			return d;
		}
		else if(op((Cons)tree)=="-"&&rhs((Cons)tree)==null){
			return eval(lhs((Cons)tree),bindings)*(-1.0);
		}
		else if(op((Cons)tree)=="-"){
			return eval(lhs((Cons)tree),bindings)-eval(rhs((Cons)tree),bindings);
		}
		else if (op((Cons)tree)=="/"){
			return eval(lhs((Cons)tree),bindings)/eval(rhs((Cons)tree),bindings);
		}
		else if(op((Cons)tree).equals("sqrt")){
			return Math.sqrt(eval(lhs((Cons)tree),bindings));
		}
		else if(op((Cons)tree).equals("expt")){
			Double d =  Math.pow(eval(lhs((Cons)tree),bindings),eval(rhs((Cons)tree),bindings));
//			System.out.println(d);
			return d;
		}
		else if(op((Cons)tree).equals("log")){
			return Math.log(eval(lhs((Cons)tree),bindings));
		} 
		else return Math.exp(eval(lhs((Cons)tree),bindings));
	}
	else if(stringp(tree)){
//		System.out.println(tree+" "+lhs(assoc(tree,bindings)));
		return (Double)(lhs(assoc(tree,bindings)));
	}
	else if(numberp(tree)&&!integerp(tree)){
//		System.out.println(tree);
		return (Double)((double)tree);
	}
	else if(integerp(tree)){
		return (Integer)tree*1.0;
	}
	else return 0.0;

}


    // ****** your code ends here ******

    public static void main( String[] args ) {

        Cons cave = list("rocks", "gold", list("monster"));
        Cons path = findpath("gold", cave);
        printanswer("cave = " , cave);
        printanswer("path = " , path);
        printanswer("follow = " , follow(path, cave));

        Cons caveb = list(list(list("green", "eggs", "and"),
                               list(list("ham"))),
                          "rocks",
                          list("monster",
                               list(list(list("gold", list("monster"))))));
        Cons pathb = findpath("gold", caveb);
        printanswer("caveb = " , caveb);
        printanswer("pathb = " , pathb);
        printanswer("follow = " , follow(pathb, caveb));

        Cons treea = list(list("my", "eyes"),
                          list("have", "seen", list("the", "light")));
        Cons treeb = list(list("my", "ears"),
                          list("have", "heard", list("the", "music")));
        printanswer("treea = " , treea);
        printanswer("treeb = " , treeb);
        printanswer("corresp = " , corresp("light", treea, treeb));
        System.out.println("formulas = ");
        Cons frm = formulas;
        Cons vset = null;
        while ( frm != null ) {
            printanswer("   "  , ((Cons)first(frm)));
            vset = vars((Cons)first(frm));
            while ( vset != null ) {
//            	System.out.println((String)first(vset));
                printanswer("       "  ,
                    solve((Cons)first(frm), (String)first(vset)) );
                vset = rest(vset); }
            frm = rest(frm); }

        Cons bindings = list( list("a", (Double) 32.0),
                              list("t", (Double) 4.0));
        printanswer("Eval:      " , rhs((Cons)first(formulas)));
        printanswer("  bindings " , bindings);
        printanswer("  result = " , eval(rhs((Cons)first(formulas)), bindings));

        printanswer("Tower: " , solveit(formulas, "h0",
                                            list(list("h", new Double(0.0)),
                                                 list("t", new Double(4.0)))));

        printanswer("Car: " , solveit(formulas, "a",
                                            list(list("v", new Double(88.0)),
                                                 list("t", new Double(8.0)))));
        
        printanswer("Capacitor: " , solveit(formulas, "c",
                                            list(list("v", new Double(3.0)),
                                                 list("v0", new Double(6.0)),
                                                 list("r", new Double(10000.0)),
                                                 list("t", new Double(5.0)))));

        printanswer("Ladder: " , solveit(formulas, "b",
                                            list(list("a", new Double(6.0)),
                                                 list("c", new Double(10.0)))));


      }

}

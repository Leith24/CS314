// libtest.java      GSN    03 Oct 08; 21 Feb 12; 26 Dec 13
// 
//Gavin Leith gdl386

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

interface Functor { Object fn(Object x); }

interface Predicate { boolean pred(Object x); }

public class libtest {

    // ****** your code starts here ******


public static Integer sumlist(LinkedList<Integer> lst) {
	Object first = lst.remove();
	Integer sum = (Integer)first;
	return sum +sumlistb(first,lst);
}

public static Integer sumlistb(Object first, LinkedList<Integer> lst){
	if(lst.peek()==first||lst.peek()==null) return 0;
	else{
//		System.out.println(first+"||"+lst.peek());
		return ((Integer)lst.remove())+sumlistb(first,lst);
	}
}


public static Integer sumarrlist(ArrayList<Integer> lst) {
	if(lst.isEmpty()) return 0;
	else{
		return ((Integer)lst.remove(0))+sumarrlist(lst);
	}
}

public static LinkedList<Object> subset (Predicate p,
                                          LinkedList<Object> lst) {
	LinkedList<Object> lstb = new LinkedList<Object>();
	return subsetb(p,lst,lstb);
}

public static LinkedList<Object> subsetb(Predicate p, LinkedList<Object> lst, LinkedList<Object> lstb){
	for(int i =0;i<lst.size();i++){
		if(p.pred(lst.get(i))){
			lstb.add(lst.get(i));
		}
	}
	return lstb;
	
}

public static LinkedList<Object> dsubset (Predicate p,
                                           LinkedList<Object> lst) {
	for(int i = 0; i<lst.size();i++){
		if(!(p.pred(lst.get(i)))){
			lst.remove(i);
			i--;
		}
	}
	return lst;
}

public static Object some (Predicate p, LinkedList<Object> lst) {
	for(int i = 0; i<lst.size();i++){
		if(p.pred(lst.get(i))){
			return lst.get(i);
		}
	}
	return null;
	
}

public static LinkedList<Object> mapcar (Functor f, LinkedList<Object> lst) {
	LinkedList<Object> lstb = new LinkedList<Object>();
	for(int i = 0; i<lst.size();i++){
		lstb.add(i,f.fn(lst.get(i)));
	}
	return lstb;
}

public static LinkedList<Object> merge (LinkedList<Object> lsta,
                                        LinkedList<Object> lstb) {
	LinkedList<Object> lst = new LinkedList<Object>();
	return merger(lsta,lstb,lst,0,0,0);
}

public static LinkedList<Object> merger(LinkedList<Object> lsta, LinkedList<Object> lstb, LinkedList<Object> lst, int i, int j, int k){
	if(i>=lsta.size()&&j>=lstb.size()) return lst;
	else if(i>=lsta.size()){
		lst.add(k,lstb.get(j));
//		System.out.println("Lst: "+lst);
		return merger(lsta,lstb,lst,i,j+1,k+1);
	}
	else if(j>=lstb.size()){
		lst.add(k,lsta.get(i));
//		System.out.println("Lst: "+lst);
		return merger(lsta,lstb,lst,i+1,j,k+1);
	}
	if(((Comparable)lsta.get(i)).compareTo(lstb.get(j))<=0){
		lst.add(k,lsta.get(i));
//		System.out.println("Lst: "+lst);
		return merger(lsta,lstb,lst,i+1,j,k+1);
	}
	else{
		lst.add(k,lstb.get(j));
//		System.out.println("Lst: "+lst);
		return merger(lsta,lstb,lst,i,j+1,k+1);
	}
}

public static LinkedList<Object> sort (LinkedList<Object> lst) {
	if(lst.size()==1) return lst;
	else{
		LinkedList<Object> lsta = new LinkedList<Object>();
		for(int i=0;i<lst.size()/2;i++){
			lsta.add(lst.get(i));
		}
		LinkedList<Object> lstb = new LinkedList<Object>();
		for(int j = lst.size()/2;j<lst.size();j++){
			lstb.add(lst.get(j));
		}
		lsta=sort(lsta);
		lstb=sort(lstb);
		return merge(lsta,lstb);
	}
}


public static LinkedList<Object> intersection (LinkedList<Object> lsta,
                                               LinkedList<Object> lstb) {
	LinkedList<Object> lst = new LinkedList<Object>();
	lsta=sort(lsta);
	lstb=sort(lstb);
	lsta=merge(lsta,lstb);
	for( Object item : lsta){
		if(lsta.indexOf(item)+1>=lsta.size()) break;
		else if(lsta.get(lsta.indexOf(item)+1)==item){
			lst.add(item);
		}
//		System.out.println("Lsta: "+ lsta);
//		System.out.println("Lst: "+lst);
	}
	return lst;
}

public static LinkedList<Object> reverse (LinkedList<Object> lst) {
	LinkedList<Object> lstb = new LinkedList<Object>();
	for(int i=0;i<lst.size();i++){
		lstb.addFirst(lst.get(i));
	}
	return lstb;
}

    // ****** your code ends here ******

    public static void main(String args[]) {
        LinkedList<Integer> lst = new LinkedList<Integer>();
        lst.add(new Integer(3));
        lst.add(new Integer(17));
        lst.add(new Integer(2));
        lst.add(new Integer(5));
        System.out.println("lst = " + lst);
        System.out.println("sum = " + sumlist(lst));

        ArrayList<Integer> lstb = new ArrayList<Integer>();
        lstb.add(new Integer(3));
        lstb.add(new Integer(17));
        lstb.add(new Integer(2));
        lstb.add(new Integer(5));
        System.out.println("lstb = " + lstb);
        System.out.println("sum = " + sumarrlist(lstb));

        final Predicate myp = new Predicate()
            { public boolean pred (Object x)
                { return ( (Integer) x > 3); }};

        LinkedList<Object> lstc = new LinkedList<Object>();
        lstc.add(new Integer(3));
        lstc.add(new Integer(17));
        lstc.add(new Integer(2));
        lstc.add(new Integer(5));
        System.out.println("lstc = " + lstc);
        System.out.println("subset = " + subset(myp, lstc));

        System.out.println("lstc     = " + lstc);
        System.out.println("dsubset  = " + dsubset(myp, lstc));
        System.out.println("now lstc = " + lstc);

        LinkedList<Object> lstd = new LinkedList<Object>();
        lstd.add(new Integer(3));
        lstd.add(new Integer(17));
        lstd.add(new Integer(2));
        lstd.add(new Integer(5));
        System.out.println("lstd = " + lstd);
        System.out.println("some = " + some(myp, lstd));

        final Functor myf = new Functor()
            { public Integer fn (Object x)
                { return new Integer( (Integer) x + 2); }};

        System.out.println("mapcar = " + mapcar(myf, lstd));

        LinkedList<Object> lste = new LinkedList<Object>();
        lste.add(new Integer(1));
        lste.add(new Integer(3));
        lste.add(new Integer(5));
        lste.add(new Integer(6));
        lste.add(new Integer(9));
        lste.add(new Integer(11));
        lste.add(new Integer(23));
        System.out.println("lste = " + lste);
        LinkedList<Object> lstf = new LinkedList<Object>();
        lstf.add(new Integer(2));
        lstf.add(new Integer(3));
        lstf.add(new Integer(6));
        lstf.add(new Integer(7));
        System.out.println("lstf = " + lstf);
        System.out.println("merge = " + merge(lste, lstf));

        lste = new LinkedList<Object>();
        lste.add(new Integer(1));
        lste.add(new Integer(3));
        lste.add(new Integer(5));
        lste.add(new Integer(7));
        System.out.println("lste = " + lste);
        lstf = new LinkedList<Object>();
        lstf.add(new Integer(2));
        lstf.add(new Integer(3));
        lstf.add(new Integer(6));
        lstf.add(new Integer(6));
        lstf.add(new Integer(7));
        lstf.add(new Integer(10));
        lstf.add(new Integer(12));
        lstf.add(new Integer(17));
        System.out.println("lstf = " + lstf);
        System.out.println("merge = " + merge(lste, lstf));

        LinkedList<Object> lstg = new LinkedList<Object>();
        lstg.add(new Integer(39));
        lstg.add(new Integer(84));
        lstg.add(new Integer(5));
        lstg.add(new Integer(59));
        lstg.add(new Integer(86));
        lstg.add(new Integer(17));
        System.out.println("lstg = " + lstg);

        System.out.println("intersection(lstd, lstg) = "
                           + intersection(lstd, lstg));
        System.out.println("reverse lste = " + reverse(lste));

        System.out.println("sort(lstg) = " + sort(lstg));

   }
}

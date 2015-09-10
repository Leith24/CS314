import java.util.HashMap;
public class Memoizer{
	private static Functor f;
	private static HashMap hash = new HashMap();
	
	public Memoizer(Functor f){
		this.f = f;
	}
	public static Object call(Object x){
		if(hash.get(x)!=null){
			return hash.get(x);
		}
		else{
			Object y = f.fn(x);
			hash.put(x,y);
			return y;
		}
	}
}
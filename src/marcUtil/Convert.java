package marcUtil;

public class Convert {

	public static Integer[] intArray2IntegerArray(int [] a){
		Integer [] b = new Integer[a.length];
		for (int i=0;i<a.length;i++) {
			b[i]=(Integer)a[i];
			//b[i]=new Integer(a[i]);
		}
		return b;
	};
	
	public static Boolean[] booleanArray2BooleanArray(boolean [] b) {
		Boolean[] a = new Boolean[b.length];
		for (int i=0;i<b.length;i++) {
			a[i]=(Boolean)b[i];
		}
		return a;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

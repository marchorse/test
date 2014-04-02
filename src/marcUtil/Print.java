package marcUtil;

import java.util.Collection;

public class Print {

	public static void objPrint(Object o) {
		System.out.println(o);
	}
	
	public static <T> void arrayPrint(T[] a) {
		for (int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	//java如何实现任意维数组的打印
	public static void intArrayPrint(int[] a,int dimension) {
		if (dimension==1) {
			for (int i=0;i<a.length;i++){
				System.out.print(a[i]+" ");
			}
			System.out.println();
		}
		else {
			for (int i=0;i<a.length;i++) {
				//intArrayPrint(a[i], dimension-1);
			}
		}
	}
	
	public static void intArrayPrint(int[] a) {
		for (int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static <T> void collectionPrint(Collection<T> c) {
		T [] a = null;
		c.toArray(a);
		for (int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

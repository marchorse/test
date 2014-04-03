package Demo;

import java.util.Iterator;
import java.util.List;

public class ListDemo {

	public static <T> void removeElementContentX(List<T> list, T ContentX) {
		Iterator<T> iterator = list.iterator();
		while (iterator.hasNext()) {
			T tmp = iterator.next();
			if (tmp == ContentX) {//tmp.equals(ContentX),but what if tmp is null!
				iterator.remove();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

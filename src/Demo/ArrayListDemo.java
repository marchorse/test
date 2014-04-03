package Demo;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListDemo {

	public static <T> void removeElementContentX(ArrayList<T> lists, T ContentX) {
		for(int i = 0 , len= lists.size();i<len;++i){
        	if(lists.get(i)==ContentX){
        		lists.remove(i);
        		--len;
        		--i;
        	}
        }
	}
	
	public static <T> void removeElementContentXWithIterator(ArrayList<T> lists, T ContentX) {
		ListDemo.removeElementContentX(lists, ContentX);
	}
	
	public static <T> void removeElementIndexX(ArrayList<T> lists, int index) {
		lists.remove(index);
	}
	
	//remove all elements in collection c from lists
	public static <T> void removeAllElementsInCollection(ArrayList<T> lists, Collection<T> c) {
		lists.removeAll(c);
	}
	
	public static <T> T getElementIndexX(ArrayList<T> lists, int index) {
		return lists.get(index);
	}
	
	//return old content at index.
	public static <T> T setElementIndexX(ArrayList<T> lists, int index, T ContentX) {
		return lists.set(index, ContentX);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

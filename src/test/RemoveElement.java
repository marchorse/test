package test;

import marcUtil.Print;
import marcUtil.Convert;

public class RemoveElement {

	public Solution solution;
	public RemoveElement () {
		solution = new Solution();
	}
	
	public class Solution {
	    public int removeElement(int[] A, int elem) {
	        int indexBefore,indexAfter;
	        indexBefore = 0;
	        indexAfter = A.length-1;
	        while(indexBefore<=indexAfter) {
	            if (A[indexBefore]==elem) {
	                while (A[indexAfter]==elem) {
	                    indexAfter--;
	                }
	                
	                A[indexBefore]=A[indexAfter];
	                A[indexAfter]=elem;//to be removed
	                indexAfter--;
	            }
	            indexBefore++;
	        }
	        return indexAfter+1;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int elem=3;
		int [] A = {1,2,3,2,3,3};
		
		Print.arrayPrint(Convert.intArray2IntegerArray(A));
		Print.objPrint((new RemoveElement()).solution.removeElement(A, elem));
		Print.arrayPrint(Convert.intArray2IntegerArray(A));
	}
}

package test;

import marcUtil.Convert;
import marcUtil.Print;

public class SortColors {

	public Solution solution;
	
	public SortColors() {
		solution = new Solution();
	}
	
	public class Solution {
	    public void sortColors(int[] A) {
	        int upboundof0,downboundof2;
	        int i,tmp;
	        for (i=0;i<A.length;i++) {
	            if (A[i]!=0) break;
	        }
	        upboundof0 = i;
	        for (i=A.length-1;i>=0;i--) {
	            if (A[i]!=2) break;
	        }
	        downboundof2 = i;
	        for(i=upboundof0;i<=downboundof2;i++) {
	        	if (upboundof0>=downboundof2)break;
	            if (A[i]==0) {
	                tmp = A[i];
	                A[i] = A[upboundof0];
	                A[upboundof0]=tmp;
	                if (A[i]==2) {
	                	if (i==downboundof2) {
	                		downboundof2--;
	                		while(A[downboundof2]==0) {
		            			downboundof2--;
		            		}
		                }
	                	else {
	                		tmp = A[i];
	                		A[i] = A[downboundof2];
	                		A[downboundof2]=tmp;
	                		downboundof2--;
	                		while(A[downboundof2]==2) {
	                			downboundof2--;
	                		}
	                	}
	                }	
	                upboundof0++;
	                while(A[upboundof0]==0) {
	                	upboundof0++;
	                }
	            }
	            else
	            	if (A[i]==2) {
	            		tmp = A[i];
	            		A[i] = A[downboundof2];
	            		A[downboundof2]=tmp;
	            		if (A[i]==0) {
	            			if (i==upboundof0) {
	            				upboundof0++;
	            				while(A[upboundof0]==0) {
	        	                	upboundof0++;
	        	                }
		            		}
	            			else {
	            				tmp = A[i];
		                		A[i] = A[upboundof0];
		                		A[upboundof0]=tmp;
		                		upboundof0++;
		                		while(A[upboundof0]==0) {
		                			upboundof0++;
		                		}
	            			}
	            		}
	            		downboundof2--;
	            		while(A[downboundof2]==2) {
	            			downboundof2--;
	            		}
	            	}
	        }
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {2,0,0};
		//int [] A = {1,0,2,0,1,2,0,1};
		(new SortColors()).solution.sortColors(A);
		Print.arrayPrint(Convert.intArray2IntegerArray(A));
	}

}

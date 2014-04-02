package test;

import marcUtil.Convert;
import marcUtil.Print;

public class SetMatrixZeroes {

	public Solution solution;
	
	public SetMatrixZeroes() {
		solution = new Solution();
	}
	
	public class Solution {
	    public void setZeroes(int[][] matrix) {
	        int m=matrix.length;
	        int n=matrix[0].length;
	        boolean[][] zeroSet = new boolean[m][n];
	        int[][] result = new int[m][n];
	        
	        for (int i=0;i<m;i++) {
	            for (int j=0;j<n;j++) {
	                if (matrix[i][j]==0) {
	                    for (int k=0;k<m;k++) {
	                        zeroSet[k][j]=true;
	                        result[k][j]=0;
	                    }
	                    for (int k=0;k<n;k++) {
	                        zeroSet[i][k]=true;
	                        result[i][k]=0;
	                    }    
	                }
	                else {
	                    if (!zeroSet[i][j]) {
	                        result[i][j]=matrix[i][j];
	                    }
	                }
	            }
	        }
	        //matrix = result;
	        
	        for (int i=0;i<m;i++) {
	        	for (int j=0;j<n;j++) {
	        		matrix[i][j]=result[i][j];
	        	}
	        }	        
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] matrix = {{1,0,1},{1,1,1},{1,1,1}};
		for (int i=0;i<matrix.length;i++) {
			Print.arrayPrint(Convert.intArray2IntegerArray(matrix[i]));
		}
		System.out.println();
		//matrix引用值重新赋值
		Print.objPrint(matrix);
		(new SetMatrixZeroes()).solution.setZeroes(matrix);
		Print.objPrint(matrix);
		for (int i=0;i<matrix.length;i++) {
			Print.arrayPrint(Convert.intArray2IntegerArray(matrix[i]));
		}
	}

}

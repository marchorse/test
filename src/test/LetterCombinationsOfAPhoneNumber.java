package test;

import java.util.ArrayList;

import marcUtil.Print;

public class LetterCombinationsOfAPhoneNumber {

	public Solution solution;
	
	public LetterCombinationsOfAPhoneNumber() {
		solution = new Solution();
	}
	
	public class Solution {
	    char digitchar[][]={
	        {' '},
	        {0},
	        {'a','b','c'},
	        {'d','e','f'},
	        {'g','h','i'},
	        {'j','k','l'},
	        {'m','n','o'},
	        {'p','q','r','s'},
	        {'t','u','v'},
	        {'w','x','y','z'}
	    };
	    
	    public ArrayList<String> letterCombinations(String digits) {
	        ArrayList<String> result = new ArrayList<String>();
	        letterCombinationsHelper(digits.toCharArray(), digits.length(), "", result);
	        return result;
	    }
	    
	    public void letterCombinationsHelper(char[] digits, int leftNum, String tmp, ArrayList<String> result) {
	        if (leftNum==0) {
	            result.add(tmp);
	            return;
	        }
	        for (char c:digitchar[digits[digits.length-leftNum]-'0']) {
	            letterCombinationsHelper(digits, leftNum-1, tmp+String.valueOf(c), result);
	        }
	    }
	}
	
	public static void main(String[] args) {
		String digits = "23";
		ArrayList<String> c = (new LetterCombinationsOfAPhoneNumber()).solution.letterCombinations(digits);
		Print.collectionPrint(c);
	}

}

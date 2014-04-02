package test;

public class EvaluateReversePolishNotationSolution {
    public int [] stack = new int [1000000];
    public int evalRPN(String[] tokens) {
        int stackpointer = 0;
        for (int i=0;i<tokens.length;i++) {
            if (tokens[i].charAt(0)=="+".charAt(0) || tokens[i].charAt(0)=="-".charAt(0)) {
                if (tokens[i].length()>1) {
                    if (tokens[i].charAt(1)!="+".charAt(0) && tokens[i].charAt(1)!="-".charAt(0) &&
                    tokens[i].charAt(1)!="*".charAt(0) && tokens[i].charAt(1)!="/".charAt(0)) {
                        if (tokens[i].charAt(0)=="+".charAt(0)) 
                            stack[stackpointer++]=evalNum(tokens[i]);
                        else 
                            stack[stackpointer++]=-evalNum(tokens[i].substring(1));
                    }
                }
                else {
                    if (tokens[i].charAt(0)=="+".charAt(0)) {
                        //stack[stackpointer++]=stack[--stackpointer]+stack[--stackpointer];
                        int tmp = stack[--stackpointer];
                        tmp += stack[--stackpointer];
                        stack[stackpointer++]=tmp;
                    }
                    else { 
                        //stack[stackpointer++]=stack[--stackpointer]-stack[--stackpointer];
                        int tmp = stack[--stackpointer];
                        tmp = stack[--stackpointer]-tmp;
                        stack[stackpointer++]=tmp;
                    }
                }
            }
            else {
                if (tokens[i].charAt(0)=="*".charAt(0) || tokens[i].charAt(0)=="/".charAt(0)) {
                    if (tokens[i].charAt(0)=="*".charAt(0)) {
                        //stack[stackpointer++]=stack[--stackpointer]*stack[--stackpointer];
                        int tmp = stack[--stackpointer];
                        tmp *= stack[--stackpointer];
                        stack[stackpointer++]=tmp;
                    }
                    else {
                        //stack[stackpointer++]=stack[--stackpointer]/stack[--stackpointer];
                        int tmp = stack[--stackpointer];
                        tmp = stack[--stackpointer]/tmp;
                        stack[stackpointer++]=tmp;
                    }
                }
                else {
                    stack[stackpointer++]=evalNum(tokens[i]);
                }
            }
        }
        if (stackpointer==1) {
            return stack[--stackpointer];
        }
        else {
            return 0;
        }
    }
    public int evalNum(String Num) {
        int result = 0;
        for (int i=Num.length()-1;i>=0;i--) {
            result += ((int)Num.charAt(i)-(int)"0".charAt(0))*pow(10, Num.length()-1-i);
        }
        return result;
    }
    public int pow(int base, int index) {
        int result = 1;
        for (int i=0;i<index;i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String [] args) {
    	String [] brgs = {"3","-16","+", "13", "5", "/", "+"};
    	System.out.println(new EvaluateReversePolishNotationSolution().evalRPN(brgs));
    }
}
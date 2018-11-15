package Evaluate;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;
import java.util.Stack;

/*
* Bug 暂时未解决
* */

public class Eva {
    public static void main(String[] args) {

//        System.out.print("Please input the String:");
        Stack<String> opr = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.equals("(")){
                return ;
            }
            else if(s.equals("+")){
                opr.push(s);
            }
            else if(s.equals("-")){
                opr.push(s);
            }
            else if(s.equals("*")){
                opr.push(s);
            }
            else if(s.equals("/")){
                opr.push(s);
            }
            else if(s.equals(")")){
                String op = opr.pop();
                Double val = vals.pop();
                if(op.equals("+")){
                    val = vals.pop()+val;
                }
                else if(op.equals("-")){
                    val = vals.pop()-val;
                }
                else if(op.equals("*")){
                    val = vals.pop()*val;
                }
                else if(op.equals("/")){
                    val = vals.pop()/val;
                }
                vals.push(val);
            }
            else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }
}

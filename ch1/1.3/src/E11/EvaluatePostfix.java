package E11;

import E4.MyStack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Objects;
import java.util.Scanner;

/*
*
* 直接弹栈计算
* */
public class EvaluatePostfix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        MyStack<Double> MsDb = new MyStack<>();
        char[] chArr = str.toCharArray();
        for(int i=0 ; i<str.length() ; i++){
            if(Objects.equals(chArr[i], '+')){
                double x = MsDb.remove();
                x = MsDb.remove()+x;
                MsDb.push(x);
            }
            else if(Objects.equals(chArr[i], '-')){
                double x = MsDb.remove();
                x = MsDb.remove()-x;
                MsDb.push(x);
            }
            else if(Objects.equals(chArr[i], '*')){
                double x = MsDb.remove();
                x = MsDb.remove()*x;
                MsDb.push(x);
            }
            else if(Objects.equals(chArr[i], '/')){
                double x = MsDb.remove();
                x = MsDb.remove()/x;
                MsDb.push(x);
            }
            else {
                MsDb.push(Double.parseDouble(String.valueOf(chArr[i])));
            }
        }
        StdOut.println(MsDb.remove());
    }
}

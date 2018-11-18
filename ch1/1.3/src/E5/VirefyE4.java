package E5;

import E4.MyStack;
import edu.princeton.cs.algs4.StdOut;

public class VirefyE4 {
    public static void main(String[] args) {
        MyStack<Integer> st = new MyStack<>();
        int N = 50;
        while(N>0){
            st.push(N%2);
            N = N/2;
        }

//        for(Integer x : st){
//            StdOut.println(st.remove());
//        }
        for(Integer x : st){
            StdOut.println(st.peek());
        }
    }
}

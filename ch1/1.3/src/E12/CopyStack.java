package E12;

import E4.MyStack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class CopyStack<E> extends MyStack<E> {
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public void push(E e) {
        super.push(e);
    }

    @Override
    public E remove() {
        return super.remove();
    }

    @Override
    public E peek() {
        return super.peek();
    }

    public MyStack<E> copy(MyStack<E> myStack){
        MyStack<E> newT = new MyStack<>(myStack.size());
        Iterator<E> it = myStack.iterator();
        while(it.hasNext()){
            newT.push(it.next());
        }
        return newT;
    }
//
//    public static void main(String[] args) {
//        MyStack<String> mst = new MyStack<>();
//        mst.push("Hello");
//        mst.push("csh");
//        mst.push("happy!");
//        CopyStack<String> cs = new CopyStack<>();
//        MyStack<String> mcs =  cs.copy(mst);
//
//        int k = mst.size();
//        for(int i=0 ; i<k ; i++){
//            StdOut.println(mst.remove());
//        }
//
//        System.out.println("----------------");
//        for(String x:mcs){
//            StdOut.println(x);
//        }
//    }
}

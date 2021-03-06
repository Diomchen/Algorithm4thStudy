package E4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class MyStack<E> implements Iterable<E>{
    private E[] Arr;
    private int N;
    public MyStack(int x){
        Arr = (E[]) new Object[x];
    }

    public MyStack(){
        Arr = (E[]) new Object[10];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void push(E e){
        if(size()>0&&size()==Arr.length/2){
            resize(Arr.length*2);
        }
        Arr[N++] = e;
    }

    public E remove(){
        if(isEmpty())throw new IllegalArgumentException("error");
        if(size()>0&&size()==Arr.length/4)resize(Arr.length/2);
        E m = Arr[--N];
        Arr[N] = null;
        return m;
    }

    public void resize(int y){
        E[] temp = (E[])new Object[y];
        for(int i=0 ; i<N ; i++){
            temp[i] = Arr[i];
        }
        Arr = temp;
    }

    public E peek(){
        int k = N;
        return Arr[--k];
    }

    @Override
    public Iterator<E> iterator() {
        return new RArrIterator();
    }

    private class RArrIterator implements Iterator<E>{

        private int i = N;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public E next() {
            return Arr[--i];
        }

        @Override
        public void remove() {

        }
    }
//
//    public static void main(String[] args) {
//        MyStack<Double> ms = new MyStack<>(10);
//        for(int i=0 ; i<20 ; i++){
//            double k = StdRandom.random()*20;
//            ms.push(k);
//            StdOut.println(k);
//        }
//        StdOut.println("---------------------");
//        for(int i=0 ; i<10 ; i++){
//            StdOut.println(ms.remove());
//        }
//    }
}

package E15;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.rmi.server.RMIClassLoader;
import java.util.Iterator;

public class MyQueue<E> implements Iterable<E> {
    private E[] myQueue;
    private int N;
    public MyQueue(){
        myQueue = (E[]) new Object[10];
    }

    public MyQueue(int x){
        myQueue = (E[]) new Object[x];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void enqueue(E e){
        if(size()>0&&size()==myQueue.length/2){
            resize(myQueue.length*2);
        }
        myQueue[N++] = e;
    }

    public E dequeue(){
        if(isEmpty())throw new IllegalArgumentException("error");
        if(size()>0&&size()==myQueue.length/4)resize(myQueue.length/2);
        E m = myQueue[0];
        for(int i=0 ; i<N-1 ; i++){
            myQueue[i] = myQueue[i+1];
        }
        return m;
    }

    public void resize(int y){
        E[] temp = (E[])new Object[y];
        for(int i=0 ; i<N ; i++){
            temp[i] = myQueue[i];
        }
        myQueue = temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new RMyQueue();
    }

    private class RMyQueue implements Iterator<E>{

        private int i = N;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public E next() {
            return myQueue[--i];
        }

        @Override
        public void remove() {

        }
    }

//    public static void main(String[] args) {
//        MyQueue<Double> mq = new MyQueue<>();
//        for(int i=0 ; i<10 ; i++){
//            double x = StdRandom.random()*50;
//            mq.enqueue(x);
//            System.out.println(x);
//        }
//
//        StdOut.println("-----------------------");
//
//        for(int i=0 ; i<10 ; i++){
//            StdOut.println(mq.dequeue());
//        }
//    }
}

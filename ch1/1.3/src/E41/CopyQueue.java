package E41;

import E15.MyQueue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: CopyQueue
 * @Description: 复制队列
 * @Author: DiomChen
 * @Date: 2018/11/26 18:40
 */
public class CopyQueue<E> implements Iterable<E>{
    private MyQueue<E> CQueue = new MyQueue<>();
    private int k;

    public CopyQueue(Queue<E> q){
        int N = q.size();
        k = N;
        E e ;
        for(int i=0 ; i<N ; i++){
            e = q.poll();
            CQueue.enqueue(e);
            q.offer(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<E>{

        private int i = k;

        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public E next() {
            i--;
            return CQueue.dequeue();
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);
        q.offer(7);


        System.out.println("------------------------------");
        CopyQueue<Integer> cq = new CopyQueue<>(q);

        q.offer(99);
        for(Integer n:q){
            StdOut.println(n);
        }

        System.out.println("------------------------------");

        for(Integer m : cq){
            System.out.println(m);
        }


    }


}

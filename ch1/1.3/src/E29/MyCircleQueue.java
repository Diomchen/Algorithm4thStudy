package E29;

import E15.MyQueue;
import E28.MyLinkedList;
import edu.princeton.cs.algs4.StdOut;

public class MyCircleQueue<E>  {
    private Node last;
    private int N;
    private class Node{
        E e;
        Node next;
        public Node (){
            this(null,null);
        }
        public Node (E e, Node next){
            this.e = e;
            this.next = next;
        }
        public Node (E e){
            this(e,null);
        }

    }

    public int size(){
        return N;
    }
    /*
     *
     * 双端链表才能达到此目的
     * 或者,getNode函数
     * */

//
//    public E removeLast(){
//        if(N == 0)throw new IllegalArgumentException("error");
//        Node temp = first;
//        Node oldNode = temp;
//        E e = null;
//        for(int i=0 ; i<N ; i++){
//            oldNode = temp;
//            temp = temp.next;
//        }
//        e = temp.e;
//        oldNode.next = null;
//        N--;
//
//        return e;
//    }

    public void enqueue(E e){
        Node node  = new Node(e);
        if(last == null){
            last = node;
            node.next = last;
            N++;
        }
        else{
            node.next = last.next;
            last.next = node;
            last = node;
            N++;
        }
        System.out.println(last.e);
    }

    public E dequeue(){
        if(last == null)throw new IllegalArgumentException("error");
        last.next = getNode(1);
        Node temp = getNode(0);
        if(last.next == last){
            E e = last.e;
            last = null;
            return e;
        }
        else {
            E e = last.next.e;
            last.next =last.next.next;
            return e;
        }

    }

    public Node getNode(int index){
        Node be = last;
        for(int i=0 ; i<N ; i++){
            if(i == index){
                return be;
            }
            be = be.next;
        }
        return null;
    }

    public static void main(String[] args) {
        MyCircleQueue<Integer> mcq =  new MyCircleQueue<>();
        mcq.enqueue(1);
        mcq.enqueue(2);
        mcq.enqueue(3);
        mcq.enqueue(1);
        mcq.enqueue(2);
        mcq.enqueue(3);
        mcq.enqueue(1);
        mcq.enqueue(2);
        mcq.enqueue(3);
        mcq.enqueue(1);
        mcq.enqueue(2);
        mcq.enqueue(3);
        System.out.println("-----------------");

        StdOut.println(mcq.dequeue());
        StdOut.println(mcq.dequeue());
        StdOut.println(mcq.dequeue());
    }
}

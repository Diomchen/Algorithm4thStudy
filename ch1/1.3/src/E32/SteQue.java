package E32;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @ClassName: SteQue
 * @Description: 用链表实现SteQue
 * @Author: DiomChen
 * @Date: 2018/11/22 11:43
 */

/**
 * ----------------------API
 *  public class SteQue <E> implements Iterable<E>
 * -----------------------------------------------------
 *                       SteQue()          创建SteQue
 *              void     push(E e)         从头部插入
 *              E        pop()             从头部删除
 *              void     enqueue(E e)      从尾部插入
 * -----------------------------------------------------
 */

public class SteQue <E> implements Iterable<E> {

    private int N;
    private Node first;
    private Node last;

    private class Node{
        public Node next ;
        public E e;

        public Node (E e){
            this(null,e);
        }

        public Node (Node next, E e){
            this.e = e;
            this.next = next;
        }

        public Node (){
            this(null,null);
        }
    }

    public boolean isEmpty(){
        return N>0;
    }

    public int size(){
        return N;
    }

    public void push(E e){
        Node node  =  new Node(e);
        if(first == null){
            first = node;
            last = node;
        }
        else {
            node.next = first;
            first = node;
        }
    }

    public E pop(){
        if(isEmpty())throw new IllegalArgumentException("error");
        if(first.next==null){
            Node node = first;
            first = null;
            last = null;
            return node.e;
        }
        else{
            Node node = first;
            first = node.next;
            node.next = null;
            return node.e;
        }

    }

    public void enqueue(E e){
        Node node = new Node(e);
        if(last == null){
            first = node;
            last = node;
        }
        else {
            last.next = node;
            last = node;
        }
    }



    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<E>{

        private int i = N;
        private Node cur = first;

        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public E next() {
            E e = cur.e;
            cur = cur.next;
            return e;
        }
    }

    public static void main(String[] args) {

        SteQue<Integer> si = new SteQue<>();
        si.enqueue(1);
        si.push(2);
        si.enqueue(3);
        si.push(4);
        si.enqueue(5);
        si.push(6);
        StdOut.println(si.pop());
        StdOut.println(si.pop());
        StdOut.println(si.pop());
        StdOut.println(si.pop());
        StdOut.println(si.pop());
        StdOut.println(si.pop());
    }
}

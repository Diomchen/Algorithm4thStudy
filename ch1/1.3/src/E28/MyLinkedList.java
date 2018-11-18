package E28;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
    private Node node;
    private Node first;
    private int N;
    private class Node{
        E e;
        Node next;
        public Node (){
            this(null,null);
        }
        public Node (E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node (E e){
            this(e,null);
        }

    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public void addFirst(E e){
        Node oldNode = first;
        first = new Node();
        first.e = e;
        first.next = oldNode;
        N++;
    }

    public E removeFirst(){
        E e = first.e;
        first = first.next;
        N--;
        return e;
    }

    /*
    *
    * 双端链表才能达到此目的
    * 或者,getNode函数
    * */
//    public void addLast(E e){
//        Node temp = first;
//        Node newNode = new Node(e);
//        for(int i=0 ; i<N ; i++){
//            temp = temp.next;
//        }
//        temp.e= newNode.e;
//        N++;
//    }
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

    public void removeAfter(Node newNode){
        if(newNode!=null && newNode.next!=null){
            newNode.next = null;
        }
    }

    public void insertAfter(Node prev,Node insertNode){
        if(prev!=null||insertNode!=null){
            insertNode.next = prev.next;
            prev.next = insertNode;
        }
        N++;
    }

    public void remove(MyLinkedList<E> myLinkedList,String key){
        Node be = myLinkedList.first;
        int n = myLinkedList.N;
        for(int i=0 ; i<N ; i++){
            if(be.e == key){
                be = be.next;
                if(i == 0){
                    E eTemp =  removeFirst();
                    i--;
                }
                else if(i<N-1){
                    getNode(i-1).next = getNode(i+1);
                    N--;
                    i--;
                }
                else {
                    getNode(i-1).next = null;
                    N--;
                }
            }
            else {
                be = be.next;
            }
        }
    }

    //仅适用于键值为整数的情况下
    public int max(Node f){
        int max = -99999;
        if(f == null){
            return 0;
        }
        else {
            while(f!=null){
                if((Integer)f.e>max){
                    max = (Integer)f.e;
                }
                f = f.next;
            }
        }
        return max;
    }

    public Node getNode(int index){
        Node be = first;
        for(int i=0 ; i<N ; i++){
            if(i == index){
               return be;
            }
            be = be.next;
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new RLinklist();
    }

    private class RLinklist implements Iterator<E>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }

    public static void main(String[] args) {
//        MyLinkedList<String> ml = new MyLinkedList<>();
//        ml.addFirst("3");
//        ml.addFirst("1");
//        ml.addFirst("2");
//        ml.addFirst("4");
//        ml.addFirst("3");
//        ml.remove(ml,"3");
//        StdOut.println(ml.removeFirst());
//        StdOut.println(ml.removeFirst());
//        StdOut.println(ml.removeFirst());
        MyLinkedList<Integer> ml = new MyLinkedList<>();
        ml.addFirst(1);
        ml.addFirst(2);
        ml.addFirst(33);
        ml.addFirst(4);
        ml.addFirst(5);
        StdOut.println(ml.max(ml.first));
    }
}

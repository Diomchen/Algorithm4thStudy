package E31;

import E30.ReverseLinkList;
import edu.princeton.cs.algs4.StdOut;

/**
 * @ClassName: DoubleLinkedList
 * @Description: create a DoubleLinkedList
 * @Author: DiomChen
 * @Date: 2018/11/21 18:43
 */
public class DoubleLinkedList<E> {

    private int N;
    private Node first;
    private Node last;

    private class Node{
        public Node next ;
        public Node prev ;
        public E e;

        public Node (E e){
            this(null,null,e);
        }

        public Node (Node prev,Node next, E e){
            this.e = e;
            this.next = next;
            this.prev = prev;
        }

        public Node (){
            this(null,null,null);
        }
    }

    public boolean isEmpty(){
        return first ==  null && last == null;
    }

    public int size(){
        return N;
    }

    public void addFirst(E e){
        Node node = new Node(e);
        if(first == null){
            first = node;
            last = first;
        }
        else {
            node.next = first;
            first.prev = node;
            first = node;
        }
        N++;
    }

    public void addLast(E e){
        Node node = new Node(e);
        if(last == null){
            last = node;
            first = last;
        }
        else{
            last.next = node;
            node.prev= last;
            last = node;
        }
        N++;
    }

    public E removeFirst(){
        Node temp = first;
        first = first.next;
        temp.next = null;
        first.prev = null;
        N--;
        return temp.e;
    }

    public E removeLast(){
        Node temp = last;
        last = last.prev;
        last.next = null;
        temp.prev = null;
        N--;
        return temp.e;
    }

    public void prevInsert(int x,E e){
        Node posNode = getNodeByIndex(x);
        Node insNode = new Node(e);
        if(x == 0){
            addFirst(e);
        }
        else{
            insNode.prev = posNode.prev;
            insNode.next = posNode;
            insNode.prev.next = insNode;
            posNode.prev = insNode;
            N++;
        }
    }

    public void behindInsert(int x,E e){
        Node posNode = getNodeByIndex(x);
        Node insNode = new Node(e);
        if(x == N-1){
            addLast(e);
        }
        else{
            insNode.next = posNode.next;
            insNode.prev = posNode;
            insNode.next.prev = insNode;
            posNode.next = insNode;
            N++;
        }

    }

    public Node getNodeByIndex(int x){
        Node f = first;
        for(int i=0 ; i<x ; i++){
            if(f.next!=null){
                f = f.next;
            }
            else{
                throw new IllegalArgumentException("Can't exits this pos!!!");
            }
        }
        return f;
    }

//    public static void main(String[] args) {
//        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
//        dll.addFirst(1);
//        dll.addLast(2);
//        dll.addFirst(3);
//        dll.addLast(4);
//        dll.addFirst(5);
//        dll.addLast(6);
//        dll.addFirst(7);
//        dll.addLast(8);
//        dll.addFirst(9);
//        dll.addLast(10);
//
//        dll.behindInsert(9,99);
//        StdOut.println(dll.size());
//        StdOut.println(dll.getNodeByIndex(0).e);
//    }

}

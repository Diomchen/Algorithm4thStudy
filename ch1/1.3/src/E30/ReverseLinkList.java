package E30;

import E28.MyLinkedList;
import edu.princeton.cs.algs4.StdOut;

public class ReverseLinkList<E> {
    private Node first;
    private Node reverse;
    private Node second;
    private int N;

    private class Node{
        public Node next ;
        public E e;

        public Node (E e){
            this(null,e);
        }

        public Node (Node next,E e){
            this.e = e;
            this.next = next;
        }

        public Node (){
            this(null,null);
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public void addLast(E e){
        Node node  = new Node(e);
        if( first == null){
            first = node ;
        }
        else {
            Node inFirst = first;
            while (inFirst.next != null) {
                inFirst = inFirst.next;
            }
            inFirst.next = node;
        }
        N++;
    }

    public E removeFirst(){
        E e = first.e;
        first = first.next;
        N--;
        return e;
    }

    //迭代法反转链表（这是我的菜鸡写法）存在小bug
    public Node ReverseLL1(Node first){
        second = first.next;

        if(first == null)throw new IllegalArgumentException("error");

        while(first!=null&&second!=null){
            Node node = second;
            Node prevNode = first;

            while(node.next!=null){
                prevNode = node;
                node = node.next;
            }

            Node renode = new Node(node.e);
            if(N == 2){
                second = null;
            }
            else {
                prevNode.next = null;
            }
            N--;

            if(reverse == null){
                reverse = renode;
            }
            else {
                Node temp = reverse;
                 while(temp.next!=null){
                     temp = temp.next;
                 }
                 temp.next = renode;
            }
        }

        Node seNode  = reverse;
        while(seNode.next!=null){
            seNode = seNode.next;
        }
        seNode.next = first;
        return reverse;

    }

    public Node ReverseLL2(Node x){
        Node first   = x;
        Node reverse = null;
        while(first!=null){
            Node second = first.next;
            first.next  = reverse;
            reverse     = first;
            first       = second;
        }
        return reverse;
    }

    public void stdOutReverse(){
        Node f = ReverseLL1(first);
        while(f!=null){
            System.out.println(f.e);
            f = f.next;
        }
    }


    public static void main(String[] args) {
        ReverseLinkList<Integer> ri = new ReverseLinkList<>();
        ri.addLast(2);
        ri.addLast(5);
        ri.addLast(9);
        ri.addLast(15);
        ri.addLast(23);
        ri.addLast(99);
        ri.addLast(18);
        ri.addLast(57);
        StdOut.println("--------------");
        ri.stdOutReverse();

    }
}

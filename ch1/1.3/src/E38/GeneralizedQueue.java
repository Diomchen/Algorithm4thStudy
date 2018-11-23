package E38;

import edu.princeton.cs.algs4.StdOut;

/**
 * @ClassName: GeneralizedQueue
 * @Description: TODO
 * @Author: DiomChen
 * @Date: 2018/11/22 21:09
 */
public class GeneralizedQueue<E> {
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

    public void insert(E e){
        Node node = new Node(e);
        if(first == null){
            first = node;
            last = node;
            N++;
        }
        else {
            node.next = first;
            first = node;
            N++;
        }
    }

    public E delete(int k){
        Node temp;
        if(k>N)throw new IllegalArgumentException("error");
            int i=N;
            temp = first;
            while(i!=k){
                temp = temp.next;
                i--;
            }

            if(i == 1&&N == 1){
                N--;
                return temp.e;
            }
            else if( i==1 && N!=1 ){
                N--;
                Node node = getNodeByIndex(N-1);
                node.next = null;
                return temp.e;
            }
            else {
                N--;
                Node node = getNodeByIndex(N-i);
                node.next = temp.next;
                return temp.e;
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

    public static void main(String[] args) {
        GeneralizedQueue<Integer> gq = new GeneralizedQueue<>();
        gq.insert(1);
        gq.insert(2);
        gq.insert(3);
        gq.insert(4);
        gq.insert(5);
        gq.insert(6);
        gq.insert(7);
        gq.insert(8);
        gq.insert(9);
        StdOut.println(gq.delete(1));
        StdOut.println(gq.delete(2));
        StdOut.println(gq.delete(3));
        StdOut.println(gq.delete(4));
        StdOut.println(gq.delete(5));
    }

}

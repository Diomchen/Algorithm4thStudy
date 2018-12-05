package E44;

import java.util.Stack;

/**
 * @ClassName: Buffer
 * @Description: Buffer
 * @Author: DiomChen
 * @Date: 2018/12/5 12:38
 */
public class Buffer <E>{
    private int N;
//    private E e;
    private Stack<E> st1;
    private Stack<E> st2;//buffStack

    private Buffer(){
        st1 = new Stack<>();
        st2 = new Stack<>();
        N = 0 ;
    }
    private int size(){
        return N;
    }

    public void push(E e){
        st1.push(e);
        N++;
    }

    public void left(int k){
        if(N != 0){
            for(int i=0 ; i<k ; i++){
                st2.push(st1.pop());
            }
            N -= k;
        }
        else{
            System.err.println("there is no elements in the left!!");
        }
    }

    public void right(int k){
        if(!st2.empty()){
            for(int i=0 ; i<k ; i++){
                st1.push(st2.pop());
            }
            N += k;
        }
        else{
            System.err.println("there is no elements in the right!!");
        }
    }

    public E delete(){
        return st1.pop();
    }

    public void insert(E e){
        st2.push(st1.pop());
        st2.push(e);
        st1.push(st2.pop());
        st1.push(st2.pop());
        N++;
    }

    public static void main(String[] args) {
        Buffer<Character> ch = new Buffer<>();
        ch.push('A');
        ch.push('B');
        ch.push('C');
        ch.push('D');
        ch.push('E');
        ch.push('F');
        ch.push('G');
        ch.push('H');
        ch.push('I');
        ch.push('J');

        ch.left(6);
        ch.right(2);

        System.out.println(ch.delete());
    }
}

package E42;

import E28.MyLinkedList;

import java.util.Iterator;
import java.util.Stack;

/**
 * @ClassName: CopyStack
 * @Description: 复制栈
 * @Author: DiomChen
 * @Date: 2018/11/26 19:10
 */
public class CopyStack<E> implements Iterable<E>{
    MyLinkedList<E> ml = new MyLinkedList<>();
    private int k;
    public CopyStack(Stack<E> s){
        int n = s.size();
        E[] EA = (E[])new Object[n];

        for(int i=n-1 ; i>=0 ; i--){
            EA[i] = s.pop();
        }

        for(int i=0 ; i<n ; i++){
            ml.addFirst(EA[i]);
            s.push(EA[i]);
        }
    }

    public E cpop(){
        return ml.removeFirst();
    }

    public void cpush(E e){
        ml.addFirst(e);
    }

    public Iterator<E> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<E> {

        private int i = k;

        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public E next() {
            i--;
            return ml.removeFirst();
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);

        CopyStack<Integer> cs = new CopyStack<>(s) ;

//        for(Integer x: cs){
//            System.out.println(x);
//        }
        System.out.println(cs.cpop());
        System.out.println(cs.cpop());
        System.out.println(cs.cpop());
        System.out.println(cs.cpop());
        System.out.println(cs.cpop());
        System.out.println(cs.cpop());
        System.out.println(cs.cpop());


        System.out.println("-------------------------");

        System.out.println(s.pop());

        System.out.println("-------------------------");
        for(Integer x:s){
            System.out.println(x);
        }
    }
}

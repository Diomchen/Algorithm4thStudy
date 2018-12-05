package E48;

import E33.Deque;

/**
 * @ClassName: DoubleListToStack
 * @Description: TODO
 * @Author: DiomChen
 * @Date: 2018/12/5 19:54
 */
public class DoubleListToStack<E> {
    private int N1;
    private int N2;
    private Deque<E> deque;


    public DoubleListToStack(){
        deque = new Deque<>();
        N1 = 0;
        N2 = 0;
    }

    public void SLpush(E e){
        deque.addFirst(e);
        N1++;
    }

    public void SRpush(E e){
        deque.addLast(e);
        N2++;
    }

    public E SLpop(){
        if(N1 == 0){
            throw new IllegalArgumentException("there is no element in stackLeft");
        }
        N1--;
       return deque.removeFirst();
    }

    public E SRpop(){
        if(N2 == 0){
            throw new IllegalArgumentException("there is no element in stackLeft");
        }
        N2--;
        return deque.removeLast();
    }
}

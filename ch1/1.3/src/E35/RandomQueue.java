package E35;

import java.util.Random;

/**
 * @ClassName: RandomQueue
 * @Description: TODO
 * @Author: DiomChen
 * @Date: 2018/11/22 19:59
 */
public class RandomQueue<E> {
    private int N;
    E [] Arr ;

    public RandomQueue(int x){
        Arr = ( E[] )new Object[x];
    }

    public boolean isEmpty(){
        return N > 0;
    }

    public int size(){
        return N;
    }

    public void enqueue(E e){
        if(N>0 && Arr.length/2<=N){resize(Arr.length*2);}
        Arr[N++] = e;
    }

    public E dequeue(){
        Random r = new Random();
        int index = r.nextInt(N);
        E temp = Arr[index];
        Arr[index] = Arr[N-1];
        Arr[N-1] = null;
        N--;
        return temp;
    }

    public E sample(){
        Random r = new Random();
        int index = r.nextInt(N);
        return Arr[index];
    }

    public void resize(int x){
        E[] temp = ( E[] )new Object[x];
        for(int i=0 ; i<size() ; i++){
            temp[i] = Arr[i];
        }
        Arr = temp;
    }

    public static void main(String[] args) {
        RandomQueue<Integer> rq = new RandomQueue(10);
        rq.enqueue(2);
        rq.enqueue(3);
        rq.enqueue(4);
        rq.enqueue(7);

        rq.enqueue(6);
        rq.enqueue(8);
        rq.enqueue(9);
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());

        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());

    }
}

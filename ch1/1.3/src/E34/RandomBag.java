package E34;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.Random;

/**
 * @ClassName: RandomBag
 * @Description: TODO
 * @Author: DiomChen
 * @Date: 2018/11/22 14:39
 */
public class RandomBag<E> implements Iterable<E> {
    private int N;
    E [] Arr ;

    public RandomBag(int x){
        Arr = ( E[] )new Object[x];
    }
    public boolean isEmpty(){
        return N > 0;
    }

    public int size(){
        return N;
    }

    public void add(E e){
        if(N>0 && Arr.length/2<=N){resize(Arr.length*2);}
        Arr[N++] = e;
    }

    public void resize(int x){
        E[] temp = ( E[] )new Object[x];
        for(int i=0 ; i<size() ; i++){
            temp[i] = Arr[i];
        }
        Arr = temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<E>{

        private int i = N;
        private int index = 0;
        int [] visited = new int[i];
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public E next() {
            Random r = new Random();
            int x = r.nextInt(i);

            while(visited[x]==1&&index <= 9){
                x = r.nextInt(i);
            }
            visited[x] = 1;
            index++;
            return Arr[x];
        }
    }

    public static void main(String[] args) {
        RandomBag<Integer> rb = new RandomBag(10);
        rb.add(1);
        rb.add(2);
        rb.add(3);
        rb.add(4);

        rb.add(5);
        rb.add(6);
        rb.add(7);
        rb.add(8);
        rb.add(9);


        for(Integer x : rb){
            System.out.println(x);
        }

    }
}

package src.索引优先队列;

import java.security.Key;

/**
 * @ClassName: IndexMinPQ
 * @Description: 索引优先队列
 * @Author: DiomChen
 * @Date: 2019/3/3 15:20
 */
public class IndexMinPQ<Item extends Comparable<Item>> {
    private int[] pq;
    private int[] qp;
    private Item[] key;
    private int n;

    public IndexMinPQ(int maxN){
        key = (Item[])new Comparable[maxN+1];
        int[] pq = new int[maxN+1];
        int[] qp = new int[maxN+1];
        for(int i=0 ; i<qp.length ; i++){
            qp[i] = -1;
        }
    }

//    public void insert(int k,Item item){
//    }

    public void insert(int k,Item item){
        n++;
        key[k] = item;
        qp[k] = n;
        pq[n] = k;
        swim(n);
    }

    public void change(int k,Item item){
        key[k] = item;
        swim(qp[k]);
        sink(qp[k]);
    }

    public boolean contains(int k){
        return qp[k] == -1;
    }

    public void delete(int k){
        int index = qp[k];
        exch(index,n--);
        swim(index);
        sink(index);
        key[k] = null;
        qp[k] = -1;
    }

    public Item min(){
        return null;
    }

    public int minIndex(){
        return 0;
    }

    public int delMin(){
        return 0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    private boolean less(int i,int j){

        return key[pq[i]].compareTo(key[pq[i]]) < 0;
    }

    private void exch(int i,int j){
        int s = pq[i];
        pq[i] = pq[j];
        pq[j] = s;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void swim(int k){
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        while(2*k <=n){
            int j = 2*k;
            if(j<n && less(j,j+1))j++;
            if(!less(k,j))break;
            exch(k,j);
            k = j;
        }
    }

    public static void main(String[] args) {
        IndexMinPQ<Integer> im = new IndexMinPQ<>(10);
        im.insert(2,3);
        im.insert(6,5);
        im.insert(7,7);
        im.insert(1,56);
        im.insert(9,8);
    }
}

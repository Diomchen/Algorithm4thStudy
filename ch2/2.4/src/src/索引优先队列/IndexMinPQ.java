package src.索引优先队列;

/**
 * @ClassName: IndexMinPQ
 * @Description: 索引优先队列
 * @Author: DiomChen
 * @Date: 2019/3/3 15:20
 */
public class IndexMinPQ<Item extends Comparable<Item>> {
    private Item[] pq;
    private int[] key;
    private int n;

    public IndexMinPQ(int maxN){
        pq = (Item[])new Comparable[maxN+1];
        key = new int [maxN+1];
    }

//    public void insert(int k,Item item){
//    }

    public void insert(Item item){
        n++;
        key[n] = n;
        pq[key[n]] = item;
        swim(key[n]);
    }

    public void change(int k,Item item){

    }

    public boolean contains(int k){
        return key[k] != 0;
    }

    public void delete(int k){

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

        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i,int j){
        Item t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k){
        if(key[k]==1)return;
        if(less(key[k]/2,key[k])){
            exch(key[k]/2,key[k]);

            swim(key[k]/2);
        }
        return;
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
        IndexMinPQ<Integer> im = new IndexMinPQ<>(5);
        im.insert(3);
        im.insert(5);
        im.insert(7);
        im.insert(56);
        im.insert(8);
    }
}

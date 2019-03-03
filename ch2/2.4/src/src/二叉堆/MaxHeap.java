package src.二叉堆;

/**
 * @ClassName: MaxHeap
 * @Description: 二叉堆
 * @Author: DiomChen
 * @Date: 2019/3/2 20:39
 */
public class MaxHeap <Key extends Comparable<Key>>{
    private Key[] pq;
    private int n;
    public MaxHeap(int max){
        pq = (Key[]) new Comparable[max+1];
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void insert(Key v){
        n++;
        pq[n] = v;
        swim(n);
    }

    public Key delMax(){
        Key t = pq[1];
        exch(n,1);
        pq[n] = null;
        n--;
        sink(1);
        return t;
    }

    private boolean less(int i,int j){

        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i,int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k){
        if(k==1)return;
        if(less(k/2,k)){
             exch(k/2,k);
             swim(k/2);
        }
        return;
    }

    private void sink(int k){
        if(2*k+1>n)return;
        //这里是我最初的版本，其实减少步骤的写法就是先比较子的大小，再拿最大的来和父比
        if(less(k,2*k)||less(k,2*k+1)){
            if(less(k,2*k)){
                exch(k,2*k);
                sink(2*k);
            }
            else if(less(k,2*k+1)){
                exch(k,2*k+1);
                sink(2*k+1);
            }
        }
        return;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> mh = new MaxHeap<>(5);
        mh.insert(3);
        mh.insert(5);
        mh.insert(7);
        mh.insert(56);
        mh.insert(8);

        while(!mh.isEmpty()){
            System.out.println(mh.delMax());
        }

    }
}

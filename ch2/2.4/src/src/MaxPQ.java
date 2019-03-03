package src;

/**
 * @ClassName: tes.MaxPQ
 * @Description: 泛型优先队列(基于普通数组)
 * @Author: DiomChen
 * @Date: 2019/3/1 16:09
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private int size;
    private Key[] arr;

    public MaxPQ(){
        size = 0;
        arr = (Key[]) new Comparable[10] ;
    }

    public MaxPQ(int max){
        size = 0;
        arr = (Key[]) new Comparable[max] ;
    }

    public MaxPQ(Key[] a){
//        size = a.length;
//        arr = (Key[]) new Comparable[size];
//        tes.MaxPQ mpq = new tes.MaxPQ();
//        for(int i=0 ; i<a.length ; i++){
//            mpq.Insert(a[i]);
//        }
//        for(int i=0 ; i<a.length ; i++){
//            arr[i] = (Key) mpq.delMax();
//        }
    }

    public void Insert(Key v){
        for(int i=0 ; i<size ; i++){
            if(less(arr[i],v)){
                if(size>= arr.length-1)resize(arr, arr.length*2);
                for(int j=i ; j<=size ;j++ ){
                    arr[j+1] = arr[j];
                }
                arr[i] = v;
                size++;
            }
        }
    }

    public Key max(){
        if(size == 0)throw new IllegalArgumentException("优先队列为空");
        return arr[0];
    }

    public Key delMax(){
        Key max = arr[0];
        for(int i=0 ; i<size-1 ; i++){
            arr[i] = arr[i+1];
        }
        if(size<= arr.length/4)resize(arr,arr.length/2);
        size--;
        return max;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b) < 0;
    }

    public Key[] resize(Key[]a,int n){
        Key[] mid = (Key[])new Object[n];
        for(int i=0 ; i<a.length ; i++){
            mid[i] = a[i];
        }
        a = mid;
        return a;
    }
    public static void main(String[] args) {
        MaxPQ<Integer> a = new MaxPQ<>();
        a.Insert(23);
        a.Insert(43);
        a.Insert(54);
        a.Insert(223);
        a.Insert(234);

        a.Insert(234);
        a.Insert(54);
        a.Insert(256);
        a.Insert(267);
        a.Insert(275);

        a.Insert(87);
        a.Insert(29);
        a.Insert(267);
        for (int i=0 ; i<a.size() ; i++){
            System.out.println(a.delMax());
        }


    }
}

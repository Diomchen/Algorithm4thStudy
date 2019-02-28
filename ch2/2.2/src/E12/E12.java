package E12;

import edu.princeton.cs.algs4.StdOut;

import java.util.List;

/**
 * @ClassName: E12
 * @Description: 次线性的额外空间
 * @Author: Shuhan Chen
 * @Date: 2019/02/25 21:31
 */
public class E12 {
    private static Comparable[] aux;

    //自顶向下归并排序
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort( a ,4 );
    }

    private static void sort(Comparable[] a , int M){
        //这里对每一个块内部进行排序
        for(int i=0 ; i<a.length ; i+=M){
            SelectSort(a,i,i+M );
        }

        //此处mid的定义就是，前一个合并块与后一个合并块之间的边界
        for(int i=0 ; i<a.length-M ; i+=M){
            int m = i+2*M-1;
            merge(a,0,m-M,m);
        }
    }

    private static void SelectSort(Comparable[] a,int l,int r){
        for(int i=l ; i<r ; i++){
            int min = i;
            for(int j=i+1 ; j<r ; j++){
                if(!less(a[min],a[j])){
                    min = j;
                }
            }
            exch(a,min,i);
        }

    }

    public static void merge(Comparable[] a , int lo , int mid , int hi){
        int i = lo;
        int j = mid+1;
        for(int k=lo ; k<=hi ; k++){
            aux[k] = a[k];
        }

        for(int k=lo ; k<=hi ; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a){
        for(int i=0 ; i < a.length ; i++){
            StdOut.print(a[i]+" ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a){
        for(int i=1 ; i<a.length ; i++){
            if(less(a[i],a[i-1]))return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String a[] = {"M","E","R","G","E","S","O","R","T","E","X","A","M","P","L","E"};
        sort(a);
        for(int i=0 ; i<a.length ; i++){
            System.out.print(a[i]+" ");
        }
    }
}

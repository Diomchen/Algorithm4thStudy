package E9;

import edu.princeton.cs.algs4.StdOut;

/**
 * @ClassName: E9
 * @Description: 不使用静态数组，也将aux[]变为merge()的局部变量，
 * @Author: Shuhan Chen
 * @Date: 2019/02/25 17:47
 */
public class E9 {

    //自顶向下归并排序
    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }
    private static void sort(Comparable[] a ,Comparable[] aux, int lo , int hi){
        if(lo>=hi) return;
        int mid = lo+(hi-lo)/2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        merge(a,aux,lo,mid,hi);
    }

    //自底向上归并排序
//    public static void sort(Comparable[] a){
//        int N = a.length;
//        aux = new Comparable[N];
//        for(int sz=1 ; sz<N ; sz = sz+sz){
//            for(int lo=0 ; lo<N-sz ; lo+= sz+sz){
//                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
//            }
//        }
//    }

    //第一种归并方法 ，非原地，需要借助辅助函数
    public static void merge(Comparable[] a , Comparable[] aux,int lo , int mid , int hi){
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
            System.out.println(a[i]);
        }
    }
}

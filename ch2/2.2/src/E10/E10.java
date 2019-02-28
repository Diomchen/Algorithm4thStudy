package E10;

import edu.princeton.cs.algs4.StdOut;

/**
 * @ClassName: E10
 * @Description: 按降序将a[]后半部分复制到aux[]，再将其归并到a[]
 * @Author: Shuhan Chen
 * @Date: 2019/02/25 18:00
 */
public class E10 {
    private static Comparable[] aux;

    //自顶向下归并排序
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a , int lo , int hi){
        if(lo>=hi) return;
        int mid = lo+(hi-lo)/2;
        sort(a,lo,mid);

        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
        System.out.print("merge(a,"+lo+","+mid+","+hi+"):");
        for(int i=0 ; i<a.length ; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
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
    public static void merge(Comparable[] a , int lo , int mid , int hi){
        int i = lo;
        int j = hi;
        //在这里，先分成两个数组
        for(int k=lo ; k<=mid ; k++){
            aux[k] = a[k];
        }

        for(int k=mid+1 ; k<=hi ; k++){
            aux[k] = a[hi-k+mid+1];
        }

        //j--避免了两边的判断
        for(int k=lo ; k<=hi ; k++) {
            if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j--];
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
//        for(int i=0 ; i<a.length ; i++){
//            System.out.print(a[i]+" ");
//        }
    }
}

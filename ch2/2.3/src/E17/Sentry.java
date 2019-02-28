package E17;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @ClassName: Sentry
 * @Description: 习题2.3.17,不知道为什么  老是出现数组越界的问题  按道理是不应该的
 * @Author: Shuhan Chen
 * @Date: 2019/02/28 13:47
 */
public class Sentry {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo)return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    //划分
    private static int partition(Comparable[] a ,int lo,int hi){
        int i=lo,j = hi+1;
        Comparable v = a[lo];
        while(true){
            while(less(a[++i],v));

            while(less(v,a[--j]));
            StdOut.println("i:" + i + " j:" + j);//for test

            if(i>=j)break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
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
        String[] str = {"Q","U","I","C","K","S","O","R","T","M","Y","H","A","P","P"};
        sort(str);
        for(int i=0 ; i<str.length ; i++){
            System.out.print(str[i]+" ");
        }

    }


}

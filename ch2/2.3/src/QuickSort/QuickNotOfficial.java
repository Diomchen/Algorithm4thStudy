package QuickSort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @ClassName: QuickNotOfficial
 * @Description:
 * @Author: Shuhan Chen
 * @Date: 2019/01/24 09:51
 */
public class QuickNotOfficial {
    public static void sort(Comparable[] a){
        Comparable sp = a[0];
        int N = a.length;
        int k = 0;
        for(int i=1 ; i<N ; i++){
            if(less(a[i],sp)){
               Comparable ti = a[i];
                for(int j=i ; j>0 ; j--){
                   a[j] = a[j-1];
               }
               a[0] = ti;
                k++;
            }
        }
        sort(a,0,k);
        sort(a,k,N);
    }

    //N 为数组的溢出位
    private static void sort(Comparable[] a,int lo,int hi){
        for(int i=lo ; i<hi ; i++){
            int min = i;
            Comparable sp = a[i];
            for(int j=i+1 ; j<hi ; j++){
                if(less(a[j],a[min])){
                    min = j;
                }
            }
            exch(a,min,i);
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
        String[] str = {"Q","U","I","C","K","S","O","R","T","M","Y","H","A","P","P"};
        sort(str);
        for(int i=0 ; i<str.length ; i++){
            System.out.print(str[i]+" ");
        }

    }

}

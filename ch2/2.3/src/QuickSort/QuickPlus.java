package QuickSort;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @ClassName: QuickPlus
 * @Description: 对于小数组，快排比插入排序要慢，且快排在递归过程也会调用自己，针对如上情况，稍微改进一下
 * @Author: Shuhan Chen
 * @Date: 2019/02/28 13:08
 */
public class QuickPlus {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo,int hi){
        //加号后面与系统参数有关，一般取值为5~15
        if(hi<=lo+5){
            Insertion.sort(a,lo,hi);
            return;
        };
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    //划分
    private static int partition(Comparable[] a ,int lo,int hi){
        int i=lo,j = hi+1;
        Comparable v = a[lo];
        while(true){
            while(less(a[++i],v)){
                if(i == hi)break;
            }
            while(less(v,a[--j])){
                if(j == lo)break;
            }
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

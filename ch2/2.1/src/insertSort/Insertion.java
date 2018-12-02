package insertSort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @ClassName: Insertion
 * @Description: InsertSort
 * @Author: DiomChen
 * @Date: 2018/12/2 16:19
 */
public class Insertion {

    private static void sort(Comparable[] a){
        int N = a.length;
        for(int i=1 ; i<N ; i++){
            int j=i-1;
            Comparable min = a[i];
            while(j>=0 && less(min,a[j])){
                exch(a,j+1,j);
                j--;
            }
            a[j+1] = min;
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
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(args[0]);
        System.setIn(fis);

        String[] a = StdIn.readStrings();

        sort(a);
        assert isSorted(a);
        show(a);


    }
}

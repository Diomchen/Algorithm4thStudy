package E14;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * @ClassName: E14
 * @Description: 将两个有序的队列作为参数传入并合并到一起
 * @Author: Shuhan Chen
 * @Date: 2019/02/28 09:39
 */
public class E14 {
    private static Comparable[] aux;

    //自顶向下归并排序
    public static void sort(Queue<String> a,Queue<String> b){
        aux = new Comparable[a.size()+b.size()];
        merge(a,b);
    }

    public static void merge(Queue<String> a,Queue<String> b){
        int len = a.size()+b.size();

        for(int i=0 ; i<len ; i++){
            if(a.peek() == ""){
                aux[i] = b.dequeue();
            }
            else if(b.peek() == ""){
                aux[i] = a.dequeue();
            }
            else if(a.peek() == "" && b.peek() == ""){
                break;
            }
            else if(less(a.peek(),b.peek())){
                    aux[i] = a.dequeue();
            }
            else{
                    aux[i] = b.dequeue();
            }
            System.out.println(i + " - "+aux[i]);
        }

//        for(int i=0 ; i<len; i++){
//            System.out.print(aux[i]);
//        }
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
//        String a[] = {"M","E","R","G","E","S","O","R","T","E","X","A","M","P","L","E"};
        Queue<String> a = new Queue<>();
        Queue<String> b = new Queue<>();
        a.enqueue("A");
        a.enqueue("B");
        a.enqueue("C");
        a.enqueue("D");

        b.enqueue("A");
        b.enqueue("B");
        b.enqueue("C");
        b.enqueue("D");
//        b.enqueue("E");

        sort(a,b);
//        for(int i=0 ; i<a.length ; i++){
//            System.out.print(a[i]);
//        }
    }
}

package QuickUnion;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

/**
 * @ClassName: QU
 * @Description: QuickUnion
 * @Author: DiomChen
 * @Date: 2018/11/27 21:41
 */
public class QU {
    private int [] id;
    private int count;

    public QU( int N){
        id = new int[N];
        count = N;
        for(int i=0 ; i<N ; i++){
            id[i] = i;
        }
    }

    public boolean connected(int q,int p ){
        return find(q) == find(p);
    }

    public int count(){
        return count;
    }

    public int find(int x){
        while(x!=id[x]){
            x = id[x];
        }
        return x;
    }

    public void union(int q, int p){
        int qRoot = id[q];
        int pRoot = id[p];
        if(qRoot == pRoot){
            return;
        }
        id[pRoot] = qRoot;//将pRoot的根节点修改为qRoot的根节点，从而实现两树合并
        count--;
    }

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.println("Please input N :");
        int N  = in.nextInt();
        QU uf = new QU(N);
        int p = 0;
        int q = 0;
        while(true){
            System.out.println("Please input 'p' and 'q' : ");
            p = in.nextInt();
            if(p == 99999){
                break;
            }
            q = in.nextInt();
            if(!uf.connected(p,q)){
                uf.union(p,q);
            }
        }
//        uf.consoleConnect(N);
        StdOut.println("----------------\n"+ uf.count()+" components ");
    }

}

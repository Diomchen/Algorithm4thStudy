package E17;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Scanner;

/**
 * @ClassName: ErdosRenyi
 * @Description: TODO
 * @Author: DiomChen
 * @Date: 2018/12/8 20:36
 */
public class ErdosRenyi {
    private int [] id;
    private int count;
    public ErdosRenyi(int N){
        count = N;
        id = new int[N];
        for(int i=0 ; i<N ; i++){
            id[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    public int find(int x){
        return id[x];
    }

    public void union(int p,int q){
        int qRoot = id[q];
        int pRoot = id[p];
        if(qRoot == pRoot){return ;}
        for(int i=0 ; i<id.length ; i++){
            if(id[i] == qRoot) id[i] = pRoot ;
        }
        count--;
    }

    public static void main(String[] args) {
        Scanner in = new  Scanner(System.in);
        int N = in.nextInt();
        int k=0;
        ErdosRenyi r = new ErdosRenyi(N);
        while(r.count()>1){
            int p = StdRandom.uniform(N);
            int q = StdRandom.uniform(N);
            if(!r.connected(p,q)){
                r.union(p,q);
                k++;
            }
        }
        System.out.println(k);


    }

}

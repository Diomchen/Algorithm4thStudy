package UnionFind;

import edu.princeton.cs.algs4.StdOut;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/*
* Author    :   DiomChen
* Data      :   2018-11-20
* Func      :   Union-find
* Detail    :   利用quick_find实现union函数
*
* */
public class UF {
    private int []id;
    private int count;
    public UF(int N){
        id = new int[N];
        for(int i=0 ; i<N ; i++){
            id[i] = i;
        }
        count = N;
    }

    public int count(){
        return count;
    }

    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    public void union(int p,int q){
        int pId = id[p];
        int qId = id[q];

        if(pId == qId){
            return ;
        }

        for(int i=0 ; i<id.length ; i++){
            if(id[i] == pId)
                id[i] = qId;
        }

        count--;
    }

    public int find(int p){
        return id[p];
    }

    public void consoleConnect(int N){
        LinkedList<Integer> lTemp = new LinkedList<>();

        for(int i=0 ; i<id.length-1 ; i++){
            StringBuilder strb = new StringBuilder();
            if(!lTemp.contains(id[i])){
                strb.append(i);
                lTemp.addLast(id[i]);
                for(int j = i+1 ; j<id.length ; j++){
                    if(id[i] == id[j]){
                        strb.append("-->"+j);
                    }
                }
                System.out.println(strb.toString());
            }
        }
    }

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.println("Please input N :");
        int N  = in.nextInt();
        UF uf = new UF(N);
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
        uf.consoleConnect(N);
        StdOut.println("----------------\n"+uf.count()+" components ");
    }
}

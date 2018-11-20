package UnionFind;

import java.sql.SQLOutput;
import java.util.Scanner;

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
    }

    public int count(){
        return count;
    }

    public boolean connected(int p,int q){
        return id[p] == id[q];
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
    }

    public int find(int p){
        return id[p];
    }

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.println("Please input N :");
        int N  = in.nextInt();
        UF uf = new UF(N);
        while(){

        }

    }
}

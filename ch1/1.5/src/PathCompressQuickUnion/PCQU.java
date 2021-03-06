package PathCompressQuickUnion;

import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName: PCQU
 * @Description: 在find中添加一行寻找共同根节点的代码，使得速度无限趋近于1
 * @Author: DiomChen
 * @Date: 2018/11/28 21:15
 */
public class PCQU {
    private int [] id;
    private int count;
    private int[] sz;

    public PCQU(int N){
        id = new int[N];
        sz = new int[N];
        count = N;
        for(int i=0 ; i<N ; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int q,int p){
        return find(q) == find(p);
    }

    public int find(int x){
        while(x!=id[x]){
            id[x] = id[id[x]];//<<<<<<<<<----------------------这就是路径压缩quick-find
            x = id[x];
        }
        return x;
    }

    public void union(int q,int p){
        int qRoot = id[q];
        int pRoot = id[p];
        if (qRoot == pRoot){
            return ;
        }

        if(sz[qRoot] < sz[pRoot]){
            id[qRoot] = pRoot;
            sz[pRoot]+=sz[qRoot];
        }
        else{
            id[pRoot] = qRoot;
            sz[qRoot]+=sz[pRoot];
        }
        count-- ;
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
                        strb.append("--"+j);
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
        PCQU uf = new PCQU(N);
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
        StdOut.println("----------------\n"+uf.count()+" components ");
    }
}

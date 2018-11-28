package QuickUnion;

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

}

package E18;

/**
 * @ClassName: RandomGrid
 * @Description: 网格生成器
 * @Author: DiomChen
 * @Date: 2018/12/8 21:07
 */
public class RandomGrid {

    private int[][] id;
    private int count;
    public RandomGrid(int N){
        count = N;
        int co = 1;
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                id[i][j] = co;
                co++;
            }
        }
    }


}

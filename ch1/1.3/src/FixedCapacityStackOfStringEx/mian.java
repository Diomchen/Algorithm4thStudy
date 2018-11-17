package FixedCapacityStackOfStringEx;

import edu.princeton.cs.algs4.StdRandom;

public class mian {
    public static void main(String[] args) {
        double[] i = new double[10];
           int N = 5;
           for(int j=0 ; j<10 ; j++){
               i[j] = StdRandom.random()*55;
               System.out.println(i[j]);
           }
        System.out.println("---"+i[--N]);
        System.out.println(N);
        System.out.println("---"+i[N--]);
           /*
           *
            10.764355092625555
            20.59339124709063
            35.84623917932062
            19.586990400506025
            16.423257303466563      <--i[--N]         先减再算
            34.73287434919255       <--i[5] == i[N--] 先算再减
            16.183043092295073
            9.271732854692043
            6.782577099307206
            36.115563611870925
            34.73287434919255---19.586990400506025
           * */
    }
}

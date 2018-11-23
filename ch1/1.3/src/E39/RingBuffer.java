package E39;

/**
 * @ClassName: RingBuffer
 * @Description: 环形缓冲区
 * @Author: DiomChen
 * @Date: 2018/11/23 20:03
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ----------------------API-------------------------
 * public class RingBuffer<E>
 * --------------------------------------------------
 *  int size()                  返回操作区数组元素
 *  boolean isEmpty()           检测操作区是否为空
 *  RingBuffer()                初始化
 *  void enterBuffer(E e)       加入缓冲区
 *  private void enQueue(E e)   加入操作区（队列）
 *  E outQueue()                从操作区（队列）删除元素
 */
public class RingBuffer<E> {
    private Queue<E> queue ;
    private E[] RBQueue ;
    private int N;
    private int RBN;

    public RingBuffer(){
        queue = new LinkedList<>();
        RBQueue = (E[])new Object[10];
    }

    public void enterRingBuffer(E e){
        if(RBN!=10){
            RBQueue[RBN] = e;
            RBN++;
        }
        else {
            E m = RBQueue[0];
            for(int i=0 ; i<RBN-1 ; i++){
                RBQueue[i] = RBQueue[i+1];
            }
            RBQueue[RBN-1] = e;
            enQueue(m);
        }
    }

    private void enQueue(E e){
        System.out.println("---------"+e+"coming into OperatorQueue..");
        queue.offer(e);
    }

    public E outQueue(){
        return queue.remove();
    }

    public boolean isEmpty(){
        return N > 0;
    }

    public int size(){
        return N;
    }

    public static void main(String[] args) {
        RingBuffer<Integer> rb = new RingBuffer<>();
        rb.enterRingBuffer(1);
        rb.enterRingBuffer(2);
        rb.enterRingBuffer(3);
        rb.enterRingBuffer(4);
        rb.enterRingBuffer(5);
        rb.enterRingBuffer(6);
        rb.enterRingBuffer(7);
        rb.enterRingBuffer(8);
        rb.enterRingBuffer(9);
        rb.enterRingBuffer(10);

        rb.enterRingBuffer(11);
        rb.enterRingBuffer(12);
        rb.enterRingBuffer(13);
    }
}

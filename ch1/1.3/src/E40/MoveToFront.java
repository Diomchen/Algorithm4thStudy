package E40;

/**
 * @ClassName: MoveToFront
 * @Description: 前移编码  程序缺点就是remove函数写的比较啰嗦
 * @Author: DiomChen
 * @Date: 2018/11/23 20:53
 */
public class MoveToFront {
    private int N;
    private Node first;
    private int mc;

    private class Node{
        public Node next ;
        public Character e;

        public Node (Character e){
            this(null,e);
        }

        public Node (Node next, Character e){
            this.e = e;
            this.next = next;
        }

        public Node (){
            this(null,null);
        }
    }

    public boolean isEmpty(){
        return N>0;
    }

    public int size(){
        return N;
    }

    public void add(Character e){
        Node node = new Node(e);
        if(first == null){
            first = node;
        }
        else {
            node.next = first;
            first = node;
        }
        N++;
    }

    public Character remove(int i){//1
        int k = 0;
        Node temp = first;
        while(i!=k+1){
            temp = temp.next;
            k++;
        }

        if(N == 1 && i == 1){
            N--;
            first = null;
            return temp.e;
        }
        else if(N != 1 && i == N ){
            N--;
            Node node = getNodeByIndex(N-1);
            node.next = null;
            return temp.e;
        }
        else if(N !=1 && i == 1){
            N--;
            first = first.next;
            return temp.e;
        }
        else {
            N--;
            Node node = getNodeByIndex(k-1);
            node.next = temp.next;
            return temp.e;
        }
    }

    public Node getNodeByIndex(int x){
        Node f = first;
        for(int i=0 ; i<x ; i++){
            if(f.next!=null){
                f = f.next;
            }
            else{
                throw new IllegalArgumentException("Can't exits this pos!!!");
            }
        }
        return f;
    }

    public boolean contains(Character e){
        Node temp = first;
        mc = 0;
        while(temp!=null){
            mc++;
            if(temp.e == e){
                return true;
            }
            else {
                temp = temp.next;
            }
        }
        return false;
    }

    public void operatorStr(String str){
        char[] charArr = str.toCharArray();
        for(int i=0 ; i<charArr.length ; i++){
            if(contains(charArr[i])){
                System.out.println(mc);
                remove(mc);
            }
            add(charArr[i]);
        }
    }

    public static void main(String[] args) {
        MoveToFront m2f = new MoveToFront();

        m2f.operatorStr("abdda");

    }
}

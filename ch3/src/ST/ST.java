package ST;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

/**
 * @ClassName: ST.ST
 * @Description:
 * @Author: Shuhan Chen
 * @Date: 2019/03/17 14:41
 */
public class ST<Key extends Comparable<Key>,Value> implements Iterable<Key> {
    private TreeMap<Key,Value> st;

    public ST(){
        st = new TreeMap<Key,Value>();
   }

   void put(Key key,Value val){
        if(key == null)throw new IllegalArgumentException("call get() with null key");
        if(val == null)throw new IllegalArgumentException("call get() with null val");
        else
            st.put(key,val);
   }

   Value get(Key key){
        if(key == null)throw new IllegalArgumentException("call get() with null key");
        return st.get(key);
   }

   void delete(Key key){
       put(key,null);
   }

   boolean contains(Key key){
       return get(key) != null;
   }

   boolean isEmpty(){
       return size() == 0;
   }

   int size(){
        return st.size();
   }

   Key min(){
        if(st.isEmpty())throw new NoSuchElementException("calls min() with empty symbol table");
        return st.firstKey();
    }

   Key max(){
       if(st.isEmpty())throw new NoSuchElementException("calls min() with empty symbol table");
        return st.lastKey();
    }

   Key floor(Key key){
        if (key == null) throw new IllegalArgumentException("call floor() with null key");
        Key k = st.floorKey(key);
        if(k == null) throw new NoSuchElementException("all keys are greater than"+key);
        return k;
   }

   Key ceiling(Key key){
       if (key == null) throw new IllegalArgumentException("call floor() with null key");
       Key k = st.ceilingKey(key);
       if(k == null) throw new NoSuchElementException("all keys are less than"+key);
       return k;
   }

//   int rank(Key key){
//
//   }
//
//   Key select(int k){
//
//   }
//
//   void deleteMin(){
//
//
//   }
//
//   void deleteMax(){
//
//   }
//
//   //[lo...hi]之间的键的数量
//   int size(Key lo,Key hi){
//
//   }
//
//   //[lo...hi]之间的所有的键，已经排序
//   Iterable<Key> keys(Key lo,Key hi){
//
//   }

   //所有键，已排序
   Iterable<Key> keys(){
        //返回一个键集合
        return st.keySet();
   }


   //迭代处理
    @Override
    public Iterator<Key> iterator() {
        return st.keySet().iterator();
    }

    public static void main(String[] args) {
        ST<String,Integer> st = new ST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++){
            String key = StdIn.readString();
            st.put(key,i);
        }
        for(String s:st.keys()){
            StdOut.println(s+" "+st.get(s));
        }
    }

}

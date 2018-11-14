package BagUse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

// implements Iterable<T>
public class Bag<T>{

    private ArrayList bag;
    public Bag(){
        bag = new ArrayList();
    }

    public void add(T t){
        bag.add(t);
    }

    public boolean isEmpty(){
        return bag.isEmpty();
    }

    public int size(){
        return bag.size();
    }

//    public T getbag(){
//        return (T) bag.get((int) (Math.random()*(size()-1)));
//    }
//    @Override
//    public Iterator<T> iterator() {
//        return null;
//    }
//
//    @Override
//    public void forEach(Consumer<? super T> action) {
//
//    }
//
//    @Override
//    public Spliterator<T> spliterator() {
//        return null;
//    }
}

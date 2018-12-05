package E33;

import E31.DoubleLinkedList;

import java.util.Iterator;

/**
 * @ClassName: Deque
 * @Description: 由于在 E31 中实现了双端链表，相同的列子不再写
 * @Author: DiomChen
 * @Date: 2018/11/22 14:29
 */
public class Deque<E> extends DoubleLinkedList<E> implements Iterable<E> {

    private int N;

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public int size() {
        this.N = super.size();
        return super.size();
    }

    @Override
    public void addFirst(E e) {
        super.addFirst(e);
    }

    @Override
    public void addLast(E e) {
        super.addLast(e);
    }

    @Override
    public E removeFirst() {
        return super.removeFirst();
    }

    @Override
    public E removeLast() {
        return super.removeLast();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<E>{

        private int i = N;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public E next() {
            return null;
        }
    }

    public static void main(String[] args) {
        Deque<Integer> d = new Deque();
        d.addFirst(1);
        d.addFirst(2);
        d.addFirst(3);
        d.addLast(4);
        d.addLast(5);
        d.addLast(6);

        d.removeFirst();
        d.removeLast();



    }

}

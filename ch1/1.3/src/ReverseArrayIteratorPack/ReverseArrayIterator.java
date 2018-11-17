package ReverseArrayIteratorPack;

import java.util.Iterator;

//implements Iterable<User>
public class ReverseArrayIterator {

    private User[] users = (User[])new Object[1];
    private int N = 0;
    public boolean isEmpty(){ return N == 0;}
    public int size(){return N;}

    private void resize(int max){
        User[] temp = (User[]) new Object[max];
        for(int i = 0 ; i<N ; i++){
            temp[i] = users[i];
        }
        users = temp;
    }
    public void push(User u){
        if(N == users.length)resize(users.length*2);
        users[N++] = u;

    }

    public User pop(){
        if(users.length == 0)
            throw new IllegalArgumentException("there is no element in stack");
            User u = users[--N];
            users[N] = null;
            if(N>0 && users.length/4==N){
                resize(users.length/2);
            }
            return u;
    }

//    @Override
//    public Iterator<User> iterator() {
//        return new ReverseArrayIterator();
//    }

    private class RAI{
        private int i=N;
        public boolean hasNext(){ return i>0 ;}
        public User next(){ return users[--i]; }
        public void remove (){}
    }
}

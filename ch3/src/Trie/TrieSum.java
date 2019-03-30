package Trie;

import java.util.TreeMap;

/**
 * @ClassName: TrieSum
 * @Description:
 * @Author: Shuhan Chen
 * @Date: 2019/03/30 22:14
 */
public class TrieSum {
    private class Node{
        public boolean isWord;
        public int value;
        public TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    public Node root;
    public int size;

    public TrieSum(){
        root = new Node();
        size = 0;
    }

    public int GetSize(){
        return size;
    }

    public void add(String word){
        Node p = root;
        for(int i=0 ; i<word.length() ; i++){
            char c = word.charAt(i);
            if(p.next.get(c) == null){
                p.next.put(c,new Node());
            }
            p = p.next.get(c);
        }
        p.isWord = true;
    }

    public boolean contains(String word){
        Node p = root;
        for(int i=0 ; i<word.length() ; i++){
            char c = word.charAt(i);
            if(p.next.get(c) == null) {
                return false;
            }
            p = p.next.get(c);
        }
        return p.isWord;
    }

    public boolean isPrefix(String wordPre){
        Node p = root;
        for(int i=0 ; i<wordPre.length() ; i++){
            char c = wordPre.charAt(i);
            if(p.next.get(c) == null)
                return false;
            p = p.next.get(c);
        }
        return true;
    }

    public boolean search(String word){
        return match(root,word,0);
    }

    private boolean match(Node node,String word,int index){
        if(index == word.length()){
            return node.isWord;
        }
        char c = word.charAt(index);
        if(c!='.'){
            if(node.next.get(c) == null){
                return false;
            }
            return match(node.next.get(c),word,index+1);
        }
        else {
            for(char nextchar : node.next.keySet()){
                if(match(node.next.get(nextchar),word,index+1)) {
                    return true;
                }
            }
            return false;
        }
    }




    public static void main(String [] args){
        Trie tr = new Trie();
        tr.add("Chenshuhan");
        tr.add("xixihaha");
        tr.add("yangkaiyou");
        tr.add("Chens");

        System.out.println(tr.contains("Chenshuhan"));
        System.out.println(tr.contains("xixihaha"));
        System.out.println(tr.contains("yangkaiyou"));
        System.out.println(tr.search("C...s"));
    }

}

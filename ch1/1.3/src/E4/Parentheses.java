package E4;

import java.util.Objects;

public class Parentheses {
    public static void main(String[] args) {
        MyStack<Character> Ms = new MyStack<>();
        String str = "[()]{}{[()()]()}";
        char[] cstr = str.toCharArray();
        for(int i=0 ; i<str.length() ; i++){
            if(Objects.equals(cstr[i],'[')||Objects.equals(cstr[i],'{')||Objects.equals(cstr[i],'(')){
                Ms.push(cstr[i]);
                System.out.println(cstr[i]);
            }
            else if(Objects.equals(cstr[i],')')){
                char t = Ms.remove();
                System.out.println("--->"+t+')');
                if(!Objects.equals(t,'(')){
                    Ms.push(t);
                }
            }
            else if(Objects.equals(cstr[i],']')){
                char t = Ms.remove();
                System.out.println("--->"+t+']');
                if(!Objects.equals(t,'[')){
                    Ms.push(t);
                }
            }
            else if(Objects.equals(cstr[i],'}')){
                char t = Ms.remove();
                System.out.println("--->"+t+'}');
                if(!Objects.equals(t,'{')){
                    Ms.push(t);
                }
            }
        }
        if(!Ms.isEmpty()){
            System.out.println("No!!!");
        }
        else {
            System.out.println("Yes");
        }

    }
}

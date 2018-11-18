package E10;

import E4.MyStack;

import java.util.Objects;
import java.util.Scanner;

/*
*3.1中序转后序算法

1、当输入的是操作数时候，直接输出
2、当输入开括号时候，把它压栈
3、当输入的是闭括号时候，先判断栈是否为空，若为空，则发生错误并进行相关处理。若非空，把栈中元素依次出栈输出，直到遇到第一个开括号，若没有遇到开括号，也发生错误，进行相关处理
4、当输入是运算符op（+、- 、×、/）时候
a)循环，当（栈非空and栈顶不是开括号and栈顶运算符的优先级不低于输入的运算符的优先级）时，反复操作：将栈顶元素出栈输出
b)把输入的运算符op压栈
5、当中序表达式的符号序列全部读入后，若栈内仍有元素，把他们依次出栈输出。若弹出的元素遇到空括号，则说明不匹配，发生错误，并进行相关处理

* */
public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        StringBuilder strb = new StringBuilder();
        char[]  Arr = str.toCharArray();
        MyStack<Character> msCh = new MyStack<>();
        for(int i=0 ; i<str.length() ; i++){
            if(Objects.equals(Arr[i],'(')){
                msCh.push(Arr[i]);
            }
            else if(Arr[i]<='9'&&Arr[i]>='0'){
                strb.append(String.valueOf(Arr[i]));
            }
            else if(Objects.equals(Arr[i],')')){
                if(msCh.isEmpty()){
                   throw new IllegalArgumentException("error");
                }
                else {
                    while(!msCh.peek().equals('(')){
                        strb.append(msCh.remove());
                        if(msCh.isEmpty()){
                            throw new IllegalArgumentException("error");
                        }
                    }
                    msCh.remove();
                }
            }
            else if(Objects.equals(Arr[i],'+')
                    ||Objects.equals(Arr[i],'-')
                    ||Objects.equals(Arr[i],'*')
                    ||Objects.equals(Arr[i],'/')){
                while(!msCh.isEmpty()&&!msCh.peek().equals('(')&&ifOperatorTStack(msCh,Arr[i])){
                    strb.append(msCh.remove());
                    if(!msCh.isEmpty()&&msCh.peek().equals('(')){
                        msCh.remove();
                    }
                }

                msCh.push(Arr[i]);
            }
        }
        while(!msCh.isEmpty()){
            if(!msCh.peek().equals(')')||!msCh.peek().equals('(')){
                strb.append(msCh.remove());
            }
        }

        System.out.println(strb.toString());
    }

    public static boolean ifOperatorTStack(MyStack<Character> MSCh, char currOpr){
        int msch = 0;
        int cur = 0;

        if((MSCh.peek() == '*'||MSCh.peek() == '/')){
            msch = 1;
        }
        if(currOpr == '+'||currOpr == '-'){
            cur = 2;
        }
        if((currOpr == '*'||currOpr == '/')){
            cur = 1;
        }
        if((MSCh.peek() == '+'||MSCh.peek() == '-')){
            msch = 2;
        }

        if(msch<=cur&&msch!=0){
            return true;
        }
        else {
            return false;
        }
    }
}

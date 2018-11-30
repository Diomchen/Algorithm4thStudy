package E43;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.util.Scanner;

/**
 * @ClassName: FileList
 * @Description: 读取文件列表所有的文件
 * @Author: DiomChen
 * @Date: 2018/11/27 12:57
 */
public class FileList {

    public FileList(String path){

        if( path.substring(3).equals("")){
            File f = new File(path);
            File[] fl = f.listFiles();

            for(File x:fl){
//                System.out.println(x);
                recursionPath(x);
            }
//            System.out.println("hhhhhhhhhhh");
        }
        else {
            File file = new File(path);
            recursionPath(file);
        }
    }

    /*##########################################
    *
    *  1.通过字符串递归实现
    *
    * ##########################################
    * */

    public void recursionPath(File file){
        if(file.exists()){
            for(File f:file.listFiles()){
                if(f.isDirectory()){
                    System.out.println(f.getPath());
                    recursionPath(f);
                }
                else if(f.isFile()){
                    StdOut.println(f.getPath());
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input the absolute path:");
        String path = in.nextLine();
        FileList fl = new FileList(path);

    }
}

package E43;

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
        File file = new File(path);
        recursionPath(file);
    }

    public void recursionPath(File file){
        if(file.isDirectory()) {
            File[] fArr = file.listFiles();
            for(File f:fArr){
                if(f.isDirectory()){
                    recursionPath(f);
                }
                else
                    System.out.println("\\"+f.getName()+"\n");
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

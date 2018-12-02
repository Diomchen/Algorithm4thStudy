package E43;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName: QueueFileList
 * @Description: QueueFileList
 * @Author: DiomChen
 * @Date: 2018/11/30 19:17
 */
public class QueueFileList {

    private Queue<String> queue;
    public QueueFileList(String path){
        queue = new LinkedList<>();
        File file = new File(path);
        recursionQueueFilelist(file);

        for(String s:queue){
            System.out.println(s);
        }
    }

    public void recursionQueueFilelist(File file){
        if(file.exists()){
            for(File f:file.listFiles()){
                if(f.isDirectory()){
                    queue.offer(f.getAbsolutePath());
//                    System.out.println(f.getPath());
                    recursionQueueFilelist(f);
                }
                else if(f.isFile()){
                    queue.offer(f.getAbsolutePath());
//                    StdOut.println(f.getPath());
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input the absolute path:");
        String path = in.nextLine();
        QueueFileList fl = new QueueFileList(path);
    }
}

package bishi.zoom;

import java.io.FileWriter;
import java.io.RandomAccessFile;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2018-09-29 16:32
 **/
///home/lab421-w/桌面/1.txt
public class test {
    public static void main(String[] args) {
        try {

            RandomAccessFile file = new RandomAccessFile("/home/lab421-w/桌面/1.txt", "rw");
            file.writeChar(12);
            file.writeInt(96);
            file.writeInt(12);
            file.writeInt(70);
            file.writeLong(10L);
            file.writeFloat(1.2f);
            file.writeDouble(2.1);
            file.seek(6);
            System.out.println(file.readInt());
            file.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

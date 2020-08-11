package com.jicl.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel案例一
 *
 * @author : xianzilei
 * @date : 2020/8/11 21:49
 */
public class NIOFileChannel03 {
    public static void main(String[] args) throws Exception {
        //创建文件输入流
        FileInputStream fileInputStream = new FileInputStream("a.txt");
        //创建通道
        FileChannel fileChannel1 = fileInputStream.getChannel();
        //创建文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream("b.txt");
        //创建通道
        FileChannel fileChannel2 = fileOutputStream.getChannel();
        //创建字节缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(76);
        int read = 0;
        while ((read = fileChannel1.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            fileChannel2.write(byteBuffer);
            byteBuffer.clear();
        }
        //关闭文件流
        fileInputStream.close();
        fileOutputStream.close();
    }
}

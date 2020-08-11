package com.jicl.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel案例一
 *
 * @author : xianzilei
 * @date : 2020/8/11 21:49
 */
public class NIOFileChannel02 {
    public static void main(String[] args) throws Exception {
        //创建文件输入流
        File file = new File("D:\\a.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        //创建通道
        FileChannel fileChannel = fileInputStream.getChannel();
        //创建字节缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        //将缓存区的内容写入到通道中
        fileChannel.read(byteBuffer);
        //将缓冲区数据转成String
        System.out.println(new String(byteBuffer.array()));
        //关闭文件流
        fileInputStream.close();
    }
}

package com.jicl.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel案例一
 *
 * @author : xianzilei
 * @date : 2020/8/11 21:49
 */
public class NIOFileChannel01 {
    public static void main(String[] args) throws Exception {
        //创建文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\a.txt");
        //创建通道
        FileChannel fileChannel = fileOutputStream.getChannel();
        //创建字节缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //往缓冲区写入数据
        byteBuffer.put("Hello，贤子磊！".getBytes());
        //反转缓冲区为读缓冲区
        byteBuffer.flip();
        //将缓存区的内容写入到通道中
        fileChannel.write(byteBuffer);
        //关闭文件流
        fileOutputStream.close();
    }
}

package com.jicl.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 文件拷贝
 *
 * @author : xianzilei
 * @date : 2020/8/11 22:32
 */
public class NIOFileChannel04 {
    public static void main(String[] args) throws Exception {
        //创建相关的流和通道
        FileInputStream fileInputStream = new FileInputStream("a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("c.txt");
        FileChannel sourceChannel = fileInputStream.getChannel();
        FileChannel destChannel = fileOutputStream.getChannel();
        //拷贝
        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        //关闭通道和流
        sourceChannel.close();
        destChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}

package com.jicl.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务器程序
 *
 * @author : xianzilei
 * @date : 2020/6/9 21:48
 */
public class BIOServer {

    public static void main(String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了！");
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("等待客户端连接...");
        while (true) {
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println("线程id="+Thread.currentThread().getId());
                    System.out.println("线程名="+Thread.currentThread().getName());
                    byte[] bytes = new byte[1024];
                    try {
                        InputStream inputStream = socket.getInputStream();
                        int read = 0;
                        System.out.println("等待read...");
                        while ((read = inputStream.read(bytes)) != -1) {
                            System.out.println(new String(bytes, 0, read));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}

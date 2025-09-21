package cn.org.shelly.leetcode.design.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
@SuppressWarnings("all")
public class AcceptSimpleDemo {
    public static void main(String[] args) throws IOException {
        // 1. 打开服务端通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8080));
        serverChannel.configureBlocking(true);

        System.out.println("服务端启动，等待连接...");

        // 缺点是线程会一直循环
        while (true) {
            // 2. 等待客户端连接
            SocketChannel clientChannel = serverChannel.accept(); 
            System.out.println("新连接来自: " + clientChannel.getRemoteAddress());

            // 3. 读取客户端消息
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int readBytes = clientChannel.read(buffer);
            buffer.flip();
            System.out.println("收到消息: " + new String(buffer.array(), 0, readBytes));

            clientChannel.close();
        }
    }
}
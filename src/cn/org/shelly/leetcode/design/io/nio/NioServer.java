package cn.org.shelly.leetcode.design.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class NioServer {
    public static void main(String[] args) throws IOException {
        // 1. 打开 ServerSocketChannel
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false); // 非阻塞模式
        serverChannel.bind(new InetSocketAddress(8080));

        // 2. 打开 Selector
        Selector selector = Selector.open();

        // 3. 注册 serverChannel 到 selector，监听 OP_ACCEPT（新连接）
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("服务器启动，监听端口 8080...");

        while (true) {
            selector.select(); // 阻塞，直到有事件就绪
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                keyIterator.remove(); // 必须手动移除

                if (key.isAcceptable()) {
                    // 4. 接收客户端连接
                    SocketChannel clientChannel = serverChannel.accept();
                    clientChannel.configureBlocking(false);
                    clientChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("新客户端连接: " + clientChannel.getRemoteAddress());
                } else if (key.isReadable()) {
                    // 5. 读取客户端数据
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int read = clientChannel.read(buffer);

                    if (read == -1) {
                        clientChannel.close();
                        System.out.println("客户端断开连接");
                    } else {
                        buffer.flip();
                        String msg = new String(buffer.array(), 0, buffer.limit());
                        System.out.println("收到消息: " + msg);

                        // 回显给客户端
                        clientChannel.write(ByteBuffer.wrap(("服务端已收到: " + msg).getBytes()));
                    }
                }
            }
        }
    }
}

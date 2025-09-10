package cn.org.shelly.leetcode.design;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class ByteBufferTest {
    public static void main(String[] args) {
//        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
//        byteBuffer.put((byte) 1);
//        byteBuffer.put((byte) 2);
//        byteBuffer.put((byte) 3);
//        byteBuffer.flip();
//        while(byteBuffer.hasRemaining()){
//            System.out.println(byteBuffer.get());
//        }
        // 读取hello.txt
        try {
            FileChannel channel = new FileInputStream("src/cn/org/shelly/leetcode/design/hello.txt").getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while(channel.read(buffer) != -1){
                buffer.flip();
                while(buffer.hasRemaining()){
                    System.out.println((char) buffer.get());
                }
                buffer.clear();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

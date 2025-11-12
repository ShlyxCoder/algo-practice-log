package cn.org.shelly.leetcode.design.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBufferTest {
    public static void main(String[] args) throws IOException {
        try {
            FileChannel channel = new FileInputStream("src/cn/org/shelly/leetcode/design/io/hello.txt").getChannel();
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
        ByteBuffer bb = ByteBuffer.allocate(100);
        bb.put("sass".getBytes());
        System.out.println("bb = " + bb);
        bb.flip();
        System.out.println("bb = " + bb);
        for (int i = 0; i < bb.limit(); i++) {
            System.out.println("i = " + bb.get());
        }
        System.out.println("bb = " + bb);
        FileChannel w = new FileOutputStream("src/cn/org/shelly/leetcode/design/io/out.txt").getChannel();
        ByteBuffer out = ByteBuffer.allocate(10);
        out.put("sass241511".getBytes());
        out.flip();
        int write = w.write(out);
        System.out.println("write = " + write);
        w.close();
        ByteBuffer bb2 = ByteBuffer.allocate(100);
        bb2.put("sass".getBytes());
        bb2.mark();
        bb2.put("ook".getBytes());
        System.out.println("bb2 = " + bb2);
        bb2.reset();
        bb2.put("iii".getBytes());
        System.out.println("bb2 = " + bb2);
        bb2.flip();
        for (int i = 0; i < bb2.limit(); i++){
            System.out.println("i = " + (char)bb2.get());
        }

    }
}

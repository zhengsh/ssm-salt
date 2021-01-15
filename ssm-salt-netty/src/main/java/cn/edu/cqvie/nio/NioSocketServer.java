package cn.edu.cqvie.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NioSocketServer {

    // 保存客户端连接
    static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 创建 NIO ServerSocketChannel， 与 BIO 的 serverSocket 类似
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9000));
        // 设置 ServerSocketChannel 为非阻塞
        serverSocket.configureBlocking(false);
        System.out.println("服务启动成功");

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    // 遍历连接进行数据读取
                    Iterator<SocketChannel> iterator = channelList.iterator();
                    while (iterator.hasNext()) {
                        SocketChannel sc = iterator.next();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                        // 非阻塞模式 read 不会阻塞，否则会金额如阻塞
                        int len = 0;
                        try {
                            len = sc.read(byteBuffer);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (len > 0) {
                            System.out.println("接收到消息：" + new String(byteBuffer.array()));
                        }
                        iterator.remove();
                        System.out.println("客户端断开连接");
                    }
                }
            }
        }).start();

        while (true) {
            // 非阻塞模式 accept 方法不会阻塞，默认会阻塞
            // NIO 的非阻塞是由操作系统内部实现的，底层调用了 linux 内核的 accept 函数。
            SocketChannel socketChannel = serverSocket.accept();
            if (socketChannel != null) { // 如果有客户端连接
                System.out.println("连接成功");
                // 设置 SocketChannel 为非阻塞
                socketChannel.configureBlocking(false);
                // 保存客户端连接在 List 中
                channelList.add(socketChannel);
            }
            if (channelList == null) {
                break;
            }
        }


    }
}

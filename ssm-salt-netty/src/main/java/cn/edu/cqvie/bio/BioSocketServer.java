package cn.edu.cqvie.bio;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO
 */
public class BioSocketServer {

    public static void main(String[] args) throws Throwable {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            while (true) {
                System.out.println("等待连接 。。。。");
                // 阻塞方法
                Socket clientSocket = serverSocket.accept();
                System.out.println("有客户端连接了。。。。。");
                handler(clientSocket);


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            handler(clientSocket);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handler(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("准备 Read 。。。。");
        // 接受客户端的数据，阻塞方法，没有数据可读取时就阻塞
        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("Read 完毕。。。。");
        if (read != -1) {
            System.out.println("接受到客户端的数据：" + new String(bytes, 0, read));
        }
        clientSocket.getOutputStream().write("HelloClient".getBytes());
        clientSocket.getOutputStream().flush();
    }
}

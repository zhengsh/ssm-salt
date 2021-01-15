package cn.edu.cqvie;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO Client
 */
public class SocketClient {

    public static void main(String[] args) throws Throwable {
        try {
            Socket socket = new Socket("127.0.0.1", 9000);
            // 向服务器发送数据
            socket.getOutputStream().write("HelloServer".getBytes());
            socket.getOutputStream().flush();
            System.out.println("向服务器发送数据结束");

            // 接受服务器回传的数据
            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes);
            System.out.println("接受到的服务器数据：" + new String(bytes));
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

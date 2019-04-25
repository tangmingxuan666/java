package demo;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String argv[]){
        try {
            ServerSocket server = new ServerSocket(1100);//创建服务器端对象，监听1100
            System.out.println("服务器启动成功，等待用户接入。。。");
            //等待用户接入，直到有用户接入为止，Socket对象表示客户端
            Socket client = server.accept();
            //得到接入客户端的IP地址
            System.out.println("有客户端接入，客户IP："+client.getInetAddress());
            InputStream in = client.getInputStream();//从客户端生成网路输入流，用于接收来自网络的数据
            OutputStream out = client.getOutputStream();//从客户端生成网路输出流，用来把数据发送到网路上
            byte[] bt = new byte[1024];//定义一个字节数组，用来存储网络数据
            int len = in.read(bt);//将网络数据写入字节数组
            String data = new String(bt,0,len);//将网络数据转换为字符串数据
            System.out.println("来自客户端的消息："+data);
            out.write("我是服务器，欢迎光临".getBytes());
            client.close();//关闭套接字
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

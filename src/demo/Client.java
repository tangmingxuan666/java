package demo;
import java.io.*;
import java.net.*;
public class Client {
    public static void main(String argv[]) throws UnknownHostException,IOException{
        //创建客户端套接字，通过指定端口链接服务器，链接本地服务器可以使用本地会送IP
        Socket client = new Socket("192.168.3.100",1100);
        System.out.println("链接服务器成功");
        InputStream in = client.getInputStream();//从客户端生成网络输入流，用于接收来自网络的数据
        OutputStream out = client.getOutputStream();//从客户端生成网络输出流，用来把数据发送到网络上
        out.write("我是客户端，欢迎光临".getBytes());//客户端数据发送
        byte[] bt = new byte[1024];//定义一个字节数组，用来存储网络数据
        int len = in.read(bt);
        String data= new String(bt,0,len);//将网络数据转换为字符串数据
        System.out.println("来自服务器的消息："+data);
        client.close();

    }
}

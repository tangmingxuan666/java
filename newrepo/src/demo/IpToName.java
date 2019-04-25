package demo;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpToName {
    public static void main(String argv[]){
        String IP = null;
        InetAddress host;//创建InetAddress对象
        try {
            host = InetAddress.getLocalHost();//实例化InetAddress对象，用来获取本节的IP地址相关信息
            String localname = host.getHostName();//获取本机名
            String localip = host.getHostAddress();//获取本机IP地址
            System.out.println("本机名"+localname+"本机的IP地址"+localip);

        }catch (UnknownHostException e){
            e.printStackTrace();
        }

        for (int i=0;i<=70;i++){
            IP = "192.168.1."+i;
            try {
                host = InetAddress.getByName(IP);//获取IP封装对象
                if (host.isReachable(2000)){//用2秒的时间测试IP是否可达
                    String hostName = host.getHostName();//获取指定Ip地址的主机名
                    System.out.println("IP地址"+IP+"的主机名称是："+hostName);

                }
            }catch (UnknownHostException e){//捕获未知主机异常
                e.printStackTrace();
            }catch (IOException e){//捕获输入输出异常
                e.printStackTrace();
            }

        }
        System.out.println("搜索完毕。");
    }
}

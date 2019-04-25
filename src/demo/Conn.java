package demo;
import java.sql.*;//倒入java.sql类包
public class Conn {//创建类conn
    Connection con;//声明Connection对象
    public  Connection getConnection(){//建立返回值为Connection的方法
        try {//加载数据库驱动类
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功");

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {//通过访问数据库的URL获取数据库链接对象
            con = DriverManager.getConnection("jdbc:mysql:"+"//192.168.3.100:8080/test","root","root");
            System.out.println("数据库链接成功");

        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;//按方法要求返回一个Connection对象


    }
    public static void main(String argv[]){
        Conn c = new Conn();//创建本类对象
        c.getConnection();//调用链接数据库的方法
    }
}

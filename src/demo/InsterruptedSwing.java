package demo;

import javax.swing.*;
import java.awt.*;

public class InsterruptedSwing extends JFrame {
    Thread thread;
    public static void main(String argv[]){
        new InsterruptedSwing();
    }

    public InsterruptedSwing(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗体后停止程序
        setSize(100,100);//设定窗体宽高
        setVisible(true);//窗体可见
        final JProgressBar progressBar = new JProgressBar();//创建进度条
        //将进度条放置在窗体合适的位置
        getContentPane().add(progressBar, BorderLayout.NORTH);
        progressBar.setStringPainted(true);//设置进度条上显示数字
        thread = new Thread(){//使用匿名内部类方式创建线程对象
            int count =0;
            public void run(){
                while (true){
                    progressBar.setValue(++count);//设置进度条的当前值
                    try {
                        if (count==50){
                            interrupt();//执行线程停止方法
                        }
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                        break;
                    }
                }
            }

        };
        thread.start();
    }
}

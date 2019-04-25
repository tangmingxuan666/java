package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ThreadSuspendFrame extends JFrame {
    private JLabel label;//显示数字的标签
    private ThreadSuspend t;//自定义线程类
    public ThreadSuspendFrame(){
        setTitle("手机号码抽奖");//窗口标题
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//窗口关闭规则，窗口关闭则停止程序
        setBounds(200,200,300,150);//设置窗口坐标和大小
        label = new JLabel("0");//实例化标签，出始值为0
        label.setHorizontalAlignment(SwingConstants.CENTER);//标签文字剧中
        label.setFont(new Font("宋体",Font.PLAIN,42));//标签使用42号字
        getContentPane().add(label,BorderLayout.CENTER);//将标签放入窗口容器的中间区域
        JButton btn = new JButton("暂停");//创建暂停按钮
        getContentPane().add(btn,BorderLayout.SOUTH);//将按钮放入窗口容器的南部区域
        t = new ThreadSuspend();//实例化自定义线程类
        t.start();//启动线程
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnText = btn.getText();//获取按钮文本
                if (btnText.equals("暂停")){
                    t.toSuspend();
                    btn.setText("继续");
                }else {
                    t.toRun();
                    btn.setText("暂停");
                }
            }
        });
        setVisible(true);//设置窗口可见

    }



    class ThreadSuspend extends Thread{
        /**
         * 线程挂起状态，若suspend为false，线程会正常运行，若suspend为true，则线程会处于挂起状态
         */

        private boolean suspend = false;
        /**
         *  (线程安全的)线程暂停方法
         */
        public synchronized void toSuspend(){
            suspend = true;
        }
        /**
         * (线程安全的)线程恢复运行方法，除了将suspend变为false，同时使用超级父类Object类提供的notify()方法唤醒线程
         */
        public synchronized void toRun(){
            suspend = false;
            notify();
        }

        @Override
        public void run() {
            //定义中奖池号码
            String[] phoneNums = {"13610780204","13847928544","18457839454","18423098757","17947928544","19867534533"};
            while (true){
                //run方法中的代码无限运行
                synchronized (this){//创建线程挂起区，线程加锁对象为this
                    while (suspend){
                        try {
                            wait();//超级父类object类提供的等待方法
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }

                }
                //获取一个phoneNums数据的随机索引
                int randomIndex = new Random().nextInt(phoneNums.length);
                String phoneNum = phoneNums[randomIndex];//获取随机号码
                label.setText(phoneNum);//修改标签的值
            }
        }
    }

    public static void main(String argv[]){
        new  ThreadSuspendFrame();
    }
}




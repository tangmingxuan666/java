package demo;
import java.lang.InterruptedException;
public class ThreadSafeTest implements Runnable {
    int num = 10;//设置当前总票数

    @Override
    public void run() {
        while (true){//设置无限循环
            if (num>0){//判断当前票数是否大于0
                try {
                    Thread.sleep(100);//使当前线程休眠100毫秒
                } catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"---票数"+num--);

            }

        }
    }
    public static  void main(String argv[]){
        ThreadSafeTest t = new ThreadSafeTest();//实例化类对象
        Thread tA = new Thread(t,"线程一");
        Thread tB = new Thread(t,"线程二");
        Thread tC = new Thread(t,"线程三");
        Thread tD = new Thread(t,"线程四");
        tA.start();
        tB.start();
        tC.start();
        tD.start();

    }
}

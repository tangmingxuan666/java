package demo;

public class SynchronizedTest implements Runnable {
    int num = 100;//设置当前总票数

    @Override
    public void run() {
        while (true){
            synchronized (this){//设置同步代码块
                if (num>0){
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"---票数"+num--);
                }

            }
        }
    }
    public static  void main(String argv[]){
        SynchronizedTest t = new SynchronizedTest();//实例化类对象
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

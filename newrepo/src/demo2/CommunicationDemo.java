package demo2;

/**线程间通讯：
 * 多个线程在处理同一资源，但是任务却不同
 * */
/**
 * 等待。唤醒机制
 * 涉及的方法
 * 1。wait():让线程处于冻结状态，被wait的线程会被存储到线程池中，
 * 2.notify()：唤醒线程池中的一个线程（任意）
 * 3.notifyAll()：唤醒线程池中的所有线程
 * 这些方法都必须定义在同步当中；
 * 应为这行方法都是用于操作线程状态的方法，
 * 必须要明确到底操作的是哪个锁上的线程
 *
 * */
/**为什么操作线程的方法wait notify notifyAll定义在Object类中{
 * 因为这些方法是监视器的方法，监视器其实就是锁，
 * 锁可以是任意的对象，任意的对象调用的方法一定定义在Object类中
 }
 *
 * */
//资源
class Resource{
    String name;
    String sex;
    Boolean flag=false;
}
//输入
class Input implements Runnable{
    Resource r ;
    Input(Resource r){
        this.r = r;
    }
    @Override
    public void run() {
        int x= 0;
        while (true){
            synchronized (r){
                if (r.flag){
                    try {
                        r.wait();
                    }catch (InterruptedException e){

                    }
                }



                if (x==0){
                    r.name = "mike";
                    r.sex = "男男男";
                }else {
                    r.name="丽丽";
                    r.sex ="女女女";
                }
                r.flag = false;
                r.notify();
            }

          x= (x+1)%2;
        }

    }
}
//输出
class Output implements Runnable{
    Resource r ;
    Output(Resource r){
        this.r = r;
    }
    @Override
    public void run() {
        while (true){
            synchronized (r){
                if (!r.flag){
                    try {
                        r.wait();
                    }catch (InterruptedException e){

                    }
                }
                System.out.println(r.name+"...."+r.sex);
                r.flag = true;
                r.notify();
            }

        }
    }
}
public class CommunicationDemo {
    public static void main(String[] args){
        Resource r = new Resource();
        r.flag = false;
        Input in = new Input(r);
        Output out = new Output(r);
        //创建线程，执行路径
        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);
        //开启线程
        t1.start();
        t2.start();
    }
}

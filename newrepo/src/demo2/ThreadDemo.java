package demo2;
/**
 * 进程：正在进行中的程序
 * 线程：就是进程中一个负责程序执行的控制单元（执行路径）
 *一个进程当中可以有多个执行路径，称之为多线程
 * 一个进程当中一定要有一个线程
 * 开启多个线程是为了同时运行多部分代码
 * 每一个线程都有自己运行的内容，这个内容可以称为线程要执行的任务
 *
 * 多线程的好处：解决了多部分同时运行的问题。
 * 多线程的弊端：线程太多会导致效率降低
 * 其实应用程序的执行都是cpu在做着快速的切换完成的，这个切换是随机的
 * */
/**jvm启动时就启动了多个线程，至少有两个线程可以分析的出来
 * 1。执行main函数的线程
 * 该线程的任务代码都定义在main函数中
 * 2。负责垃圾回收的线程
 *
 */
/**如何创建一个线程呢？
 * 步鄹{
 * 1。定义一个类继承Thread类
 * 2。覆盖Thread类中的run方法
 * 3.直接创建Thread类的子类对象
 * 4。嗲用start方法开启想成并调用线程的任务run执行
 *
 * }
 *可以通过Thread的getName方法获取线程的名称，Thread-编号，从0开始
 * 祝线程的名字就是main。
 * */
/**调用run和调用start有什么区别？{
 *
 }
 *
 * cpu的执行资格：可以被cpu的处理，在处理队列中排队
 * cpu的执行权：正在被cpu的处理
 * */
/**
 //创建线程的目的是为了开启一条执行路径，去执行指定的代码和其他代码实现同时运行
 而运行的指定代码就是这个执行路径的任务
 jvm创建的祝线程的任务都定义在了主函数中，
 而自定义的线程他的任务在哪呢？
 Thread类用于描述线程，线程是需要任务的，所以Thread类也对任务的描述
 这个任务就通过Thread类中的run方法来实现的，也就是说，run方法就是封住自定义线程运行任务的函数
 run方法中定义的就是线程要运行的任务代码
 我们开启线程是为了运行指定代码，所以只有继承THread类并复写run方法，
 将运行的代码定义在run方法中即可
 */
/**创建线程的第一种方法，继承Thread类
 * 创建线程的第二种方式，实现Runnable接口{
 *     1.定义类实现Runnable接口
 *     2。覆盖接口中run方法，将线程的任务代码封装到run方法中
 *     3。通过Thread类创建线程队象，并将Runnable接口的子类对象作为构造函数的参数进行传递{
 *         因为线程的任务都封装在Runnable接口子类对象的run方法中，所以要在线程对象创建时候必须明确要运行的任务
 *     }
 *     4。调用线程对象的start方法开启线程
 * }
 * */
/**实现Runnable接口的好处
 * 1。可将线程的任务从线程的子类中分离出来，进行了单独的封装
 * 按照面向对象的思想将任务封装成对象
 * 2。避免了Java单继承的局限性
 *
 * 所以，创建线程的第二种方式较为常用
 *
 * */

class Demo extends Thread{
    private String name;
    Demo (String name){
        this.name = name;
    }
    public void show(){
        for (int x=0;x<10;x++){
            System.out.println(name+"x="+x+"......"+Thread.currentThread().getName());
        }
    }

    @Override
    public void run() {
        show();
    }
}
class Demo1 implements Runnable{
    @Override
    public void run() {
        show();
    }
    public void show(){
        for (int x=0;x<10;x++){
            System.out.println("x="+x+"......"+Thread.currentThread().getName());
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args){
        Demo1 d1 = new Demo1();
        Demo1 d2 = new Demo1();
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        t1.start();
        t2.start();

//        d1.run();
//        d2.run();//开启线程，调用run 方法




    }
}

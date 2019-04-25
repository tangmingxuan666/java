package demo;
class Priority extends Thread{
    private String threadName;//线程的名称
    private String output;//控制台输出的信息
    //以线程名，控制台输出的信息为参数的构造方法，利用构造方法初始化变量
    public  Priority(String threadName,String output){
        this.threadName = threadName;
        this.output = output;
    }

    @Override
    public void run() {
        System.out.println(threadName+":"+output+"");
    }
}

public class PriorttTest {
    public static void main(String argv[]){
        for (int i=0;i<1;i++){
            //创建4个线程名，输出信息为参数的线程类子类的对象，并分别设置这4个线程的优先级
            Priority test1 = new Priority("加","+");
            test1.setPriority(Thread.MIN_PRIORITY);//设置优先级最低
            Priority test2 = new Priority("减","-");
            test2.setPriority(3);//设置数字的优先级
            Priority test3 = new Priority("乘","X");
            test3.setPriority(8);
            Priority test4 = new Priority("除","÷");
            test4.setPriority(Thread.MAX_PRIORITY);//设置最高优先级
            //启动线程
            test1.start();
            test2.start();
            test3.start();
            test4.start();
            System.out.println();//换行

        }
    }
}

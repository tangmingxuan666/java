package demo2;
/**
 * 需求：储户，两个，每个都到银行存钱，每次村100，共存三次
 * */
/**
 * 同步函数使用的锁是this
 * 同步函数和同步代码块的区别{
 *     同步函数的锁是固定的this
 *     同步代码块的锁是任意的对象
 *
 *
 *     建议使用同步代码块，
 * }*/
/**
 * 静态的同步函数使用的锁是该函数所属字节码文件对象
 * 可以用getClass方法获取或者是当前类名.class获取*/

class Bank{
    private int sum;
    public synchronized void add(int num){//同步函数
//        synchronized (this) {
            sum = sum + num;
            System.out.println("sum=" + sum);
//        }
    }
}
class Cus implements Runnable{
   private Bank b = new Bank();
    @Override
    public void run() {

        for (int i=0;i<3;i++){
           b.add(100);
        }
    }
}
public class BankDemo {
    public static void main(String[] argc){
        Cus c =new Cus();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}

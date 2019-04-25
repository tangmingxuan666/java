package demo2;
/**
 * 死锁：常见情景之一，同步的嵌套
 * */
class Test implements Runnable{
    private boolean flags;
    Test(Boolean flags){
        this.flags = flags;
    }

    @Override
    public void run() {
        if (flags){
            synchronized (MyLock.locka){
                System.out.println("if语句中的a锁");
                synchronized (MyLock.lockb){
                    System.out.println("if语句中的b锁");

                }
            }
        }else {
            synchronized (MyLock.lockb){
                System.out.println("else语句中的b锁");
                synchronized (MyLock.locka){
                    System.out.println("else语句中的a锁");
                }
            }
        }
    }
}
class MyLock{
    public static final Object locka = new Object();
    public static final Object lockb = new Object();
}
public class DeadlockClass {
    public static void main(String[] args){
        Test a= new Test(true);
        Test b = new Test(false);
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();
    }
}

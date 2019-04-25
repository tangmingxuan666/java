package demo2;
/**生产者，消费者
 *
 * 多生产者，多消费者
 * if判断标记，只有一次，会导致不该运行的线程运行了，出现了数据错误的情况
 * while判断标记，解决了线程获取执行权后，是否运行
 notify:只能唤醒一个线程，如果本方唤醒了本方，没有意义，而且while判断标记+notify会导致死锁 *
 notifyAll解决了本方线程一定会唤醒对方线程的问题
 * */
/***
 * 同步代码块，对于锁的操作是隐式的
 * jdk1.5以后将同步和锁封装成了对象，
 * 并将操作锁的隐式方式定义成了该对象中，
 * 将隐式动作变成了显示动作
 *
 * Lock接口，出现替代了同步代码块或者函数,将同步的隐式锁操作变成了现实锁操作
 * 同时更为灵活，可以一个锁上加上多组监视器
 * lock():获取锁
 * unlock();释放锁，通常需要定义finally代码块中
 *
 * condition 接口，出现替代了Object中的wait notify notifyAll方法
 * 将这些监视器方法单独进行了封装，变成Condition监视器对象
 * 可以任意锁进行组合
 * await()
 * signal()
 * signalAll()
 */
/**wait和sleep区别
 * 1。wait可以指定时间也可以不指定，sleep必须指定时间
 * 2。在同步中时，对cpu的执行权和锁的处理不同，wait释放执行权，释放锁
 * sleep：释放执行权，不释放锁
 * */
/**停止线程
 * 1。stop方法
 * 2。run方法结束。
 *
 * 怎么控制线程的任务结束呢？
 * 任务中都会有循环结构，只要控制住线程就可以结束任务。
 *
 * 控制循环通常就用定义标记来完成
 * 但是如果线程处于了冻结状态，就无法读取标记，如何结束呢
 * 可以使用interrupt（）方法将线程从冻结状态强制恢复到运行状态中来，让线程具备cpu的执行资格
 * 当时强制动作会发生了InterruptedException，记得要处理
 *
 * */
import java.sql.Connection;
import java.util.concurrent.locks.*;

class Resrouce2{
    private String name;
    private int count=1;
    private boolean flag = false;
    Lock lock = new ReentrantLock();
    Condition pro_con = lock.newCondition();
    Condition con_con = lock.newCondition();
    public void set(String name){
        this.name = name;
    }
    public void out(){

    }

}
public class ProducerConsumerDemo {
}

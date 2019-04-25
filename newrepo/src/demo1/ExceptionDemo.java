package demo1;
/**
 * 异常，是在运行时期发生的不正常情况。
 *
 * 在Java中用类的形式对不正常情况进行了描述和封装对象
 * 描述不正常的情况的类，就称为异常类
 * 以前正常流程代码和问题处理代码相结合
 * 现在将正常流程代码和问题处理代码分离，提高阅读性
 *
 * 其实异常就是Java通过面向对象的思想将问题封装成了对象，用异常类对其进行描述
 * 不同的问题用不同的类进行具体的描述。
 *
 * 问题很多，意味着描述的类也很多
 * 将其共性进行向上抽取，形成异常体系
 *
 * 最终问题（不正常情况）就分成两大类{
 *     1.一般不可处理的（Error）特点：是由jvm抛出的严重性的问题
 *     这种问题发生一般不针对性处理，直接修改程序
 *     2.可以处理的。（Exception）
 * }
 *
 *
 * 该体系的特点：{
 *     子类的后缀名都是用其父类名作为后缀，阅读性很强
 *     * }
 *
 *     如果让一个类称为异常类，必须继承异常体系，因为只有称为异常体系的子类才有资格具备可抛性
 *     才可以被两个关键字所操作
 * */
/**异常的分类
 * 1.编译时被检测异常：只要时Exception和其子类都是。除了特殊子类RuntimeException体系
 * 这种问题一旦出现，希望在编译时就进行检测，让这种问题有对应的处理方式
 * 这样的问题都可以针对性的处理
 * 2.编译时不检测异常（运行时异常）:就是Exception中的RuntimeException和其子类
 * 这种问题的发生，无法让功能继续，运算无法进行，更多时因为调用的原因导致的或者引发了内部状态的改变导致的
 * 那么这种问题一般不处理，直接编译通过，在运行时，让调用这调用时的程序强制停止，让调用这对代码进行修正
 * */
//所以自定义异常时，要么继承Exception或者继承RuntimeException
    /**throws和throw的区别
     * 1.throws 使用在函数上
     * throw使用在函数内
     * 2。throws抛出的是异常类，可以抛出多个，用逗号隔开
     * throw抛出的是异常对象
     *
     * */

import java.lang.reflect.Array;

/**
     * {

     try{
     //需要被检测异常的代码
     }
     catch{异常类变量，该变量用于接收发生的异常对象
     //处理异常的代码

     }
     finally{

     一定会被执行的代码
     }


     * }
     */
class FuShuIndexException extends Exception{
    FuShuIndexException(){

    };
}
class ArrayDemo{
    public int method(int[] array,int index){
//        if (index>=array.length){
//            throw new ArrayIndexOutOfBoundsException("数组角标越界啦");
//        }
        return array[index];
    }
}
//多catch父类的catch放在最下边，否则编译失败
/**异常处理的原则
 * 1。函数内部如果抛出需要检测的异常，那么函数上必须要声明
 * 否则必须在函数内用try catch 捕捉，否则编译失败
 * 2。如果调用到了声明异常的函数，那么try catch要么throw，否则编译失败
 * 3。什么以后catch，什么时候throws呢
 * 功能内容可以解决，用catch，
 * 解决不了，用throws告诉嗲用者，由调用者解决、
 * 4。一个功能如果抛出了多个异常，那么调用时，必须有对应多个catch进行针对性的处理
 * 内部有几个需要检测的异常，就抛几个异常，抛出几个，就catch几个
 * */
public class ExceptionDemo {
//    throw new FuShuIndexException()
    public static void main(String[] args) throws FuShuIndexException{

        int[] arr = new int[]{1,2,3};
        ArrayDemo demo = new ArrayDemo();
        try {
            int num = demo.method(arr,2);
            System.out.println("num="+num);
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println(e.toString());
        }finally {//通常用于关闭或者释放资源，
           System.out.println("一定被执行到的内容");
        }


        System.out.println("我是异常后的数据");
    }
}
/**try catch finally组合特点
 * {
 *     1.try catch finally
 *     2.tyy catch(多个)当没有必要资源需要释放时，可以不用定义finally
 *     3.try finally 异常无法直接catch处理，但是资源需要关闭
 *
 * }
 * */
/**异常的注意事项{
 * 1.子类在覆盖父类方法时，父类的方法如果抛出了异常，
 * 那么子类的方法只能抛出父类的异常或者该异常的子类
 * 2.如果父类抛出多个异常，那么子类只能抛出父类异常的子集
 *
 * 简单来说：子类覆盖父类只能抛出父类的异常或者子类或者子集
 * 注意：如果父类的方法没有抛出异常，那么子类覆盖时绝对不能抛，就只能try
 }
 * */
/**
 *
 * */

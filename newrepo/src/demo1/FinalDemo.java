package demo1;

//继承弊端，打破了封装性
/**final关键字
 * 1.final是一个修饰符，可以修饰类，方法，变量
 * 2。final修饰的类不可以被继承
 * 3。final修饰的方法不可以被修改
 * 4.final修饰的变量是一个常量，只能赋值一次
 *
 * 为什么要用final修饰变量{
 *     其实在程序中如果一个数据是固定的，那么直接使用这个数据就可以了，但是这样阅读性差
 *     所以给该数据起个名称，而且这个变量名称的值不能变化，所以加上final固定。
 *     写法规范：常量所有字母都大写，多个单词，中间用_链接
 * }
 * */
 class Fu1{
    void method(){
        //调用了底层系统的资源
    }

}
class Zi1 extends Fu1{
    void method(){
        System.out.println("haha");
    }
}
public class FinalDemo {
    public static void main(String[] args){

    }
}
interface USB{
     public void open();
     public void close();
}
class BookPc{
     public static void main(String[] args){
         useUSB(new Upan());
     }
     public static void useUSB(USB u){//接口类型引用，用于接收接口的子类对象
         u.open();
         u.close();

     }

}
class Upan implements USB{
     public void open(){
         System.out.println("U盘开启");
     }
     public void close(){
         System.out.println("U盘关闭");
     }
}

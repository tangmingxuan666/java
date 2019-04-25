package demo1;
/**内部类的访问特点{
 * 1.内部类可以直接访问外部类中的成员
 * 2.外部类要访问内部类，必须建立内部类的对象
 *
 }
 一般用于类的设计{
 分析事物时，发现该事物描述中还有事物，而且这个事物还在访问被描述事物的内容，
 这时就是还有的事物定义或内部类来描述

 }
 如果内部类中有静态成员则该内部类也必须用静态修饰
 * */
/**为什么内部类能直接访问外部类中的成员呢{
 * 那是因为内部类持有了外部类的医用，外部类名.this
 }
 * */

/**
 * 内部类可以存放在局部位置上
 * 内部类在局部位置上只能访问局部中被final修饰的局部变量
 * */
public class OutClass {//外部类
    private int num = 4;
//    class Inner{//定义内部类
//        void show(){
//            System.out.println("num="+num);
//        }
//
//    }
    public void method(){
//        Inner in = new Inner();
//        in.show();
        class Inner1{
            void show(){
                System.out.println("我是局部类");
            }
        }
        Inner1 in = new Inner1();
        in.show();

    }
}
class InnerClassDemo{
    public static void main(String args[]){
        OutClass o = new OutClass();
        o.method();

    }
}
/**匿名内部类，就是内部类的简写格式
 * 必须有前提
 * 内部类必须继承或者实现一个外部类或者接口
 *
 * 匿名内部类，其实就是一个匿名子类对象
 * 格式：new 父类or接口名加大括号
 * */
/**
 * 通常的使用场景之一
 * 当函数参数是接口类型时，而且接口中的方法不超过三个，可以使用匿名函数类作为使劲参数进行传递
 * */
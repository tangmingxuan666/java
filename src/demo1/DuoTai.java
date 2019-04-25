package demo1;
/**对象的多态性
 * 简单来说就是一个对象对应着不同类型
 * 多态在代码中的体现
 * 父类或者接口的引用指向子类的对象
 *
 *
 * 多态的好处{
 *     提高了代码的扩展性，前期定义的代码可以使用后期的内容
 * }
 * 多态的弊端{
 *     前期定义的内容不能使用后期子类的特有内容
 * }
 * 多态的前提{
 *     1。必须有关系，继承、实现
 *     2。要有覆盖
 * }
 * 注意对于转型，自始至终都是子类对象在做着类型变化
 *
 * */
abstract class Animal{
    abstract void eat();

}
class Dog extends Animal{
    @Override
    void eat() {
        System.out.println("啃骨头");
    }
    void lookHome(){
        System.out.println("看家");
    }
}
class Cat extends Animal{
    @Override
    void eat() {
        System.out.println("吃鱼");
    }
}
/**多态时成员的特点
 * 1。成员变量{
 *     编译时，参考引用型变量所属的类中的是否有调用的成员变量，
 *     运行时，参考引用型变量所属的类中的是否有调用的成员变量，
 *     简单说：编译和运行都参考等号的左边
 * }
 * 2。成员函数（非静态的）{
 *    编译时，参考引用型变量所属的类中的是否有调用的函数，有，编译通过，没有编译失败。
 *    运行时，参考的时对象所属的类中是否有调用的函数
 *    简单说，编译看左边，运行看右边
 * }
 * 3。静态函数{
 *     编译时，参考引用型变量所属的类中的是否有调用的静态方法，
 *     运行时，参考引用型变量所属的类中的是否有调用的静态方法，
 *     简单说，编译和运行都看等号左边；
 *
 *     其实对于静态方法是不需要对象的，直接用类名调用
 * }
 * */
public class DuoTai {
    public static void main(String[] args){
        Cat c = new Cat();
        Dog d = new Dog();
        method(d);
    }
    public static void method(Animal a){
        a.eat();
        if (a instanceof Cat){//instanceof 用于判断对象的具体类型，只能用于引用数据类型判断
            System.out.println("我是猫");
        }
    }
}

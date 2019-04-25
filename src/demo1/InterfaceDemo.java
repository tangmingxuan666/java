package demo1;
//定义接口使用的关键字不是class，是inertface
/**对于接口当中常见的成员，而且这些成员都有固定的修饰符
 * 1。全局常量
 * 2。抽象方法
 *
 * */
interface Demo11{
    public static final int NUM =4;
    public abstract void show1();
    public abstract void show2();
}
//类与类之间是继承关系，类与接口之间是实现关系
/**
 * 接口不可以实例化，只能由实现了接口的子类并覆盖了接口中所有的抽象方法后，
 * 该子类才可以实例化，否则，这个子类就是一个抽象类
 * 接口的出现避免了单继承的局限性
 * 接口与接口之间是继承关系，接口可以多继承
 * */
/**抽象类和接口的异同点
 * 相同点{
 *     都是不断向上抽取而来的
 * }
 * 不同点{
 *     1。抽象类需要被继承，而且只能是单继承
 *     接口需要被实现，而且可以多实现
 *     2。抽象类中可以定义抽象方法和非抽象方法，子类继承后，可以直接使用非抽象方法，接口中只能定义
 *     抽象方法，必须由子类去实现
 *     3。抽象类的继承，是is a关系，在定义该体系的基本共性内容
 *     接口的实现是like a关系，在定义体系额外功能
 *
 * }
 */
//在不同的问题领域中有不同的分析方式

class DemoImpl implements Demo11{
    @Override
    public void show1() {

    }

    @Override
    public void show2() {

    }
}

    public class InterfaceDemo {

        public static void main(String[] args) {

        }
    }


package demo2;
/**
 * 多线程下的单利
 * */
//饿汉式

class  Single{
    private static final Single s=  new Single();
    private Single(){};
    public static Single getInstance(){
        return s;
    }
}
//懒汉式
class Singles{
    private static Singles s= null;
    private Singles(){};
    public static  Singles getInstance(){//单利同步函数这样写效率不高
        if (s==null){
            synchronized (Singles.class){//这样写效率高
                if (s==null){
                    s = new Singles();
                }
            }

        }

        return s;
    }

}
public class SingleClass {
    public static void main(String[] argv){

    }
}

package demo2;
class Resouce1{
    private String name;
    private String sex;
    private Boolean flag = false;
    public synchronized void set(String name,String sex){
        if (flag){
            try {
                this.wait();
            }catch (InterruptedException e){

            }
        }
        this.name = name;
        this.sex = sex;
        flag = true;
        this.notify();
    }
    public synchronized void out(){
        if (!flag){
            try {
                this.wait();
            }catch (InterruptedException e){

            }
        }
        System.out.println(name+"......+...."+sex);
        flag = false;
        notify();
    }
}
//输入
class Input1 implements Runnable{
    Resouce1 r;
    Input1(Resouce1 r){
        this.r = r;
    }

    @Override
    public void run() {
        int x = 0;
        while (true){
            if (x==0){
                r.set("Tom","男");
            }else {
                r.set("丽丽","女");
            }
            x=(x+1)%2;
        }
    }
}
//输出
class Output1 implements Runnable{
    Resouce1 r;
    Output1(Resouce1 r){
        this.r = r;
    }

    @Override
    public void run() {
        while (true){
            r.out();
        }

    }
}
public class ResouceDemo {
    public static void main(String[] args){
        Resouce1 r = new Resouce1();
        Input1 in = new Input1(r);
        Output1 out = new Output1(r);
        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);
        t1.start();
        t2.start();
    }

}

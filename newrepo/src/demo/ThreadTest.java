package demo;

public class ThreadTest extends Thread{

    String name;
    public void run() {
        int count = 100000;
        while (true){
            if (count>0){
                count--;
                System.out.println("线程："+name+"的count="+count);
            }
        }
    }

    public static void main(String argv[]){
        ThreadTest test1 = new ThreadTest();
        test1.name = "线程一";
//        try {
//            test1.sleep(3000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }




        ThreadTest test2 = new ThreadTest();
        test2.name = "线程二";
//        test2.setPriority(1);
        test1.start();
//        test1.yield();
        try {
            test1.join(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        test2.start();



    }
}

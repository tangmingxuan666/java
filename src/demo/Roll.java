package demo;

public class Roll implements Runnable {
    @Override
    public void run() {
        int count = 10;
        while (count >0){
            count--;
            System.out.println("count="+count);

        }
    }
    public static void main(String argv[]){
        Roll r = new Roll();
        Thread t = new Thread(r);
        t.start();
    }
}

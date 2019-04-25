package demo;

public class JoinTest {
    public static void main(String argv[]) {


        Thread B = new Thread(new Runnable() {
            int count = 0;

            @Override
            public void run() {
                while (true) {
                    System.out.println("B.Count="+count);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (count == 100) {
                        break;

                    }
                }
            }
        });



        Thread A = new Thread(new Runnable() {
             int count = 0;

              @Override
             public void run() {
                 while (true) {
                     System.out.println("A.Count="+count);
                     try {
                      Thread.sleep(100);
                      if (count == 20) {
                        B.join();
                       }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (count == 100) {
                    break;
                }
            }

        }
    });
   }


}

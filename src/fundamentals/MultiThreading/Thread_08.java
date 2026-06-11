package fundamentals.MultiThreading;

import org.w3c.dom.ls.LSOutput;

import java.sql.Timestamp;

class Library implements Runnable{
    String res1 = "java";
    String res2 = "DSA";
    String res3 = "SpringBoot";
//    String name = Thread.currentThread().getName();//this return main as it is outside the run method


//  When the other thread is not getting resource the it will go in blocked state
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
//        System.out.println(name);
//        System.out.println(Thread.currentThread().getName());
        if (name.equals("Student1")) {
            try {
                System.out.println("Student1 got into Library");
//                System.out.println(System.currentTimeMillis());
                Thread.sleep(2000);
//                System.out.println(System.currentTimeMillis());

                synchronized (res3) {
                    Thread.sleep(2000);
                    System.out.println("Student1 has acquired " + res3);
                    synchronized (res2) {
                        Thread.sleep(2000);
                        System.out.println("Student1 has acquired " + res2);
                        synchronized (res1) {
                            Thread.sleep(2000);
                            System.out.println("Student1 has acquired " + res1);
                        }
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            try{
                System.out.println("Student2 got into Library");
                Thread.sleep(2000);
                synchronized (res1){
                    Thread.sleep(2000);
                    System.out.println("Student2 has acquired " + res1);
                    synchronized (res2){
                        Thread.sleep(2000);
                        System.out.println("Student2 has acquired " + res2);

                        synchronized (res3){
                            Thread.sleep(2000);
                            System.out.println("Student2 has acquired " + res3);

                        }
                    }
                }

            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Thread_08 {
    public static void main(String[] args) {
        Library lb = new Library();
        Thread t1 = new Thread(lb);
        Thread t2 = new Thread(lb);

        t1.setName("Student1");
        t2.setName("Student2");

        t1.start();
        t2.start();
    }

}

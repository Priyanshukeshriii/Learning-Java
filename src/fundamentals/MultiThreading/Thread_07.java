package fundamentals.MultiThreading;
class MyCar1 implements Runnable{
    public void run(){
        try {
            System.out.println(Thread.currentThread().getName() +" has Enter the parking lot");
            Thread.sleep(4000);
            synchronized (this){
                System.out.println(Thread.currentThread().getName() + " has entered into Car");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " has started to drive the car");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " has came back and park the car");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
public class Thread_07 {
    public static void main(String[] args) {
        MyCar1 car = new MyCar1();
        Thread t1 = new Thread(car);
        Thread t2 = new Thread(car);
        Thread t3 = new Thread(car);
        Thread t4 = new Thread(car);
        t1.setName("Priyanshu");
        t2.setName("Riya");
        t3.setName("Rupam");
        t4.setName("Ujjwal");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

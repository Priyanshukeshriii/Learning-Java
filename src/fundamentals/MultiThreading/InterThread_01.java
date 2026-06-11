package fundamentals.MultiThreading;

import java.util.function.Consumer;

class Producer extends  Thread{
    Queue q ;
    int i = 1;
    public Producer(Queue q){
        this.q = q;

    }

    @Override
    public void run() {
        while (true){
            q.produce(i++);
        }
    }
}
class Consumers extends Thread{
    Queue q ;
    public Consumers(Queue q){
        this.q = q;
    }

    @Override
    public void run() {
        while (true){
            q.consume();
        }
    }
}
class Queue {
    int data;
    boolean flag = false;
    synchronized public void produce(int data){
        try{
            if (flag == true) {
                System.out.println("Producer in Waiting state");
                wait();
            }
            else {
                this.data = data;
                System.out.println("I Have Produced Data " + this.data);
                flag = true;
                notify();
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    synchronized public void consume(){
        try{
            if (flag == false) {
                System.out.println("Consumer in Waiting state");
                wait();
            }
            else {
                System.out.println("I Have Consumed Data "+ data);
                flag = false;
                notify();
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

    }
}

public class InterThread_01 {
    public static void main(String[] args) {
        Queue q = new Queue();
        Producer p = new Producer(q);
        Consumers c = new Consumers(q);
        p.setName("Pro");
        c.setName("Con");
        p.start();
        c.start();
    }
}

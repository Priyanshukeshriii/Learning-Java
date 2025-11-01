package com.MultiThreading;

class BookTicket extends  Thread{
    Object train,comp;

    public BookTicket(Object train, Object compartment) {
        this.train = train;
        this.comp=compartment;
    }


    @Override
    public void run()
    {
        synchronized(train)
        {
            System.out.println("BookTicket locked on train");
            try
            {
                Thread.sleep(150);
            }
            catch(InterruptedException ex)
            {
                ex.printStackTrace();
            }
            System.out.println("BookTicket now waiting to lock on compartment..");

            synchronized(comp)
            {
                System.out.println("BookTicket locked on compartment");
            }
        }

    }
}
class CancelTicket extends Thread
{
    Object train,comp;

    public CancelTicket(Object train , Object comp)
    {
        this.train = train;
        this.comp =comp;
    }

    @Override
    public void run()
    {
        synchronized(comp)
        {
            System.out.println("Cancel Ticket locked on compart ment");
            try
            {
                Thread.sleep(200);

            }
            catch(InterruptedException ex)
            {
                ex.printStackTrace();
            }
            System.out.println("Cancel Ticket now waitinh to lock on train");
            synchronized(train)
            {
                System.out.println("CancelTicket locked on train");
            }
        }
    }

}

public class DeadLockReal
{
    public static void main(String args[])
    {
        Object train = new Object();
        Object compartment = new Object();
        BookTicket obj1 = new BookTicket(train, compartment);
        CancelTicket obj2 = new CancelTicket(train, compartment);
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        t1.start();
        t2.start();
    }
}




package com.MultiThreading;



class ClassHerarchyThread {
    static class  shared{
        public synchronized void test(){
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                if (i == 50){
                    Thread.currentThread().stop();
                }
            }
        }
    }
    static class Thread1 extends Thread{
        shared s = null;
        public Thread1 (shared s){
            this.s =s;
        }
        @Override
        public void run() {
            s.test();
        }
    }

    static class Thread2 extends Thread{
        shared s = null;
        public Thread2 (shared s){
            this.s =s;
        }
        @Override
        public void run() {
            s.test();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        shared s = new shared();
        Thread1 t1 = new Thread1(s);
        Thread2 t2 = new Thread2(s);
        t1.start();
        t2.sleep(5000);

        t2.start();
    }

}

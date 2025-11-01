package com.MultiThreading;



class ClassHerarchyThread {
    static class  shared{
        public synchronized void test() throws InterruptedException {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                Thread.currentThread().sleep(100);
                if (i == 50 && Thread.currentThread().getName().equalsIgnoreCase("thread-0")) {
                    Thread.currentThread().stop();
                }
                test1();
            }
        }
        void test1(){

        }
    }
    static class Thread1 extends Thread{
        shared s = null;
        public Thread1 (shared s){
            this.s =s;
        }
        @Override
        public void run() {
            try {
                s.test();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class Thread2 extends Thread{
        shared s = null;
        public Thread2 (shared s){
            this.s =s;
        }
        @Override
        public void run() {
            try {
                s.test();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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

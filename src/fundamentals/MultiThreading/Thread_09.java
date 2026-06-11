package fundamentals.MultiThreading;
class MSWord implements Runnable{
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if (name.equals("Typing")){
            typing();
        } else if (name.equals("Spell")) {
            spellChecking();
        }else{
            autoSaving();
        }
    }

    public void typing(){
        try{
            for(int i =0 ; i< 4 ; i++){
                System.out.println("typing..");
                Thread.sleep(2000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void spellChecking(){
        try{
            for(int i =0 ; i< 4 ; i++){
                System.out.println("Spell Checking..");
                Thread.sleep(2000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void autoSaving(){
        try{
            for(int i =0 ; i< 4 ; i++){
                System.out.println("Auto Saving..");
                Thread.sleep(2000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class Thread_09 {
    public static void main(String[] args) {
        MSWord ms = new MSWord();
        Thread t1 = new Thread(ms);
        Thread t2 = new Thread(ms);
        Thread t3 = new Thread(ms);
        t1.setName("Typing");
        t2.setName("Spell");
        t3.setName("AutoSaving");
        t2.setDaemon(true);
        t3.setDaemon(true);
        t2.setPriority(9);
        t3.setPriority(10);
        t1.start();
        t2.start();
        t3.start();
    }
}

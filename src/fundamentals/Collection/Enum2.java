package fundamentals.Collection;
enum Result{
    PASS,FAIL,NA;
//    Behind the Scene
//    public static final Result PASS = new Result();
//    public static final Result FAIL = new Result();
//    public static final Result NA = new Result();

    enum Weeks{
        MON,TUE;
        //        public static final Weeks MON = new Weeks();
        //        public static final Weeks TUE = new Weeks();
        Weeks(){
            System.out.println("inner of Enum Constructor");
        }
    }
    int marks;
    Result(){
        System.out.println("Enum's Constructor");
    }
    public void setMarks (int mark){
        marks = mark;
    }
    public int getMarks(){
        return marks;
    }
}

public class Enum2 {
    public static void main(String[] args) {
        Result.Weeks week = Result.Weeks.MON;
        System.out.println(week); // the constructor of inner class only being called
        Result.FAIL.setMarks(23);
        System.out.println(Result.FAIL.getMarks());
    }
}

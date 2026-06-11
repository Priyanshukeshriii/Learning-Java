package fundamentals;

class example {
    int num1;
    int num2;
    void add(){
        num1 = 1;
        num2 = 2;
        int res = num1 + num2;
        System.out.println(res);
    }
}
public class VariableScope{
    public static void main(String[] args) {
        example e = new example();
        System.out.println(e.num1); // 0
        e.num1 = 20;
        e.num2 = 30;
        e.add();
        System.out.println(e.num1);
    }
}
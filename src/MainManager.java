
import java.lang.*;




class Constructor extends Object{ //Super class of all classes in java is  Object

    Constructor() {
        super();// first line of constructor by default
        System.out.println("hi");
    }
    Constructor(String s){
        System.out.println(s);
    }
    Constructor(int i ){
        System.out.println(i);
    }
    // the constructor overloading is an concept where we use same constructor name with different attribute
    //construstor can not be overridde
}
public class MainManager{
    public static void main(String[] args) {
        Constructor c = new Constructor();
        Constructor c1 = new Constructor("hello Priyanshu");
    }
}

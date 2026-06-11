package fundamentals.Collection;
class Animal{
    public void sound(){
        System.out.println("Roar");
    }
}
class Cat extends Animal{
    @Override
    public void sound(){
        System.out.println("meow");
    }
}

public class Annotation {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.sound();
    }
}

interface CheckInterface{
    // by default in interface we have static and final variable.

    int age = 44;
    String area = "Mumbai";

    // by default in interface we have public and abstract method, if we don't mention also it will work.
    void show();
    void config();
}

class CheckInterface1 implements CheckInterface{
    public void show(){
        System.out.println("in show() method");
    }

    public void config(){
        System.out.println("in config() method");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        CheckInterface ch = new CheckInterface1();
        ch.show();;
        ch.config();

        System.out.println(CheckInterface.area);
        System.out.println(CheckInterface1.age);
    }
}

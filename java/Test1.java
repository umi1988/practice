class Parent{
    Parent(){
        System.out.println("Parants cons");
    }
}
class Child extends Parent{
    Child(String s) {
     //   super(s);
        System.out.println("Child cons");
    }
}
public class Test1
{
    public static void main(String[] args) {
        Parent p = new Child("abc");
    }
}

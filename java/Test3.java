public class Test3
{
    public void display(){
        System.out.println("Display without");
    }

    public void display(String s)
    {
        System.out.println("Display with string");
    }

    public void display(Object o)
    {
        System.out.println("Display with object");
    }

    public static void main(String[] args) {
        Test3 t = new Test3();
        t.display(null);
    }
}

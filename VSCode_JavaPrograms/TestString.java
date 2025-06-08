public class TestString{
public static void main(String[] args) {
    String s1 = "umesh";
    String s2 = new String("umesh");
    String s3 = "umesh";
    String s4 = new String("umesh");
    System.out.println("s1 " + s1.hashCode());
    System.out.println("s2 "+ s2.hashCode());
    System.out.println("s3 "+ s3.hashCode());
    System.out.println("s4 "+ s4.hashCode());
    System.out.println("============");
    System.out.println(s1 == s2);
    System.out.println(s3 ==s4);
    System.out.println(s1 == s3);
    System.out.println(s2 == s4);
    System.out.println("===========");
    System.out.println(s1.equals(s2));
    System.out.println(s3.equals(s4));
    System.out.println(s1.equals(s3));
    System.out.println(s2.equals(s4));
}

}
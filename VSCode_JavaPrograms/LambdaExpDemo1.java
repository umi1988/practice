interface AddTest{
    int add(int i, int j);
}


public class LambdaExpDemo1 {
    public static void main(String[] args) {
        // if we wants to return any values then in lambda expression we should not mention the return statement
       // AddTest at = (int a, int b) -> a+b; // working
       AddTest at = (a, b) -> a+b;

       int res =  at.add(8, 1);
       System.out.println(res);
    }
}

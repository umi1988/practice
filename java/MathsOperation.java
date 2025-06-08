public class MathsOperation
{
    private static int add(int a, int b){
        int c = a+b;
        System.out.println("Addition :- " + c);
        return c;
    }
    private static int multiply(int a, int b){
        int c = a*b;
        System.out.println("Addition :- " + c);
        return c;
    }

    public static void main(String[] args) {
        int a  = 4, b = 6;
        int output_a = add(a,b);
        System.out.println(output_a);

        int mul_out = multiply(a,b);
        System.out.println(mul_out);
    }
}

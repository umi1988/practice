
class BoxingAutoBoxingDemo{
    public static void main(String[] args) {
        

        int num1 = 7;
        //Integer num2 = new Integer(num1); // boxing 

        Integer num2 = num1; // auto-boxing
        System.out.println(num2);

        int num3 = num2;// auto-unboxing
        System.out.println(num3);

        String str = "12";
        int i = Integer.parseInt(str);
        System.out.println(i*5);

    }
}
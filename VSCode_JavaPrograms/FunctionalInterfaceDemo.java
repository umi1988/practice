
@FunctionalInterface // are those which hv only one abstarct method  and we can call it as SAM(single abstract method) interface
interface FunctionalInterfaceTest{
    void show();
}
// with java 8 java is no more verbose language meaning specifying everything, detailed code. in java 8 we have shorten the code length using lambda exp
public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        FunctionalInterfaceTest fit = new FunctionalInterfaceTest(){
            public void show(){
                System.out.println("Test functonal interface");
            }
        };

        fit.show();
    }
}

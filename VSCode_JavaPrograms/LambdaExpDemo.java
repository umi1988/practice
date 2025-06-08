
@FunctionalInterface // are those which hv only one abstarct method  and we can call it as SAM(single abstract method) interface
interface FunctionalInterfaceTest11{
    void show(int i);
}
// with java 8 java is no more verbose language meaning specifying everything, detailed code. in java 8 we have shorten the code length using lambda exp
// with lambda exp we are not creating any class file but with anonymous inner class, it does.


public class LambdaExpDemo {
    public static void main(String[] args) {
        FunctionalInterfaceTest11 fit = (int i) ->
            {
                System.out.println("Test functonal interface with lambda exp " +  i);
            };
        fit.show(10);
    }
}

class OuterClass{

    public void show(){
        System.out.println("in OuterClass show() method");
    }

    class InnerClass{
        public void show(){
            System.out.println("in InnerClass show() method");
        }
    }

    static class InnerStaticClass{
        public void show(){
            System.out.println("in InnerStaticClass show() method");
        }
    }
}

//same method name as can define inside a inner class as outside class

class InnerClassDemo{
    public static void main(String[] args) {
        // outer class method directly we can access using outer class object.
        OuterClass oc =  new OuterClass();
        oc.show();

         // inner class method  we need to access using outer class object like the below line
        OuterClass.InnerClass ic = oc.new InnerClass();
        ic.show();

         // static inner class method  we need to access directly using new keyword and outer class name like the below line
       OuterClass.InnerStaticClass isc =  new OuterClass.InnerStaticClass();
       isc.show();
    }

}


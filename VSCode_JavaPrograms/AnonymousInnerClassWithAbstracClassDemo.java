
abstract class AnonymousInnerClassWithAbstracClass{
    public abstract void show();
    public abstract void config();
}


class AnonymousInnerClassWithAbstracClassDemo{
    public static void main(String[] args) {
        AnonymousInnerClassWithAbstracClass acwac = new AnonymousInnerClassWithAbstracClass() {
            public void show() {
               System.out.println("in new show");
            }

            public void config() {
                System.out.println("in new config");
            }   
        };

        acwac.show();
        acwac.config();
    }
}
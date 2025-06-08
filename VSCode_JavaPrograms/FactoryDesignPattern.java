interface OS{ // FACTORY DESIGN PATTERN -- CREATIONAL DESIGN PATTERN
        void spec();
}
class Android implements OS {
    @Override
    public void spec() {
        System.out.println("MOST POWERFUL OS");
    }
}
class IOS implements OS {
    @Override
    public void spec() {
        System.out.println("MOST SECURED OS");
    }
}
class Window implements OS {
    @Override
    public void spec() {
        System.out.println("ABOUT TO DIE THIS");
    }
}
class OSFactory{//// this will change once we have a new class in future
   public OS getInstance(String s){
    if(s.equals("OPEN")){
        return new Android();
    }else if(s.equals("CLOSED")){
        return new IOS();
    }else{
        return new Window();
    }
   }
}
// this is the client implementation...this should not be changes
public class FactoryDesignPattern {
    public static void main(String[] args) {
        OSFactory oSFactory = new OSFactory();
        OS os = oSFactory.getInstance("OPEN");
        os.spec();
    }
    
}

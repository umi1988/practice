
abstract class Car{ // abstract class
    public abstract void drive();
    public abstract  void fly();

    public void playMusic(){
        System.out.println("Playing Music...");
    } 
}

abstract class Benz extends Car{ // abstract
    @Override
    public void drive() {
       System.out.println("Driving...");
    }
}

 class UpdatedBenz extends Benz{// concrete class
    @Override
    public void fly() {
       System.out.println("flying...");
    }
}

class AbstractCLassDemo{
    public static void main(String[] args) {
        Car car = new UpdatedBenz();
        car.drive();
        car.drive();
        car.fly();
    }
}
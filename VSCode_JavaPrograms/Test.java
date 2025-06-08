class Laptop{
    String name;
    int price;

    @Override
    public String toString() {
        return name + " -- " + price;
    }

    public boolean equals(Laptop that){
        if(this.name.equals(that.name) && this.price == that.price)
            return true;
        else
            return false;
    }

    
}

class Test{
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop();
        laptop1.name = "Macbook";
        laptop1.price = 1000;

        Laptop laptop2 = new Laptop();
        laptop2.name = "Macbook";
        laptop2.price = 1000;

        boolean res = laptop1.equals(laptop2);
        System.out.println(res);


    }
}
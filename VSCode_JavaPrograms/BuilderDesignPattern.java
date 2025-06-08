class Phone{
    private String phoneBrand;
    private String phoneProcessor;
    private double size;
    private int battery;
    private int ram;
    public Phone(String phoneBrand, String phoneProcessor, double size, int battery, int ram) {
        this.phoneBrand = phoneBrand;
        this.phoneProcessor = phoneProcessor;
        this.size = size;
        this.battery = battery;
        this.ram = ram;
    }
    @Override
    public String toString() {
        return "Phone{phoneBrand='" + phoneBrand + "', phoneProcessor='" + phoneProcessor + "', size=" + size + ", battery=" + battery + ", ram=" + ram + "}";
    }
}
class PhoneBuilder{
    private String phoneBrand;
    private String phoneProcessor;
    private double size;
    private int battery;
    private int ram;
    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;}
    public PhoneBuilder setPhoneBrand(String phoneBrand) {
        this.phoneBrand = phoneBrand;
        return this;}
    public PhoneBuilder setPhoneProcessor(String phoneProcessor) {
        this.phoneProcessor = phoneProcessor;
        return this;}
    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;}
    public PhoneBuilder setSize(double size) {
        this.size = size;
        return this;}
        
    public Phone getPhone(){
        return new Phone(phoneBrand, phoneProcessor, size, battery, ram);
    }
}
public class BuilderDesignPattern {
    public static void main(String[] args) {
       // Phone p = new Phone(null, null, 0, 0, 0) // no need to provide complete set of values
        Phone p = new PhoneBuilder().setRam(10).setBattery(3000).setPhoneBrand("iOS").getPhone();
        System.out.println(p); 
    }
}

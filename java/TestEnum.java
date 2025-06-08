

enum  Currency{
    USD(1.18), EUR(1.0), JPY(132.17);

    private double rate;
    Currency(double rate){
        this.rate =rate;
    }

    double convertToUSD(double amount){
        return amount * rate;
    }

}

public class TestEnum
{
    public static void main(String[] args) {
       Currency currency = Currency.EUR;
        System.out.println(currency.convertToUSD(50));
    }
}
// o/p = 50.0
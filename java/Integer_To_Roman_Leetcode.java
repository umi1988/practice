public class Integer_To_Roman_Leetcode
{
    public static String intToRoman(int num) {
        final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] symbols = {"M", "CM", "D",  "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; ++i) {
            if (num == 0)
                break;
            while (num >= values[i]) {// condition check
                sb.append(symbols[i]);// adding the roman symbol based on the values
                num -= values[i];// we are doing minus values. so that remaining will be calculated
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        int num = 3749;
        String s = intToRoman(num);
        System.out.println(s);
    }


}


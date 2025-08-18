package DSA.String;

import java.util.Map;

/**
 * Convert a Roman numeral to an integer.
 *
 */
public class RomanToInteger
{
    public static int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = map.get(s.charAt(i));
            if (i + 1 < s.length() && val < map.get(s.charAt(i + 1))) {
                sum -= val;
            } else {
                sum += val;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int result = romanToInt("MD");
        System.out.println(result);
    }
}

package DSA.String;

/**
 * ALGO:-
 *
 1> Uses a count[256] array to cover all ASCII characters:
    Lowercase and uppercase letters
    Digits 0–9
    Special characters like @, !, #, etc.
 2> Increments for s, decrements for t
 3> Final check: all counts must be zero


 Example Cases :-
 s1	          s2	        Result
 "A1@bc!"	 "!cb@1A"	    ✅
 "Hello!"	 "oHell!"	    ✅
 "abc123"	 "321cba"	    ✅
 "abc"	     "abC"	        ❌ (case-sensitive)

 */
public class ValidAnagram_WithFULLASCII_RANGE_Optimised_Algo
{
    public boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()) return false;

        int[] count = new int[256];// for full ASCII Range
        for (int i =0;i<s1.length();i++){
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for(int c : count){
            if(c != 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        ValidAnagram_WithFULLASCII_RANGE_Optimised_Algo validator = new ValidAnagram_WithFULLASCII_RANGE_Optimised_Algo();
        String s1 = "A1@bc!";
        String s2 = "!cb@1A";
        System.out.println("Are they anagrams? " + validator.isAnagram(s1, s2)); // true
    }
}

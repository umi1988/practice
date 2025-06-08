public class StringPermutation_AC
{
    public static void printPermutation(String s, String perm, int idx){
        if(s.length()==0) {
            System.out.println(perm);
            return;
        }
        for (int i =0;i<s.length();i++){
           char currChar =  s.charAt(i);
           String newStr = s.substring(0,i) + s.substring(i+1); // i will not be included
            printPermutation(newStr,perm+currChar,idx+1);
        }
    }
    public static void main(String[] args) {
        String s = "ABC";
        printPermutation(s,"", 0);
    }
}

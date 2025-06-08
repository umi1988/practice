import java.util.*;

public class ComparatorDemo1 {
    public static void main(String[] args) {
        

        // this comparator is doing the sorting based on the length of the string in the str array
        
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String i, String j){
                if(i.length()> j.length())
                    return 1;
                else if(i.length()< j.length())
                    return -1;
                else return 0;
            }
        };
        

        List<String> str = new ArrayList<>();
        str.add("Umesh kumar");
        str.add("Sumit Jadav Pandit");
        str.add("Vikas kumar Sharma");
        str.add("Hi How are you");
        str.add("I am fine with ur proposal");
        str.add("you need to understand the logic and make it work with ur implemenation");

        Collections.sort(str, comp);

        System.out.println(str);

    }
}

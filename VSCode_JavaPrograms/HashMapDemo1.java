
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo1 {
    public static void main(String[] args) {
        Map<String, Integer> hm = new HashMap<>();

        hm.put("Navin", 10);
        hm.put("Sumit", 18);
        hm.put("Drishti", 5);
        hm.put("Manoj", 2);
        hm.put("Arpan", 1);
        hm.put("Jack", 199);

        for(String key : hm.keySet()){
            System.out.println(key + " : " + hm.get(key));
        }
    }
}

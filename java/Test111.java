import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Test111
{
    public static void iterateMap(Map<String, String> hacker){
       for(Entry<String, String> entry : hacker.entrySet()){
           System.out.print(entry.getValue() + ", " + entry.getKey());
        }
    }

    public static void main(String[] args) {
        Map<String, String> hacker = new HashMap<>();
        hacker.put("key 1", "value 1");
        hacker.put("key 2", "value 2");
        Test111.iterateMap(hacker);
    }
}
// out put would be -  value 2 - key 2value 1 - key
// Notes: HashMap doesnt preserve any order by default 

import java.util.HashMap;
import java.util.Map;

public class IterateHashMap {
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<String, String>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    
    for (Map.Entry<String, String> entry: map.entrySet()) {
      System.out.println(entry.getKey() + "=" + entry.getValue());
    }
  }
}

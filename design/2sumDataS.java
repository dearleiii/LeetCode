/* Test case not passed: 
["TwoSum","add","add","find","find","find","add","find","find","find","add","find"]
[[],[1],[1],[0],[1],[2],[-1],[0],[1],[-2],[-1],[-2]]
*/

class TwoSum {
    // initialize Hashmap<Integer value, corresponding position index>
    HashMap<Integer, Integer> database;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        database = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
       database.put(number, 1+database.getOrDefault(number, 0));
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int remain;
        // for (int item: database) {
        for (Map.Entry<Integer, Integer> entry: database.entrySet()) {
            remain = value - entry.getKey();
            database.put(entry.getKey(), entry.getValue()-1);
            if (database.containsKey(remain) && database.get(remain) >=1) 
              // Important! add back if ture as well: database.put(entry.getKey(), entry.getValue()+1);
                return true; 
            
            database.put(entry.getKey(), entry.getValue()+1);
        }
        
        return false;
    }
}

// Mistake: 
  // test case: ["TwoSum","add","add","find","find","find","add","find","find","find","add","find"]
[[],[1],[1],[0],[1],[2],[-1],[0],[1],[-2],[-1],[-2]]
  // when there are consecutive add & find 
  
  
// Simplify 2nd function: 
public boolean find(int value) { 
        for(Integer k : map.keySet()){
            int t = value - k;
            if((t == k && map.get(k) > 1) || (t != k && map.containsKey(t))) return true;
        }
        return false;
    }



/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
 
 
 // faster solution: 
 // Reason: There's nothing surprising that iterating a count map is slower than iterating a list, if you take a look at the source code of Java hashmap, or simply take a look at Java doc:
https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
 
 public class TwoSum {
    private List<Integer> list = new ArrayList<Integer>();
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    // Add the number to an internal data structure.
	public void add(int number) {
	    if (map.containsKey(number)) map.put(number, map.get(number) + 1);
	    else {
	        map.put(number, 1);
	        list.add(number);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int i = 0; i < list.size(); i++){
	        int num1 = list.get(i), num2 = value - num1;
	        if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) return true;
	    }
	    return false;
	}
}

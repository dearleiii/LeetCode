// My solution: HashMap 13/16 passed

class TwoSum {
    // initialize Hashmap<Integer value, corresponding position index>
    HashMap<Integer, Integer> database;
    int pos;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        database = new HashMap<Integer, Integer>();
        pos = 0;
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
       database.put(number, pos++);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int remain;
        // for (int item: database) {
        for (Map.Entry<Integer, Integer> entry: database.entrySet()) {
            remain = value - entry.getKey();
            if (database.containsKey(remain) && database.get(remain) != entry.getValue()) 
                return true; 
        }
        
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 
 
 
 // Solution: HashSet 
 


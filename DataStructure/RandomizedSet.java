/*
/** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
    */

class RandomizedSet {
    private Map<Integer, Integer> num2index;
    private List<Integer> nums;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        num2index = new HashMap<Integer, Integer>();
        nums = new ArrayList<Integer>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (num2index.containsKey(val))
            return false;
        num2index.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!num2index.containsKey(val))
            return false;
        
        int index = num2index.get(val);
        if (index < nums.size() - 1) {
            // not the last one: swap the last one with this
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            num2index.put(last, index);
        }
        
        num2index.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

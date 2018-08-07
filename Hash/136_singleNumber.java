class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> counting = new HashMap<>();
        
        for (int item: nums) {
            if (counting.containsKey(item)) {
                counting.put(item, counting.get(item) +1);
            }
            else 
                counting.put(item, 1);
        }
        
        for (Map.Entry<Integer, Integer> entry:counting.entrySet()) {
            if (entry.getValue() ==1)
                return entry.getKey();
        }
        
        return nums[0];
    }
}



// Solution2. With constant space 
// XOR of 0: return that bit; 
// XOR of 2 same bits: return 0;
// XOR: return 1 if only cnt = 1;

// -> Bitwise operation: a ^ 0 = a; a ^a = 0;

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int item: nums) {
            res = res^item;
        }
        
        return res;
    }
}

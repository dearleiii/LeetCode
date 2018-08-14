// Method 1. Official
class Solution {
    public int findDuplicate(int[] nums) {
         // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }
}

// Method 2: Index Array 
  // beat 100% solution
class Solution {
    public int findDuplicate(int[] nums) {
        int curr = 0, prev = 0;
        while (nums[curr] != 0) {
            curr = nums[curr];   // the new position to check 
            nums[prev] = 0;
            prev = curr;
        }
        
        return curr;
    }
}

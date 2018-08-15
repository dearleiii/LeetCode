// My broken: 
  // not consider corner case: i.e. [2, 1]
      // -> runtime error: when [mid-1] out of index 
class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l+r)/2;
            if (nums[mid] < nums[mid+1]) {
                l = mid; 
            } else if (nums[mid] < nums[mid-1]) {
                r = mid;
            }
            else return mid;
        }
        
        return l;
    }
}



// Correction: 
public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}

// Note!!
// when appear [mid-1], [mid+1] -> check whether out of index!
// perfer use [mid+1] for B.S to avoid this 

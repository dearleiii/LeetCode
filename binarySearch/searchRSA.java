// Method1. B.S 2 times 

public class Solution {
    int search(int[] nums, int target) {
        int lo=0,hi=nums.length-1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(nums[mid]>nums[hi]) lo=mid+1;
            else hi=mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot=lo;
        lo=rot;hi=rot-1;
        // The usual binary search and accounting for rotation.
        while(lo<=hi){
            int mid=(lo+hi)/2;
            int realmid=(mid+rot)%nums.length;
            if(nums[realmid]==target)return realmid;
            if(nums[realmid]<target)lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }
}

// Method2. B.S 1 time 
    // 1-time search, visualize to discussion different possibilities 
    // discuss mid-line firse 
        // discuss within each situation
public class Solution {
    int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        int start = 0; 
        int end = nums.length-1;
        int mid;
        
        while (start+1 < end) {
            mid = start+ (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }    
            } else { 
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
}


// !! Note!!!
while (start+1 < end) 
    // to avoid time limit exceed
if: while (start < end) {
    update mid: mid = start;
    update: start: start = mid; 
    -> CANT break while loop
}
    

public class Solution {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int res = 1; 
        int i, j;
        
        int[] f = new int[n];
        f[0] = 1;
        
        for (i = 1; i < n; i++) {
            f[i] = 1;   // when only itself
            // previous element nums[i]
            for (j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    f[i] = Math.max(f[j] + 1, f[i]);
            }
            
            res = Math.max(res, f[i]);
        }
        
        return res;
    }
}

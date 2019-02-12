public class Solution {
    /**
     * @param nums: the array
     * @return: the minimum times to flip digit
     */
    public int flipDigit(int[] nums) {
        // Write your code here
        int n = nums.length;
        if (n <= 1) return 0;
        int[][] f = new int[n + 1][2];
        
        // init 
        f[0][0] = f[0][1] = 0;
        int i, j, t, k; 
        for (i = 1; i <= n; i++) {
            for (j = 0; j < 2; j++) {
                f[i][j] = Integer.MAX_VALUE;
                t = 0; 
                if (j != nums[i - 1]) 
                    ++t;    // t is a flag of whether flip 
                
                for (k = 0; k < 2; ++k) {
                    if (k == 0 && j == 1)
                        continue;
                    f[i][j] = Math.min(f[i - 1][k] + t, f[i][j]);
                }
            }
        }
        
        return Math.min(f[n][0], f[n][1]);
    }
}

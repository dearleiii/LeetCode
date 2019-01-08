// Importance of setting the boundary:
  //  if (f[i] == true && i+j < n)
  //  f[i] has to be true: be able to come to f[i] !

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] f = new boolean[n];
        f[0] = true;
        
        int curr;
        for (int i = 0; i < n; i++) {
            // f[i] = false;
            curr = nums[i];
            for (int j = 1; j <= curr; j++) {
                if (f[i] == true && i+j < n)
                    f[i+j] = true;
            }
        }
        
        return f[n-1];
    }
}

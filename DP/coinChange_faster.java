
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        
        // initialization 
        f[0] = 0;
        int i, j;
        
        // dp subproblem 
        for (i = 1; i <= amount; i++) {
            f[i] = Integer.MAX_VALUE;
            for (j = 0; j < coins.length; j++) {
                if (i >= coins[j] && f[i-coins[j]] < Integer.MAX_VALUE) 
                    f[i] = Math.min(f[i], f[i-coins[j]] + 1);
            }
        }
        
        if (f[amount] == Integer.MAX_VALUE)
            return -1;
        else
            return f[amount];
    }
}

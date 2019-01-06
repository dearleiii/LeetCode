class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        int n = coins.length;
        
        f[0] = 0;
        int i, j;
        for (i = 1; i <= amount; i++) {
            f[i] = -1;
            for (j = 0; j < n; j++) {
                if (i >= coins[j] && f[i-coins[j]] != -1) {
                    if (f[i] == -1 || f[i-coins[j]] + 1 < f[i])
                        f[i] = f[i-coins[j]] + 1;
                }
            }
        }
        
        return f[amount];
    }
}

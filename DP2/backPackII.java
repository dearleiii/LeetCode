public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int n = A.length;
        if (n == 0)
            return 0;
            
        int[][] f = new int[n + 1][m + 1];
        int i, w; 
        for (i = 1; i <= n; ++i) {
            for (w = 0; w <= m; ++w) {
                f[i][w] = f[i - 1][w];
                if (w >= A[i - 1] && f[i - 1][w - A[i - 1]] != -1) 
                    f[i][w] = Math.max(f[i][w], f[i - 1][w - A[i - 1]] + V[i - 1]);
            }
        }
        
        int res = 0;
        for (w = 0; w <= m; ++w) {
            if (f[n][w] != -1)
                res = Math.max(res, f[n][w]);
        }
        
        return res;
    }
}

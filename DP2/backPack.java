public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int n = A.length;
        if (n == 0) return 0;
        
        // n items, check whether can fill m size packpack 
        boolean[][] f = new boolean[n + 1][m + 1];
        
        // initialize 
        int i, w;
        for (i = 1; i <= m; ++i) {
            f[0][i] = false; // when 0 item, no size to fill
        }
        
        f[0][0] = true;
        for (i = 1; i <= n; ++i) {
            for (w = 0; w <= m; ++w) {
                f[i][w] = f[i - 1][w];
                if (w >= A[i-1]) 
                    f[i][w] = (f[i][w] || f[i-1][w-A[i-1]]);
            }
        }
        
        for (i = m; i >= 0; --i) {
            if (f[n][i]) 
                return i;
        }
        
        return 0 ;
    }
}

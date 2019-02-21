public class Solution {
    /**
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        char[] A = word1.toCharArray();
        char[] B = word2.toCharArray();
        int m = A.length;
        int n = B.length;
        
        int[][] f = new int[m + 1][n + 1];
        
        // init 
        int i, j;
        for (i = 0; i <= n; ++i)
            f[0][i] = i;
        for (i = 0; i <= m; ++i) 
            f[i][0] = i;
        
        // sub-problem 
        for (i = 1; i <= m; ++i) {
            for (j = 1; j <= n; ++j) {
                f[i][j] = Math.min(Math.min(f[i][j - 1] + 1, f[i - 1][j - 1] + 1), f[i - 1][j] + 1);
                if (A[i - 1] == B[j - 1])
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
            }
        }
        
        return f[m][n];
    }
}

// Careful when set the init condition 
  // f[i][j] = 1

class Solution {
    public int uniquePaths(int m, int n) {
        // states: 
        int[][] f = new int[m][n];
        
        // init && boundary 
        int i, j;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (i == 0 || j == 0) 
                    f[i][j] = 1;
                else
                    f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
        
        return f[m-1][n-1];
    }
}

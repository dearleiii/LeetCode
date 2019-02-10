class Solution {
    public int minPathSum(int[][] grid) {
      // write your code here
        int h = grid.length;
        int w = grid[0].length;
        int i, j;
        int[][] f = new int[2][w];
        int old, now = 0; 
        
        for (i = 0; i < h; ++i) {
            old = now;
            now = 1 - now;
            
            for (j = 0; j < w; ++j) {
                if (i == 0 && j == 0) {
                    f[now][j] = grid[0][0];
                    continue;
                }
                
                f[now][j] = Integer.MAX_VALUE;
                if (i > 0)
                    f[now][j] = Math.min(f[old][j], f[now][j]);
                if (j > 0)
                    f[now][j] = Math.min(f[now][j - 1], f[now][j]);
                
                f[now][j] += grid[now][j];
            }
        }
        
        return f[now][w - 1];
    }
}

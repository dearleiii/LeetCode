public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        
        int h = grid.length;
        int w = grid[0].length;
        int i, j;
        int[][] f = new int[h][w];
        f[0][0] = grid[0][0];
        
        for (i = 1; i < w; i++)
            f[0][i] = f[0][i -1] + grid[0][i];
        for (i = 1; i < h; i++)
            f[i][0] = f[i - 1][0] + grid[i][0];
            
        for (i = 1; i < h; i++) {
            for (j = 1; j < w; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }
        
        return f[h - 1][w - 1];
    }
}

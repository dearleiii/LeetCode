public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // edge cases 
        if (pages == null || pages.length == 0) return 0;
        int books = pages.length;
        if (k >= books) {
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < books; i++)
                res = Math.max(res, pages[i]);
            return res;
        }
        
        // define states
        int[][] f = new int[k + 1][books + 1];  // state to record min time for k persons to finish i books;
        int i, j;
        for (i = 0; i <= books; i++) 
            f[0][i] = Integer.MAX_VALUE;    // with 0 person, take MAX_VALUE time to finish book 
        for (i = 0 ;i <= k; i++)
            f[i][0] = 0;    // with 0 book, t = 0 to finish 
        
        // sub-problem
        int rest, r;
        for (i = 1; i <= k; i++) {
            for (j = 1; j <= books; j++) {
                f[i][j] = Integer.MAX_VALUE;
                rest = 0;
                for (r = j; r >= 0; r--) {
                    f[i][j] = Math.min(Math.max(rest, f[i - 1][r]), f[i][j]);
                    // r = 0?
                    if (r > 0)
                        rest += pages[r - 1];
                }
            }
            
        }
        
        return f[k][books];
    }
}

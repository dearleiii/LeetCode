public class Solution {
    /**
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        char[] sc = s.toCharArray();
        int i, j; 
        int[][] f = new int[n][n];
        
        // init 
        for (i = 0; i < n - 1; i ++) {
            f[i][i] = 1;
            if (sc[i] == sc[i + 1])
                f[i][i + 1] = 2;
            else    
                f[i][i + 1] = 1;
        }
        f[n - 1][n - 1] = 1;
        
        // sub-problem 
        int l; 
        for (l = 2; l <= n; l++) {
            for (i = 0; i < n - l; i++) {
                f[i][i + l] = Math.max(f[i + 1][i + l], f[i][i + l - 1]);
                if (sc[i] == sc[i + l])
                    f[i][i + l] = Math.max(f[i][i + l], f[i + 1][i + l - 1] + 2);
            }
        }
        
        return f[0][n - 1];
    }
}

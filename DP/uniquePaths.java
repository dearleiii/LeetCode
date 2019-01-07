class Solution {
    
     public int uniquePaths(int m, int n) {
        int rights = m - 1;
        int downs = n - 1;
        int sum = rights + downs;
        int large = rights >= downs ? rights: downs;
        int small = rights < downs ? rights: downs;
        
        long res = 1;
        for (int i = 0; i < small; i ++) {
            res = res * (sum --) / (i + 1);
        }
        // return (int)res;
         return res;
    }
}

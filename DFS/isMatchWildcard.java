class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        
        return isMatchHelper(s, p, 0, 0, memo, visited);
    }
    
    private boolean isMatchHelper(String s, String p, int sIndex, int pIndex, boolean[][] memo, boolean[][] visited) {
        if (sIndex == s.length() && pIndex == p.length()) {
            return true; 
        } else if (sIndex == s.length()) {
            // check whether all remanining are '*'
            for (int i = pIndex; i < p.length(); i++) {
                if (p.charAt(i) != '*') return false;
            }
            return true;
        } else if (pIndex == p.length()) {
            return false;
        }
        
        if (visited[sIndex][pIndex]) 
            return memo[sIndex][pIndex];
        
        char sCurr = s.charAt(sIndex);
        char pCurr = p.charAt(pIndex);
        visited[sIndex][pIndex] = true;

        if (sCurr == pCurr || pCurr == '?') {
            memo[sIndex][pIndex] = true;
            return isMatchHelper(s, p, sIndex+1, pIndex+1, memo, visited);
        } else if (pCurr != '*') {
            memo[sIndex][pIndex] = false;
            return false;
        } else { 
            memo[sIndex][pIndex] = (isMatchHelper(s, p, sIndex+1, pIndex, memo, visited) || isMatchHelper(s, p, sIndex, pIndex+1, memo, visited));
            return memo[sIndex][pIndex];
        }
    }
}

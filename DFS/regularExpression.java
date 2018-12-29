class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] visited = new boolean[s.length()][p.length()];
        boolean[][] memo = new boolean[s.length()][p.length()];
        
        return isMatchHelper(s, 0, p, 0, memo, visited);
    }
    
    private boolean isMatchHelper(String s, int sIndex, 
                                 String p, int pIndex, 
                                 boolean[][] memo, boolean [][] visited) {
        // set finish criteria 
        if (pIndex == p.length()) {
            return sIndex == s.length();
        } 
        if (sIndex == s.length()) {
            return pRemains(p, pIndex);
        }
        
        // check appearance before 
        if (visited[sIndex][pIndex])
            return memo[sIndex][pIndex];
        visited[sIndex][pIndex] = true;
        
        // check matching 
        char sCurr = s.charAt(sIndex);
        char pCurr = p.charAt(pIndex);
        boolean match;
        
        if ((pIndex + 1) < p.length() && p.charAt(pIndex+1) == '*') {
            match = (isMatchHelper(s, sIndex, p, pIndex+2, memo, visited) || (isMatchHelper(s, sIndex + 1, p, pIndex, memo, visited) && charMatch(sCurr, pCurr)));
        } else {
            match = charMatch(sCurr, pCurr) && isMatchHelper(s, sIndex + 1, p, pIndex +1, memo, visited);
        }
        
        memo[sIndex][pIndex] = match;
        return match;
    }
    
    private boolean pRemains(String p, int pIndex) {
        for (int i = pIndex; i < p.length(); i += 2) {
            if ((i+1) >= p.length() || p.charAt(i+1) != '*')
                return false;
        }
        return true;
    }
    private boolean charMatch(char s, char p) {
        if (s == p || p == '.') {
            return true;
        } 
        return false;
    }
}

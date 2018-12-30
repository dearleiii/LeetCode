// if miss the condition: 
// isMatchHelper(s, sIndex + 1, p, pIndex, visited, memo) && (sCurr == pCurr || pCurr == '.')

class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] visited = new boolean[s.length()][p.length()];
        boolean[][] memo = new boolean[s.length()][p.length()];
        
        return isMatchHelper(s, 0, p, 0, visited, memo);
    }
    
    private boolean isMatchHelper(String s, int sIndex,
                                 String p, int pIndex, 
                                 boolean[][] visited,
                                 boolean[][] memo) {
        // return condition 
        if (pIndex == p.length()) {
            return sIndex == s.length();
        } 
        if (sIndex == s.length()) {
            return isEmpty(p, pIndex);
        }
        
        // check visited 
        if (visited[sIndex][pIndex])
            return memo[sIndex][pIndex];
        visited[sIndex][pIndex] = true;
        
        // checking matching with recursion 
        char sCurr = s.charAt(sIndex);
        char pCurr = p.charAt(pIndex);
        if ((pIndex+1) < p.length() && p.charAt(pIndex+1) == '*') {
            memo[sIndex][pIndex] = (isMatchHelper(s, sIndex, p, pIndex+2, visited, memo) || isMatchHelper(s, sIndex + 1, p, pIndex, visited, memo) && (sCurr == pCurr || pCurr == '.'));
            return memo[sIndex][pIndex];
        } else {
            memo[sIndex][pIndex] = (sCurr == pCurr || pCurr == '.');
            if (!memo[sIndex][pIndex])
                return false;
            else
                return isMatchHelper(s, sIndex+1, p, pIndex+1, visited, memo);
        }
        
    }
    
    private boolean isEmpty(String p, int pIndex) {
        for (int i = pIndex; i < p.length(); i+=2) {
            if (i+1 >= p.length() || p.charAt(i+1) != '*')
                return false;
        }
        return true;
    }
}

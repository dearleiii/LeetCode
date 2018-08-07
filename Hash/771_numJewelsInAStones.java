// Brutal force solution -> HashSet 

class Solution {
    public int numJewelsInStones(String J, String S) {
        int cnt = 0;
        char jewel;
        
        for (int j = 0; j < J.length(); j++) {
            jewel = J.charAt(j);
            for (int s = 0; s < S.length(); s++) {
                if (jewel == S.charAt(s)) cnt++;
            }
        }
        
        return cnt;
    }
}


// Solution: HashSet 
class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> Jset = new HashSet();
        for (char j: J.toCharArray())
            Jset.add(j);

        int ans = 0;
        for (char s: S.toCharArray())
            if (Jset.contains(s))
                ans++;
        return ans;
    }
}

// Analysis: supposed to be faster, O(m+n)
// Acutally slower, with the time to search hashset 

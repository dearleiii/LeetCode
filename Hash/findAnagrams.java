// Time limit exceeded for some 
// My broken: start searching for each indices
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() ==0 || p.length() == 0 || p.length() > s.length()) return res;
        HashMap<Character, Integer> pMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0)+1);
        }
        
        for (int i = 0 ; i <= s.length() - p.length(); i++) {
            System.out.println(pMap);
            HashMap<Character, Integer> mapCopy = new HashMap<>();
            mapCopy = (HashMap) pMap.clone();
            if (indexCheckAnagram(s, mapCopy, i, p.length())) res.add(i);
        }
        
        return res;
    }
    
    private boolean indexCheckAnagram(String s, HashMap<Character, Integer> pMap, int index, int l) {
        char c;
        for (int i = index; i<index + l; i++) {
            c = s.charAt(i);
            if (pMap.containsKey(c) == false) return false;
            pMap.put(c, pMap.get(c) -1);
            if (pMap.get(c) == 0) pMap.remove(c);
        }
        if (pMap.isEmpty() == false) return false;
        return true;
    }
}


// Fast : 94% Sliding window 
    // 1. Construct a map of 26 characters: recording how many / exceed the chars in p
            // if exceed: recording as '-' 
        chars[c - 'a']++;
    // 2. start = 0, end = 0;
    // 3. Go over the string: 
        if (map.charAt(end) >= 0) // appeared in p
            count--; end++;
        else if (end - start == p.length() && )
                

public List<Integer> findAnagrams(String s, String p) {
    int[] chars = new int[26];
    List<Integer> result = new ArrayList<>();

    if (s == null || p == null || s.length() < p.length())
        return result;
    for (char c : p.toCharArray())
        chars[c-'a']++;

    int start = 0, end = 0, count = p.length();
    // Go over the string
    while (end < s.length()) {
        // If the char at start appeared in p, we increase count
        if (end - start == p.length() && chars[s.charAt(start++)-'a']++ >= 0)
            count++;
        // If the char at end appeared in p (since it's not -1 after decreasing), we decrease count
        if (--chars[s.charAt(end++)-'a'] >= 0)
            count--;
        if (count == 0)
            result.add(start);
    }
    
    return result;
}


// Notes!!
    // chars[s.charAt(end++) - 'a'] in order to find index!

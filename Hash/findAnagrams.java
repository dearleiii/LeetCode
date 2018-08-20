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


//

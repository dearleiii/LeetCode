// Version 1. not all passes: 
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        // if (s.length < 1 || s == null) return true;
        HashMap<Character, Character> match = new HashMap<Character, Character>();
        
        char cs, ct;
        for (int i = 0; i < s.length(); i++) {
            cs = s.charAt(i); 
            ct = t.charAt(i);
            if (match.containsKey(cs)) { // has to be value == ct
                if (match.get(cs)!= ct) return false;    
            } else { // not in hashmap, put in 
                match.put(cs, ct);
            }
        }
        return true;        
    }
}

// Corner case: when all s-> can map to t, but not all t-> map to s 

// in else, need to check map.contains(b)
else {
                if(!map.containsValue(b))
                map.put(a,b);
                else return false;
                
            }

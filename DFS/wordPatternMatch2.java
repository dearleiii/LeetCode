class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> bijection = new HashMap<>();
        Set<String> duplicates = new HashSet<>();
        return match(pattern, str, bijection, duplicates);
    }
    
    private boolean match(String pattern, 
                         String str, 
                         Map<Character, String> bijection,
                         Set<String> dup) {
        // return condition 
        if (pattern.length() == 0)
            return str.length() == 0;
        
        // recursion 
        Character c = pattern.charAt(0);
        // if c in bijection, appeared before, check the mapping 
        if (bijection.containsKey(c)) {
            if (!str.startsWith(bijection.get(c)))
                return false;
            return match(pattern.substring(1), 
                        str.substring(bijection.get(c).length()), 
                        bijection, dup);
        }
        
        // c not appeared before, try out each possible substring 
        for (int i = 0; i < str.length(); i++) {
            String word = str.substring(0, i+1);
            if (dup.contains(word))
                continue;
            
            bijection.put(c, word);
            dup.add(word);
            if (match(pattern.substring(1), 
                     str.substring(i+1), 
                     bijection, dup))
                return true;
            dup.remove(word);
            bijection.remove(c);
        }
        return false;
    }
}

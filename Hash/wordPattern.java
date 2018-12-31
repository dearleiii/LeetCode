class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] str_arr = str.split(" ");
        if (pattern.length() != str_arr.length) return false;
        
        HashMap<Character, String> bijection = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String token = str_arr[i];
            
            if (bijection.containsKey(c)) { // check key == str_arr mapping 
                if (token.equals(bijection.get(c)) == false) return false;
            } else { // bijection not contain
                if (bijection.containsValue(token)) return false;
                bijection.put(c, token);
            }
            
        }
        
        return true;
    }
}

// Method 1. HashTable ... slow 
class Solution {
    public char findTheDifference(String s, String t) {
        if (s == null || s.length() == 0) return t.charAt(0);
        
        HashMap<Character, Integer> origin = new HashMap<>();
        
        for (char c: s.toCharArray()) {
            origin.put(c, 1+ origin.getOrDefault(c, 0));
        }
        
        char c = t.charAt(0);
        for (int i = 0; i <t.length(); i++) {
            c = t.charAt(i);
            if (!origin.containsKey(c) || origin.get(c) == 0) return c;
            origin.put(c, origin.get(c) -1);
        }
        
        return c;
    }
}

// Method2. Bit manipulation 
	// ^: return 0 when same value, else: return the bit value 
public char findTheDifference(String s, String t) {
	char c = 0;
	for (int i = 0; i < s.length(); ++i) {
		c ^= s.charAt(i);
	}
	for (int i = 0; i < t.length(); ++i) {
		c ^= t.charAt(i);
	}
	return c;
}

//-> optimize code 
public char findTheDifference(String s, String t) {
	int n = t.length();
	char c = t.charAt(n - 1);
	for (int i = 0; i < n - 1; ++i) {
		c ^= s.charAt(i);
		c ^= t.charAt(i);
	}
	return c;
}

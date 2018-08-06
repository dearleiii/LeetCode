// My Solution: 
// Read character by character, store with StringBuffer, update each time encounter a different char

public String countAndSay(int n) {
        // Method using StringBuffer
        StringBuffer prev = new StringBuffer("1");
        if (n == 1) return prev.toString();
        StringBuffer curr = new StringBuffer("");
        int cnt=1;
        char hold;
        
        for (int i = 2; i <=n; i++) {
            hold = prev.charAt(0);
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) == hold) {
                    cnt++;
                }
                else {
                    // Add to StringBuffer 
                    curr.append(cnt);
                    curr.append(hold);
                    hold = prev.charAt(j);
                    cnt = 1;
                }
            }
            System.out.printf("cnt = " + String.valueOf(cnt) + " for char " + hold + "\n");
            curr.append(cnt);
            curr.append(hold);
            prev.delete(0, prev.length());
            prev.append(curr);
            curr.delete(0, curr.length());
            cnt = 1;
        }
        
        return prev.toString();
    }
    
    
    // Faster solution ~ 93% 
    // Recursion 
    public String countAndSay(int n) {
        if (n == 1) return "1";
        return count(countAndSay(n-1));
    }
    
    private String count(String s) {
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) != s.charAt(k)) {
                sb.append(j-k);
                sb.append(s.charAt(k));
                k = j;
            }
            if (j == s.length() -1) {
                sb.append(j-k+1);
                sb.append(s.charAt(k));
            }
        }
        return sb.toString();
    }

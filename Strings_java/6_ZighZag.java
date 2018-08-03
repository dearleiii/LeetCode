import Java.lang

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        // Combine the 3 lines, for simplicity, also decrease the corner case
        String res = new String("");
        
        int gap = (numRows-2)*2;
        for (int pos_row = 0; pos_row < numRows; pos_row++) { 
            for (int pos = pos_row; pos < s.length(); pos+=gap) {
                res = res + s.charAt(pos);
                if (pos_row != 0 && pos_row != numRows-1 && ((pos+gap-2*pos_row) < s.length()) )
                    res = res + s.charAt(pos+gap-2*pos_row);
            }
        }
        
        return res;
    }
}

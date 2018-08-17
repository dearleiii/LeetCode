// Note: if not the approperiate algorithm, so manyyyyyyy corner cases: 

  // e.x. cases: "ebcbbececabbacecbbcbe" -> true 


// mine 456/460 : 

class Solution {
    public boolean validPalindrome(String s) {
        int front = 0, end = s.length()-1;
        boolean delete = false;
        
        while (front < end) {
            if (s.charAt(front) == s.charAt(end)) {
                front++; end--;
            } else if (delete == false) {
                // 2 possible deletion 
                if (s.charAt(front) == s.charAt(end-1)) end--;
                else front++;
                delete = true;
            }
            else return false;
        }
        
        return true;
    }

}

// Method2: same idea, 2 pointers, -> When two chars are not equal, 
    // try to skip (pseudo delete) either left one or right one and continue checking.
    
class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++; j--;
        }

        if (i >= j) return true;

        if (isPalin(s, i + 1, j) || isPalin(s, i, j - 1)) return true;
        return false;
    }

    private boolean isPalin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++; j--;
            }
            else return false;
        }
        return true;
    }
}

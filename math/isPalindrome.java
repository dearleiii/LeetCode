// Coud you solve it without converting the integer to a string?

// main idea: 
  // reverse half of the x, condition to judge it's half: reverse < x
  // consider both the case 1221, 121
        if (reverse == x || reverse/10 == x) return true;


// Edge case 1 : 
        if (x < 0 || x%10 == 0 && x!=0) return false;



class Solution {
    /* Idea: to reverse half of x, compare whether equal 
            check it's half: remaining number v.s.token number 
            */
    
    public boolean isPalindrome(int x) {
        // edge case: all - number are false 
        if (x < 0 ) return false;
        int reverse = 0;
        
        while (reverse < x) {
            reverse = 10* reverse + x %10;
            x = x/10;
        }
        
        if (reverse == x || reverse/10 == x) return true;
        else return false;
    }
}

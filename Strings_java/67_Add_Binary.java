class Solution {
  public String addBinary(String a, String b) {
  // Solution that no need to consider the length of a vs. b 
  // while loop: until both pointer reaches the end 
    int len_a = a.length(), len_b = b.length();
        int p_a = len_a-1, p_b = len_b-1;
        StringBuffer res = new StringBuffer("");
        int sum, carry=0;
        
        while (p_a >= 0 || p_b >=0) {
            if (p_a <0) {
                sum = (b.charAt(p_b)-'0' + carry) % 2;
                carry = (b.charAt(p_b)-'0' + carry) /2;
            }
            else if (p_b <0) { // add the rest of a 
                sum = (a.charAt(p_a) -'0'+ carry ) %2;
                carry = (a.charAt(p_a) -'0' + carry) /2;
            }
            else {
                // add both a & b part 
                sum = (a.charAt(p_a)-'0' + b.charAt(p_b)-'0' + carry) % 2;
                carry = (a.charAt(p_a)-'0' + b.charAt(p_b)-'0' + carry) / 2;
            }
            res.append(sum);
            p_a--; p_b--;
        }
        if (carry == 1) 
            res.append(carry);
        return res.reverse().toString();
  }
}

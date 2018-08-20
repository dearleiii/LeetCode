// Idea: same as p1+p2 == target, 3Sum problem, but now: p1+p2 > target
// Important trick! 
  // when p1+p2 > target, all p1~ p2-1 are good! -> next check: p2--;
  // else when: p1+p2 <= target, all p1+2~p2 are bad! -> next check: p1++;
  
 // My broken: 
  // 200 / 220 test cases passed. TLExceed 
  // fix small bug: not to println -> 69%
  
 class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        int cnt = 0;
        Arrays.sort(nums);
        
        for (int longest = nums.length-1; longest >=2; longest--) {
            int p1 = 0, p2 = longest-1;
            while (p1 < p2) {
                if (nums[p1] + nums[p2] > nums[longest]) {
                    // all p1+ are good 
                    cnt += (p2-p1);
                    System.out.println(cnt);
                    p2--;
                } else { // <= longest, all p1- are <= 
                    p1++;
                }
                
            }
        }
        return cnt;
    }
}


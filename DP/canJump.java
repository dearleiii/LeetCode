class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >=0; i--) {
            if (i + nums[i] >= lastPos) lastPos = i; //if lastPos is good position: update the Right-most good position
        }
        return lastPos == 0;
    }
}

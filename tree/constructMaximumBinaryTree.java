class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length-1);
    }
    
    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r) return null;
        
        int maxIndex = l;
        for (int i = l+1; i <= r; i++) {
            if (nums[maxIndex] < nums[i] ) maxIndex = i;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
               
        root.left = helper(nums, l, maxIndex-1);
        root.right = helper(nums, maxIndex+1, r);
        
        return root;
    }
}

// structure: check basic case first: root, root.left, root.right 
  // Divide: 
    // Devide to the left & right part 
  // Conquer: 
    // if left / right ==. else: ..

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if (left == 0) return right + 1;
        if (right == 0) return left + 1;
        
        return Math.min(left+1, right+1);
    }
}

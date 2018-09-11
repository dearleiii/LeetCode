// my broken: 
class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        
        int left = largestBSTSubtree(root.left);
        int right = largestBSTSubtree(root.right);
        
        if (root.left != null || root.right != null) {
            // if (root.val <= root.right.val && root.val > root.left.val) return(left + right + 1);
            
        }
        if (root.left != null)  {
            if (left != -1) return left;
            else return -1;
        }
        if (root.right != null) {
            if (right != -1) return right;
            else return -1;
        }
        
        return 1;
    }
}

// Official:


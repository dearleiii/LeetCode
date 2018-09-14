// my 66%

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flattenHelper(root);
    }
    
    private TreeNode flattenHelper(TreeNode root) {
        if (root == null) return null;
        if (root.right == null && root.left == null) return root;
        if (root.left == null) {
            return flattenHelper(root.right);
        } else if (root.right == null) {
            root.right = root.left;
            root.left = null;
            return flattenHelper(root.right);
        }
        
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        
        TreeNode rightLast = flattenHelper(root.right);
        rightLast.right = root.left;
        root.left = null;
        return flattenHelper(rightLast);
    }
}

// jiuzhang: 99%
 helper(root);
    }
    
    // flatten root and return the last node
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);
        
        // connect leftLast to root.right
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        if (rightLast != null) {
            return rightLast;
        }
        
        if (leftLast != null) {
            return leftLast;
        }
        
        return root;
    }

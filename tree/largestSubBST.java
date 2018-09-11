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
    // Since need to keep track of more values: isBST, node number, smallest of subtree, largest of subtree 
    // -> create SuperNode!

class Solution {
    public class SuperNode {
        int ans; 
        int small, large;
        boolean isBST;
        public SuperNode() {
            ans = 0;
            isBST = true;
            small = Integer.MAX_VALUE;
            large = -Integer.MAX_VALUE;
        }
    }
    
    public int largestBSTSubtree(TreeNode root) {
        return dfs(root).ans;
    }
    
    public SuperNode dfs(TreeNode node) {
        if (node == null) return new SuperNode();
        SuperNode now = new SuperNode();
        SuperNode left = dfs(node.left);
        SuperNode right = dfs(node.right);
        
        if (left.small < node.val) now.small = left.small;
        else now.small = node.val;  // not a BST
        
        now.large = Math.max(right.large, node.val);
        if (left.isBST && right.isBST && left.large < node.val && right.small >= node.val) {
            now.ans = left.ans + right.ans + 1;
            now.isBST = true;
        } else {
            now.ans = Math.max(left.ans, right.ans);
            now.isBST = false;
        }
        return now;
    }
}

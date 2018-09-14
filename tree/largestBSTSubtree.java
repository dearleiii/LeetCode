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

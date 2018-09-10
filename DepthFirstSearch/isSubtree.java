// Note! compareTree()

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (s.val == t.val) {
            if(compareTree(s, t)) return true;
        } 
        
        boolean left = isSubtree(s.left, t);
        boolean right = isSubtree(s.right, t);
        
        return left || right;
    }
    
    private boolean compareTree(TreeNode x, TreeNode y) {
        if (x == null && y == null) return true;
        if (x == null || y == null) return false;
        return x.val == y.val && compareTree(x.left, y.left) && compareTree(x.right, y.right);
    }
}

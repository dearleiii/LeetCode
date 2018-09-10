// Official traverse solution ~ 23%
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }
    public boolean equals(TreeNode x, TreeNode y) {
        if (x == null && y == null) return true;
        if (x == null || y == null) return false;
        return x.val == y.val && equals(x.left, y.left) && equals(x.right, y.right);
    }
    public boolean traverse(TreeNode s, TreeNode t) {
        return s!= null && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }
}

// Cobine traverse to 1 function  ~ 27%
public boolean isSubtree(TreeNode s, TreeNode t) {
        return s!= null && (equals(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }
    public boolean equals(TreeNode x, TreeNode y) {
        if (x == null && y == null) return true;
        if (x == null || y == null) return false;
        return x.val == y.val && equals(x.left, y.left) && equals(x.right, y.right);
    }
    
 // My DFS based implement after fixgin compareTree() ~ 98%
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

class Solution {
    private int index, kth;
    
    public int kthSmallest(TreeNode root, int k) {
        index = 0;
        inorder(root, k);
        return kth;
    }
    
    private void inorder(TreeNode root, int k) {
        if (root == null) return;
        
        inorder(root.left, k);
        index++;
        if (index == k) {
            kth = root.val;
        }
        if (index < k) {
            inorder(root.right, k);
        }
    }
}

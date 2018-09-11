// Ofiicial 12%
class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    private int maxFreq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        int dummy = subTreeSum(root);
        return map.keySet().stream().
            filter(n-> map.get(n) == maxFreq).
            mapToInt(n->n).
            toArray();
    }
    
    private int subTreeSum(TreeNode root) {
        if (root == null) return 0;
        int sum = root.val + subTreeSum(root.left) + subTreeSum(root.right);
        map.put(sum, map.getOrDefault(sum, 0)+1);
        maxFreq = maxFreq > map.get(sum) ? maxFreq : map.get(sum);
        return sum;
    }
}

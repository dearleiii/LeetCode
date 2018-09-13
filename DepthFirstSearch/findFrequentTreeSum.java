// Improve performance from 69% -> 76% by combine all helper, no discussing cases 

class Solution {
    Map<Integer, Integer> freq = new HashMap<>();
    int maxFreq = Integer.MIN_VALUE;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        int tot = helper(root);
        List<Integer> maxSum = new ArrayList<>();
        
        for (int sum: freq.keySet()) {
            if (freq.get(sum) == maxFreq) 
                maxSum.add(sum);
        }
        int[] sumArr = new int[maxSum.size()];
        for (int i = 0; i < sumArr.length; i++) 
            sumArr[i] = maxSum.get(i);
        return sumArr;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        /*
        if (root.left == null && root.right == null) {
            freq.put(root.val, freq.getOrDefault(root.val, 0) + 1);
            if (freq.get(root.val) > maxFreq) 
                maxFreq = freq.get(root.val);
            return root.val;
        }*/
        
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        int curr = root.val + leftSum + rightSum;
        freq.put(curr, freq.getOrDefault(curr, 0)+1);
        if (freq.get(curr) > maxFreq) 
            maxFreq = freq.get(curr);
        return curr;
    }
}

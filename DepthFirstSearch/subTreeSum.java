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


// my broken: 
private Map<Integer, Integer> map = new HashMap<>();
    private int maxFreq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        int sum = findTreeSum(root);
        // System.out.println(map);
        List<Integer> result = new ArrayList<>();
        for (Integer key: map.keySet()) {
            if (map.get(key) == maxFreq) result.add(map.get(key));
        }
        System.out.println(result);
        int[] result_arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) 
            result_arr[i] = result.get(i);
        return result_arr;
    }
    
    private int findTreeSum(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            if (map.get(root.val) > maxFreq) maxFreq = map.get(root.val);
            return root.val;   
        }
        
        int left = findTreeSum(root.left);
        int right = findTreeSum(root.right);
        int currSum = left + right + root.val;
        map.put(currSum, map.getOrDefault(currSum, 0)+1);
        if (map.get(currSum) > maxFreq) maxFreq = map.get(root.val);
        return currSum;
    }

// fixed online: 97%
    // Note! no need to have if (root.left == null && root.right == null) case, an extra
s Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    private int maxFreq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        int sum = findTreeSum(root);
        
        List<Integer> result = new ArrayList<>();
        for (Integer key: map.keySet()) {
            if (map.get(key) == maxFreq) result.add(key);
        }

        int[] result_arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) 
            result_arr[i] = result.get(i);
        return result_arr;
    }
    
    private int findTreeSum(TreeNode root) {
        if (root == null) return 0;
        
        int left = findTreeSum(root.left);
        int right = findTreeSum(root.right);
        int currSum = left + right + root.val;
        int count = map.getOrDefault(currSum, 0)+1;
        map.put(currSum, count);
        maxFreq = Math.max(maxFreq, count);
        return currSum;
    }

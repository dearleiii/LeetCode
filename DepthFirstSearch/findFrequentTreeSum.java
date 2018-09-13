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

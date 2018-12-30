class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // need to sort, if sort -> easiler to find the duplicated element  
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) { // 3 index elements are contained 
            list.add(new ArrayList<>(tempList));
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                // if (tempList.contains(nums[i])) continue;  
                // since it's sorted, can check duplicate by : nums[i] == nums[i-1]
                if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue; // used[i-1] visited         
                // used[i] : if current has 
               // if (used[i] || i > 0 && nums[i] == nums[i-1]) continue;
                
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() -1);   // remove the last element in tempList
            }
        }
    }
}

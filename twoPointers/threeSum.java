// My broken: 236 / 313 test cases passed, time limit exceed 

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        
        // assume a <= b <= c
        for (int cIndex = 2; cIndex < nums.length; cIndex++) {
            List<List<Integer>> twoIndex = new ArrayList<>();
            twoIndex = findTwoSum(0, cIndex -1, -nums[cIndex], nums);
            for (List<Integer> item: twoIndex) {
                item.add(nums[cIndex]);
                if (res.contains(item) == false)
                    res.add(item);
            }
            
        }
        
        return res;
    }
    
    private List<List<Integer>> findTwoSum(int front, int back, int target, int[] nums) {
        // how to avoid the duplicate triplets? 
        List<List<Integer>> res = new ArrayList<>();
        int tot;
        while (front < back) {
            tot = nums[front] + nums[back];
            System.out.println("target = " + target + " curr total = " + tot);
            if (tot < target) front++;
            else if (tot == target) {
                List<Integer> found = new ArrayList<>();
                found.add(nums[front]); found.add(nums[back]);
                System.out.println(found);
                if (res.contains(found) == false) res.add(found);
                front++;
            }
            else back--;
        }
        
        return res;
    }
}

// Standard: 67.37% same idea, consice implementation 
// important : use while to 
    // skip equal elements to avoid duplicates in the answer without making a set or smth like that.
public List<List<Integer>> threeSum(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> res = new LinkedList<>(); 
    for (int i = 0; i < num.length-2; i++) {
        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
                    while (lo < hi && num[lo] == num[lo+1]) lo++;
                    while (lo < hi && num[hi] == num[hi-1]) hi--;
                    lo++; hi--;
                } else if (num[lo] + num[hi] < sum) lo++;
                else hi--;
           }
        }
    }
    return res;
}

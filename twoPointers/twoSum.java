// brutal force: O(n^2) method 
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p1=0, p2 = p1;
        int[] output = new int[2];
        for (p1 = 0; p1 < numbers.length; p1++) {
            int remain = target - numbers[p1];
            p2 = p1+1;
            while (p2<numbers.length && numbers[p2] <= remain) {
                if (numbers[p2] == remain) {
                    output[0]=p1+1; output[1]=p2+1;
                }
                p2++;
            }
        }
        
        return output;
    }
}

// O(1) method: 2 pointers front && end

class Solution {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        // System.out.println("current min value = " + minprice + "\n");
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
                // System.out.println("current min value = " + minprice + "\n");
            }
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}


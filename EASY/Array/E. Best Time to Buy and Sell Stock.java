class Solution { -O(n) O(1) - Kadane's Algorithm
    public int maxProfit(int[] prices) {
        int buy=prices[0];
        int res=0;
        for(int i=1;i<prices.length;i++)
        {
            int sell=prices[i];
            int diff=sell-buy;
            if(diff>0)
             res=Math.max(res,diff);
            else buy=sell;
        }
        return res;
    }
}

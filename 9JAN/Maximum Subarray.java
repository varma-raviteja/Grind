//O(N) O(1) Kadane's Algorithm


class Solution {
    public int maxSubArray(int[] nums) {
       int maxsum=0;
       int res=Integer.MIN_VALUE;
       for(int i=0;i<nums.length;i++)
       {
           maxsum=maxsum+nums[i];
           res=Math.max(res,maxsum);
           if(maxsum<0)
           maxsum=0;
           
       }
       return res;

    }
}


// Using Dp

public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
}

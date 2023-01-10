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

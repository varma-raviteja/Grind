public class Solution {
    public int rob(int[] nums) {
        // If we get invalid input, return 0
        if (nums == null || nums.length == 0) return 0;
        
        // Keep track of whether or not we robbed the previous house
        int robbedPrevious = 0;
        int didNotRobPrevious = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            // If we don't rob the current house, take the max of robbing and not robbing the previous house
            int currentNotRobbed = Math.max(robbedPrevious, didNotRobPrevious);
            
            // If we rob the current house, add the current money robbed to what we got from not robbing previous
            int currentIsRobbed = didNotRobPrevious + nums[i];
            
            // Update our values for the next iteration
            didNotRobPrevious = currentNotRobbed;
            robbedPrevious = currentIsRobbed;
        }
        
        // Return the maximum we could have robbed provided we looked at both options
        return Math.max(robbedPrevious, didNotRobPrevious);
    }
}



// Recursion Time - O(n^2) Space - O(n)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return getMaxAmount(nums, nums.length - 1);
    }
    
    
    public int getMaxAmount(int[] nums, int n) {
       if(n < 0) return 0; 
       if(n == 0) return nums[0];
       if(n == 1) return Integer.max(nums[1], nums[0]);
       return Integer.max(nums[n] + getMaxAmount(nums, n-2), getMaxAmount(nums, n-1));
    }
}


// DP - Memoization Time - O(n^2) Space - O(n)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return getMaxAmount(nums, nums.length - 1, dp);
    }
    
    
    public int getMaxAmount(int[] nums, int n, int[] dp) {
       if(n < 0) return 0; 
       if(n == 0) return nums[0];
       if(n == 1) return Integer.max(nums[1], nums[0]);
       if(dp[n] != -1) return dp[n]; 
       dp[n] = Integer.max(nums[n] + getMaxAmount(nums, n-2, dp), getMaxAmount(nums, n-1, dp));
       return dp[n]; 
    }
}

// DP - Top Down Time - O(n) Space - O(n)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return getMaxAmount(nums);
    }
    
    
    public int getMaxAmount(int[] nums) {
       int dp[] = new int[nums.length];
       dp[0] = nums[0];
       dp[1] = Integer.max(nums[1], nums[0]); 
       for(int i = 2; i < nums.length; i++) {
           if(dp[i] > 0) return dp[i]; 
            dp[i] = Integer.max(nums[i] + dp[i-2], dp[i-1]);
       }
       return dp[nums.length-1]; 
    }
}

// Optimised DP 
// Time O(n)
// Space O(1)
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return getMaxAmount(nums);
    }
    
     public int getMaxAmount(int[] nums) { 
        nums[1] = Math.max(nums[1], nums[0]);
        for(int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i] + nums[i-2], nums[i-1]);
           System.out.println(nums[i]); 
        }  
         return nums[nums.length-1]; 
    }
}

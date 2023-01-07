//Input: nums = [4,1,2,1,2]
//Output: 4

public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums) {
            res ^= num;
        }
        return res;
    }
}

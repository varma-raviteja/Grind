// O(N), O(1)

class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        int z=0;
        while(i<nums.length)
        {
            if(nums[i]!=0)
            {
                int temp=nums[i];
                nums[i]=nums[z];
                nums[z]=temp;
                z++;
            }
            i++;
        }
        return;
    }
}

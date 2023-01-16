/*Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]*/
 
// brute force - count all the zeros, ones and two and add into array

// One pass, two -pointer technique


// Every time 0 is encountered we swap it first place and move forward. for 1 we simple move forward and for 2, we swap with the last place and not move forward as the newly swapped element
//could be anything.


class Solution {
    public void sortColors(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int i=0;
        while(i<=high)
        {
            if(nums[i]==0)
            {
              int temp=nums[i];
              nums[i]=nums[low];
              nums[low]=temp;
              low++;
              i++;
              
            }
           else if(nums[i]==2)
            {
              int temp=nums[i];
              nums[i]=nums[high];
              nums[high]=temp;
              high--; 
            }
            else i++;
        }
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int arr[]=new int[k];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=nums[nums.length-k+i];
            //System.out.println(nums.length-k+i);
        }
        int arr2[]=new int[nums.length-k];
         for(int i=0;i<nums.length-k;i++)
        {
            arr2[i]=nums[i];
        }


       for(int i=0;i<k;i++)
       {
           nums[i]=arr[i];
       }
       for(int i=0;i<arr2.length;i++)
       {
           nums[i+k]=arr2[i];
       }

      
    }
}



class Solution {
    
    public static int[] reverse(int[] nums, int low, int high)
    {
        while(low<=high)
        {
            int x=nums[low];
            nums[low]=nums[high];
            nums[high]=x;
            low++;
            high--;
        }
        return nums;
    }
    
    
    public void rotate(int[] nums, int k) {
        int mod=k%nums.length;
        nums=reverse(nums,0,nums.length-1);
        nums=reverse(nums, 0,mod-1);
        System.out.print(Arrays.toString(nums));
        nums=reverse(nums,mod,nums.length-1);
        
    }
}

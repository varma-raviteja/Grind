

class Solution {
    private static List<List<Integer>> superlist;
    public List<List<Integer>> permute(int[] nums) {
        superlist=new ArrayList<List<Integer>>();
        
         ArrayList<Integer> nums_lst = new ArrayList<Integer>();
         for (int num : nums)
             nums_lst.add(num);
        
        permute(nums,0,nums_lst);
        return superlist;
    }
    
    public static void permute(int nums[],int curr,List<Integer> list)
    {
        
       
        if(curr==nums.length)
        {
            superlist.add(new ArrayList<Integer>(list));
        
        }
        
        for(int i=curr;i<nums.length;i++)
        {
            Collections.swap(list,curr,i);
            permute(nums,curr+1,list);
            Collections.swap(list,curr,i);
        }
        return;
    } 
    
}









class Solution {
    public static void swap(int[] nums, int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void computeP(List<List<Integer>> res,int start,int[] nums)
    {
        if(start>=nums.length)
        return;
        if(start==nums.length-1)
        {
           
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<nums.length;i++)
            {
                l.add(nums[i]);
            }
            if(!res.contains(l))
            res.add(l);
        }
        for(int i=0;i<nums.length;i++)
        {
            swap(nums,start,i);
            computeP(res,start+1,nums);
            swap(nums,i,start);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();   
            computeP(res,0,nums);
        return res;
    }
}

class Solution {
    public int findMaxLength(int[] nums) {
        
       HashMap<Integer,Integer> map=new HashMap<>();

       map.put(0,-1);
       int count=0;
       int maxlen=0;

       for(int i=0;i<nums.length;i++)
       {
           if(nums[i]==1)
           count+=1;
           else count+=-1;

           if(map.containsKey(count))
           {
               maxlen=Math.max(maxlen,i-map.get(count));
           }else
           map.put(count,i);
       }
       return maxlen;
    }
   
}

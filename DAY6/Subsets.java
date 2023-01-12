// Backtracking - O(N*2^N) O(N*2^N)

// Do a recursion add the current element and same recursion without adding the current element(remove). Subsets are formed by considering an element 1 or without considering that element.
// there are 2^n subsets (0 or 1) for an array of n elements.


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res =new ArrayList<List<Integer>>();
        generateSubsets(0,res,nums,new ArrayList<>()); // create a new list here
        return res;
    }

    public static void generateSubsets(int curr,List<List<Integer>> res, int[] arr, List<Integer> comp)
    {
        if(curr==arr.length)
        {
            res.add(new ArrayList<>(comp)); // create a new list with a comp everytime you reach end else and empty lists of lists of size 2^n is returned.
            return;
        }
       
        comp.add(arr[curr]);
        generateSubsets(curr+1,res,arr,comp);
        comp.remove(comp.size()-1);
        generateSubsets(curr+1,res,arr,comp);
    }
}


//  Bitmasking - O(N*2^N) O(N*2^N)  // for size 3 , corresponding bits are from 000 to 111 

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res= new ArrayList<>();
        for(int i=(int)Math.pow(2,n);i<(int)Math.pow(2,n+1);i++) //for size 3 start from 2^3 to 2^4
        {
            String x=Integer.toBinaryString(i).substring(1); // the left most element is removed when sunstring is used, so that we get the size 2^n of num.length size
            
            List<Integer> curr=new ArrayList<Integer>();
            for(int j=0;j<n;j++)
            {
                if(x.charAt(j)=='1') // Add for every 1 in the bit string
                {
                    curr.add(nums[j]);
                }
            }
            res.add(curr);

        }
        return res;
    }
}

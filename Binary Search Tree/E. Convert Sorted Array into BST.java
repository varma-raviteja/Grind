// O(N) O(N)

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    
    public static TreeNode helper(int nums[],int low, int high)
    {
        if(low>high)
        return null;
        int mid=low+(high-low)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,low, mid-1);
        root.right=helper(nums,mid+1,high);
        return root;

    }

}

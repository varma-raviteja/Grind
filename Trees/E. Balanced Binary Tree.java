// O(N) O(N)

class Solution 
{
    boolean flag= true;//setting the balanced flag default by true 
    public boolean isBalanced(TreeNode root) 
    {
        if(root == null)//base case for null graph 
           return true;
        height_bal(root);//calculates the height and the balance factor simultaneously for each subtree 
        return flag;//returning the flag 
    }
    public int height_bal(TreeNode root)//Height is calculated on the basis of node
    {//DFS(postorder)
        if(root == null)
            return 0;
        
        int left= height_bal(root.left);//recursively traveling the left subtree
        int right= height_bal(root.right);//recursively traveling the right subtree
        
        int max= Math.max(left, right)+1;//getting the maximum height among left and right subtree and adding 1 for each level of BT
    
        if(Math.abs(left-right) >1)//balanceing the left and right subtree condition 
            flag= false;//not balanced flag
        
        return max;//returning the maximum height for the particular subtree
    }
}

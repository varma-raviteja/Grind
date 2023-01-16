

Intuition
If root is null or if root is x or if root is y then return root
Made a recursion call for both
i) Left subtree
ii)Right subtree

Because we would find LCA in the left or right subtree only.

If the left subtree recursive call gives a null value that means we haven’t found LCA in the left subtree, which means we found LCA on the right subtree. So we will return right.
If the right subtree recursive call gives null value, that means we haven’t found LCA on the right subtree, which means we found LCA on the left subtree. So we will return left .
If both left & right calls give values (not null) that means the root is the LCA.

Complexity
Time complexity:O(N)
Space complexity:O(N)

class Solution 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(root == null)//base case when we reach to the null node 
            return null;//returning back 
        
        if(root == p || root == q)//when we are founding the desired node we are returning it and deleting the current activation record 
            return root;
        
        TreeNode left= lowestCommonAncestor(root.left,p,q);//we are traversing the left subbtree 
        TreeNode right= lowestCommonAncestor(root.right,p,q);//and then the right subtree is trsversed 
        
        if(left != null && right != null)//when we got the lowest commont node from left and rigt subtree 
            return root;
        
        if(left == null && right == null)//when both(left,right) are null we return null as there is no chance of getting our desired node
            return null;
        
        return (left != null)?left: right;//when one of the node is null it returns the node without null in order to compare with the next node 
    }
}

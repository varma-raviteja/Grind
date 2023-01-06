class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
        return null;
    
        invertTree(root.left);
        invertTree(root.right);
        TreeNode x= root.left;
        root.left=root.right;
        root.right=x;
   
        return root;
        
    }

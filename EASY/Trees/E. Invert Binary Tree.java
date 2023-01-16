class Solution { -O(n) O(h)
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
                
                
// Level Order Traversal  - O(n) O(h)
                
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
}

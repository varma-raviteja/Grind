class Solution {
    public int kthSmallest(TreeNode root, int k) {
     if(root==null)
     return Integer.MIN_VALUE;

     Stack<TreeNode> s =new Stack<TreeNode>();
    
     int count=0;

     while(root!=null || !s.isEmpty())
     {
        while(root!=null)
        {
            s.add(root);
            System.out.println(root.val);
            root=root.left;
        }
       
        TreeNode t=s.pop();
        count++;
        if(count==k)
        return t.val;
        //if(root!=null)
        t=t.right;
        root=t;
     }
        return Integer.MIN_VALUE;
 }
}



  // better keep these two variables in a wrapper class
  private static int number = 0;
  private static int count = 0;

  public int kthSmallest(TreeNode root, int k) {
      count = k;
      helper(root);
      return number;
  }
  
  public void helper(TreeNode n) {
      if (n.left != null) helper(n.left);
      count--;
      if (count == 0) {
          number = n.val;
          return;
      }
      if (n.right != null) helper(n.right);
  }

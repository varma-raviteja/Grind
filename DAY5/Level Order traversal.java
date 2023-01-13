/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalres=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();

        if(root==null)
        return finalres;

        q.add(root);

        while(!q.isEmpty())
        {
            
            List<Integer> sublist=new ArrayList<>();

            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode value=q.poll();
                sublist.add(value.val);
                //System.out.println(value.val);

                if(value.left!=null)
                q.add(value.left);
                if(value.right!=null)
                q.add(value.right);

            }

            finalres.add(sublist);

        }

        return finalres;
    }
}




public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res,root,0);
        return res;
    }
    public void dfs(List<List<Integer>> list,TreeNode node,int deep){
        if(node==null)return;
        if(list.size()==deep)
            list.add(new ArrayList<Integer>());
        list.get(deep).add(node.val);
        dfs(list, node.left, deep+1);
        dfs(list, node.right, deep+1);    
    }
}

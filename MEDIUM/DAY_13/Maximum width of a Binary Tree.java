class Solution { // Time limit exceeded
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)
        return 0;
        int len=1;
        q.add(root);
        int level=1;
        int maxi=0;
        while(!q.isEmpty())
        {
            
            int arr[]=new int[level];
            for(int i=0;i<level;i++)
            {
                TreeNode s=q.poll();
                arr[i]=s.val;
                if(s.right!=null)
                q.add(s.right);
                else q.add(new TreeNode(-101));
                if(s.left!=null)
                q.add(s.left);
                else q.add(new TreeNode(-101));
            }
            level=level*2;
            int count=0;
            int start=0;
            int end=-1;
           
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]==-101)
                {
                    count++;
                }
            }
            int i2=0;
            while(i2<arr.length)
            {
                if(arr[i2]!=-101)
                {
                    start=i2;
                    break;
                }
                i2++;
            }
            int i3=arr.length-1;
            while(i3>=0)
            {
                if(arr[i3]!=-101)
                {
                    end=i3;
                    break;
                }
                i3--;
            }
            if(end!=-1 && start!=-1)
            maxi=Math.max(maxi,end-start+1);
            if(count==arr.length)
            break;
            
        }
        return maxi;
    }
}




class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        int max = 0;
        
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        
        queue.offer(new Pair(root, 0));
        
        while(!queue.isEmpty()) {
            
            int levelSize = queue.size();
            int start = 0, end = 0;
            for(int i = 0 ; i < levelSize; i++) {
                Pair<TreeNode, Integer> p = queue.poll();
                TreeNode current = p.getKey();
                Integer idx = p.getValue();
                if( i == 0) start = idx;
                if(i == levelSize - 1) end = idx;
                
                if(current.left != null) {
                    queue.offer(new Pair(current.left, 2*idx + 1));
                }
                
                if(current.right != null)
                    queue.offer(new Pair(current.right, 2*idx + 2));
                
                
            }
            max = Math.max(max, end - start + 1);
            
            
        }
        
        return max;
        
    }
}

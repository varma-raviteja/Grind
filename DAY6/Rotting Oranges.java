class Solution {  // -O(N) O(N)
    public int orangesRotting(int[][] grid) {
        int ones=0;
        Queue<Pair<Integer,Integer>> q=new LinkedList<>();
        int nomin=-1;

        for(int i=0;i<grid.length;i++) // count ones and add inices with 2 into queue
        {
            for(int j=0;j<grid[0].length;j++)  
            {
                if(grid[i][j]==1)
                ones++;
                if(grid[i][j]==2)
                q.add(new Pair(i,j));

            }
        }
        if(ones==0) // when there are no fresh oranges
        return 0;
        int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};  // four directions


       while(!q.isEmpty())
       {
           int size=q.size();
           System.out.println(q);
           for(int i=0;i<size;i++)
           {
              
               Pair<Integer,Integer> point=q.poll();
               for(int j=0;j<4;j++)
               {
                   int r=point.getKey();
                   int c=point.getValue();
                   int nr=r+dir[j][0];
                   int nc=c+dir[j][1];
                   if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==1)
                   {
                       ones--;
                       q.add(new Pair(nr,nc));
                       grid[nr][nc]=2;
                   }
               }
           }
           nomin++;  // iterate for every minute
       }
        if(ones>0)
        return -1;
        return nomin;
    }
}

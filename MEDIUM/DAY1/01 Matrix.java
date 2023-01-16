Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]

https://leetcode.com/problems/01-matrix/solutions/1369741/c-java-python-bfs-dp-solutions-with-picture-clean-concise-o-1-space/?orderBy=most_votes

// BFS O(M*N) O(M*N)- for Queue

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int  res[][]=new int[mat.length][mat[0].length];
        Queue<Pair<Integer,Integer>> q=new LinkedList<>();

        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==0)
                {
                    res[i][j]=0;
                    q.add(new Pair(i,j));
                }
                else res[i][j]=-1;
            }
        }

          int sum[][]=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
          while(!q.isEmpty())
        {
           Pair<Integer,Integer> p=q.poll();
           int x=p.getKey();
           int y=p.getValue();
           for(int i=0;i<4;i++)
           {
               int nr = x + sum[i][0], nc = y + sum[i][1];
               // System.out.println(nr+" "+nc);
                if (nr < 0 || nr == mat.length || nc < 0 || nc == mat[0].length || res[nr][nc]!=-1 ) continue;
              
                res[nr][nc]=res[x][y]+1;
                q.add(new Pair(nr,nc));
           }
          
        }
       
        return res;
    }
}


// Dynamic Programming
class Solution { // 5 ms, faster than 99.66%
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length, INF = m + n; // The distance of cells is up to (M+N)
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 0) continue;
                int top = INF, left = INF;
                if (r - 1 >= 0) top = mat[r - 1][c];
                if (c - 1 >= 0) left = mat[r][c - 1];
                mat[r][c] = Math.min(top, left) + 1;
            }
        }
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (mat[r][c] == 0) continue;
                int bottom = INF, right = INF;
                if (r + 1 < m) bottom = mat[r + 1][c];
                if (c + 1 < n) right = mat[r][c + 1];
                mat[r][c] = Math.min(mat[r][c], Math.min(bottom, right) + 1);
            }
        }
        return mat;
    }
}

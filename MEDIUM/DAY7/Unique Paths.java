
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];

        dp[m-1][n-1]=1;
        for(int i=0;i<=n-2;i++)
        {
            dp[m-1][i]=1;
        }

         for(int i=0;i<=m-2;i++)
        {
            dp[i][n-1]=1;
        }

        for(int i=m-2;i>=0;i--)
        {
            for(int j=n-2;j>=0;j--)
            {
              dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }

     
        return dp[0][0];
    }
}



Recursion
Check out the comments.



// Define: opt(i, j) the number of ways to the point (i, j)
// (0, 0) is the starting point, (m - 1, n - 1) is the finish point
// Recurrence: opt(i, j) = opt(i - 1, j) + opt(i, j - 1)
// Init: opt(0, 0) = 1, opt(0, j) = opt(i, 0) = 1
public int uniquePaths(int m, int n) {
  if (m == 0 || n == 0) {
    throw new IllegalArgumentException("m or n can't be 0");
  }
  return numPaths(m - 1, n - 1);
}

private int numPaths(int i, int j) {
  if (i == 0 || j == 0) { // includes the row 0 and col 0
    return 1;
  }
  return numPaths(i - 1, j) + numPaths(i, j - 1);
}
Time: O(2^{M + N})
Space: O(M + N)

Recurrence Tree for complexity analysis:



DP (Top-down with Memoization)
Use an 2D array mem to do memoization.

public int uniquePaths(int m, int n) {
  if (m == 0 || n == 0) {
    throw new IllegalArgumentException("m or n can't be 0");
  }
  int[][] mem = new int[m][n];
  for (int i = 0; i < m; ++i) { // init
    for (int j = 0; j < n; ++j) {
      mem[i][j] = -1;
    }
  }
  return numPaths(m - 1, n - 1, mem);
}

private int numPaths(int i, int j, int[][] mem) {
  if (i == 0 || j == 0) {
    return 1;
  }
  if (mem[i - 1][j] == -1) mem[i - 1][j] = numPaths(i - 1, j, mem);
  if (mem[i][j - 1] == -1) mem[i][j - 1] = numPaths(i, j - 1, mem);
  return mem[i - 1][j] + mem[i][j - 1];
}
Time: O(MN) where MN is the number of subproblems.
Space: O(MN)



DP (Bottom-up)


public int uniquePaths(int m, int n) {
  if (m == 0 || n == 0) {
    throw new IllegalArgumentException("m or n can't be 0");
  }
  int[][] dp = new int[m][n];
  // init
  for (int i = 0; i < m; ++i) dp[i][0] = 1;
  for (int i = 0; i < n; ++i) dp[0][i] = 1;
  // dp
  for (int i = 1; i < m; ++i) {
    for (int j = 1; j < n; ++j) {
      dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    }
  }
  return dp[m - 1][n - 1];
}
Time: O(MN)
Space: O(MN)

DP (Bottom-up, Linear Space)
Reduce the O(MN) space complexity to O(N) (a row) or O(M) (a column). In terms of a row, we would update dp[j] by its old value plus dp[j - 1].



public int uniquePaths(int m, int n) {
  if (m == 0 || n == 0) {
    throw new IllegalArgumentException("m or n can't be 0");
  }
  int[] dp = new int[n]; // row
  // init
  for (int i = 0; i < n; ++i) dp[i] = 1;
  // dp
  for (int i = 1; i < m; ++i) {
    for (int j = 1; j < n; ++j) {
      dp[j] = dp[j] + dp[j - 1];
    }
  }
  return dp[n - 1];
}

//Input: n = 2
//Output: [0,1,1]
//Explanation:
//0 --> 0
//1 --> 1
//2 --> 10

// count for every bit

class Solution {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = count(i);
        }
        return ans;
    }

    private int count(int x) {
        int count = 0;
        while (x != 0) {
            x &= x - 1; // sets the LSD to 0
            count++;
        }
        return count;
    }
}


// dp

0
1=1+dp[1-offset]
2=1+dp[1-offset]

//0 | 01 |10 11 |100 101 110 111 |1000 - As shown in the pattern after every power of 2 an extra 1 is added so we update offset accordingly

class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];

        ans[0]=0;
        int offset=0;

        for(int i=1;i<=n;i++)
        {
            if((i&i-1)==0)
            offset=i;
            ans[i]=1+ans[i-offset];
        }
        return ans;
    }
}

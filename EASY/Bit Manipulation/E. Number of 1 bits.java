// By doing n&n-1 , LSB vanishes

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
      while(n != 0) {
        count += (n & 1);
        n = n >>> 1;
      }
      return count;
    }
}

// 1 & 1=1, count for evry 1
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        int mask=1;
        int count=0;
        
        for(int i=0;i<32;i++)
        {
            if((n&mask)!=0)
                count++;
    
            mask<<=1;
            
        }
        
        return count;
    }
}

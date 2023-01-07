// Using HashMap -O(N) O(N)

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map =new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int check=0;
        int res=0;
        for(Map.Entry<Character,Integer> hm:map.entrySet())
        {
            if(hm.getValue()%2==1)
            {
                check=1;
            }
            int ans=hm.getValue()/2;
            res+=ans*2;

        }
        return res+check;
    }
}

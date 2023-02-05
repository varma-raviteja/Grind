class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();

        int l=0;
        int max=0;
        int maxf=0;
        for(int r=0;r<s.length();r++)
        {
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            maxf=Math.max(maxf,map.get(s.charAt(r)));
            while(r-l+1 - maxf >k)
            {
                int val=map.get(s.charAt(l));
                val--;
                if(val==0)
                map.remove(s.charAt(l));
                else
                map.put(s.charAt(l),val);
                l++;
            }
            max=Math.max(max,r-l+1);
        }
        return max;
    }
}

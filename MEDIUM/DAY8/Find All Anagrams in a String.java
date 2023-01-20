class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> hp=new HashMap<>();
        HashMap<Character,Integer> hs=new HashMap<>();
        List<Integer> ans=new ArrayList<Integer>();

        if(s.length()<p.length())
        return ans;


        for(int i=0;i<p.length();i++)
        {
            hp.put(p.charAt(i),hp.getOrDefault(p.charAt(i),0)+1);
            hs.put(s.charAt(i),hs.getOrDefault(s.charAt(i),0)+1);
        }

        if(hs.equals(hp))
             ans.add(0);

        for(int i=p.length();i<s.length();i++)
        {
            hs.put(s.charAt(i),hs.getOrDefault(s.charAt(i),0)+1);
            int ret=hs.get(s.charAt(i-p.length()));
            ret--;
            if(ret==0)
            {
                hs.remove(s.charAt(i-p.length()));
            }else 
             hs.put(s.charAt(i-p.length()),ret);

             if(hs.equals(hp))
             ans.add(i-p.length()+1);
        
           
        }

        return ans;
    }
}

// Count Map - O(N) O(1)
public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}

// Hash Map -O(N) O(N)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);       
        }
        
        for(int i=0;i<s.length();i++)
        {   if(!map.containsKey(t.charAt(i)))
                return false;
            int x=map.get(t.charAt(i));
            x--;
            map.put(t.charAt(i),x);
        }
        
        System.out.println(map);
        
        for(Map.Entry<Character,Integer> hm:map.entrySet())
        {
            if(hm.getValue()!=0)
                return false;
        }
        
        return true;
    }
}

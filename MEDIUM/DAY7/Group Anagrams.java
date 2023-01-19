class Solution {  O(NklogK) O(NK)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map =new HashMap<>();
        List<List<String>> res =new ArrayList<>();
        for(String s:strs)
        {
            char sc[]= s.toCharArray();
            Arrays.sort(sc);
            StringBuilder sb =new StringBuilder();
            for(int i=0;i<sc.length;i++)
            {
                sb.append(sc[i]);
            }
            String cs=sb.toString();
            
            if(!map.containsKey(cs))
            {
                map.put(cs,new ArrayList<>());
                
            }
                List<String> l=map.get(cs);
                l.add(s);
                map.put(cs,l);
            
        }


        for(List<String> hm: map.values())
        {
            res.add(hm);
        }

        return res;


    }
}


O(NK) O(NK)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}

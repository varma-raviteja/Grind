// Two Pointer Technique
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int maxlen=0;
        int low=0;
        for(int i=0;i<s.length();i++)
        {
            if(low<i && map.containsKey(s.charAt(i)))
            {
              while(map.containsKey(s.charAt(i)))
              {
                  map.remove(s.charAt(low));
                  low++;
              }

            }
            map.put(s.charAt(i),i);

            maxlen=Math.max(maxlen,i-low+1);

        }


        return maxlen;
    }
}


// Optimal

class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}

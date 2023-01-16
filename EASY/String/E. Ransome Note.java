Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

// Using sort and pointers -O(NlogN) O(1)

class Solution { 
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] r = ransomNote.toCharArray();
        char[] m = magazine.toCharArray();

        Arrays.sort(r);
        Arrays.sort(m);

        int r_pointer = 0;
        int m_pointer = 0;

        while(m_pointer < magazine.length()){
            if(r[r_pointer] == m[m_pointer]) r_pointer++;
            if(r_pointer == r.length) return true;
            m_pointer++;
        }
        return false;
    }
}


// Using Hashtable - O(N) O(N)

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        
        for(int i=0;i<magazine.length();i++)
        {
            map.put(magazine.charAt(i),map.getOrDefault(magazine.charAt(i),0)+1);
        }
        
       
        
        for(int i=0;i<ransomNote.length();i++)
        {
            if(map.containsKey(ransomNote.charAt(i)))
            {
                int c=map.get(ransomNote.charAt(i));
                if(c==0)
                    return false;
                map.put(ransomNote.charAt(i),--c);
            }
            else
            {
                return false;
            }
            
        }
        return true;
    }
}

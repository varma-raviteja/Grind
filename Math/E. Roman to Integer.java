class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int sum=0;
        
        sum+=map.get(s.charAt(0));
        for(int i=1;i<s.length();i++)
        {
            
        if(s.charAt(i)=='V' && s.charAt(i-1)=='I' || s.charAt(i)=='X' && s.charAt(i-1)=='I' )
               {
                    sum=sum+map.get(s.charAt(i))- 2*map.get(s.charAt(i-1));
            continue;
                }
        if(s.charAt(i)=='L' && s.charAt(i-1)=='X' || s.charAt(i)=='C' && s.charAt(i-1)=='X' )
               {
                    sum=sum+map.get(s.charAt(i))- 2*map.get(s.charAt(i-1));
            continue;
                }
        if(s.charAt(i)=='D' && s.charAt(i-1)=='C' || s.charAt(i)=='M' && s.charAt(i-1)=='C' )
               {
                    sum=sum+map.get(s.charAt(i))- 2*map.get(s.charAt(i-1));
            continue;
                }
                
            
            sum+=map.get(s.charAt(i));
            
        }
        
        return sum;
        
    }
}

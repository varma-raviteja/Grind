
// Given two binary strings a and b, return their sum as a binary string. a=11 b =1 ; res= 100

class Solution {

    public String addBinary(String a, String b) {    
        StringBuilder sb = new StringBuilder();
        
        int carry = 0;
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        
        while (p1 >= 0 || p2 >= 0){
            int c1 = p1 >= 0 ? a.charAt(p1) - '0' : 0;
            int c2 = p2 >= 0 ? b.charAt(p2) - '0' : 0;
            
            int digit = carry ^ (c1 ^ c2); // (a XOR b) XOR c
            sb.append(digit);
            
            carry = (c1 & c2) | (carry & c1) | (carry & c2);
            
            p1--;
            p2--;
        }
        
        if (carry == 1){
            sb.append(1);
        }
        
        
        return sb.reverse().toString();
    }
}

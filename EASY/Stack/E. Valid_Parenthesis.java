Using Stack -O(n) O(n)
  
// Add into stack in case on open parthensis, else if stack is not empty and top element of stack pairs the current element, pop them. 

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st =new Stack<Character>();

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='[')  
                st.push(c);
            else if(!st.isEmpty() && c==')' && st.peek()=='(') 
            {
                st.pop();
            }else if(!st.isEmpty() && c==']' && st.peek()=='[') 
            {
                st.pop();
            }
            else if(!st.isEmpty() && c=='}' && st.peek()=='{') 
            {
                st.pop();
            }else
            {
                st.push(c);  // for cases }}}{{{}}}
            }
        }
        
        return st.isEmpty() ? true : false;
    }
}

// O(n) O(1) 

public class Solution {
    public boolean isValid(String s) {
        int length;
    
        do {
            length = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        } while(length != s.length());
    
        return s.length() == 0;
    }
}



class Solution {
public:
    bool isValid(string s) {
        int top = -1;
        for(int i =0;i<s.length();++i){
            if(top<0 || !isMatch(s[top], s[i])){
                ++top;
                s[top] = s[i];
            }else{
                --top;
            }
        }
        return top == -1;
    }
    bool isMatch(char c1, char c2){
        if(c1 == '(' && c2 == ')') return true;
        if(c1 == '[' && c2 == ']') return true;
        if(c1 == '{' && c2 == '}') return true;
        return false;
    }
};



// Will not work when {[]} -O(n) O(1)
class Solution {
    public boolean isValid(String s) {
        int count=0;

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='[')
                count++;
            else if(i>0 && c==')' && s.charAt(i-1)=='(') 
            {
               
                count--;
            }else if(i>0 && c==']' && s.charAt(i-1)=='[') 
            {
               
                count--;
            }
            else if(i>0 && c=='}' && s.charAt(i-1)=='{') 
            {
               
                count--;
            }else
            {
                return false;
            }
        }
        
        return count==0 ? true : false;
    }
}

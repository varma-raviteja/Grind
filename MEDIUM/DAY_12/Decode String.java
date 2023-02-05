class Solution {
    public String decodeString(String s) {
        Stack<Character> st=new Stack<Character>();

        for(int i=0;i<s.length();i++)
        {
            Character x=s.charAt(i);
            if(x!=']')
            {
                st.push(x);
            }
            else
            {
                String str=new String();
                while(st.peek()!='[')
                {
                    str+=st.pop();
                    
                }
                
                st.pop();
                int sum=0;
                int base=1;
                while(!st.isEmpty() && Character.isDigit(st.peek()))
                {
                    sum=sum + (st.pop()-'0')*base;
                    base=10*base;
                }

                while(sum!=0)
                {
                    for(int j=str.length()-1;j>=0;j--)
                    {
                        st.push(str.charAt(j));
                    }
                    sum--;
                }

            }
        }
        char[] result = new char[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        return new String(result);

        
         
    }
}



class Solution {
    public String decodeString(String s) {
        Stack<String> prefixes = new Stack<>();
        Stack<Integer> numbers = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int number = 0;
                while (Character.isDigit(s.charAt(i))) {
                    number = number*10 + (s.charAt(i) - '0');
                    i++;
                }
                numbers.push(number);
                prefixes.push(sb.toString());
                sb.setLength(0);
                // the loop increment i++ skips the next opening bracket
            } else if (c == ']') {
                String inner = sb.toString();
                sb.setLength(0);
                sb.append(prefixes.pop());
                int number = numbers.pop();
                for (int j = 0; j < number; j++) {
                    sb.append(inner);
                }
            } else {// a regular character
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

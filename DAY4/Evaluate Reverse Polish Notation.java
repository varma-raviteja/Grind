class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> s=new Stack<String>();
        int res=0;

        for(int i=0;i<tokens.length;i++)
        {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/"))
            {

            
                    int x= Integer.valueOf(s.pop());
                
                    int y= Integer.valueOf(s.pop());
                

                if(tokens[i].equals("+"))
                {
                    res=x+y;
                    s.push(Integer.toString(res));
                }else if(tokens[i].equals("-"))
                {
                    res=y-x; //check
                    s.push(Integer.toString(res));
                }else if(tokens[i].equals("*"))
                {
                    res=x*y;
                    s.push(Integer.toString(res));
                }else
                {
                    res=y/x; // check
                    s.push(Integer.toString(res));
                }

            }
            else s.push(tokens[i]);
        }

        return Integer.valueOf(s.pop());
    }
}

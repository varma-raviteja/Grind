class Solution {
    public int[] dailyTemperatures(int[] t) {
        int[] ans =new int[t.length];
        Stack<Integer> s=new Stack<Integer>();  // Maintain a monotonic statck with partially decreasing order

        for(int i=0;i<t.length;i++) // iterate through the array
        {
            while(s.size()>0 && t[i]>t[s.peek()]) // if the current element is greater than the top of the stack, pop it. 
            {
                ans[s.peek()] =i-s.pop();  // add the answer by calculating the difference between the popped element and current element an the index of the popped
                                           // element as it violates the decreasing property of the stack.
          
            }
            s.push(i);
        }
        return ans;
    }
}

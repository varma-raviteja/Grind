class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0 || intervals == null)
            return 0;
        Arrays.sort(intervals, (o1,o2)->Integer.compare(o1[1],o2[1]));
        int count=0;

        int start=intervals[0][0];
        int end=intervals[0][1];

        for(int i=1;i<intervals.length;i++)
        {
            
            int start2=intervals[i][0];
            int end2=intervals[i][1];
            
            if(end>start2)
            {
                count++;
            }else 
            {
                end=end2;   
                
            }  
           
        } 
        return count;
    }
}

/*
The solution for this problem involves using a greedy solution. In this
    greedy solution you sort the input by their ending times and only attend meetings where the current start time
    is >= the end time of the previous meeting we attend. In this problem we can do the same thing: 
        - First sort the given input by the 2nd value in each interval
        - Starting at the second interval check for the invalid condition where the current interval's first value
          is < the previous valid interval's second value.
            - If we find an invalid interval then we increase the number of invalid intervals to remove by 1.
            - This requires the program to keep track of the previous valid interval's end time.
        - Return the number of invalid intervals removed
*/

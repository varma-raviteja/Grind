public int[][] merge(int[][] intervals) {
    
    Arrays.sort(intervals, (o1,o2)->Integer.compare(o1[0],o2[0]));          //sort the array on the basis of first interval
    ArrayList<int[]> list = new ArrayList<>();                              //to store the merge intervals
    int start = intervals[0][0];                                            //initialize start and end by the interval of the first row
    int end = intervals[0][1];
    
    for(int i=1;i<intervals.length;i++){                    //initialize i by 1, zeorth index intervals  already stored in start & end
       int s = intervals[i][0];                             //now store the intervals to compare with the previous one
        int e = intervals[i][1];
        
        if(s<=end){                                         //Now compare if the start (s) interval is less than the previous end interval then 
            end=Math.max(end,e);                            //merge them, means update our end by the greater value of the end interval
        }else{                                              //if not means that interval is not overlapping in the current interval               
            list.add(new int[]{start,end});                 //add that previous merged interval into list and update start & end by the current intervals
            start = s;
            end = e;
        }
        
    }
    
    list.add(new int[]{start,end});                         //Don't forget to add the last updated interval
    
    // int[][] res = new int[list.size()][2];               //we have to return the ans int 2D array format, you can do this or can also return directly
    // int i=0;
    // for(int[] ans : list){
    //     res[i] = ans;
    //     i++;
    // }
    
    return list.toArray(new int[list.size()][2]);            //by using toArray in built function BOTH are correct!
}

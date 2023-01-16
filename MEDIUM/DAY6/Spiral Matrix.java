

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        

        List<Integer> res =new ArrayList<>(); 
        
        int top=0;
        int bottom=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;

        int size=matrix.length*matrix[0].length;


        while(res.size()<size)
        {
            for(int i=left;i<=right && res.size()<size;i++) // remember the conditions
            {
                res.add(matrix[top][i]);
            }
            top++;
             for(int i=top;i<=bottom && res.size()<size;i++) // remember the conditions
            {
                res.add(matrix[i][right]);
            }
            right--;
             for(int i=right;i>=left && res.size()<size;i--) // remember the conditions
            {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            for(int i=bottom;i>=top && res.size()<size;i--) // remember the conditions
            {
                res.add(matrix[i][left]);
            }
            left++;
      
        }

        return res;

    }
}

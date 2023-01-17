class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int h=height.length-1;
        int max=0;
        while(l<h)
        {

            max=Math.max(max,Math.min(height[l],height[h])*(h-l));
            //System.out.println(max+" "+l+" "+h+" "+height[l]+" "+height[h]);
            if(height[l]<height[h])
                l++;
            else h--;
        }

        return max;
    }
}

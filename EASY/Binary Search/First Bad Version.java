public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l=0;
        int r=n;
        int res=-1;
        while(l<=r)
        {
            int mid= l+ (r-l)/2;
            if(isBadVersion(mid)==true)
            {
                res=mid;
                r=mid-1;
            }
            if(isBadVersion(mid)==false)
            {
                l=mid+1;
            }
        }
        return res;
    }
}

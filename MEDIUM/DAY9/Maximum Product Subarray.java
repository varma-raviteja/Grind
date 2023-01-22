public class Solution {
  public int maxProduct(int[] A) {
    if (A == null || A.length == 0) {
        return 0;
    }
    int[] f = new int[A.length]; // to store max
    int[] g = new int[A.length];  // to store min
    f[0] = A[0];  // intialise all the three to the first element
    g[0] = A[0];
    int res = A[0];
    for (int i = 1; i < A.length; i++) {
        f[i] = Math.max(Math.max(f[i - 1] * A[i], g[i - 1] * A[i]), A[i]); // store the maximum of current, current multiplied with minimum and maximum of the previous element
        g[i] = Math.min(Math.min(f[i - 1] * A[i], g[i - 1] * A[i]), A[i]); // store the minimum of current, current multiplied with minimum and maximum of the previous element
        res = Math.max(res, f[i]);
    }
    return res;
  }
  
}



 static int maxSubarrayProduct(int arr[], int n)
    {
 
        // max positive product
        // ending at the current position
        int max_ending_here = arr[0];
 
        // min negative product ending
        // at the current position
        int min_ending_here = arr[0];
 
        // Initialize overall max product
        int max_so_far = arr[0];
 
        // /* Traverse through the array.
        // the maximum product subarray ending at an index
        // will be the maximum of the element itself,
        // the product of element and max product ending
        // previously and the min product ending previously.
        // */
        for (int i = 1; i < n; i++) {
            int temp = Math.max(
                Math.max(arr[i], arr[i] * max_ending_here),
                arr[i] * min_ending_here);
            min_ending_here = Math.min(
                Math.min(arr[i], arr[i] * max_ending_here),
                arr[i] * min_ending_here);
            max_ending_here = temp;
            max_so_far
                = Math.max(max_so_far, max_ending_here);
        }
 
        return max_so_far;
    }

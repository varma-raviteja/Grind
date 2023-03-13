class Solution {  //o(logM +logN)
    public boolean searchMatrix(int[][] matrix, int target) {
         
        int row = matrix.length;
        int col = matrix[0].length;

        if (matrix[0][0] > target || matrix[row - 1][col - 1] < target) {
            return false;
        }

        int rowIdx = binarySearchColumn(matrix, target);
        return binarySearchRow(matrix[rowIdx], target);
    }

    public static int binarySearchColumn(int[][] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid][0] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static boolean binarySearchRow(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return arr[left] == target;
    }
    
}

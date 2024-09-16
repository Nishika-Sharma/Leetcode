class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0;
        int j = cols - 1;
        while (i < rows && j >= 0) {
            int mid = matrix[i][j];          
            if (mid == target) {
                return true; 
            } else if (mid > target) {
                j--;
            } else {
                i++; 
            }
        }
        return false; 
    }
}
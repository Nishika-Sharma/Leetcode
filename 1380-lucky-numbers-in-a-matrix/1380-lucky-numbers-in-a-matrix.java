public class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int rowMin = matrix[i][0];
            int colIndex = 0;
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < rowMin) {
                    rowMin = matrix[i][j];
                    colIndex = j;
                }
            }
            boolean isLuckyNumber = true;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][colIndex] > rowMin) {
                    isLuckyNumber = false;
                    break;
                }
            }
            if (isLuckyNumber) {
                res.add(rowMin);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
            {3, 7, 8},
            {9, 11, 13},
            {15, 16, 17}
        };
        List<Integer> luckyNumbers = solution.luckyNumbers(matrix);
        System.out.println(luckyNumbers);
    }
}

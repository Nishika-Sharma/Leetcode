import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums); // Sort the array
        int res = 0; // Result to hold the count of valid triangles
        int n = nums.length; // Length of the array

        // Iterate through each element as the first side of the triangle
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) continue; // Skip if the element is zero
            
            // Iterate through each element as the second side of the triangle
            for (int j = i + 1; j < n - 1; j++) {
                int k = j + 1; // Initialize the third side of the triangle

                // Find the maximum `k` such that nums[i] + nums[j] > nums[k]
                while (k < n && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                
                // The count of valid triangles for a given `i` and `j`
                res += k - j - 1;
            }
        }

        return res; // Return the total count of valid triangles
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {7, 0, 0, 0};
        System.out.println(solution.triangleNumber(nums));  // Expected output: 0
    }
}

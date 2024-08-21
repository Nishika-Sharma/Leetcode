class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double ans = -Double.MAX_VALUE;
        for (int l = 0, r = l + k - 1; l <= nums.length - k; l++) {
            double avg = sum / k;
            ans = Math.max(ans, avg);
            sum -= nums[l];
            r++;
            if (r < nums.length) {
                sum += nums[r];
            }
        }
        return ans;
    }
}
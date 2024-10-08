class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int maxAlt = 0;

        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            maxAlt = Math.max(maxAlt, sum);
        }

        return maxAlt;
    }
}
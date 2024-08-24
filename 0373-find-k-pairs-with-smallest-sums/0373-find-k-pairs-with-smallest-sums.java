class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> ans = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.add(new int[]{nums1[i] + nums2[0], i, 0});
        }
        while (!pq.isEmpty() && k > 0) {
            int[] t = pq.remove();

            int i = t[1];
            int j = t[2];

            List<Integer> ta = new ArrayList<>();
            ta.add(nums1[i]);
            ta.add(nums2[j]);
            ans.add(ta);

            if (j + 1 < nums2.length) {
                pq.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
            k--;
        }
        return ans;
    }
}
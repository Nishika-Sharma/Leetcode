class Solution {
    public int[] arrayRankTransform(int[] a) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int val : a) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int rank = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            map.put(entry.getKey(), rank);
            rank++;
        }
        int[] ans = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            ans[i] = map.get(a[i]);
        }
        return ans;
    }
}
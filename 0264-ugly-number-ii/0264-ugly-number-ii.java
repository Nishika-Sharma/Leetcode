class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> st = new TreeSet<>();
        st.add(1L);
        int cnt = 0;
        long ans = 1;
        while (cnt != n) {
            long ugly = st.pollFirst();
            ans = ugly;
            ++cnt;
            st.add(2 * ugly);
            st.add(3 * ugly);
            st.add(5 * ugly);
        }
        return (int) ans;
    }
}
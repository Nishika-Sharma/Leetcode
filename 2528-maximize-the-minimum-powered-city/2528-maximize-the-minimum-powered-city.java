class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length; 
        long lo = 0, hi = k + Arrays.stream(stations).asLongStream().sum();
        while (lo < hi) {
            long mid = lo + (hi-lo+1)/2, prefix = 0; 
            int kk = k; 
            int[] ss = stations.clone(); 
            boolean ok = true; 
            for (int i = 0; i < n+r; ++i) {
                if (i < n) prefix += ss[i]; 
                if (i >= 2*r+1) prefix -= ss[i-2*r-1]; 
                if (i >= r && prefix < mid) {
                    if (kk < mid - prefix) {
                        ok = false; 
                        break; 
                    }
                    kk -= mid - prefix; 
                    if (i < n) ss[i] += mid - prefix; 
                    prefix = mid; 
                }
            }
            if (ok) lo = mid; 
            else hi = mid - 1; 
        }
        return lo; 
    }
}
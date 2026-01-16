class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] hF = Arrays.copyOf(hFences, hFences.length + 2);
        hF[hFences.length] = 1;
        hF[hFences.length + 1] = m;
        
        int[] vF = Arrays.copyOf(vFences, vFences.length + 2);
        vF[vFences.length] = 1;
        vF[vFences.length + 1] = n;
        Arrays.sort(hF);
        Arrays.sort(vF);
        Set<Integer> st = new HashSet<>();

        for(int i = 0; i < hF.length; i++){
            for(int j = i + 1; j < hF.length; j++){
                st.add(hF[j] - hF[i]);
            }
        }

        int Flen = -1;
        for(int i = 0; i < vF.length; i++){
            for(int j = i + 1; j < vF.length; j++){
                if(st.contains(vF[j] - vF[i]))
                    Flen = Math.max(Flen, vF[j] - vF[i]);
            }
        }
        return Flen == -1 ? -1 : (int) ((long )Flen * Flen % 1000000007);
    }
}
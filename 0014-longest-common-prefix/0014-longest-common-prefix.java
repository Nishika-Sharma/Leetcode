class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (String s : strs) {
                if (i == s.length() || s.charAt(i) != c) {
                    return res.toString();
                }
            }
            res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"flower", "flow", "flight"};
        String result = solution.longestCommonPrefix(strs);
        System.out.println(result);  // Output: "fl"
    }
}

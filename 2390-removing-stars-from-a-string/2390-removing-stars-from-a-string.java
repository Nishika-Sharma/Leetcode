class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char next  = s.charAt(i);

            if(next == '*'){
                st.pop();
            }
            else{
                st.push(next);
            }
        }
    StringBuilder sb = new StringBuilder();
        String result;
        while (!st.isEmpty()) {
                sb.append(st.pop());
            }
        
        return sb.reverse().toString();
    }
}
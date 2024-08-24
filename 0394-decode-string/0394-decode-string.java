class Solution {
    public String decodeString(String s) {

    Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder();

                while(!st.isEmpty() && st.peek() != '[') {
                    temp.insert(0, st.pop());
                }
                st.pop();

                StringBuilder num = new StringBuilder();
                while(!st.isEmpty() && st.peek() >= '0' && st.peek() <= '9') {
                    num.insert(0, st.pop());
                }
                int repeatCount = Integer.parseInt(num.toString());
                String repeatedString = temp.toString().repeat(repeatCount);
                
                for(int j = 0; j < repeatedString.length(); j++) {
                    st.push(repeatedString.charAt(j));
                }
            } else {
                st.push(s.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()) {
            res.insert(0, st.pop());
        }
        return res.toString();
    }
}
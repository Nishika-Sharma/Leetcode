class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int num = 0;
        for(int i = 31; i >= 0; i--){
            int mask = (1<<i);
            if((mask&left) != 0 && (mask&right) != 0 && right - left <= mask){
              num |= mask;  
            }
        }
        return num;
    }
}
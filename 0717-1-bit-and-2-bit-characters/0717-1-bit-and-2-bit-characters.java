class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int count = 0;
        int n = bits.length;
        for(int i=n-2;i>=0 && bits[i]!=0;i--){
            count++;
        }
        return (count%2==0);
    }
}
class Solution {
    public int maxVowels(String s, int k) {
        int start=0;
        int end=0;
        int count=0;
        int maxCount=Integer.MIN_VALUE;
        while(end<s.length()){
            char ch=s.charAt(end);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') count++;
            end++;
            if(count==k)return count;
            if(end-start==k){
               maxCount=Math.max(maxCount,count);
               char ch1=s.charAt(start);  
               if(ch1=='a'||ch1=='e'||ch1=='i'||ch1=='o'||ch1=='u') count--;
               start++;
            }
        }
        return maxCount;
    }
}
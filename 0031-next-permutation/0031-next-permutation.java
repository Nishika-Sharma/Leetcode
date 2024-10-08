class Solution {
    public void nextPermutation(int[] nums) {
        int ind=-1; 
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }
        if(ind==-1)
            rev(nums,0,nums.length-1);
        
        for(int i=nums.length-1;i>ind&&ind!=-1;i--){
            if(nums[i]>nums[ind]){
               int t=nums[i];
               nums[i]=nums[ind];
               nums[ind]=t;
               break;
            }
        }
        if(ind!=-1) rev(nums,ind+1,nums.length-1);
    }
    public int[] rev(int[] a,int s,int e){
        while(s<e){
            int t=a[s];
            a[s]=a[e];
            a[e]=t;
            s++;e--;
        }
        return a;
    }
}
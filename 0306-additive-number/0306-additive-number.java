class Solution {
    boolean backtrack(String s,int n,int ind,int p1,int p2,int c)
    {
        if(ind==n)
        {
            return c>=3;
        }
        int num=0;
        for(int i=ind;i<n;i++)
        {
            num=num*10+s.charAt(i)-'0';
            if(p1==-1 || p2==-1 || p1+p2==num)
            {
                if(backtrack(s,n,i+1,p2,num,c+1))
                {
                    return true;
                }
            }
            if(s.charAt(ind)=='0')
            {
                break;
            }
        }
        return false;
    }
    public boolean isAdditiveNumber(String num) {
        return backtrack(num,num.length(),0,-1,-1,0);
    }
}
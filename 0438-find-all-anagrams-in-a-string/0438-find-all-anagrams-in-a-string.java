class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> l=new ArrayList<>();
        if(p.length()>s.length()) return l;
        int[] a=new int[26];
        int[] b=new int[26];
        help(b,p);
        help(a,s.substring(0,p.length()));
        if(same(a,b)) l.add(0);
        int u=0;
        int w=p.length();
        while(w<s.length()){
            a[s.charAt(u)-'a']--;
            a[s.charAt(w)-'a']++;
            if(same(a,b)) l.add(u+1);
            u++;
            w++;
        }
        return l;
    }
    void help(int[] a,String g){
        for(int i=0;i<g.length();i++){
            a[g.charAt(i)-'a']++;
        }
    }
    boolean same(int[] o,int[] q){
        for(int h=0;h<26;h++){
            if(o[h]!=q[h]) return false;
        }
        return true;
    }
}
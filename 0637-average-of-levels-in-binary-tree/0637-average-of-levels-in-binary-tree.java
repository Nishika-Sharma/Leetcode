class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return res;
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            double level_sum=0;
            for(int i=0;i<n;i++){
                TreeNode r=q.poll();
                if(r.left!=null){
                    q.add(r.left);
                }
                if(r.right!=null){
                    q.add(r.right);
                }
                level_sum+=r.val;
            }
            res.add(level_sum/n);
        }
        return res;
    }
}

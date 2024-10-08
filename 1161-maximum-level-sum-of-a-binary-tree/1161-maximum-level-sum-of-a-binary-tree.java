class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        int maxVal = Integer.MIN_VALUE; 
        int ans = 1; 
        int level = 1; 
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                sum += curr.val;
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            if(sum > maxVal){ 
                maxVal = sum;
                ans = level;
            }
            level++;
        }
        return ans;
    }
}

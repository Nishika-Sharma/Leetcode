class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> subans1 = new ArrayList<>();
        subans1 = ans(root1, subans1);
        ArrayList<Integer> subans2 = new ArrayList<>();
        subans2 = ans(root2, subans2);
        return subans1.equals(subans2);
    }
    ArrayList<Integer> ans(TreeNode root, ArrayList<Integer> subans){
        if(root == null){
            return subans;
        }
        if(root.left == null && root.right == null){
            subans.add(root.val);
        }
        subans = ans(root.left, subans);
        subans = ans(root.right, subans);
        return subans;
    }
}
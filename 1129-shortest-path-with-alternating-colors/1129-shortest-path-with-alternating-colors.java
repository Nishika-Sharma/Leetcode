class Solution {
    public class Node{
        public int n;
        ArrayList<Integer> bct;
        ArrayList<Integer> rct;
        public Node(int n){
            this.n = n;
            bct = new ArrayList<>();
            rct = new ArrayList<>();
        }
    }
    public int[] shortestAlternatingPaths(int n, int[][] re, int[][] be) {
        Map<Integer, Node> m = new HashMap<>() ;
        for(int i = 0;i<n;i++){
            m.put(i,new Node(i));
        }
        for(int [] redEdge: re){
            m.get(redEdge[0]).rct.add(redEdge[1]);
        }
        for(int [] blueEdge: be){
            m.get(blueEdge[0]).bct.add(blueEdge[1]);
        }
        int [] ans = new int[n];
        Arrays.fill(ans,-1);
        boolean[][] vis = new boolean[n][2];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0, -1 });
        ans[0] = 0;
        vis[0][1] = vis[0][0] = true;
        while (!q.isEmpty()) {
            int[] el = q.poll();
            int no_of_Node = el[0], steps = el[1], prevc = el[2];
            for(Integer i: m.get(no_of_Node).rct){
                if(!vis[i][0] && prevc!=0){
                    if(ans[i] == -1) ans[i] = 1 + steps;
                    vis[i][0] = true;
                    q.offer(new int[]{i,1+steps,0});
                }
            }
            for(Integer i: m.get(no_of_Node).bct){
                if(!vis[i][1] && prevc!=1){
                    if(ans[i] == -1) ans[i] = 1 + steps;
                    vis[i][1] = true;
                    q.offer(new int[]{i,1+steps,1});
                }
            }
        }
        return ans;
    }
}
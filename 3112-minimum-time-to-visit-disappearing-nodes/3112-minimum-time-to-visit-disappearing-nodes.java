class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] graph = new List[n];
        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            int dist = edge[2];
            if(dist < disappear[to] && graph[from] == null) graph[from] = new LinkedList<>();
            if(dist < disappear[from] && graph[to] == null) graph[to] = new LinkedList<>();
            if(dist < disappear[to]) graph[from].add(new int[]{to, dist});
            if(dist < disappear[from]) graph[to].add(new int[]{from, dist});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        pq.offer(new int[]{0, 0});
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int distSoFar = curr[1];
            if (dist[node] != -1 && distSoFar > dist[node]) continue;
            if(graph[node] != null) {
                for(int[] neighNode: graph[node]) {
                    int neigh = neighNode[0];
                    int neighDist = neighNode[1];
                    if((dist[neigh] == -1 || distSoFar + neighDist < dist[neigh]) && distSoFar + neighDist < disappear[neigh]) {
                        dist[neigh] = distSoFar + neighDist;
                        pq.offer(new int[]{neigh, dist[neigh]});
                    } } } }    
        return dist;
    } }
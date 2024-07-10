class Solution {
    public boolean isBipartite(int[][] graph) {
        int col[]=new int[graph.length];
        for(int i=0;i<col.length;i++){
            col[i]=-1;
        }
        Queue<Integer> qe=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
           if(col[i]==-1){
               qe.add(i);
               col[i]=1;
               while(!qe.isEmpty()){
                   int curr=qe.poll();
                   int arr[]=graph[curr];
                   for(int j=0;j<arr.length;j++){
                       if(col[graph[curr][j]]==-1){
                         
                           col[graph[curr][j]]=1-col[curr];
                           qe.add(graph[curr][j]);
                       }
                       else if(col[graph[curr][j]]==col[curr]){
                           return false;
                       }
                   }
               }
           }
        }
        return true;
    }
}
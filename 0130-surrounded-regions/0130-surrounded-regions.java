class Solution {
    class Pair{
        int x,y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public void bfs(char[][] board,int[][] visited,Queue<Pair> q){

        int n=board.length;
        int m=board[0].length;
       
        int[][] ne={{0,1},{1,0},{0,-1},{-1,0}};
         while(!q.isEmpty())
         {
            Pair val=q.poll();
            for(int[] te:ne)
            {
                int i=val.x+te[0];
                int j=val.y+te[1];

                if(i>=0 && i<n && j>=0 && j<m && board[i][j]=='O'&& visited[i][j]!=1)
                {
                    q.add(new Pair(i,j));
                board[i][j]='t';
                visited[i][j]=1;
                }
            }
         }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] visited=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(board[i][0]=='O' && visited[i][0]!=1)
            {
                q.add(new Pair(i,0));
                board[i][0]='t';
                visited[i][0]=1;
                
            }
            if(board[i][m-1]=='O' && visited[i][m-1]!=1)
            {
                q.add(new Pair(i,m-1));
                board[i][m-1]='t';
                visited[i][m-1]=1;
                
            }
        }
        for(int i=0;i<m;i++)
        {
            if(board[0][i]=='O' && visited[0][i]!=1)
            {
                q.add(new Pair(0,i));
                board[0][i]='t';
                visited[0][i]=1;
 
            }
            if(board[n-1][i]=='O' && visited[n-1][i]!=1)
            {
                q.add(new Pair(n-1,i));
                board[n-1][i]='t';
                visited[n-1][i]=1;
                 
            }
        }
            bfs(board,visited,q);

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    
                    if(board[i][j]=='t')
                      board[i][j]='O';

                    else if(board[i][j]=='O')
                      board[i][j]='X';
                }
            }
    }
}
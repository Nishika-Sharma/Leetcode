class Solution {
    int[][] g;
    Integer[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        g=obstacleGrid;
        memo=new Integer[g.length][g[0].length];
        return f(0, 0);
    }
    private int f(int i, int j) {
        if(i==g.length || j==g[0].length || g[i][j]==1) return 0;
        if(i==g.length-1 && j==g[0].length-1) return 1;
        if(memo[i][j]!=null) return memo[i][j];
        return memo[i][j]=f(i+1,j)+f(i,j+1);
    }
}
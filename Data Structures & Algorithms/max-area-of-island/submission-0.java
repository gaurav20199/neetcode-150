class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        for(int ridx=0;ridx<grid.length;ridx++) {
            for(int cidx=0;cidx<grid[0].length;cidx++) {
                int val = grid[ridx][cidx];
                if(!visited[ridx][cidx] && val==1) {
                    int res = dfs(ridx,cidx,grid,visited);
                    maxArea = Math.max(maxArea,res);
                }
            }
        }

        return maxArea;
        
    }

    public int dfs(int ridx,int cidx, int[][]grid, boolean [][]visited) {
        if(ridx<0 || cidx<0 || ridx>=grid.length || cidx>=grid[0].length || visited[ridx][cidx] || grid[ridx][cidx]==0)
            return 0;

        int ans = 1;
        visited[ridx][cidx] = true;
        ans+=dfs(ridx-1,cidx,grid,visited);
        ans+=dfs(ridx+1,cidx,grid,visited);
        ans+=dfs(ridx,cidx-1,grid,visited);
        ans+=dfs(ridx,cidx+1,grid,visited);

        return ans;
    }
}

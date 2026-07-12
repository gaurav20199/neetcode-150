class Solution {
    public int numIslands(char[][] grid) {
        int countOfIslands = 0;
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        for(int ridx=0;ridx<grid.length;ridx++) {
            for(int cidx=0;cidx<grid[0].length;cidx++) {
                char ch = grid[ridx][cidx];
                if(!visited[ridx][cidx] && ch=='1') {
                    dfs(ridx,cidx,grid,visited);
                    countOfIslands++;
                }
            }
        }
        return countOfIslands;
    }

    public void dfs(int ridx,int cidx, char[][]grid, boolean [][]visited) {
        if(ridx<0 || cidx<0 || ridx>=grid.length || cidx>=grid[0].length || visited[ridx][cidx] || grid[ridx][cidx]=='0')
            return;

        visited[ridx][cidx] = true;
        dfs(ridx-1,cidx,grid,visited);
        dfs(ridx+1,cidx,grid,visited);
        dfs(ridx,cidx-1,grid,visited);
        dfs(ridx,cidx+1,grid,visited);
    }
}

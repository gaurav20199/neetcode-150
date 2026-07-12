class Solution {
    class Pair {
        int xc;
        int yc;
        Pair(int xc, int yc) {
            this.xc = xc;
            this.yc = yc;
        }
    }

    public int orangesRotting(int[][] grid) {
        int totalFreshOranges = 0;
        Queue<Pair> rottenOranges = new LinkedList<>();
        for(int ridx=0;ridx<grid.length;ridx++) {
            for(int cidx=0;cidx<grid[0].length;cidx++) {
                if(grid[ridx][cidx]==1)
                    totalFreshOranges++;
                else if(grid[ridx][cidx]==2)
                    rottenOranges.add(new Pair(ridx,cidx));
            }
        }
        int [][]directions = {{-1,0},{1,0},{0,-1},{0,1}};
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        int totalTime = 0;
        while(totalFreshOranges>0 && !rottenOranges.isEmpty()) {
            int size = rottenOranges.size();
            for(int count=1;count<=size;count++) {
                Pair removedPair = rottenOranges.remove();
                visited[removedPair.xc][removedPair.yc] = true;
                for(int idx=0;idx<directions.length;idx++) {
                    int currentxc = removedPair.xc+directions[idx][0];
                    int currentyc = removedPair.yc+directions[idx][1];
                    if(isValidCoordinate(grid.length,currentxc) && isValidCoordinate(grid[0].length,currentyc) && !visited[currentxc][currentyc] && grid[currentxc][currentyc]==1) {
                        totalFreshOranges--;
                        grid[currentxc][currentyc] = 2;
                        rottenOranges.add(new Pair(currentxc,currentyc));
                    }
                }
            }
            totalTime++;
        }
        return totalFreshOranges!=0?-1:totalTime;
    }

    private boolean isValidCoordinate(int maxLen, int currentCoordinate) {
        return currentCoordinate>=0 && currentCoordinate<maxLen;
    }
}

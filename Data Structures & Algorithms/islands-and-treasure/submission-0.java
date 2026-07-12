class Solution {
    class Pair {
        int xc;
        int yc;
        int dist;
        public Pair(int xc, int yc, int dist) {
            this.xc = xc;
            this.yc = yc;
            this.dist = dist;
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        for(int ridx=0;ridx<grid.length;ridx++) {
            for(int cidx=0;cidx<grid[0].length;cidx++) {
                if(grid[ridx][cidx]==0)
                    queue.add(new Pair(ridx,cidx,0));
            }
        }
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        while(!queue.isEmpty()) {
            Pair removed = queue.remove();
            int val = grid[removed.xc][removed.yc];
            visited[removed.xc][removed.yc] = true;
            if(val==2147483647) {
                grid[removed.xc][removed.yc] = removed.dist;
            }

            if(removed.xc+1<grid.length && !visited[removed.xc+1][removed.yc] && grid[removed.xc+1][removed.yc]!=-1)
                queue.add(new Pair(removed.xc+1,removed.yc,removed.dist+1));

            if(removed.xc-1>=0 && !visited[removed.xc-1][removed.yc] && grid[removed.xc-1][removed.yc]!=-1)
                queue.add(new Pair(removed.xc-1,removed.yc,removed.dist+1));

            if(removed.yc-1>=0 && !visited[removed.xc][removed.yc-1] &&  grid[removed.xc][removed.yc-1]!=-1)
                queue.add(new Pair(removed.xc,removed.yc-1,removed.dist+1));

            if(removed.yc+1<grid[0].length && !visited[removed.xc][removed.yc+1] && grid[removed.xc][removed.yc+1]!=-1)
                queue.add(new Pair(removed.xc,removed.yc+1,removed.dist+1));             

        }
    }
}

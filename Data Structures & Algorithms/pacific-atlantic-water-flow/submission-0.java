class Solution {
    class Pair {
        int xc;
        int yc;

        public Pair(int xc, int yc) {
            this.xc = xc;
            this.yc = yc;
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<Pair> pacific = new LinkedList<>();
        Queue<Pair> atlantic = new LinkedList<>();
        boolean [][]pacificVisited = new boolean[heights.length][heights[0].length];
        boolean [][]atlanticVisited = new boolean[heights.length][heights[0].length];
        for(int ridx=0;ridx<heights.length;ridx++) {
            for(int cidx=0;cidx<heights[0].length;cidx++) {
                if(cidx==0 || ridx==0) {
                    pacific.add(new Pair(ridx,cidx));
                    pacificVisited[ridx][cidx] = true;
                }
                if(ridx==heights.length-1 || cidx==heights[0].length-1) {
                    atlantic.add(new Pair(ridx,cidx));
                    atlanticVisited[ridx][cidx] = true;    
                }
            }
        }
        
        traverseQueue(pacific,pacificVisited,heights);
        traverseQueue(atlantic,atlanticVisited,heights);
        List<List<Integer>> res = new ArrayList<>();
        for(int ridx=0;ridx<heights.length;ridx++) {
            for(int cidx=0;cidx<heights[0].length;cidx++) {
                if(pacificVisited[ridx][cidx] && atlanticVisited[ridx][cidx])
                    res.add(List.of(ridx,cidx));
            }
        }
        return res;


    }

    private void traverseQueue(Queue<Pair> queue, boolean [][]visited, int [][]heights) {
        int [][]directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()) {
            Pair removedPair = queue.remove();
            for(int idx=0;idx<directions.length;idx++) {
                int newxc = removedPair.xc+directions[idx][0];
                int newyc = removedPair.yc+directions[idx][1];
                if(isValidCell(heights.length,newxc) && isValidCell(heights[0].length,newyc) && !visited[newxc][newyc] && heights[newxc][newyc]>=heights[removedPair.xc][removedPair.yc]) {
                    queue.add(new Pair(newxc,newyc));
                    visited[newxc][newyc] = true;
                }

                
            }
        }
    }

    private boolean isValidCell(int maxLimit, int cellValue) {
        return cellValue>=0 && cellValue<maxLimit;
    }


}

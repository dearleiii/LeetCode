// bfs run time 9%. vs. dfs runtime: 90%

class Coordinate {
    int x, y; 
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    markByBFS(grid, i, j);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    private void markByBFS(char[][] grid, int x, int y) {
        int[] directionX = {0, 1, -1, 0};
        int[] directionY = {1, 0, 0, -1};
        
        Queue<Coordinate> queue = new LinkedList<>();
        
        queue.offer(new Coordinate(x, y));
        grid[x][y] = '0';
        
        while (!queue.isEmpty()) {
            Coordinate coor = queue.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate adj = new Coordinate(
                    coor.x+directionX[i],
                    coor.y+directionY[i]
                );
                if (!inBound(adj, grid)) continue;
                if (grid[adj.x][adj.y] == '1') {
                    grid[adj.x][adj.y] = '0';
                    queue.offer(adj);
                }
            }
        }
    }
    
    private boolean inBound(Coordinate coor, char[][] grid) {
        int n = grid.length; 
        int m = grid[0].length;
        
        return coor.x >= 0 && coor.x < n && coor.y >=0 && coor.y < m; 
    }
}


// Self modification: without constructing object each time, only compute coordinates -> 31%

private void markByBFS(char[][] grid, int currX, int currY) {
        int[] coordinateX = {-1, 0, 0, 1};
        int[] coordinateY = {0, -1, 1, 0};
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(currX, currY));
        grid[currX][currY] = '0';
        
        while (!queue.isEmpty()) {
            Coordinate currPos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int adjX = currPos.x +coordinateX[i];
                int adjY = currPos.y +coordinateY[i];
                if (!inBound(grid, adjX, adjY)) continue;
                if (grid[adjX][adjY] == '1') {
                    grid[adjX][adjY]= '0';
                    queue.offer(new Coordinate(adjX, adjY));
                }
            }
            
            // end of checking at current position -> next while iter.
        }
    }

// dfs version: 
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] - '0' == 1) {
                    grid[i][j] = '0';
                    markBFS(grid, i, j);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    private void markBFS(char[][] grid, int x, int y) {
        int[] xDiff = new int[]{-1, 1, 0, 0};
        int[] yDiff = new int[]{0, 0, -1, 1};
        
        int xCurr, yCurr;
        for (int i = 0; i < 4; i++) {
            xCurr = x + xDiff[i];
            yCurr = y + yDiff[i];
            // System.out.printf("x: %d, y: %d\n", xCurr, yCurr);
            if (inBound(grid, xCurr, yCurr) && grid[xCurr][yCurr] - '0' == 1) {
                grid[xCurr][yCurr] = '0';
                markBFS(grid, xCurr, yCurr);
            }
        }
    }
    
    private boolean inBound(char[][] grid, int xCurr, int yCurr) {
        return xCurr >=0 && yCurr >= 0 && xCurr < grid.length && yCurr < grid[0].length;
    }
}

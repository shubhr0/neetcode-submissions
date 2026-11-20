class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> list = new ArrayList<>();

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        // Pacific Ocean: top row + left column
        for(int i = 0; i < rows; i++) {

            pacific[i][0] = true;
            pacificQueue.offer(new int[]{i, 0});

        }

        for(int j = 0; j < cols; j++) {

            pacific[0][j] = true;
            pacificQueue.offer(new int[]{0, j});

        }

        // Atlantic Ocean: bottom row + right column
        for(int i = 0; i < rows; i++) {

            atlantic[i][cols - 1] = true;
            atlanticQueue.offer(new int[]{i, cols - 1});

        }

        for(int j = 0; j < cols; j++) {

            atlantic[rows - 1][j] = true;
            atlanticQueue.offer(new int[]{rows - 1, j});

        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // BFS for Pacific
        while(!pacificQueue.isEmpty()) {

            int[] point = pacificQueue.poll();

            int row = point[0];
            int col = point[1];

            for(int[] direction : directions) {

                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if(newRow < 0 || newRow >= rows ||
                   newCol < 0 || newCol >= cols) {
                    continue;
                }

                if(pacific[newRow][newCol]) {
                    continue;
                }

                if(heights[newRow][newCol] < heights[row][col]) {
                    continue;
                }

                pacific[newRow][newCol] = true;
                pacificQueue.offer(new int[]{newRow, newCol});
            }
        }

        // BFS for Atlantic
        while(!atlanticQueue.isEmpty()) {

            int[] point = atlanticQueue.poll();

            int row = point[0];
            int col = point[1];

            for(int[] direction : directions) {

                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if(newRow < 0 || newRow >= rows ||
                   newCol < 0 || newCol >= cols) {
                    continue;
                }

                if(atlantic[newRow][newCol]) {
                    continue;
                }

                if(heights[newRow][newCol] < heights[row][col]) {
                    continue;
                }

                atlantic[newRow][newCol] = true;
                atlanticQueue.offer(new int[]{newRow, newCol});
            }
        }

        // Cells that can reach both oceans
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {

                if(pacific[i][j] && atlantic[i][j]) {
                    list.add(Arrays.asList(i, j));
                }
            }
        }

        return list;
    }
}
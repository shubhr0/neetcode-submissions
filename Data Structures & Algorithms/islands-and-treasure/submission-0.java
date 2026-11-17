class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        // Put ALL treasure cells into the queue
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1}    // right
        };

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for (int[] direction : directions) {

                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Outside grid
                if (newRow < 0 || newRow >= grid.length ||
                    newCol < 0 || newCol >= grid[0].length) {
                    continue;
                }

                // Wall
                if (grid[newRow][newCol] == -1) {
                    continue;
                }

                // Already has a distance
                if (grid[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }

                // Distance is current cell + 1
                grid[newRow][newCol] = grid[row][col] + 1;

                queue.offer(new int[]{newRow, newCol});
            }
        }
    }
}
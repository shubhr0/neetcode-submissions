class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        int minute = 0;
        int fresh = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){

                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }

                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while(!queue.isEmpty() && fresh > 0){

            int size = queue.size();

            for(int i = 0; i < size; i++){

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                for(int[] direction : directions){

                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if(newRow < 0 || newRow >= grid.length ||
                       newCol < 0 || newCol >= grid[0].length){
                        continue;
                    }

                    if(grid[newRow][newCol] == 1){

                        queue.offer(new int[]{newRow, newCol});

                        grid[newRow][newCol] = 2;

                        fresh--;
                    }
                }
            }

            minute++;
        }

        if(fresh > 0){
            return -1;
        }

        return minute;
    }
}
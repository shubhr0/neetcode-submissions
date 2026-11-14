class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxcount=0;
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                count=dfs(grid,i,j);
                maxcount = Math.max(maxcount,count);
            }
        }
        return maxcount;
    }

    public int dfs(int[][] grid,int row,int col){
        int area=0;
        if(row<0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return area;
        }
        if(grid[row][col] == 0){
            return area;
        }

        grid[row][col] = 0;
        
        area = 1 + dfs(grid,row-1,col) + dfs(grid,row+1,col) +
        dfs(grid,row,col-1) +  dfs(grid,row,col+1);

        return area;
    }
}

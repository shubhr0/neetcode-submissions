class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] visited = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(backtrack(board,word,i,j,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word,int row,int col,int index,int[][] visited){
        if(index==word.length()){
            return true;
        }

        if(row<0 || row >= board.length || col<0 || col >= board[0].length){
            return false;
        }

        if(visited[row][col] == 1){
            return false;
        }

        if(board[row][col] != word.charAt(index)){
            return false;
        }

        visited[row][col] =1;

        boolean found =
            backtrack(board, word, row - 1, col, index + 1, visited) ||
            backtrack(board, word, row + 1, col, index + 1, visited) ||
            backtrack(board, word, row, col - 1, index + 1, visited) ||
            backtrack(board, word, row, col + 1, index + 1, visited);

        visited[row][col] = 0;

        return found;

    }
}

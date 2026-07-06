class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int s=0;
        int e=m*n-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(target>matrix[(mid/n)][(mid%n)]){
                s=mid+1;
                continue;
            }
            if(target<matrix[(mid/n)][(mid%n)]){
                e=mid-1;
                continue;
            }
            if(target==matrix[(mid/n)][(mid%n)]){
                return true;
            }
            
        }   
        return false;
    }
}

class Solution {
    public int maxArea(int[] heights) {
       int i=0;
       int j=heights.length-1;
       int vol=0;
       while(i<j){
        int vol1=Math.min(heights[i],heights[j])*(j-i);
        vol=Math.max(vol1,vol);
        if(heights[i]<heights[j]){
            i++;
        }
        else{
            j--;
        }
       }
       return vol;
    }
}

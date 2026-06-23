class Solution {
    public boolean isPalindrome(String s) {
        String s1=s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i=0;
        int j=s1.length()-1;
        while(i<=j){
            if(s1.charAt(i)==s1.charAt(j)){
                i++;
                j--;
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}

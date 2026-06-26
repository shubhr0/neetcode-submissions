class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int left=0;
        for(int right1=0;right1<s1.length();right1++){
            freq1[s1.charAt(right1) - 'a']++;
        }
        if(s1.length() > s2.length()){
            return false;
        }
        for(int right=0;right<s2.length();right++){
            freq2[s2.charAt(right) - 'a']++;
            if(right-left+1>s1.length()){
                freq2[s2.charAt(left) - 'a']--;
                left++;
            }
            if(right-left+1==s1.length() && Arrays.equals(freq1,freq2)){
                return true;
            }

        }
        return false;

    }
}

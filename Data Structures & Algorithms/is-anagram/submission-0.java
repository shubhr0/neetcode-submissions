class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> word1=new HashMap<>();
        HashMap<Character,Integer> word2=new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        for(char words:s.toCharArray()){
            word1.put(words,word1.getOrDefault(words,0)+1);
        }
        for(char wordt:t.toCharArray()){
            word2.put(wordt,word2.getOrDefault(wordt,0)+1);
        }
        if(word1.equals(word2)){
            return true;
        }
        return false;
        
          
    }
}

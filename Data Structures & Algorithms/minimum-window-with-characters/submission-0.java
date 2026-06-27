class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length())
            return "";

        HashMap<Character, Integer> need = new HashMap<>();

        // Count frequency of characters in t
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0;
        int formed = 0;
        int required = need.size();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // Add current character to window
            window.put(c, window.getOrDefault(c, 0) + 1);

            // Check if this character is now satisfied
            if (need.containsKey(c)
                    && window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            // Try shrinking while window is valid
            while (formed == required) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar)
                        && window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}
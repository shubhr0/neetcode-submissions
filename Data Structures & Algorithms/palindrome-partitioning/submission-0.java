class Solution {
    List<List<String>> list = new ArrayList<>();
    String s;

    public List<List<String>> partition(String s) {
        this.s = s;

        List<String> current = new ArrayList<>();

        backtrack(current, 0);

        return list;
    }

    public void backtrack(List<String> current, int index) {

        // We have reached the end of the string
        if (index == s.length()) {
            list.add(new ArrayList<>(current));
            return;
        }

        // Try every possible ending position
        for (int end = index; end < s.length(); end++) {

            // Check if s[index...end] is a palindrome
            if (isPalindrome(index, end)) {

                // Choose
                current.add(s.substring(index, end + 1));

                // Explore
                backtrack(current, end + 1);

                // Undo choice
                current.remove(current.size() - 1);
            }
        }
    }

    public boolean isPalindrome(int start, int end) {

        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
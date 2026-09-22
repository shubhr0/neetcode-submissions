class Solution {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder current = new StringBuilder();

        backtrack(current, 0, 0, n);

        return list;
    }

    public void backtrack(StringBuilder current, int open, int close, int n) {

        // We have used all parentheses
        if (current.length() == 2 * n) {
            list.add(current.toString());
            return;
        }

        // We can add an opening parenthesis
        if (open < n) {
            current.append('(');
            backtrack(current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1);
        }

        // We can add a closing parenthesis only if
        // there is an unmatched opening parenthesis
        if (close < open) {
            current.append(')');
            backtrack(current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
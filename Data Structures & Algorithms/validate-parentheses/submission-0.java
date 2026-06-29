class Solution {
    public boolean isValid(String s) {

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // If it's a closing bracket
            if (map.containsKey(ch)) {

                // No matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                // Top doesn't match
                if (stack.peek() != map.get(ch)) {
                    return false;
                }

                // Match found
                stack.pop();
            }
            // It's an opening bracket
            else {
                stack.push(ch);
            }
        }

        // Valid only if no unmatched opening brackets remain
        return stack.isEmpty();
    }
}
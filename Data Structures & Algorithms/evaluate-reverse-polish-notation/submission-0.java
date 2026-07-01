class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {

            // If the token is a number, push it
            if (!tokens[i].equals("+") &&
                !tokens[i].equals("-") &&
                !tokens[i].equals("*") &&
                !tokens[i].equals("/")) {

                stack.push(tokens[i]);
                continue;
            }

            int b = Integer.parseInt(stack.pop());
            int a = Integer.parseInt(stack.pop());

            int val = 0;

            if (tokens[i].equals("+")) {
                val = a + b;
            } else if (tokens[i].equals("-")) {
                val = a - b;
            } else if (tokens[i].equals("*")) {
                val = a * b;
            } else if (tokens[i].equals("/")) {
                val = a / b;
            }

            stack.push(Integer.toString(val));
        }

        return Integer.parseInt(stack.pop());
    }
}
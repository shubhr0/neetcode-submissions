
class Solution {
    public int numUniqueEmails(String[] emails) {

        HashSet<String> set = new HashSet<>();

        for (String email : emails) {

            String[] parts = email.split("@");
            String local = parts[0];
            String domain = parts[1];

            // Ignore everything after '+'
            int plusIndex = local.indexOf('+');
            if (plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }

            // Remove all dots
            local = local.replace(".", "");

            // Store normalized email
            set.add(local + "@" + domain);
        }

        return set.size();
    }
}
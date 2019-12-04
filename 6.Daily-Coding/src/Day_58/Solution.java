package Day_58;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{"testemail@leetcode.com", "testemail1@leetcode.com", "testemail+david@lee.tcode.com"}));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");
            String domain = parts[1];
            String localName = formatLocalName(parts[0]);
            set.add(localName + "@" + domain);
        }

        return set.size();
    }

    private static String formatLocalName(String localName) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < localName.length(); i++) {
            char c = localName.charAt(i);

            if (c == '.') {
                continue;
            }

            if (c == '+') {
                break;
            }

            answer.append(c);
        }

        return answer.toString();
    }
}

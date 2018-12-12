package Day_21;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    static String twoStrings(String s1, String s2) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            if (set.contains(s2.charAt(i))) {
                return "YES";
            }
        }

        return "NO";
    }
}

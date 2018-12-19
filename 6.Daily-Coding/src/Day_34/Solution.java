package Day_34;

public class Solution {
    static int superDigit(String n, int k) {
        String s = n.chars().mapToLong(Character::getNumericValue).sum() * k + "";
        if (s.length() == 1) {
            return Integer.parseInt(s);
        } else {
            return superDigit(s, 1);
        }
    }
}

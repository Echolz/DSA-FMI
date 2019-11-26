package Day_44;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(checkInclusion("hello", "ooolleoooleh"));
        //false

//        System.out.println(checkInclusion("ab", "eidboaoo"));
//        //false
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> chars = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            addToMap(s1.charAt(i), chars);
        }

        for (int i = 0; i < s2.length(); i++) {
            Character currentChar = s2.charAt(i);

            if (chars.containsKey(currentChar)) {
                if (slidingWindow(new HashMap<>(chars), s2.substring(i), s1.length())) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean slidingWindow(Map<Character, Integer> map, String currentWord, int length) {
        for (int i = 0; i < currentWord.length(); i++) {
            if (length == 0) {
                return true;
            }
            Character currentChar = currentWord.charAt(i);
            Integer count = map.get(currentChar);

            if (count == null || count <= 0) {
                return false;
            }

            map.put(currentChar, count - 1);
            length--;
        }

        return length == 0;
    }

    private static void addToMap(char currentChar, Map<Character, Integer> chars) {
        if (!chars.containsKey(currentChar)) {
            chars.put(currentChar, 0);
        }

        chars.put(currentChar, chars.get(currentChar) + 1);
    }
}

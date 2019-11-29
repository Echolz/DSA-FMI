package Day_49;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }

    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> map = new HashMap<>();

        String[] strings = str.split(" ");

        if (strings.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            Character currentChar = pattern.charAt(i);
            String currentWord = strings[i];

            if (!map.containsKey(currentWord) && !charMap.containsKey(currentChar)) {
                map.put(currentWord, currentChar);
                charMap.put(currentChar, currentWord);
                continue;
            }

            if (charMap.containsKey(currentChar) && !map.containsKey(currentWord)) {
                return false;
            }

            if (!charMap.containsKey(currentChar) && map.containsKey(currentWord)) {
                return false;
            }

            String prevWord = charMap.get(currentChar);
            Character prevChar = map.get(currentWord);

            if (!prevWord.equals(currentWord) || !prevChar.equals(currentChar)) {
                return false;
            }
        }
        return true;
    }
}

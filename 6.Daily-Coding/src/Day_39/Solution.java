package Day_39;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }

    public static int countCharacters(String[] words, String chars) {
        Map<Character, Integer> chrs = new HashMap<>();

        for (int i = 0; i < chars.length(); i++) {
            Character currentChar = chars.charAt(i);

            if (!chrs.containsKey(currentChar)) {
                chrs.put(currentChar, 0);
            }

            chrs.put(currentChar, chrs.get(currentChar) + 1);
        }

        int answer = 0;

        for (String word : words) {
            Map<Character, Integer> map = new HashMap<>(chrs);

            boolean flag = true;

            for (int i = 0; i < word.length(); i++) {
                Character currentChar = word.charAt(i);

                if (!map.containsKey(currentChar) || map.get(currentChar) == 0) {
                    flag = false;
                    break;
                }

                map.put(currentChar, map.get(currentChar) - 1);
            }

            if (flag) {
                answer += word.length();
            }
        }

        return answer;
    }
}

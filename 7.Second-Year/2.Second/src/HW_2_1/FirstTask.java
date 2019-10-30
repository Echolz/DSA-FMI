package HW_2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FirstTask {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String n = scanner.readLine();

        String firstWord = scanner.readLine();
        String secondWord = scanner.readLine();

        if (firstWord.length() != secondWord.length()) {
            System.out.println("no");
            return;
        }

        Map<Character, Integer> firstWordChars = createWordLettersMap(firstWord);

        for (int i = 0; i < secondWord.length(); i++) {
            Character currentChar = secondWord.charAt(i);

            if (!firstWordChars.containsKey(currentChar)) {
                System.out.println("no");
                return;
            }

            firstWordChars.put(currentChar, firstWordChars.get(currentChar) - 1);
        }

        for (Character character : firstWordChars.keySet()) {
            if (firstWordChars.get(character) != 0) {
                System.out.println("no");
                return;
            }
        }

        System.out.println("yes");
    }

    private static Map<Character, Integer> createWordLettersMap(String firstWord) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < firstWord.length(); i++) {
            Character currentChar = firstWord.charAt(i);

            if (!map.containsKey(currentChar)) {
                map.put(currentChar, 0);
            }

            map.put(currentChar, map.get(currentChar) + 1);
        }

        return map;
    }
}

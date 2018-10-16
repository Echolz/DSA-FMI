package HW_2_2;

import java.util.*;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> characters = new HashMap<>();

        List<Character> characterList = new ArrayList<>();

        Character currentChar;
        for (int i = 0; i < input.length(); i++) {
            currentChar = input.charAt(i);

            if (!characters.containsKey(currentChar)) {
                characters.put(currentChar, 0);
                characterList.add(currentChar);
            }

            characters.put(currentChar, characters.get(currentChar) + 1);
        }

        int timesLetterRepeats;
        for (Character uniqueLetter : characterList) {
            timesLetterRepeats = characters.get(uniqueLetter);

            if (input.length() - timesLetterRepeats - timesLetterRepeats < -1) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");

    }
}
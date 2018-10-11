package HW_1_3;

import java.io.*;
import java.util.*;

public class ThirdTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstString = scanner.nextLine();

        String secondString = scanner.nextLine();

        Map<Character, Integer> firstWordLetters = new HashMap<>();

        Map<Character, Integer> secondWordLetters = new HashMap<>();

        for (int i = 0; i < firstString.length(); i++) {
            if (!firstWordLetters.containsKey(firstString.charAt(i))) {
                firstWordLetters.put(firstString.charAt(i), 0);
            }

            firstWordLetters.put(firstString.charAt(i), firstWordLetters.get(firstString.charAt(i)) + 1);
        }

        for (int i = 0; i < secondString.length(); i++) {
            if (!secondWordLetters.containsKey(secondString.charAt(i))) {
                secondWordLetters.put(secondString.charAt(i), 0);
            }

            secondWordLetters.put(secondString.charAt(i), secondWordLetters.get(secondString.charAt(i)) + 1);
        }

        List<Character> characterList = new ArrayList<>();

        Set<Character> usedCharacters = new HashSet<>();

        for (int i = 0; i < firstString.length(); i++) {
            Character currentCharacter = firstString.charAt(i);

            if (usedCharacters.contains(currentCharacter)) {
                continue;
            }

            if (!secondWordLetters.containsKey(currentCharacter)) {
                continue;
            }

            int firstWordNumberOfLetter = firstWordLetters.get(currentCharacter);
            int secondWordNumberOfLetter = secondWordLetters.get(currentCharacter);

            int minWordNumberOfLetter = -1;

            if (firstWordNumberOfLetter > secondWordNumberOfLetter) {
                minWordNumberOfLetter = secondWordNumberOfLetter;
            } else {
                minWordNumberOfLetter = firstWordNumberOfLetter;
            }

            for (int j = 0; j < minWordNumberOfLetter; j++) {
                characterList.add(currentCharacter);
            }
            usedCharacters.add(currentCharacter);
        }

        Collections.sort(characterList);

        for (int i = 0; i < characterList.size(); i++) {
            System.out.print(characterList.get(i));
        }

    }
}

package Day_6;

import java.util.*;

public class Solution {
    private static List<Character> letters;
    private static Set<String> decodings;

    public static void main(String[] args) {
        initLetters();
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        solve(input);

        System.out.println(decodings.size());
        for (String decoding : decodings) {
            System.out.println(decoding);
        }
    }

    private static void solve(String input) {
        dfs(input, 0, "");
    }

    private static void dfs(String input, int currentIndex, String currentDecoding) {
        if (currentIndex == input.length()) {
            decodings.add(currentDecoding);
            return;
        }

        int letterIndex = input.charAt(currentIndex) - 49;

        if (letterIndex < 0) {
            return;
        }
        dfs(input, currentIndex + 1, currentDecoding + letters.get(letterIndex));

        if (currentIndex == input.length() - 1) {
            return;
        }

        String numberAsString = input.substring(currentIndex, currentIndex + 2);
        int numberIndex = Integer.parseInt(numberAsString) - 1;

        if (!(numberIndex >= 0 && numberIndex <= 25)) {
            return;
        }

        dfs(input, currentIndex + 2, currentDecoding + letters.get(numberIndex));
    }

    private static void initLetters() {
        decodings = new TreeSet<>();
        letters = new ArrayList<>();
        for (int i = 1; i < 27; i++) {
            letters.add((char) (96 + i));
        }
    }
}

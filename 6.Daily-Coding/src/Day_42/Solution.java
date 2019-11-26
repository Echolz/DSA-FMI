package Day_42;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[] words = {"iekm", "tpnhnbe"};
        String order = "loxbzapnmstkhijfcuqdewyvrg";

        System.out.println(isAlienSorted(words, order));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!compareWords(words[i], words[i + 1], orderMap)) {
                return false;
            }
        }

        return true;
    }

    private static boolean compareWords(String firstWord, String secondWord, Map<Character, Integer> orderMap) {
        if (firstWord.equals(secondWord)) {
            return true;
        }

        for (int i = 0; i < firstWord.length() && i < secondWord.length(); i++) {
            Integer firstWordCharIndex = orderMap.get(firstWord.charAt(i));
            Integer secondWordCharIndex = orderMap.get(secondWord.charAt(i));

            if (firstWordCharIndex.equals(secondWordCharIndex)) {
                continue;
            }

            return firstWordCharIndex < secondWordCharIndex;
        }

        return false;
    }
}

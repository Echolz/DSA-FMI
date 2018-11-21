package Day_9;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String text = "aabacbebebe";
        int distinctLetters = 3;

        binarySearch(distinctLetters, text.length(), text, distinctLetters, null);

    }

    static void binarySearch(int low, int high, String text, int uniqueLetters, String answer) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            ReturnVal ret = canFit(text, mid, uniqueLetters);

            if (ret.canFit) {
                binarySearch(mid + 1, high, text, uniqueLetters, ret.value);
            } else {
                binarySearch(low, mid - 1, text, uniqueLetters, answer);
            }
        } else {
            System.out.println(answer.length());
            System.out.println(answer);
        }
    }

    static ReturnVal canFit(String text, int lenght, int uniqueLetters) {
        Map<Character, Integer> uniqueChars = new HashMap<>();

        int currentLength = 0;


        for (int i = 0; i < text.length(); i++) {
            Character currentLetter = text.charAt(i);
            currentLength++;
            uniqueChars.put(currentLetter, i);

            if (currentLength < lenght) {
                continue;
            }

            if (currentLength == lenght) {
                if (uniqueChars.size() == uniqueLetters) {
                    return new ReturnVal(true, text.substring(i - currentLength + 1, i + 1));
                }
            }

            if (currentLength > lenght) {
                Character lastLetter = text.charAt(i - currentLength + 1);
                currentLength--;


                if (uniqueChars.get(lastLetter) == i - currentLength) {
                    uniqueChars.remove(lastLetter);
                }

                if (currentLength == lenght) {
                    if (uniqueChars.size() == uniqueLetters) {
                        return new ReturnVal(true, text.substring(i - currentLength + 1, i + 1));
                    }
                }
            }
        }

        return new ReturnVal(false, null);
    }
}

class ReturnVal {
    boolean canFit;
    String value;

    public ReturnVal(boolean canFit, String value) {
        this.canFit = canFit;
        this.value = value;
    }
}
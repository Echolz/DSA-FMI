package Day_23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("cdcd"));
    }

    static int sherlockAndAnagrams(String s) {
        int answer = 0;
        List<List<String>> buckets = new ArrayList<>();
        generateBuckets(buckets, s.length());
        StringBuilder sb = new StringBuilder();
        String toString;
        for (int i = 0; i < s.length(); i++) {
            sb.setLength(0);
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                toString = sb.toString();
                int bucketIndex = toString.length();
                buckets.get(bucketIndex).add(toString);
            }
        }

        for (List<String> bucket : buckets) {
            if (bucket.size() == 1 || bucket.size() == 0) {
                continue;
            }

            for (int i = 0; i < bucket.size(); i++) {
                String currentWord = bucket.get(i);
                for (int j = i + 1; j < bucket.size(); j++) {
                    String secondWord = bucket.get(j);
                    if (areAnagrams(currentWord, secondWord)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    private static boolean areAnagrams(String currentWord, String secondWord) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < currentWord.length(); i++) {
            Character c = currentWord.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }

            map.put(c, map.get(c) + 1);
        }

        for (int i = 0; i < currentWord.length(); i++) {
            Character c = secondWord.charAt(i);

            if (!map.containsKey(c)) {
                return false;
            }

            int repetitions = map.get(c) - 1;

            if (repetitions < 0) {
                return false;
            }

            map.put(c, repetitions);
        }


        for (Integer i : map.values()) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    private static void generateBuckets(List<List<String>> buckets, int maxLenght) {
        for (int i = 0; i < maxLenght + 1; i++) {
            buckets.add(new ArrayList<>());
        }
    }

}
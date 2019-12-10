package Day_60;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(sortString("tweet"));
        System.out.println(sortString("assddfffq"));

    }

    private static String sortString(String str) {
        Map<Character, Char> map = new HashMap<>();

        List<Char> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);


            if (!map.containsKey(charAt)) {
                Char toBeAdded = new Char(charAt);
                map.put(charAt, toBeAdded);
                list.add(toBeAdded);
            }

            Char currentChar = map.get(charAt);
            currentChar.timesSeen += 1;
        }

        Collections.sort(list);

        StringBuilder output = new StringBuilder();
        for (Char aChar : list) {
            for (int i = 0; i < aChar.timesSeen; i++) {
                output.append(aChar.c);
            }
        }

        return output.toString();
    }


}

class Char implements Comparable<Char> {
    Character c;
    int timesSeen;

    public Char(Character c) {
        this.c = c;
    }

    @Override
    public int compareTo(Char aChar) {
        return Integer.compare(aChar.timesSeen, this.timesSeen);
    }
}

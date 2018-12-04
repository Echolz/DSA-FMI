package HW_8_2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> peopleInTeam = new HashSet<>();

        int firstPlayer = scanner.nextInt();

        peopleInTeam.add(firstPlayer);

        int n = scanner.nextInt();

        int answer = 1;

        for (int i = 0; i < n; i++) {
            int bestFriend = scanner.nextInt();
            int player = scanner.nextInt();

            if (peopleInTeam.contains(bestFriend)) {
                peopleInTeam.add(player);
            }
        }

        System.out.println(peopleInTeam.size());
    }
}

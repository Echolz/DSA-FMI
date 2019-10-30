package HW_2_2;

import java.util.*;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int blasterPower = scanner.nextInt();

        List<Integer> monsters = new ArrayList<>();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int currentMonster = scanner.nextInt();
            if (set.contains(currentMonster)) {
                continue;
            }

            monsters.add(currentMonster);
            set.add(currentMonster);
        }

        Collections.sort(monsters, (x1, x2) -> Integer.compare(x2, x1));

        int blasts = 0;


        for (Integer monster : monsters) {
            if (monster - (blasts * blasterPower) <= 0) {
                break;
            }

            blasts++;
        }

        System.out.println(blasts);
    }
}

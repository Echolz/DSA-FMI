package HW_1_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> walls = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            walls.add(scanner.nextInt());
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int smallerWall = Math.min(walls.get(i), walls.get(j));
                int width = j - i;
                int currentArea = smallerWall * width;
                if (maxArea <  currentArea) {
                    maxArea = currentArea;
                }
            }
        }

        System.out.println(maxArea);
    }
}

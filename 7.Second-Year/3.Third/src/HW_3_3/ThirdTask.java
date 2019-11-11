package HW_3_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Long daysCount = scanner.nextLong();
        Long balloonsLeft = scanner.nextLong();

        List<Long> balloons = new ArrayList<>();
        List<Long> candies = new ArrayList<>();

        for (int i = 0; i < daysCount; i++) {
            balloons.add(scanner.nextLong());
        }

        for (int i = 0; i < daysCount; i++) {
            candies.add(scanner.nextLong());
        }

        List<Day> days = new ArrayList<>();

        Long minBound = 0L;
        Long maxBound = 0L;

        for (int i = 0; i < daysCount; i++) {
            Day currentDay = new Day(balloons.get(i), candies.get(i));
            days.add(currentDay);

            if (currentDay.toMin > maxBound) {
                maxBound = currentDay.toMin;
            }
        }

        System.out.println(search(days, minBound, maxBound, balloonsLeft));
    }

    private static Long search(List<Day> days, Long minBound, Long maxBound, Long balloonsLeft) {
        while (minBound <= maxBound) {
            Long mid = minBound + (maxBound - minBound) / 2;
            if (validate(days, mid, balloonsLeft)) {
                maxBound = mid - 1;
                continue;
            }
            minBound = mid + 1;
        }

        return minBound;
    }

    private static boolean validate(List<Day> days, Long currentBaloons, Long balloonsLeft) {
        for (Day day : days) {
            if (day.toMin <= currentBaloons) {
                continue;
            }

            balloonsLeft -= (day.toMin - currentBaloons + day.candies - 1) / day.candies;
            if (balloonsLeft < 0) return false;
        }

        return true;
    }
}

class Day {
    Long baloons;
    Long candies;
    Long toMin;

    public Day(Long baloons, Long candies) {
        this.baloons = baloons;
        this.candies = candies;

        this.toMin = baloons * candies;
    }
}

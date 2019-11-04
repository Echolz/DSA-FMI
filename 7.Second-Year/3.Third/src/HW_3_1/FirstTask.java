package HW_3_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FirstTask {
    static List<Integer> answers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Long> berries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            berries.add(scanner.nextLong());
        }

        long m = scanner.nextLong();

        List<Long> sweetBerries = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            sweetBerries.add(scanner.nextLong());
        }

        List<Bucket> buckets = new ArrayList<>();

        for (int i = 0; i < berries.size(); i++) {
            if (buckets.size() == 0) {
                buckets.add(new Bucket(1, berries.get(i)));
                continue;
            }

            long lastBucketUpper = buckets.get(i - 1).upper;

            buckets.add(new Bucket(lastBucketUpper + 1, lastBucketUpper + berries.get(i)));
        }

        for (Long sweetBerry : sweetBerries) {
            System.out.println(findBerry(sweetBerry, buckets, 0, buckets.size() - 1));
        }
    }

    private static int findBerry(Long sweetBerry, List<Bucket> buckets, int left, int right) {
        if (left <= right) {
            int middle = left + (right - left) / 2;

            Bucket currentBucket = buckets.get(middle);

            if (currentBucket.lower <= sweetBerry && sweetBerry <= currentBucket.upper) {
                return middle + 1;
            }

            if (currentBucket.lower > sweetBerry) {
                return findBerry(sweetBerry, buckets, left, middle - 1);
            }

            return findBerry(sweetBerry, buckets, middle + 1, right);

        }
        return 0;
    }
}

class Bucket {
    long lower;
    long upper;

    public Bucket(long lower, long upper) {
        this.lower = lower;
        this.upper = upper;
    }

    @Override
    public String toString() {
        return "From: " + lower + " To: " + upper;
    }
}
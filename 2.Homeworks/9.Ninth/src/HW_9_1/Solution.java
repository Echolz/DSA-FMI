package HW_9_1;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map map = new Map();

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            map.insert(scanner.nextLong());
        }

        System.out.println(map.getSize());
    }
}

class Map {
    private int size;

    private List<Set<Long>> array = new ArrayList<>();

    public Map() {
        size = 0;
        initArray();
    }

    private void initArray() {
        for (int i = 0; i < 200002; i++) {
            array.add(new TreeSet<>());
        }
    }

    public void insert(Long value) {
        int bucketIndex = Math.abs(value.hashCode() % 200000);
        Set<Long> bucket = array.get(bucketIndex);
        if (bucket.add(value)) {
            size++;
        }
    }

    public int getSize() {
        return size;
    }
}
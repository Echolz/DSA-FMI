package HW_3_4;

import java.util.*;

public class FourthTask1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> buildings = new ArrayList<>();
        List<Integer> costs = new ArrayList<>();

        Map<Integer, Long> heightToCost = new HashMap<>();
        List<Integer> heights = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            buildings.add(scanner.nextInt());
        }

        for (int i = 0; i < n; i++) {
            costs.add(scanner.nextInt());
        }

        for (int i = 0; i < n; i++) {
            int currentBuildingHeight = buildings.get(i);
            if (!heightToCost.containsKey(currentBuildingHeight)) {
                heightToCost.put(currentBuildingHeight, 0L);
                heights.add(currentBuildingHeight);
            }

            heightToCost.put(currentBuildingHeight, heightToCost.get(currentBuildingHeight) + costs.get(i));
        }

        long minSum = Long.MAX_VALUE;


        long currentSum;
        for (Integer buildingHeight : heights) {

            currentSum = 0;
            for (Integer restBuildingHeight : heights) {
                if (buildingHeight.compareTo(restBuildingHeight) == 0) {
                    continue;
                }
                currentSum += Math.abs(buildingHeight - restBuildingHeight) * heightToCost.get(restBuildingHeight);
            }

            if (currentSum < minSum) {
                minSum = currentSum;
            }
        }

        System.out.println(minSum);
    }
}

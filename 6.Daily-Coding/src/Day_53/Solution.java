package Day_53;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(generate(5).toString());
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i < numRows + 1; i++) {
            List<Integer> currentList;
            if (i == 1) {
                currentList = new ArrayList<>();
                currentList.add(1);
                list.add(currentList);
                continue;
            }

            if (i == 2) {
                currentList = new ArrayList<>();
                currentList.add(1);
                currentList.add(1);
                list.add(currentList);
                continue;
            }

            currentList = createList(list.get(i - 2), i);
            list.add(currentList);
        }

        return list;
    }

    private static List<Integer> createList(List<Integer> previousList, int n) {
        List<Integer> currentList = new ArrayList<>();
        currentList.add(1);

        int j = 0;

        for (int i = 1; i < n - 1; i++) {
            int num1 = previousList.get(j);
            int num2 = previousList.get(j + 1);
            currentList.add(num1 + num2);
            j++;
        }

        currentList.add(1);

        return currentList;
    }
}

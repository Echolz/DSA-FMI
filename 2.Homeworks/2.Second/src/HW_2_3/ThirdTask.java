package HW_2_3;

import utils.GenericSorter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> toysList = new ArrayList<>();
        GenericSorter<Integer> genericSorter = new GenericSorter<>();

        for (int i = 0; i < n; i++) {
            toysList.add(scanner.nextInt());
        }

        genericSorter.mergeSort(toysList, 0, toysList.size() - 1);

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (k - toysList.get(i) < 0) {
                break;
            }

            k -= toysList.get(i);
            answer ++;
        }

        System.out.println(answer);
    }
}



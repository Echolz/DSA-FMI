package HW_2_4;

import utils.InversionsCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FourthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();
        int q;
        int n;
        long currentInversions;
        List<Integer> integerList = new ArrayList<>();
        InversionsCounter<Integer> inversionsCounter = new InversionsCounter<>();


        q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            integerList.clear();
            n = scanner.nextInt();

            for (int j = 0; j < n; j++) {
                integerList.add(scanner.nextInt());
            }

            currentInversions = inversionsCounter.mergeSort(integerList, 0, integerList.size() - 1);

            answer.append(currentInversions).append("\n");
        }

        System.out.println(answer.toString());

    }
}

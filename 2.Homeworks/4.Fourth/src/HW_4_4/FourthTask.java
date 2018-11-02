package HW_4_4;

import java.util.LinkedList;
import java.util.Scanner;

public class FourthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        String[] inputArr;

        scanner.nextLine();

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            inputArr = scanner.nextLine().split(" ");

            if (inputArr[0].equals("add")) {
                linkedList.add(Integer.parseInt(inputArr[1]));
                continue;
            }

            if (inputArr[0].equals("gun")) {
                linkedList.pollLast();
            }

            if (inputArr[0].equals("milen")) {
                for (int j = 0; j < linkedList.size() / 2; j++) {
                    linkedList.add(linkedList.poll());
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(linkedList.size()).append("\n");

        for (Integer integer : linkedList) {
            sb.append(integer).append(" ");
        }

        sb.setLength(sb.length() - 1);

        System.out.println(sb.toString());
    }
}

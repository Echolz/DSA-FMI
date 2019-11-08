package HW_4_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class FifthTask {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            solve();
        }
    }

    private static void solve() {
        List<Integer> list = readInput();

        Stack<Integer> st = new Stack<>();

        int truckSeq = 1;

        for (int i = 0; i < list.size(); i++) {
            int currentTruck = list.get(i);

            //if the truck is in the right place, skip
            if (truckSeq == currentTruck) {
                truckSeq++;
                continue;
            }

            //if the truck is not in the right place and the stack is empty
            if (st.isEmpty()) {
                st.push(currentTruck);
                continue;
            }

            //if the truck is not in the right place and the stack is not empty
            while (!st.isEmpty() && st.peek() == truckSeq) {
                st.pop();
                truckSeq++;
            }

            if (truckSeq == currentTruck) {
                truckSeq++;
                continue;
            }

            st.push(currentTruck);
        }

        while (!st.isEmpty() && st.peek() == truckSeq) {
            st.pop();
            truckSeq++;
        }

        if (!st.isEmpty()) {
            System.out.println("no");
        } else {
            System.out.println("yes");
        }
    }

    private static List<Integer> readInput() {
        int q = scanner.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            list.add(scanner.nextInt());
        }

        return list;
    }
}

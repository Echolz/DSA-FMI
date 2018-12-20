package Day_36;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> sequences = initSeq(n);
        List<Integer> answers = new ArrayList<>();
        int lastAnswer = 0;

        for (List<Integer> query : queries) {
            int q = query.get(0);
            int x = query.get(1);
            int y = query.get(2);

            int seqN = (x ^ lastAnswer) % n;
            List<Integer> sequence = sequences.get(seqN);
            if (q == 1) {
                sequence.add(y);
                continue;
            }

            lastAnswer = sequence.get(y % sequence.size());
            answers.add(lastAnswer);
        }

        return answers;
    }

    private static List<List<Integer>> initSeq(int n) {
        List<List<Integer>> seq = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            seq.add(new ArrayList<>());
        }

        return seq;
    }
}

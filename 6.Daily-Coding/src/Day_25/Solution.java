package Day_25;

import java.util.*;

public class Solution {
    static List<Integer> freqQuery(List<int[]> queries) {
        Map<Integer, Integer> numberToFreq = new HashMap<>();
        Map<Integer, Set<Integer>> freqToNumbers = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for (int[] query : queries) {
            int command = query[0];
            int number = query[1];

            if (command == 1) {
                if (!numberToFreq.containsKey(number)) {
                    numberToFreq.put(number, 0);

                }
                int prevQur = numberToFreq.get(number);
                numberToFreq.put(number, prevQur + 1);

                if (!freqToNumbers.containsKey(prevQur)) {
                    freqToNumbers.put(prevQur, new HashSet<>());
                }

                freqToNumbers.get(prevQur).remove(number);

                if (!freqToNumbers.containsKey(prevQur + 1)) {
                    freqToNumbers.put(prevQur + 1, new HashSet<>());
                }

                freqToNumbers.get(prevQur + 1).add(number);
            }

            if (command == 2) {
                if (!numberToFreq.containsKey(number)) {
                    continue;

                }
                int currentQur = numberToFreq.get(number);

                //the number should be removed
                freqToNumbers.get(currentQur).remove(number);
                if (currentQur - 1 == 0) {
                    numberToFreq.remove(number);
                    continue;
                }

                numberToFreq.put(number, currentQur - 1);

                if (!freqToNumbers.containsKey(currentQur - 1)) {
                    freqToNumbers.put(currentQur - 1, new HashSet<>());
                }

                freqToNumbers.get(currentQur - 1).add(number);

            }

            if (command == 3) {
                if (freqToNumbers.containsKey(number) && freqToNumbers.get(number).size() != 0) {
                    answer.add(1);
                    continue;
                }

                answer.add(0);
            }
        }
        return answer;
    }
}

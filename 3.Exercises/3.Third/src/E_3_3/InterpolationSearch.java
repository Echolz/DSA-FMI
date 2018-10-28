package E_3_3;

import java.util.ArrayList;
import java.util.List;

public class InterpolationSearch {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            numbers.add(i);
        }

        System.out.println(interpolationSearch(numbers, 20));
    }

    static int interpolationSearch(List<Integer> numbers, int number) {
        int lo = 0;
        int hi = (numbers.size() - 1);

        while (lo <= hi && number >= numbers.get(lo) && number <= numbers.get(hi)) {
            int pos = lo + (((hi - lo) / (numbers.get(hi) - numbers.get(lo)) * (number - numbers.get(lo))));


            if (numbers.get(pos) == number) {
                return pos;
            }

            if (numbers.get(pos) < number) {
                lo = pos + 1;
            } else {
                hi = pos - 1;
            }
        }
        return -1;
    }

}

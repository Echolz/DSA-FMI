package Day_87;

import java.util.PriorityQueue;

public class Solution {


  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> queue = new PriorityQueue<>((integer, t1) -> Integer.compare(t1, integer));

    for (int stone : stones) {
      queue.add(stone);
    }

    int newStone;
    while (queue.size() > 1) {
      newStone = Math.abs(queue.poll() - queue.poll());

      if (newStone == 0) {
        continue;
      }

      queue.add(newStone);
    }

    if (queue.size() == 0) {
      return 0;
    }

    return queue.poll();
  }
}

import java.util.PriorityQueue;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        Queue<Integer> priorQueu = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1, o2)));

        priorQueu.add(1);
        priorQueu.add(2);

        System.out.println(priorQueu.poll());
    }
}



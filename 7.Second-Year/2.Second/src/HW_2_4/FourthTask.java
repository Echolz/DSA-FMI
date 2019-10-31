package HW_2_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FourthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Event> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            events.add(new Event(scanner.nextInt(), scanner.nextInt()));
        }

        Collections.sort(events);

        int ended = 0;
        int answer = 0;

        for (Event e : events) {
            if (e.start >= ended) {
                answer ++;
                ended = e.start + e.duration;
            }
        }

        System.out.println(answer);
    }
}

class Event implements Comparable<Event> {
    int start;
    int duration;

    public Event(int start, int duration) {
        this.start = start;
        this.duration = duration;
    }

    @Override
    public int compareTo(Event event) {
        return Integer.compare(start + duration, event.start + event.duration);
    }
}

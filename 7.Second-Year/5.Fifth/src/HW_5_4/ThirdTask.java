package HW_5_4;

import java.util.*;

public class ThirdTask {
    static Map<Integer, Queue<Student>> groupToStudents = new HashMap<>();
    static Queue<Integer> groups = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = scanner.nextInt();
        int groupNumber = scanner.nextInt();

        for (int i = 0; i < students; i++) {
            String studentName = scanner.next();
            int studentGroup = scanner.nextInt();

            Student currentStudent = new Student(studentName, i, studentGroup);
            //addStudents
            addStudent(currentStudent);

            if (i % 2 == 0 && i != 0) {
                outputStudent(i);
            }
        }

        printLeftStudents(students);
    }

    private static void printLeftStudents(int k) {
        k = k - 1;
        if (k % 2 == 1) {
            k++;
        } else {
            k += 2;
        }

        while (!groups.isEmpty()) {
            outputStudent(k);
            k += 2;
        }
    }

    private static void outputStudent(int k) {
        Queue<Student> studentsForCurrentGroup = groupToStudents.get(groups.peek());

        studentsForCurrentGroup.poll().print(k);

        //if it is the last student from the current group
        if (studentsForCurrentGroup.isEmpty()) {
            groupToStudents.remove(groups.poll());
        }
    }

    private static void addStudent(Student currentStudent) {
        if (groups.isEmpty() || !groupToStudents.containsKey(currentStudent.group)) {
            Queue<Student> queue = new LinkedList<>();
            queue.add(currentStudent);
            groupToStudents.put(currentStudent.group, queue);
            groups.add(currentStudent.group);
            return;
        }

        Queue<Student> queue = groupToStudents.get(currentStudent.group);
        queue.add(currentStudent);
    }
}

class Student {
    String name;
    int time;
    int group;

    public Student(String name, int time, int group) {
        this.name = name;
        this.time = time;
        this.group = group;
    }

    public void print(int k) {
        System.out.println(name + " " + time + " " + k);
    }
}

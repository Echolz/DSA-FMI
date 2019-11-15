package HW_5_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue queue = new Queue();

        int numberOfStudents = scanner.nextInt();
        int numberOfGroups = scanner.nextInt();

        for (int i = 0; i < numberOfStudents; i++) {
            String studentName = scanner.next();
            int studentGroup = scanner.nextInt();

            Student currentStudent = new Student(studentName, studentGroup, i);
            queue.add(currentStudent);

            if (i % 2 == 0 && i != 0) {
                System.out.println(queue.pop() + " " + i);
            }
        }

        int k = numberOfStudents - 1;
        if (k % 2 == 1) {
            k++;
        } else {
            k += 2;
        }
        queue.print(k);
    }
}

class Student {
    String name;
    int group;
    int time;

    Student nextStudentFriend;
    Student nextStudentInLine;

    public Student(String name, int group, int time) {
        this.name = name;
        this.group = group;
        this.time = time;
    }

    @Override
    public String toString() {
        return name + " " + time;
    }
}

class Queue {
    Map<Integer, Student> groupToLastStudent;
    Student currentStudent;
    Student lastStudent;

    public Queue() {
        this.groupToLastStudent = new HashMap<>();
    }

    Student pop() {
        Student answer = currentStudent;

        if (currentStudent.nextStudentFriend != null) {
            currentStudent = currentStudent.nextStudentFriend;
            currentStudent.nextStudentInLine = answer.nextStudentInLine;
            return answer;
        }

        //current student has no more friends in line
        currentStudent = currentStudent.nextStudentInLine;
        groupToLastStudent.remove(answer.group);
        return answer;
    }

    void add(Student student) {
        //this is the first student
        if (groupToLastStudent.isEmpty()) {
            groupToLastStudent.put(student.group, student);
            currentStudent = student;
            lastStudent = student;
            return;
        }


        //the student has no friends in line
        if (!groupToLastStudent.containsKey(student.group)) {
            lastStudent.nextStudentInLine = student;
            lastStudent = lastStudent.nextStudentInLine;
            groupToLastStudent.put(student.group, student);
            return;
        }

        Student studentFriend = groupToLastStudent.get(student.group);
        studentFriend.nextStudentFriend = student;
        groupToLastStudent.put(student.group, student);
    }

    void print(int k) {
        Student sst = currentStudent;
        Student st;

        while (sst != null) {
            System.out.println(sst.toString() + " " + k);
            k += 2;
            st = sst;
            while (st.nextStudentFriend != null) {
                st = st.nextStudentFriend;
                System.out.println(st.toString() + " " + k);
                k += 2;
            }
            sst = sst.nextStudentInLine;
        }
    }

}
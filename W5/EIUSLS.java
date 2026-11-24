import java.util.*;
import java.util.Map.Entry;

public class EIUSLS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// numbStudent
        ArrayList<Student> lists = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int grades = sc.nextInt();// numbGrade
            Student stu = new Student(name);
            for (int j = 0; j < grades; j++) {
                stu.addGrade(sc.nextDouble());
            }
            lists.add(stu);
        }
        // Sort by comparator
        // Reversed cuz we need the top ppl gpa mean decsending
        lists.sort(Comparator.comparing(Student::getAvgGrade).reversed());
        int choose = 0;
        for (Student student : lists) {
            if (choose < 2) {
                System.out.println(student.getName());
                choose++;
            } else {
                break;
            }
        }
    }

    static class Student {
        String name;
        double grade;
        double totalGrade;
        int countSubj;

        public Student(String name) {
            this.name = name;
        }

        private void addGrade(double grade) {
            totalGrade += grade;
            countSubj++;
        }

        public double getAvgGrade() {
            return totalGrade / countSubj;
        }

        public String getName() {
            return name;
        }

    }
}
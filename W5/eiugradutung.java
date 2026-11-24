import java.util.*;

public class eiugradutung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt(); // so luoong hoc sinh
        int q = sc.nextInt(); // minimum credit

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Student temp = new Student(sc.nextLong(), sc.next());
            students.add(temp);
            int s = sc.nextInt();
            for (int sub = 0; sub < s; sub++) {
                temp.addGrade(sc.nextInt());
            }
        }

        students.sort((s1, s2) -> {
            var compare = Double.compare(s2.getGpa(), s1.getGpa());
            if (compare == 0) {
                return Long.compare(s1.id, s2.id);
            }
            return compare;
        });

        for (Student s : students) {
            if (s.totalCredits >= q)
                sb.append(s);
        }
        System.out.println(sb);
    }

    static class Student {
        long id;
        String name;

        long totalGrades;
        long totalCredits;
        double gpa;

        public Student(long id, String name) {
            this.id = id;
            this.name = name;
            totalCredits = 0;
            totalGrades = 0;
        }

        public void addGrade(int grade) {
            if (grade >= 50) {
                totalCredits += 4;
                totalGrades += grade;
            }
        }

        public double getGpa() {
            if (totalCredits == 0)
                return 0;
            gpa = (double) totalGrades / (totalCredits / 4);
            return gpa;
        }

        @Override
        public String toString() {
            return "%s %s %s \n".formatted(this.id, this.name, (int) Math.floor(gpa));
        }
    }
}

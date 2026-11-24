import java.util.*;

public class EISTULI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();// numb of Student
        int k = sc.nextInt();// require quantity
        List<Student> lists = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long id = sc.nextLong();
            String name = sc.next();
            int subj = sc.nextInt();
            Student student = new Student(id, name);
            for (int j = 0; j < subj; j++) {
                student.addGrade(sc.nextDouble());
            }
            lists.add(student);

        }
        lists.sort((s1, s2) -> Double.compare(s2.getAvgGrade(), s1.getAvgGrade()));
        if (k >= n) {
            for (int i = 0; i < lists.size(); i++) {
                sb.append(lists.get(i) + "\n");
            }
        } else {
            for (int i = 0; i < k; i++) {
                if (lists.get(i).getAvgGrade() > lists.get(k - 1).getAvgGrade()) {
                    sb.append(lists.get(i) + "\n");
                }
            }
        }
        System.out.println(sb);
    }

    static class Student {
        private long id;
        private String name;
        private double total;
        private long count;

        public void addGrade(double grade) {
            if (grade >= 50) {
                total += grade;
                count++;
            }
        }

        public double getAvgGrade() {
            return total / count;
        }

        public Student(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return getId() + " " + getName() + " " + Math.round(getAvgGrade()) + " " + count * 4;
        }
    }
}

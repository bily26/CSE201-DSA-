import java.util.*;

public class EIGRADU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();// numbStu
        int creditsReq = sc.nextInt();
        // B1: Determine the data structure
        List<Student> lists = new ArrayList<>();

        // B2: input and update the datas
        for (int i = 0; i < n; i++) {
            long id = sc.nextLong();
            String name = sc.next();
            int subj = sc.nextInt();
            Student stu = new Student(id, name);
            for (int j = 0; j < subj; j++) {
                stu.addGrade(sc.nextDouble());
            }
            if (stu.getCountPass() * 4 >= creditsReq) {
                lists.add(stu);
            }
        }

        // Sort follows the gpa same-> sort id ascending
        lists.sort((s1, s2) -> {
            // Descending gpa
            int compare = Double.compare(s2.getGpa(), s1.getGpa());
            if (compare == 0) {
                // Ascending id
                compare = Long.compare(s1.getId(), s2.getId());
            }
            return compare;
        });
        // B3: Print
        for (Student student : lists) {
            sb.append(student + "\n");
        }
    }

    static class Student {
        long id;
        String name;
        double total;
        private int countPass;

        public Student(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getCountPass() {
            return countPass;
        }

        public double getTotal() {
            return total;
        }

        public double getGpa() {
            return Math.floor(total / countPass);
        }

        public void addGrade(double grade) {
            if (grade >= 50) {
                total += grade;
                countPass++;
            }
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return getId() + " " + getName().toLowerCase() + " " + (long) getGpa() + "\n";
        }
    }
}
import java.util.*;

public class EISTULI_LAMBDA {
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
                // student.addGrade(sc.nextDouble()); (co the sai so)-> khi compare voi 50
                // student.addGrade(sc.nextInt());
                student.addGrade(sc.nextDouble());
            }
            lists.add(student);

        }
        lists.sort((s1, s2) -> Double.compare(s2.gpa, s1.gpa));

        //
        double pivot = (k < n) ? lists.get(k).gpa : -1;
        for (int i = 0; i < k; i++) {
            if (lists.get(i).gpa > pivot) {
                sb.append(lists.get(i) + "\n");
            }
        }
        System.out.println(sb);
    }

    static class Student {
        private long id;
        private String name;
        private double total;
        private long count;
        private double gpa;
        private long credit;

        public Student(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public void addGrade(double grade) {
            // khi dung double de compare voi 1 so long hay int se co sai so => hay ep kieu
            // de so sanh
            if (grade >= (double) 50) {
                total += grade;
                count++;
                credit += 4;
                gpa = total / count;
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
            return id + " " + name + " " + Math.round(gpa) + " " + credit;
        }
    }
}

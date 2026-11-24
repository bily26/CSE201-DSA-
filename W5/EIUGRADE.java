import java.util.*;

public class EIUGRADE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();// testCases

        //
        Map<Long, Student> stuInfo = new HashMap<>();
        List<Student> lists = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long id = sc.nextLong();
            long idSubj = sc.nextLong();
            double grade = sc.nextDouble();

            if (!stuInfo.containsKey(id)) {
                stuInfo.put(id, new Student(id, idSubj));
            }
            //
            stuInfo.get(id).addGrade(grade);
        }

        System.out.println(sb);
    }

    static class Student {
        long id;
        long noSubj;
        double grade;
        double totalGrade;
        long countSubj;
        double avg;

        public Student(long id, long noSubj) {
            this.id = id;
            this.noSubj = noSubj;
        }

        public double getAvg() {
            return avg;
        }

        public void addGrade(double grade) {
            this.grade = grade;
            totalGrade += grade;
            countSubj++;
            avg = totalGrade / countSubj;
        }

        public long getId() {
            return id;
        }

        @Override
        public String toString() {
            return "%d %.3f\n".formatted(id, avg);
        }
    }
}

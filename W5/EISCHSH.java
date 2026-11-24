import java.util.*;

public class EISCHSH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();// numb of stu
        int k = sc.nextInt();// numb of scholarships

        List<Student> lists = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long id = sc.nextLong();
            String name = sc.next();
            int subj = sc.nextInt();
            Student info = new Student(id, name);
            for (int j = 0; j < subj; j++) {
                info.addGrade(sc.nextInt());
            }
            lists.add(info);
        }

        lists.sort(Comparator.comparing(Student::getAvg).reversed().thenComparing(Student::getId));

        int inOrderRank = 1;
        double compare = lists.get(0).getAvg();
        for (int i = 0; i < lists.size(); i++) {
            if (i == 0) {
                sb.append(inOrderRank + " " + lists.get(i).toString() + "\n");
                k--;
            } else {
                if (k > 0) {
                    if (lists.get(i).getAvg() == lists.get(i - 1).getAvg()) {
                        sb.append(inOrderRank + " " + lists.get(i).toString() + "\n");
                        k--;
                    } else {
                        inOrderRank = i + 1;
                        sb.append(inOrderRank + " " + lists.get(i).toString() + "\n");
                        k--;
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    static class Student {
        long id;
        String name;
        double totalGrade;
        int count;
        double avg;

        public double getAvg() {
            return avg;
        }

        public long getId() {
            return id;
        }

        public void addGrade(int grade) {
            if (grade >= 50) {
                totalGrade += grade;
                count++;
                avg = totalGrade / count;
            }
        }

        public Student(long id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return id + " " + name + " " + Math.round(avg);
        }
    }
}

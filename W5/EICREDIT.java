import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EICREDIT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            String name = sc.next();
            int numbGrades = sc.nextInt();
            double[] grades = new double[numbGrades];
            for (int j = 0; j < grades.length; j++) {
                grades[j] = sc.nextDouble();
            }
            StudentGrade student = new StudentGrade(name, grades);
            sb.append(student.getName() + " " + student.getCredit() + "\n");
        }
        System.out.println(sb);
    }

}

class StudentGrade {
    private String name;
    private double[] gradeList;
    private final double passedGrade = 50;
    private int credit = 4;

    public StudentGrade(String name, double[] grades) {
        this.name = name;
        this.gradeList = grades;
    }

    public String getName() {
        return this.name;
    }

    public int getCredit() {
        int count = 0;
        for (int i = 0; i < gradeList.length; i++) {
            if (gradeList[i] >= passedGrade) {
                count++;
            }
        }
        return credit * count;
    }

}

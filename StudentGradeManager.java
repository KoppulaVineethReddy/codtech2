import java.util.ArrayList;
import java.util.Scanner;

class Grade {
    String subject;
    double score;

    Grade(String subject, double score) {
        this.subject = subject;
        
        this.score = score;
    }
}

public class StudentGradeManager {
    private ArrayList<Grade> grades;

    public StudentGradeManager() {
        grades = new ArrayList<>();
    }

    public void addGrade(String subject, double score) {
        grades.add(new Grade(subject, score));
    }

    public double calculateAverage() {
        double total = 0;
        for (Grade grade : grades) {
            total += grade.score;
        }
        return total / grades.size();
    }

    public String getLetterGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public void displayGrades() {
        System.out.println("Grades:");
        for (Grade grade : grades) {
            System.out.println(grade.subject + ": " + grade.score);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeManager manager = new StudentGradeManager();

        while (true) {
            System.out.println("Enter the subject (or type 'exit' to finish):");
            String subject = scanner.nextLine();
            if (subject.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter the grade for " + subject + ":");
            double score = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            manager.addGrade(subject, score);
        }

        manager.displayGrades();
        double average = manager.calculateAverage();
        System.out.println("Average Grade: " + average);
        System.out.println("Letter Grade: " + manager.getLetterGrade(average));
    }
}
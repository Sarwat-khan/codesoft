import java.util.Scanner;

public class studentGradeCal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Marks in each Subject out of 100!");

        System.out.println(" your marks in English?");
        float Eng = sc.nextFloat();

        System.out.println(" your marks in Mathamathics?");
        float Maths = sc.nextFloat();

        System.out.println(" your marks in Urdu?");
        float urdu = sc.nextFloat();

        System.out.println(" your marks in Science?");
        float Science = sc.nextFloat();

        System.out.println(" your marks in Islamiyat?");
        float Islam = sc.nextFloat();

        float totalMarks = (Eng + Maths + urdu + Science + Islam);

        int average = (int) totalMarks / 5;

        String grade = "";

        if (average > 80) {

            grade = "A";

        } else if (average > 60) {
            grade = "B";
        } else if (average > 30) {
            grade = "C";
        } else {
            grade = "F";
        }

        System.out.println(
                "Total_Marks :" + totalMarks + "\n" + "AveragePercentage :" + average + "%" + "\n" + "Grade:" + grade);

    }

}

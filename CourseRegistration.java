import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

///// as there is not backend connected to this however, i have code simple registration system using java programming..

public class CourseRegistration {
    private List<Course> courses;
    private List<Student> students;

    public CourseRegistration() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void listCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public Student findStudent(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    public Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CourseRegistration system = new CourseRegistration();
        Scanner scanner = new Scanner(System.in);

        // Add some sample courses
        system.addCourse(new Course("CS101", "FundamentalProgramming", " we will learn using C language", 30,
                " Mon 9:00-10:00"));
        system.addCourse(
                new Course("MATH123", "Calculus I", "Differention and integration", 40, "Tues 10:00-11:30"));

        system.addStudent(new Student("S001", "Sarwat"));
        system.addStudent(new Student("S002", "Siraj"));
        system.addStudent(new Student("S003", "Sania"));
        system.addStudent(new Student("S004", "neesha"));
        system.addStudent(new Student("S005", "hifsa"));

        while (true) {
            System.out.println("\n1. List Courses\n2. Register for Course\n3. Drop Course\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    system.listCourses();
                    break;
                case 2:
                    System.out.print("Enter Student ID ");
                    System.out.println("between S001 to S005 : ");
                    String studentID = scanner.nextLine();
                    System.out.print("Enter Course Code: ");
                    String courseCode = scanner.nextLine();

                    Student student = system.findStudent(studentID);
                    Course course = system.findCourse(courseCode);

                    if (student != null && course != null) {
                        if (student.registerCourse(course)) {
                            System.out.println("Registered successfully.");
                        } else {
                            System.out.println("Course is full.");
                        }
                    } else {
                        System.out.println("Invalid student ID or course code.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID:");
                    System.out.println("between S001 to S005 : ");
                    studentID = scanner.nextLine();
                    System.out.print("Enter Course Code: ");
                    courseCode = scanner.nextLine();

                    student = system.findStudent(studentID);
                    course = system.findCourse(courseCode);

                    if (student != null && course != null) {
                        if (student.dropCourse(course)) {
                            System.out.println("Dropped successfully.");
                        } else {
                            System.out.println("You are not registered for this course.");
                        }
                    } else {
                        System.out.println("Invalid student ID or course code.");
                    }
                    break;
                case 4:
                    scanner.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

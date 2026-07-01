import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("==================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    Student student = new Student();

                    System.out.print("Enter Name: ");
                    sc.nextLine(); // Consume newline
                    student.setName(sc.nextLine());

                    System.out.print("Enter Age: ");
                    student.setAge(sc.nextInt());

                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    student.setCourse(sc.nextLine());

                    System.out.print("Enter Email: ");
                    student.setEmail(sc.nextLine());

                    System.out.print("Enter Phone: ");
                    student.setPhone(sc.nextLine());

                    dao.addStudent(student);
                    break;

                case 2:

                    dao.viewStudents();
                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();

                    dao.searchStudent(searchId);
                    break;

                case 4:

                    Student updateStudent = new Student();

                    System.out.print("Enter Student ID to Update: ");
                    updateStudent.setStudentId(sc.nextInt());

                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    updateStudent.setName(sc.nextLine());

                    System.out.print("Enter New Age: ");
                    updateStudent.setAge(sc.nextInt());

                    sc.nextLine();

                    System.out.print("Enter New Course: ");
                    updateStudent.setCourse(sc.nextLine());

                    System.out.print("Enter New Email: ");
                    updateStudent.setEmail(sc.nextLine());

                    System.out.print("Enter New Phone: ");
                    updateStudent.setPhone(sc.nextLine());

                    dao.updateStudent(updateStudent);
                    break;

                case 5:

                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = sc.nextInt();

                    dao.deleteStudent(deleteId);
                    break;

                case 6:

                    System.out.println("Thank you for using Student Management System!");
                    break;

                default:

                    System.out.println("Invalid Choice! Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}

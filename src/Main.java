import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    service.addStudent(id, name, marks);
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    service.searchStudent(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String uname = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    int umarks = sc.nextInt();

                    service.updateStudent(uid, uname, umarks);
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    service.deleteStudent(sc.nextInt());
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}
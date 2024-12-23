import java.util.Scanner;

class STUDENT {
    Scanner scanner = new Scanner(System.in);
    String name;
    String USN;
    int credits[] = new int[6];
    int marks[] = new int[6];

    void ENTER_DETAILS() {
        System.out.print("Enter the name: ");
        name = scanner.nextLine();
        System.out.print("Enter the USN: ");
        USN = scanner.nextLine();
        
        System.out.println("Enter the credits: ");
        for (int i = 0; i < 6; i++) {
            credits[i] = scanner.nextInt();
        }
        
        System.out.println("Enter the marks: ");
        for (int i = 0; i < 6; i++) {
            marks[i] = scanner.nextInt();
        }
        
        // Consume the leftover newline character
        scanner.nextLine();
    }

    void DISPLAY_DETAILS() {
        System.out.println("Name: " + name);
        System.out.println("USN: " + USN);
        System.out.println("These are the credits and marks: ");
        for (int i = 0; i < 6; i++) {
            System.out.println("Subject " + (i + 1) + ": Credits = " + credits[i] + ", Marks = " + marks[i]);
        }
    }

    double SGPA() {
        int totalCredits = 0;
        double totalMarks = 0.0;

        for (int i = 0; i < 6; i++) {
            totalCredits += credits[i];
            totalMarks += (marks[i] / 10.0) * credits[i]; // Assuming marks are out of 100
        }
        return totalCredits > 0 ? (totalMarks / totalCredits) : 0.0;
    }
}

class Student_info {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        STUDENT[] students = new STUDENT[n];

        // Initialize each STUDENT object before using
        for (int i = 0; i < n; i++) {
            students[i] = new STUDENT(); // Instantiate each student
            students[i].ENTER_DETAILS();
        }

        for (int i = 0; i < n; i++) {
            students[i].DISPLAY_DETAILS();
            System.out.printf("SGPA: %.2f%n", students[i].SGPA());
        }
        
        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}

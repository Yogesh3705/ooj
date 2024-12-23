import CIE.*;
import SEE.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        External[] students = new External[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("USN: ");
            String usn = sc.next();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Semester: ");
            int sem = sc.nextInt();

            System.out.println("Enter internal marks (5 subjects):");
            int[] internalMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                internalMarks[j] = sc.nextInt();
            }

            System.out.println("Enter SEE marks (5 subjects):");
            int[] externalMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                externalMarks[j] = sc.nextInt();
            }

            students[i] = new External(usn, name, sem, externalMarks);

            // Adding internal marks to external marks for final calculation
            for (int j = 0; j < 5; j++) {
                students[i].externalMarks[j] += internalMarks[j] / 2; 
            }
        }

        System.out.println("\nFinal Marks:");
        for (External student : students) {
            System.out.println("Student: " + student.name + " (USN: " + student.usn + ")");
            System.out.println("Final Marks:");
            for (int mark : student.externalMarks) {
                System.out.print(mark + " ");
            }
            System.out.println("\n");
        }
    }
}

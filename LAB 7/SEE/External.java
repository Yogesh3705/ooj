package SEE;

import CIE.Student;

public class External extends Student {
    public int[] externalMarks = new int[5];

    public External(String usn, String name, int sem, int[] marks) {
        super(usn, name, sem);
        System.arraycopy(marks, 0, externalMarks, 0, 5);
    }
}

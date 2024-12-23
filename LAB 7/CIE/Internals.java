package CIE;

public class Internals {
    public int[] internalMarks = new int[5];

    public Internals(int[] marks) {
        System.arraycopy(marks, 0, internalMarks, 0, 5);
    }
}

import java.util.Scanner;

class Father {
    protected int fatherAge;

    // Constructor for Father class
    public Father(int fatherAge) throws WrongAge {
        if (fatherAge < 0) {
            throw new WrongAge("Father's age cannot be negative.");
        }
        this.fatherAge = fatherAge;
    }

    public int getFatherAge() {
        return fatherAge;
    }
}

class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}

class Son extends Father {
    private int sonAge;

    // Constructor for Son class
    public Son(int fatherAge, int sonAge) throws WrongAge {
        super(fatherAge); // Calling Father's constructor
        if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age cannot be greater than or equal to Father's age.");
        }
        this.sonAge = sonAge;
    }

    public int getSonAge() {
        return sonAge;
    }
}

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n=1;
	while(n!=0){
	        try {
		   System.out.println("father age : ");
		   int fatherage = sc.nextInt();
 	           Father father = new Father(fatherage);
 	           System.out.println("Father's age: " + father.getFatherAge());
		   System.out.println("son age : ");
 	           int sonage = sc.nextInt();
	            Son son = new Son(fatherage, sonage);
	            System.out.println("Son's age: " + son.getSonAge());
	
	        } catch (WrongAge e) {
	            System.out.println("Exception: " + e.getMessage());
	        }
		System.out.println("Enter 0 to exit ");
		n = sc.nextInt();
	}
    }
}
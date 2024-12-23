class DisplayMessage extends Thread {
    private String message;
    private int interval;

    public DisplayMessage(String message, int interval) {
        this.message = message;
        this.interval = interval;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(message);
                Thread.sleep(interval * 1000);
            }
        } catch (InterruptedException e) {
        }
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        new DisplayMessage("BMS College of Engineering", 10).start();
        new DisplayMessage("CSE", 2).start();
    }
}

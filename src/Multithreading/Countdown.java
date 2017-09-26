package Multithreading;

public class Countdown implements Runnable {

    protected int countdown = 10;
    private final int TASK_ID = counter++;
    private static int counter = 0;

    public Countdown() {
    }

    public Countdown(int countdown) {
        this.countdown = countdown;
    }

    public String status() {
        return "#" + TASK_ID + "(" + ( countdown>0  ? countdown : "Start!" ) + ")";
    }

    @Override
    public void run() {
        while (countdown-->0) {
            System.out.println(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {


        for (int i = 0; i<5; i++) {
        new Thread(new Countdown()).start();
        }
        System.out.println("Countdown started!");

    }

}

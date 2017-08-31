package Exceptions;

public class NeedsCleaning {
    private static int counter = 0;
    private final int ID = ++counter;

    public NeedsCleaning() {
        counter++;
        System.out.println("Created NC-" + ID + ". Cleaning will be required.");
    }

    public void dispose() {
        System.out.println("Cleaning for NC-" + ID + " performed.");
    }

    @Override
    public String toString() {
        return "NC-" + ID;
    }
}

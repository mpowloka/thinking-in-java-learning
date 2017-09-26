package Strings;

import java.util.Formatter;

public class Receipt {

    private Formatter formatter = new Formatter(System.out);
    private double totalAmount = 0;

    public void printTitle() {
        formatter.format("|%-20.20s |%-10s |%-10s\n", "Ware", "Count", "Due amount");
        for (int i=0; i<45; i++) System.out.print("-");
        System.out.println();
    }

    public void printWare(String name, int count, double price) {
        formatter.format("|%-20.20s |%-10d |%-10.2f", name, count, count*price);
        totalAmount += count*price;
        System.out.println();
    }

    public void printSummary() {
        for (int i=0; i<45; i++) System.out.print("-");
        System.out.println();
        formatter.format("%s: %.2f", "Total", totalAmount);
    }

    public static void smth (Object... obj) {

    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.printWare("Milk", 2, 5.50);
        receipt.printWare("Cabbage", 1, 1.30);
        receipt.printWare("iPhone", 1, 400);
        receipt.printWare("Concentrated dark matter", 400, 40);
        receipt.printWare("Red Label", 0,0);
        receipt.printWare("Love", 1, 999999);
        receipt.printSummary();

    }
}

package Strings;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.Normalizer;
import java.util.Formatter;

public class BasicFormatter {

    static class Turtle {
        private String name;
        private Formatter formatter;
        public Turtle(String name, Formatter formatter) {
        this.name=name;
        this.formatter = formatter;
        }

        public void report() {
            formatter.format("Turtle named %s on duty!", name);
        }
    }

    public static void main(String[] args) {

        Turtle tommy = new Turtle("Tommy", new Formatter(System.out));
        tommy.report();
        PrintStream printStream = System.err;

        System.out.println();

        new Turtle("Timmy", new Formatter(printStream)).report();
    }
}

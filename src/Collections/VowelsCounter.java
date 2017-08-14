package Collections;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class VowelsCounter {

    public static void main(String[] args) {

        Set<String> vowels = new HashSet<String>();
        Collections.addAll(vowels, "a o u e i y A O U E I Y".split(" ")); //(polish ones from the common alphabet)
        FileReader in;
        BufferedReader buffer;

        try {
            in = new FileReader("vowels.txt");
            buffer = new BufferedReader(in);

            String line;
            int vowelsTotal, vowelsInWord, wordsCounter, wordsInLineCounter;
            vowelsInWord = vowelsTotal = wordsCounter = 0;

            while ( (line=buffer.readLine()) != null ) {
                wordsInLineCounter = 0;
                for (char c : line.toCharArray()) {


                    if (vowels.contains(Character.toString(c))) {
                        vowelsTotal++;
                        vowelsInWord++;
                    }
                    if (c == ' ') {
                        System.out.println("Found " + vowelsInWord + " vowels in word no. " + ++wordsCounter + "(" + line.split(" ")[wordsInLineCounter++] + ").");
                        System.out.println(vowelsTotal + " vowels in total found so far.");
                        System.out.println();
                        vowelsInWord = 0;
                    }
                }
                // to include word right before line separator
                System.out.println("Found " + vowelsInWord + " vowels in word no. " + ++wordsCounter + "(" + line.split(" ")[wordsInLineCounter++] + ").");
                System.out.println(vowelsTotal + " vowels in total found so far.");
                System.out.println();
                vowelsInWord = 0;
            }
        }
        catch(IOException ex) {
            System.out.println("No expected file found.");
        }

    }

}

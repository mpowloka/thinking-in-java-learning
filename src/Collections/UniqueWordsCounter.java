package Collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class UniqueWordsCounter {

    private class WordFraction {
        private final String WORD;
        private int counter;
        private WordFraction(String word) {
            this.WORD = word;
            counter = 1;
        }
        private void add() {
            counter++;
        }
        public String toString() {
            return("Word: " + WORD + " occured " + counter + " times.");
        }
    }

    public Set<WordFraction> getSet (String fileName) {

        Set<WordFraction> set = new HashSet<>();
        try {

            String line;
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            while ( null != (line=reader.readLine()) ) {

                myFirstLabelLol:
                for(String s : line.split(" ")) {


                    Iterator<WordFraction> iterator = set.iterator();
                    while(iterator.hasNext()) {
                        WordFraction wf = iterator.next();
                        if(wf.WORD.equals(s.toLowerCase())){
                            wf.add();
                            continue myFirstLabelLol;
                        }
                    }
                    set.add(new WordFraction(s.toLowerCase()));
                }
            }


        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return set;
    }

    public Map<String, Integer> getMap(String fileName) {
        Map<String, Integer> map = new HashMap<>();
        int a;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;
            while( null != (line=reader.readLine()) ) {
                for (String s : line.split(" ")) {


                    if(!map.containsKey(s.toLowerCase())) map.put(s.toLowerCase(), 1);
                    else {
                        int i = map.get(s.toLowerCase()) + 1;
                        map.put(s.toLowerCase(), i);
                    }
                }
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return map;
    }

    public static void main(String[] args) {
        UniqueWordsCounter uwc = new UniqueWordsCounter();
        System.out.println("Counting using a set of WordFraction objects:");
        System.out.println(uwc.getSet("uniqueWords.txt"));
        System.out.println();

        System.out.println("Counting using a Map<String,Integer>:");
        System.out.println(uwc.getMap("uniqueWords.txt"));
        System.out.println();
    }
}

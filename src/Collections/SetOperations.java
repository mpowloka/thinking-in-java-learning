package Collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetOperations {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        Collections.addAll(set,"A B C D E F G H I J K".split(" "));
        set.add("L");
        System.out.println("H: " + set.contains("H"));
        System.out.println("M: " + set.contains("M"));

        Set<String> set2 = new HashSet<>();
        Collections.addAll(set2, "A C G".split(" "));

        System.out.println("A C G: " + set.containsAll(set2));

        set.removeAll(set2);
        System.out.println("set: " + set);

    }

}

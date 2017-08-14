package Lambdas;

import java.util.*;

class Box {
        final int NUMBER;
        final boolean IS_IMPORTANT;
        final float CONTENT;

        private static Set<Integer> log = new HashSet<>();

        public Box(int number, boolean isImportant, float content) {

            if(log.contains(number)) throw new IllegalArgumentException("Such number is already used");
            log.add(number);
            this.NUMBER = number;
            this.IS_IMPORTANT = isImportant;
            this.CONTENT = content;
        }

        public String toString() {
            String text = IS_IMPORTANT ? "Important" : "Not important";
            return text + " box no. " + NUMBER + ", containing: " + CONTENT;
        }
}

public class ArraysSorter {

    public static List<String> stringListSorter(List<String> list) {
        list.sort( (String s1, String s2) -> {
            if (s1.length()==s2.length()) return 0;
            return (s1.length()>s2.length()) ? -1 : 1;} );
        System.out.println(list);
        return list;
    }

    public static int compareBoxes(Box b1, Box b2) {
        if (b1.IS_IMPORTANT && !b2.IS_IMPORTANT) return -1;
        if (!b1.IS_IMPORTANT && b2.IS_IMPORTANT) return 1;
        if (b1.CONTENT==b2.CONTENT) return b1.NUMBER>b2.NUMBER ? -1 : 1;
        return b1.CONTENT>b2.CONTENT ? -1 : 1;

    }

    public static void main(String[] args) {
        String[] temp = {"did", "you", "know", "taco cat", "spelled", "backwards", "is", "still", "taco cat"};
        List<String> list = Arrays.asList(temp);
        list = stringListSorter(list);

        Random rand = new Random(42);

        List<Box> boxes = new ArrayList<>();
        for (int i=0; i<10; i++) {
            boxes.add(new Box(i+1, rand.nextBoolean(), rand.nextFloat()));
        }

        boxes.sort(ArraysSorter::compareBoxes);
        for (Box b : boxes) {
            System.out.println(b);
        }

    }


}

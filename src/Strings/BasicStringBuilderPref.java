package Strings;

public class BasicStringBuilderPref {

    static class UsingStringIsOk {
        @Override
        public String toString() {
            return "In such case, compiler " +"will do fine without String Builder";
        }
    }

    static class UsingStringIsMeh {

        @Override
        public String toString() {
            String result = "";
            for (int i = 0; i < 10; i++) {
                result += i;
            }
            return result + " When loops involved, using String is inefficient.";
        }

        public String useMeInstead() {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                result.append(i);
            }
            return result.append(" String Builder is more efficient here").toString();

        }
    }

    public static void main(String[] args) {
        System.out.println(new UsingStringIsOk().toString());
        System.out.println(new UsingStringIsMeh().toString());
        System.out.println(new UsingStringIsMeh().useMeInstead());
    }

}

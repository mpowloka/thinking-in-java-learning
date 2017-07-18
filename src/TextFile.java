/**
 * Created by michal.powloka on 18.07.2017.
 */

// showing that internal classes have access to all fields from outer classes
// and that object of internal class is linked to object of external class which created it

public class TextFile {

    private String text;
    TextFile(String text) {
        this.text=text;
    }

    private class TextEditor {
        public void eraseAll() {
            text = "";
        }
        public void addText(String addon) {
            text += addon;
        }
        public void erase(int size) {
            text = text.substring(0, text.length()-size);
        }
        public void capitalize() {
            text = text.toUpperCase();
        }
        public void deCapitalize() {
            text = text.toLowerCase();
        }
    }

    public TextEditor getEditor() {
        return new TextEditor();
    }

    public String getText() {
        return text;
    }

    public static void main (String[] args) {

        TextFile tf = new TextFile("Kappa");
        TextEditor te = tf.getEditor();

        System.out.println(tf.getText());
        te.capitalize();
        System.out.println(tf.getText());
        te.addText(" kek");
        te.deCapitalize();
        System.out.println(tf.getText());
    }

}

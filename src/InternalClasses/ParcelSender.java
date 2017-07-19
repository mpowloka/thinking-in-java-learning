package InternalClasses;

interface Destination {
    public String getLabel();
}

class Parcel {
    private static int counter;
    private final int ID;

    Parcel(String destination, String origin, int content){
        ID = ++counter;
        ParcelDestination pd = this.new ParcelDestination(destination, origin);
        ParcelContent pc = this.new ParcelContent(content);
        System.out.println("Sending parcel no. " + ID + " from " + origin + " to " + destination + ". " + content + " items inside.");
    }

    public ParcelDestination getParcelDestination () {
        //test phrase
        return new ParcelDestination("your heart, honey ", "your stomach");
    }

    public ParcelContent getParcelContent () {
        //test number
        return new ParcelContent(42);
    }

    private class ParcelDestination implements Destination {

        private final String destination, origin;

        private ParcelDestination(String destination, String origin) {
            this.destination = destination;
            this.origin = origin;
        }

        @Override
        public String getLabel() {
            return "From " + origin + " to " + destination;
        }
    }

    protected class ParcelContent {
        private final int content;

        ParcelContent(int content) {
            this.content = content;
        }

        public int getContent() {
            return  content;
        }
    }
}

public class ParcelSender {

    public static void main (String[] args) {
        Parcel p1 = new Parcel("Dalików", "Warszawa", 5); // regular operation
        Parcel p2 = new Parcel("Breslau", "Warszawa", 5); // another regular operation

        Destination d = p2.getParcelDestination(); // creating instance of internal class
        // Invalid, cannot use name of private component (ParcelDestination)
        // ParcelDestination pd = p2.getParcelDestination();
        System.out.println(d.getLabel());

        // Valid, because protected components are avaible within package
        Parcel.ParcelContent pc = p2.getParcelContent();
        System.out.println(pc.getContent());
    }
}

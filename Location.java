class PlaceThread extends Thread {

    String place;

    PlaceThread(String place) {
        this.place = place;
    }

    public void run() {
        System.out.print(place);
    }
}

public class Location {
    public static void main(String[] args) throws Exception {

        String p1 = "India > ";
        String p2 = "Maharashtra > ";
        String p3 = "Nagar > ";
        String p4 = "Kopargaon"

        
        PlaceThread t1 = new PlaceThread(p4 + " > ");
        PlaceThread t2 = new PlaceThread(p3 + " > ");
        PlaceThread t3 = new PlaceThread(p2 + " > ");
        PlaceThread t4 = new PlaceThread("India");

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();

        t4.start();
    }
}


class Booking_Scoe {

    int available = 10;

    synchronized void printing(int seat) {

        System.out.println("Hello: " + Thread.currentThread().getName());
        System.out.println("Hello: " + Thread.currentThread().getName());
        System.out.println("Hello: " + Thread.currentThread().getName());

        String name = Thread.currentThread().getName();

        if (available >= seat) {
            System.out.println("Seats are booked by " + name);
            available = available - seat;
            System.out.println("Available seats: " + available);
        } else {
            System.out.println("Sorry " + name);
            System.out.println("Available seats: " + available + " only");
        }

        System.out.println("Bye " + Thread.currentThread().getName());
        System.out.println("Bye " + Thread.currentThread().getName());
        System.out.println("Bye " + Thread.currentThread().getName());
    }
}

class MyThread extends Thread {

    static Booking_Scoe op;
    int seat;

    public void run() {
        op.printing(seat);
    }
}

public class Sdata {
    public static void main(String[] args) {

        MyThread.op = new Booking_Scoe();

        MyThread t1 = new MyThread();
        t1.seat = 7;
        t1.setName("Amol");

        MyThread t2 = new MyThread();
        t2.seat = 6;
        t2.setName("Rahul");

        t1.start();
        t2.start();
    }
}

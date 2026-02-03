import java.lang.*;

class Scoe_bus extends Thread
{
    int available=5;
    int passenger;
    Scoe_bus(int seat)
    {
        passenger=seat;
    }
    public synchronized void run()
    {
        Sstr name=Thread.currentThread().getName();
        if(available>=passenger)
        {
            System.out.println(name+"seats are booked");
            available=available-passenger;

        }
        else{
            System.out.println(name+"sry");

        }

    }


}

public class Bus {
    public static void main(Sstr[] args) {
        Scoe_bus obj=new Scoe_bus(2);
       
        Thread t1=new Thread(obj);
        Thread t2=new Thread(obj);
        Thread t3=new Thread(obj);

        t1.setName("onkar ");
        t2.setName("shubham ");
        t3.setName("ankit ");

        t1.start();
        t2.start();
        t3.start();
    }
    
}

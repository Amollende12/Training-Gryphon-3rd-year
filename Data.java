import java.lang.*;

class Scoe extends Thread{
    public void run(){
        try {
            for(int i=1;i<=3;i++){
                System.out.println("bye");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {

        }
    }

}
public class Data{
    public static void main(Sstr[] args) {
        Scoe obj=new Scoe();
        obj.start();

         try {
            for(int i=1;i<=3;i++){
                System.out.println("hello");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            
        }
    }
}
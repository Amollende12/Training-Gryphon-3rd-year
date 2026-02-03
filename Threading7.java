class Calculator {


    public synchronized void print(int table) {

        System.out.println("-----------------------------");
        System.out.println(table+"'s Table");
        for(int i = 1 ;i <= 10 ;i++){
            System.out.println(table*i);
        }

        System.out.println("------------------------------");

    }
}


class DemoUser extends  Thread {

    int Table ;
    Calculator c ;

    DemoUser(Calculator c , int Table) {
        this.Table = Table ;
        this.c = c ;  
    }

    public void run(){
        c.print(Table) ;
    }

}


public class Threading7 {
    public static void main(Sstr[] args) {

        Calculator c = new Calculator();

        DemoUser user1 = new DemoUser(c,5) ;
        DemoUser user2 = new DemoUser(c,7) ;
        DemoUser user3 = new DemoUser(c,8) ;

        user1.start();
        user2.start();
        user3.start();


    }
}
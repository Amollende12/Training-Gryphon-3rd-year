
// public class Sample{
//      public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

    
//         System.out.print("Enter size of array: ");
//         int N = sc.nextInt(); 

//         int[] arr = new int[N];

        
//         System.out.println("Enter array elements:");
//         for (int i = 0; i < N; i++) {
//             arr[i] = sc.nextInt();
//         }

       
//         int count = 1;          
//         int max = arr[0];

//         for (int i = 1; i < N; i++) {
//             if (arr[i] > max) {
//                 count++;
//                 max = arr[i];
//             }
//         }
//         System.out.println("Count = " + count);

//      for(int i=0;i<=100;i++){
//         if(i%2==0){
//             System.out.println(i);

//         }
       
        
//      }
//     }
//  }

import java.awt.*;

public class Main extends Frame{
    Main(){
        Button b=new Button("Home");
        b.setBounds(30,100,80,30);
        add(b);
        setSize(300,300);
        setLayout(null);
        setVisible(true);
    }
    public static void main (String [] args){
        new Main();
    }
}


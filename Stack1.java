// import java.util.Stack;


// public class Stack1{

//     public static void main(String[] args) {

//         Stack<Integer> stack = new Stack<Integer>();
//         Stack<Integer> tempStack = new Stack<Integer>();

//         stack.push(10);
//         stack.push(12);
//         stack.push(13);
//         stack.push(18);
//         stack.push(11);
//         stack.push(15);

//         System.out.println("Before Sorting Stack : " + stack);

     
//         while (!stack.isEmpty()) {

//             int temp = stack.pop();  

            
//             while (!tempStack.isEmpty() && tempStack.peek() > temp) {
//                 stack.push(tempStack.pop());
//             }

//             tempStack.push(temp);
//         }

//         System.out.println("After Sorting Stack  : " + tempStack);
//     }
// }


import java.util.Stack;

public class Stack1 {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()])
                 {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,3,5,7};
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights));
    }
}
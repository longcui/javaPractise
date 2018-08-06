package amazonTest;

import java.util.Stack;

/**
 * Created by long on 12.02.2017.
 */
public class Test1 {
    public static void main(String[] args){
        Stack<String> stack = new Stack<String>();
        stack.push("Java");
        stack.push("C#");
        stack.push("Python");
        System.out.println(stack.pop());
        for (Object lang : stack.toArray())
            System.out.println("lang : " + lang);
    }
}

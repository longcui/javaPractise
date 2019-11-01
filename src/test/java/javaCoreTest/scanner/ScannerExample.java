package javaCoreTest.scanner;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class ScannerExample {

    @Test
    public void test1() {
        String input = "1 2";
        Scanner scanner = new Scanner(input);
//        System.out.println(scanner.nextInt());
//        System.out.println(scanner.nextInt());

        int a = scanner.nextInt();
        int b = scanner.nextInt();

//        scanner.close();

        Assert.assertEquals(1, a);
        Assert.assertEquals(2, b);

    }

    @Test
    public void testWithAutoClose() {
        String input = "1 2";
        try(Scanner scanner = new Scanner(input)) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            Assert.assertEquals(1, a);
            Assert.assertEquals(2, b);
        }

        System.out.println("        scanner.close(); is called after \"try\" key word");
    }
}

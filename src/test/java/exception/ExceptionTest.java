package exception;

import org.junit.Assert;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionTest {

    /**
     * line separator windows: \r\n
     * the stack trace output varies from versions of JDK
     */
    //todo: java 8, 11 issue
//    @Test
//    public void testExceptionToString() {
//        try {
//            int[] a = new int[1];
//            a[5] = 444;
//        } catch (Exception e) {
//            Assert.assertEquals("java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 1", e.toString());
//
//            StringWriter stringWriter = new StringWriter();
//            e.printStackTrace(new PrintWriter(stringWriter));
//            Assert.assertTrue(stringWriter.toString().contains("java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 1"));
//        }
//    }

    @Test
    public void testCloneException() {
        try {
            throw new CloneNotSupportedException("");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

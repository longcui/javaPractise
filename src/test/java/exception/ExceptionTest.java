package exception;

import org.junit.Assert;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionTest {

    /**
     * line separator windows: \r\n
     */
    @Test
    public void testExceptionToString() {
        try {
            int[] a = new int[1];
            a[5] = 5;
        } catch (Exception e) {
            Assert.assertEquals("java.lang.ArrayIndexOutOfBoundsException: 5", e.toString());

            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            Assert.assertEquals("java.lang.ArrayIndexOutOfBoundsException: 5\r\n" +
                    "\tat exception.ExceptionTest.testExceptionToString(ExceptionTest.java:15)\r\n" +
                    "\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n" +
                    "\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n" +
                    "\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n" +
                    "\tat java.base/java.lang.reflect.Method.invoke(Method.java:564)\r\n" +
                    "\tat org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)\r\n" +
                    "\tat org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)\r\n" +
                    "\tat org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)\r\n" +
                    "\tat org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)\r\n" +
                    "\tat org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)\r\n" +
                    "\tat org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)\r\n" +
                    "\tat org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)\r\n" +
                    "\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n" +
                    "\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n" +
                    "\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n" +
                    "\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n" +
                    "\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n" +
                    "\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n" +
                    "\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\r\n" +
                    "\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\r\n" +
                    "\tat com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)\r\n" +
                    "\tat com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)\r\n" +
                    "\tat com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)\r\n", stringWriter.toString());
        }
    }
}

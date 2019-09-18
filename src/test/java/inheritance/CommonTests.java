package inheritance;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by geir on 14/08/2017.
 */
public abstract class CommonTests {

    String s;

    @Before
    public abstract void setup();

    @Test
    public void commonTest() {
        System.out.println("Common with " + s);
    }
    @Test
    public void commonTest2() {
        System.out.println("Common2 with " + s);
    }
}

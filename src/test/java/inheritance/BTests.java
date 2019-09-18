package inheritance;

import org.junit.Test;

/**
 * Created by geir on 14/08/2017.
 */
public class BTests extends CommonTests {

    @Override
    public void setup() {
        s = "config B";
    }

    @Test
    public void b() {
        System.out.println("Special B with " + s);
    }
}

package inheritance;

import org.junit.Test;

/**
 * Created by geir on 14/08/2017.
 */
public class ATests extends CommonTests {

    @Override
    public void setup() {
        s = "config A";
    }

    @Test
    public void specialA(){
        System.out.println("Special A with " + s);
    }
}

import org.junit.Test;

public class RandomNumberGeneratorTest {

    @Test
    public void test() {
        for (int i = 0; i < 8; i++) {
            System.out.println(Math.random() * 0.001);
        }
    }
}

import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class NormalTest {
    @Test
    public void testPassByValue() {
        double[] changed = new double[2];
        changed[0] = 1;
        changeMe(changed);
        Assert.assertEquals(11, changed[0], 0.1);
    }

    private void changeMe(double[] changed) {
        changed[0] = 11;
    }

    @Test
    public void testTwoDimensionArray() {
        double[][] a = new double[2][3];
        Assert.assertEquals(2, a.length);
        Assert.assertEquals(6, a.length  * a[0].length);
    }

    /**
     * %n Platform-specific line separator.
     */
    @Test
    public void testStringFormat() {
        String output = String.format("%s = %d", "joe", 35);
        Assert.assertEquals("joe = 35", output);
    }

    //todo: why
    @Test
    public void testString() throws UnsupportedEncodingException {
        String chinese = "中国人";
        Assert.assertEquals("中国人", chinese);
        String encoded = Base64.getEncoder().encodeToString(chinese.getBytes());
        Assert.assertEquals("5Lit5Zu95Lq6", encoded);
        Assert.assertEquals("中国人", new String(Base64.getDecoder().decode(encoded.getBytes())));

        byte[] bytes = chinese.getBytes("utf-16");
        encoded = Base64.getEncoder().encodeToString(bytes);
        Assert.assertEquals("/v9OLVb9Tro=", encoded);
        byte[] bytesUtf16 = encoded.getBytes("utf-8");
        Assert.assertEquals("中国人", new String(Base64.getDecoder().decode(bytesUtf16), "utf-16"));
    }

    @Test
    public void testEqual() {
        Rectangle rect1 = new Rectangle();
        rect1.setWidth(1);
        rect1.setHeight(2);
        Rectangle rect2 = new Rectangle();
        rect2.setWidth(1);
        rect2.setHeight(2);
        Set<Rectangle> set = new HashSet<>();
        set.add(rect1);
        System.out.println(set.contains(rect1));     // truemap
        System.out.println(set.contains(rect2));     // true
        rect1.setWidth(5);
        System.out.println(rect1.hashCode());
        set.forEach(rectangle -> System.out.println(rectangle.hashCode()));
        System.out.println(set.contains(rect1));     // false
        System.out.println(set.contains(rect2));     // false
    }


    @Test
    public void testIntInteger() {
        int a = 5;
        Integer A = 5;
        Assert.assertTrue(A.equals(a));

    }

    public class Rectangle {
        private double width;
        private double height;
        public double getWidth() {
            return width;
        }
        public void setWidth(double width) {
            this.width = width;
        }
        public double getHeight() {
            return height;
        }
        public void setHeight(double height) {
            this.height = height;
        }        @Override
        public int hashCode() {
            return (int) width + 13 * (int) height;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Rectangle)) {
                return false;
            }
            Rectangle other = (Rectangle) obj;
            return other.width == width && other.height == height;
        }
    }
}

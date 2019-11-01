package javaCoreTest;

import org.junit.Assert;
import org.junit.Test;

public class ClassExample {

    @Test
    public void testClassName() {
        Assert.assertEquals("ClassExample", this.getClass().getSimpleName());
        Assert.assertEquals("javaCoreTest.ClassExample", this.getClass().getName());
        Assert.assertEquals("javaCoreTest.ClassExample", this.getClass().getCanonicalName());
    }
}

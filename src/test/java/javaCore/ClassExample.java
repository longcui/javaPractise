package javaCore;

import org.junit.Assert;
import org.junit.Test;

public class ClassExample {

    @Test
    public void testClassName() {
        Assert.assertEquals("ClassExample", this.getClass().getSimpleName());
        Assert.assertEquals("javaCore.ClassExample", this.getClass().getName());
        Assert.assertEquals("javaCore.ClassExample", this.getClass().getCanonicalName());
    }
}

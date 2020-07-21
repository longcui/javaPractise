package competition.hackerrank;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedStringTest {

    @Test
    void repeatedString() {
        Assert.assertEquals(7, RepeatedString.repeatedString("aba", 10));
        Assert.assertEquals(1000000000000L, RepeatedString.repeatedString("a", 1000000000000L));
        Assert.assertEquals(51574523448L, RepeatedString.repeatedString("kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm", 736778906400L));
    }
}
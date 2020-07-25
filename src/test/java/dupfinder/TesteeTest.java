package dupfinder;

import org.junit.Assert;
import org.junit.Test;

public class TesteeTest {
    @Test
    public void power2_test() {
        Assert.assertEquals(4, Testee.power2(2));
        Assert.assertEquals(9, Testee.power2(3));
    }
}
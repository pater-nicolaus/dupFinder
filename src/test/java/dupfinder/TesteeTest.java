package dupfinder;

import org.junit.Assert;
import org.junit.Test;

public class TesteeTest {
    @Test
    public void power2_test() {
        Assert.assertEquals(4, Testee.power2(2));
        Assert.assertEquals(9, Testee.power2(3));
    }
    public void power3_test() {
        Assert.assertEquals(8, Testee.power3(2));
        Assert.assertEquals(27, Testee.power3(3));
    }
}
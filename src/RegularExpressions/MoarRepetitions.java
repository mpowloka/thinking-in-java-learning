package RegularExpressions;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

public class MoarRepetitions {

    // last symbol has to appear 5 times - no more no less
    Pattern pattern1 = Pattern.compile("kek{5}");

    @Test
    public void test1 () {
        Assert.assertTrue(pattern1.matcher("kekkkkk").matches());
    }
    @Test
    public void test2 () {
        Assert.assertFalse(pattern1.matcher("kek").matches());
    }
    @Test
    public void test3 () {
        Assert.assertFalse(pattern1.matcher("ke").matches());
    }
    @Test
    public void test4 () {
        Assert.assertFalse(pattern1.matcher("kekkkkkkkkkkk").matches());
    }

    // last symbol has to appear 5 times or more
    Pattern pattern2 = Pattern.compile("ARGH{3,}");

    @Test
    public void test5 () {
        Assert.assertTrue(pattern2.matcher("ARGHHHHH").matches());
    }
    @Test
    public void test6 () {
        Assert.assertTrue(pattern2.matcher("ARGHHH").matches());
    }
    @Test
    public void test7 () {
        Assert.assertFalse(pattern2.matcher("ARGH").matches());
    }
    @Test
    public void test8 () {
        Assert.assertFalse(pattern2.matcher("ARGHH").matches());
    }

    // 'L' symbol has to appear 2-4 times
    Pattern pattern3 = Pattern.compile("BAL{2,4}ANCE");

    @Test
    public void test9 () {
        Assert.assertTrue(pattern3.matcher("BALLANCE").matches());
    }
    @Test
    public void test10 () {
        Assert.assertTrue(pattern3.matcher("BALLLANCE").matches());
    }
    @Test
    public void test11 () {
        Assert.assertTrue(pattern3.matcher("BALLLLANCE").matches());
    }
    @Test
    public void test12 () {
        Assert.assertFalse(pattern3.matcher("BALANCE").matches());
    }
}

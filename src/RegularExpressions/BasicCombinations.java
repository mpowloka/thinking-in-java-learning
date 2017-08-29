package RegularExpressions;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

public class BasicCombinations {

    Pattern emailAdress = Pattern.compile(".+@.+\\..{2,3}");

    @Test
    public void test1 () {
        Assert.assertTrue(emailAdress.matcher("michalpowloka@gmail.com").matches());
    }
    @Test
    public void test2 () {
        Assert.assertTrue(emailAdress.matcher("michalpowloka@interia.pl").matches());
    }
    @Test
    public void test3 () {
        Assert.assertTrue(emailAdress.matcher("I realize that will not check if email actually exists@I really do!.lol").matches());
    }
    @Test
    public void test4 () {
        Assert.assertFalse(emailAdress.matcher("Now method return false, because I have forgotten to put ap .com").matches());
    }

    Pattern date = Pattern.compile("[0-9]{4}\\.[0-9]{2}\\.[0-9]{2}");

    @Test
    public void test5 () {
        Assert.assertTrue(date.matcher("2017.08.23").matches());
    }
    @Test
    public void test6 () {
        Assert.assertTrue(date.matcher("0000.00.00").matches());
    }
    @Test
    public void test7 () {
        Assert.assertFalse(date.matcher("201.07.45").matches());
    }
    @Test
    public void test8 () {
        Assert.assertFalse(date.matcher("2056.16.5c").matches());
    }
}

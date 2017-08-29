package RegularExpressions;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

public class Repetitions {

    @Test
    public void test1() {
        Pattern pattern = Pattern.compile("my?man");
        Assert.assertFalse(pattern.matcher("yman").matches());

    }
    @Test
    public void test2 () {
        Pattern pattern = Pattern.compile("my?man");
        Assert.assertFalse(pattern.matcher("man").matches());
    }
    @Test
    public void test3 () {
        Pattern pattern = Pattern.compile("my?man");
        Assert.assertTrue(pattern.matcher("mman").matches());
    }




    @Test
    public void test4 () {
        Pattern pattern = Pattern.compile("ra*mpage!");
        Assert.assertTrue(pattern.matcher("raaaaaaaaaaampage!").matches());
    }
    @Test
    public void test5 () {
        Pattern pattern = Pattern.compile("ra*mpage!");
        Assert.assertTrue(pattern.matcher("rmpage!").matches());
    }
    @Test
    public void test6 () {
        Pattern pattern = Pattern.compile("ra*mpage!");
        Assert.assertTrue(pattern.matcher("rampage!").matches());
    }
    @Test
    public void test7 () {
        Pattern pattern = Pattern.compile("ra*mpage!");
        Assert.assertFalse(pattern.matcher("raampaaaaaaaage!").matches());
    }




    @Test
    public void test8 () {
        Pattern pattern = Pattern.compile("z+");
        Assert.assertTrue(pattern.matcher("z").matches());
    }
    @Test
    public void test9 () {
        Pattern pattern = Pattern.compile("z+");
        Assert.assertTrue(pattern.matcher("zzzzzzzzzzz").matches());
    }
    @Test
    public void test10 () {
        Pattern pattern = Pattern.compile("z+");
        Assert.assertFalse(pattern.matcher("").matches());
    }

}

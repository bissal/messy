package io.github.bissal.messy.tests.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 4our6ix on 2016. 3. 17..
 */
public class StringConcatTest {
    @Test
    public void testConcat() {
        // given
        String kiwi = "kiwi";
        String banana = "banana";
        String kiwiBanana = "kiwibanana";

        // when
        String result = kiwi.concat(banana);

        // then
        Assert.assertEquals(kiwiBanana, result);
    }
}

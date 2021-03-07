package jpass.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilsTest {


    @Test
    public void shouldReturnNullWithNullInputTest(){

        String result = StringUtils.stripNonValidXMLCharacters(null);

        assertEquals(null,result);
    }

    @Test
    public void shouldReturnEmptyStringWithNullInputTest(){

        String result = StringUtils.stripNonValidXMLCharacters(" ");

        assertEquals(" ",result);
    }

    @Test
    public void shouldStripNonValidChars(){

        char invalidChar = 0xD810;
        String input = Character.toString(invalidChar);
        input += "1234";

        String result = StringUtils.stripNonValidXMLCharacters(input);

        assertEquals("?1234",result);
    }

    @Test
    public void shouldNotStripValidChars(){

        char validChar = 0xE000;
        String input = Character.toString(validChar);
        input += "1234";

        String result = StringUtils.stripNonValidXMLCharacters(input);

        assertEquals("\uE0001234",result);
    }
}

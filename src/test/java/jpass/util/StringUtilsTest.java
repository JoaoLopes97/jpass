package jpass.util;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtilsTest {

	// Lenght = 0
	@Test
	public void testeStripStringLenght0String10() {

		int length0 =  0;
		String stringEqqual10Char = "Teste da f...";

		String expectedResult = "Teste da f...";
		String resultFunction = StringUtils.stripString(stringEqqual10Char, length0);

		assertEquals(expectedResult, resultFunction);
	}

	@Test
	public void testeStripStringLenght0String0() {

		int length0 =  0;
		String string0Char = "";

		String expectedResult = "";
		String resultFunction = StringUtils.stripString(string0Char, length0);

		assertEquals(expectedResult, resultFunction);
	}

	// Lenght = 10
	@Test
	public void testeStripStringLenght10String10() {

		int length10 = 10;
		String stringEqqual10Char = "Teste da f...";

		String expectedResult = "Teste da f";
		String resultFunction = StringUtils.stripString(stringEqqual10Char, length10);

		assertEquals(expectedResult, resultFunction);
	}

	@Test
	public void testeStripStringLenght10StringLess10() {

		int length10 = 10;
		String stringLess10Char = "Teste";

		String expectedResult = "Teste";
		String resultFunction = StringUtils.stripString(stringLess10Char, length10);

		assertEquals(expectedResult, resultFunction);
	}

	@Test
	public void testeStripStringLenght10StringBigger10() {

		int length10 = 10;
		String stringBigger10Char = "Teste da fun��o com mais de 10 caracteres.";

		String expectedResult = "Teste da f...";
		String resultFunction = StringUtils.stripString(stringBigger10Char, length10);

		assertEquals(expectedResult, resultFunction);
	}

	// Lenght = 10
	@Test
	public void testeStripStringLenght_2String10() {

		int length_2 = -2;
		String stringEqqual10Char = "Teste da f...";

		String expectedResult = "Teste da f";
		String resultFunction = StringUtils.stripString(stringEqqual10Char, length_2);

		assertEquals(expectedResult, resultFunction);
	}

	@Test
	public void testeStripStringNull() {

		int length10 = 10;
		String stringNull = null;

		String expectedResult = null;
		String resultFunction = StringUtils.stripString(stringNull, length10);

		assertEquals(expectedResult, resultFunction);
	}




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

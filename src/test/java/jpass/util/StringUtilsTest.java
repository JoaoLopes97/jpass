package jpass.util;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtilsTest {

	//region ASSIGNMENT 1

	// Length = 0
	@Test
	public void StripStringLength0String10Test() {

		int length0 =  0;
		String stringEqqual10Char = "Teste da f...";

		String expectedResult = "Teste da f...";
		String resultFunction = StringUtils.stripString(stringEqqual10Char, length0);

		assertEquals(expectedResult, resultFunction);
	}

	@Test
	public void StripStringLength0String0Test() {

		int length0 =  0;
		String string0Char = "";

		String expectedResult = "";
		String resultFunction = StringUtils.stripString(string0Char, length0);

		assertEquals(expectedResult, resultFunction);
	}

	// Length = 10
	@Test
	public void StripStringLength10String10Test() {

		int length10 = 10;
		String stringEqqual10Char = "Teste da f...";

		String expectedResult = "Teste da f";
		String resultFunction = StringUtils.stripString(stringEqqual10Char, length10);

		assertEquals(expectedResult, resultFunction);
	}

	@Test
	public void StripStringLength10StringLess10Test() {

		int length10 = 10;
		String stringLess10Char = "Teste";

		String expectedResult = "Teste";
		String resultFunction = StringUtils.stripString(stringLess10Char, length10);

		assertEquals(expectedResult, resultFunction);
	}

	@Test
	public void StripStringLength10StringBigger10Test() {

		int length10 = 10;
		String stringBigger10Char = "Teste da fun��o com mais de 10 caracteres.";

		String expectedResult = "Teste da f...";
		String resultFunction = StringUtils.stripString(stringBigger10Char, length10);

		assertEquals(expectedResult, resultFunction);
	}

	// Length = 10
	@Test
	public void StripStringLength_2String10Test() {

		int length_2 = -2;
		String stringEqqual10Char = "Teste da f...";

		String expectedResult = "Teste da f";
		String resultFunction = StringUtils.stripString(stringEqqual10Char, length_2);

		assertEquals(expectedResult, resultFunction);
	}

	@Test
	public void StripStringNullTest() {

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
    //endregion

	//region ASSIGNMENT 2

	//endregion
}

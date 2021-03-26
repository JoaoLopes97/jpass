package jpass.util;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtilsTest {

	//region ASSIGNMENT 1

	// Length = 0
	@Test
	public void StripStringLength0String10Test() {

		int length0 =  0;
		String stringEqqual10Char = "Teste da f";

		String expectedResult = "...";
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
		String stringEqqual10Char = "Teste da f";

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
	@Test(expected = StringIndexOutOfBoundsException.class)
	public void StripStringLength_2String10Test() {

		int length_2 = -2;
		String stringEqqual10Char = "Teste da f";

		String expectedResult = "Teste da f...";
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
    
 // Lenght = 0	
 	@Test
 	public void stripStringLenght0StringCharTest() {

 		int length = 0;
 		String string = "Testedafun�";

 		String expectedResult = "...";
 		String resultFunction = StringUtils.stripString(string, length);

 		assertEquals(expectedResult, resultFunction);
 	}

 	@Test
 	public void stripStringLenght0StringNumberTest() {

 		int length = 0;
 		String string = "12345678910";

 		String expectedResult = "...";
 		String resultFunction = StringUtils.stripString(string, length);

 		assertEquals(expectedResult, resultFunction);
 	}

 	@Test
 	public void stripStringLenght0StringNumberCharTest() {

 		int length = 0;
 		String string = "Teste12fun�";

 		String expectedResult = "...";
 		String resultFunction = StringUtils.stripString(string, length);

 		assertEquals(expectedResult, resultFunction);
 	}

 	// Lenght = 1
 	@Test
 	public void stripStringLenght1StringCharTest() {

 		int length = 1;
 		String string = "Testedafun�";

 		String expectedResult = "T...";
 		String resultFunction = StringUtils.stripString(string, length);

 		assertEquals(expectedResult, resultFunction);
 	}

 	@Test
 	public void stripStringLenght1StringNumberTest() {

 		int length = 1;
 		String string = "12345678910";

 		String expectedResult = "1...";
 		String resultFunction = StringUtils.stripString(string, length);

 		assertEquals(expectedResult, resultFunction);
 	}

 	@Test
 	public void stripStringLenght1StringNumberCharTest() {

 		int length = 1;
 		String string = "Teste12fun�";

 		String expectedResult = "T...";
 		String resultFunction = StringUtils.stripString(string, length);

 		assertEquals(expectedResult, resultFunction);
 	}

 	// Lenght = 9
 	@Test
 	public void stripStringLenght9StringCharTest() {

 		int length = 9;
 		String string = "Testedafun�";

 		String expectedResult = "Testedafu...";
 		String resultFunction = StringUtils.stripString(string, length);

 		assertEquals(expectedResult, resultFunction);
 	}

 	@Test
 	public void stripStringLenght9StringNumberTest() {

 		int length = 9;
 		String string = "12345678910";

 		String expectedResult = "123456789...";
 		String resultFunction = StringUtils.stripString(string, length);

 		assertEquals(expectedResult, resultFunction);
 	}

 	@Test
 	public void stripStringLenght9StringNumberCharTest() {

 		int length = 9;
 		String string = "Teste12fun�";

 		String expectedResult = "Teste12fu...";
 		String resultFunction = StringUtils.stripString(string, length);

 		assertEquals(expectedResult, resultFunction);
 	}

 	// Lenght = 10
 	@Test
 	public void stripStringLenght10StringCharTest() {

 		int length = 10;
 		String string = "Testedafun�";

 		String expectedResult = "Testedafun...";
 		String resultFunction = StringUtils.stripString(string, length);

 		assertEquals(expectedResult, resultFunction);
 	}

 	@Test
 	public void stripStringLenght10StringNumberTest() {

 		int length = 10;
 		String string = "12345678910";

 		String expectedResult = "1234567891...";
 		String resultFunction = StringUtils.stripString(string, length);

 		assertEquals(expectedResult, resultFunction);
 	}

 	@Test
 	public void stripStringLenght10StringNumberCharTest() {

 		int length = 10;
 		String string = "Teste12fun�";

 		String expectedResult = "Teste12fun...";
 		String resultFunction = StringUtils.stripString(string, length);

 		assertEquals(expectedResult, resultFunction);
 	}

 	// Lenght = 11
 /*	@Test
 	public void stripStringLenght11StringCharTest() {

 		int length = 11;
 		String string = "Testedafun�";

 		String expectedResult = "Testedafun�";
 		String resultFunction = StringUtils.stripString(string, length);

 		assertEquals(expectedResult, resultFunction);
 	}*/

 	@Test
 	public void stripStringLenght11StringNumberTest() {

 		int length = 11;
 		String string = "12345678910";

 		String expectedResult = "12345678910";
 		String resultFunction = StringUtils.stripString(string, length);

 		assertEquals(expectedResult, resultFunction);
 	}

 /*	@Test
 	public void stripStringLenght11StringNumberCharTest() {

 		int length = 11;
 		String string = "Teste12fun�";

 		String expectedResult = "Teste12fun�";
 		String resultFunction = StringUtils.stripString(string, length);

 		assertEquals(expectedResult, resultFunction);
 	}*/
 	
/* 	@Test
 	public void nullStripNonValidXMLCharactersTest() {

 		String string = null;

 		String expectedResult = "";
 		String resultFunction = StringUtils.stripNonValidXMLCharacters(string);

 		assertEquals(expectedResult, resultFunction);
 	}*/
 	
 	@Test
 	public void emptyStripNonValidXMLCharactersTest() {

 		String string = "";

 		String expectedResult = "";
 		String resultFunction = StringUtils.stripNonValidXMLCharacters(string);

 		assertEquals(expectedResult, resultFunction);
 	}
 	
 	@Test
 	public void string1CharStripNonValidXMLCharactersTest() {

 		char validChar = 0X20;
        String input = Character.toString(validChar);

 		String expectedResult = " ";
 		String resultFunction = StringUtils.stripNonValidXMLCharacters(input);

 		assertEquals(expectedResult, resultFunction);
 	}

 	// endregion

	//region ASSIGNMENT 5

	@Test
	public void stripStringTest() {

		String string = "Teste";

		String expectedResult = "Teste";
		String resultFunction = StringUtils.stripString(string);

		assertEquals(expectedResult, resultFunction);
	}

	@Test
	public void shouldNotStripValid2Chars(){

		char validChar = 0x9;
		String input = Character.toString(validChar);
		input += "1234";

		String result = StringUtils.stripNonValidXMLCharacters(input);

		assertEquals("\t1234",result);
	}

	@Test
	public void shouldNotStripValid3Chars(){

		char validChar = 0xA;
		String input = Character.toString(validChar);
		input += "1234";

		String result = StringUtils.stripNonValidXMLCharacters(input);

		assertEquals("\n1234",result);
	}

	@Test
	public void shouldNotStripValid4Chars(){

		char validChar = 0xD;
		String input = Character.toString(validChar);
		input += "1234";

		String result = StringUtils.stripNonValidXMLCharacters(input);

		assertEquals("\r1234",result);
	}
	@Test
	public void shouldNotStripValid5Chars(){

		char validChar = 0x20;
		String input = Character.toString(validChar);
		input += "1234";

		String result = StringUtils.stripNonValidXMLCharacters(input);

		assertEquals(" 1234",result);
	}

	@Test
	public void shouldNotStripValid6Chars(){

		char validChar = 0xD7FF;
		String input = Character.toString(validChar);
		input += "1234";

		String result = StringUtils.stripNonValidXMLCharacters(input);

		assertEquals("\uD7FF1234",result);
	}

	@Test
	public void shouldNotStripValid7Chars(){

		char validChar = 0xFFFD;
		String input = Character.toString(validChar);
		input += "1234";

		String result = StringUtils.stripNonValidXMLCharacters(input);

		assertEquals("\uFFFD1234",result);
	}
	//endregion
}

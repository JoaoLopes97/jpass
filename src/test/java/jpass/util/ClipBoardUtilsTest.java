package jpass.util;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ClipBoardUtilsTest {

	//region ASSIGNMENT 1

	@Test
	public void ClipBoardContentCorrectTest() throws Exception {
		
		String stringContent = "Novo conteudo!!";
		String expectedResult =  "Novo conteudo!!";

		ClipboardUtils.setClipboardContent(stringContent);

		assertEquals(expectedResult, ClipboardUtils.getClipboardContent());
	}

	@Test
	public void ClipBoardContentNullTest() throws Exception {
		
		String stringContent = null;
		String expectedResult =  null;
		
		ClipboardUtils.setClipboardContent(stringContent);

		assertEquals(expectedResult, ClipboardUtils.getClipboardContent());
	}
	
	@Test
	public void ClipBoardContentEmptyTest() throws Exception {
		
		String stringContent = "";
		String expectedResult =  null;
		
		ClipboardUtils.setClipboardContent(stringContent);
		
		assertEquals(expectedResult, ClipboardUtils.getClipboardContent());
	}

	//endregion

	//region ASSIGNMENT 2

	@Test
	public void ClipBoardContentStringLength0Test() throws Exception {

		String stringContent = "";

		ClipboardUtils.setClipboardContent(stringContent);

		assertEquals(null, ClipboardUtils.getClipboardContent());
	}

	@Test
	public void ClipBoardContentStringLength1Test() throws Exception {

		String stringContent = "T";
		String expectedResult = "T";

		ClipboardUtils.setClipboardContent(stringContent);

		assertEquals(expectedResult, ClipboardUtils.getClipboardContent());
	}

	@Test
	public void ClipBoardContentStringWithCharsBelow32Test() throws Exception {

		char invalidChar = 0x19; // Decimal value 31
		String stringContent = Character.toString(invalidChar);
		stringContent += "1234";
		String expectedResult = stringContent;

		ClipboardUtils.setClipboardContent(stringContent);

		assertEquals(expectedResult, ClipboardUtils.getClipboardContent());
	}

	@Test
	public void ClipBoardContentStringWithCharsEqual32Test() throws Exception {

		char validChar = 0x20; // Decimal value 32
		String stringContent = Character.toString(validChar);
		stringContent += "1234";
		String expectedResult = " 1234";

		ClipboardUtils.setClipboardContent(stringContent);

		assertEquals(expectedResult, ClipboardUtils.getClipboardContent());
	}

	@Test
	public void ClipBoardContentStringWithCharsEqual127Test() throws Exception {

		char invalidChar = 0x7f; // Decimal value 31
		String stringContent = Character.toString(invalidChar);
		stringContent += "1234";
		String expectedResult = stringContent;

		ClipboardUtils.setClipboardContent(stringContent);

		assertEquals(expectedResult, ClipboardUtils.getClipboardContent());
	}

	@Test
	public void ClipBoardContentStringWithCharsHigher127Test() throws Exception {

		char validChar = 0x80; // Decimal value 32
		String stringContent = Character.toString(validChar);
		stringContent += "1234";
		String expectedResult = stringContent;

		ClipboardUtils.setClipboardContent(stringContent);

		assertEquals(expectedResult, ClipboardUtils.getClipboardContent());
	}
	//endregion

	//region ASSIGNMENT 5

	@Test
	public void clipboardTest(){

	}

	//endregion
}

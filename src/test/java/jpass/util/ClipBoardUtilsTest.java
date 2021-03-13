package jpass.util;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

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

	//endregion

}

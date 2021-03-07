package jpass.util;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ClipBoardUtilsTest {

	@Test
	public void testeClipBoardContentCorrect() throws Exception {
		
		String stringContent = "Novo conteudo!!";
		String expectedResult =  "Novo conteudo!!";
		
		ClipboardUtils.setClipboardContent(stringContent);
		
		assertEquals(expectedResult, ClipboardUtils.getClipboardContent());
	}
	
	@Test
	public void testeClipBoardContentIncorrect() throws Exception {
		
		String stringContent = "Novo conteudo!!";
		String expectedResult =  "Novo conteudo!!";
		
		ClipboardUtils.setClipboardContent(stringContent);
		
		assertEquals(expectedResult, ClipboardUtils.getClipboardContent());
	}
	
	@Test
	public void testeClipBoardContentNull() throws Exception {
		
		String stringContent = null;
		String expectedResult =  null;
		
		ClipboardUtils.setClipboardContent(stringContent);
		
		assertEquals(expectedResult, ClipboardUtils.getClipboardContent());
	}
	
	@Test
	public void testeClipBoardContentEmpty() throws Exception {
		
		String stringContent = "";
		String expectedResult =  null;
		
		ClipboardUtils.setClipboardContent(stringContent);
		
		assertEquals(expectedResult, ClipboardUtils.getClipboardContent());
	}

}

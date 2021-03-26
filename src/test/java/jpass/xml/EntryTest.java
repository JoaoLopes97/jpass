package jpass.xml;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.junit.Before;
import org.junit.Test;

import jpass.xml.bind.Entry;

public class EntryTest {
	
	private Entry entry;
	private String now;

	@Before 
	public void initialize() {
		entry = new Entry();
		now = LocalDateTime.now()
	            .truncatedTo(ChronoUnit.SECONDS)
	            .format(DateTimeFormatter.ISO_DATE_TIME);
	}
	
	@Test
	public void titleTest() {
		
		String title = "String";
		entry.setTitle(title);
		
		assertEquals(entry.getTitle(), title);
	}
	
	@Test
	public void urlTest() {
		
		String url = "String";
		entry.setUrl(url);
		
		assertEquals(entry.getUrl(), url);
		
	}
	
	@Test
	public void userTest() {		

		String user = "String";
		entry.setUser(user);
		
		assertEquals(entry.getUser(), user);
	}
	
	@Test
	public void passwordTest() {

		String password = "String";
		entry.setPassword(password);
		
		assertEquals(entry.getPassword(), password);
	}
	
	@Test
	public void notesTest() {

		String notes = "String";
		entry.setNotes(notes);
		
		assertEquals(entry.getNotes(), notes);
	}
	
	@Test
	public void creationDateTest() {

		String creationDate = "String";
		entry.setCreationDate(creationDate);
		
		assertEquals(entry.getCreationDate(), creationDate);
	}
	
	@Test
	public void lastModificationTest() {
		assertEquals(entry.getLastModification(), now);
	}

}

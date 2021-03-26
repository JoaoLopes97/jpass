package jpass.data;

import jpass.xml.bind.Entries;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.*;


public class EntriesRepositoryTest {

    @Test
    public void shouldFormatValidFormatTest(){
        String fileName = "Name";
        EntriesRepository result = EntriesRepository.newInstance(fileName);

        assertNotNull(result);
    }

    @Test
    public void shouldFormatValidFormatSecondConstructorTest(){
        String fileName = "Name";

        byte[] key = new byte[32];
        Random rnd = new Random();
        rnd.nextBytes(key);

        EntriesRepository result = EntriesRepository.newInstance(fileName,key);

        assertNotNull(result);
    }


    @Test(expected = DocumentProcessException.class)
    public void readDocumentShouldReturnFileExceptionTest() throws IOException, DocumentProcessException {

        String fileName = null;

        EntriesRepository result = EntriesRepository.newInstance(fileName);
        Entries entries = result.readDocument();

    }

    @Test(expected = Exception.class)
    public void readDocumentShouldReturnFileInputStreamTest() throws IOException, DocumentProcessException {

        String fileName = "Name";

        byte[] key = new byte[32];
        Random rnd = new Random();
        rnd.nextBytes(key);

        EntriesRepository result = EntriesRepository.newInstance(fileName,key);
        Entries entries = result.readDocument();

    }
    @Test
    public void readDocumentShouldReturnTest() throws IOException, DocumentProcessException {

        String fileName = "Name";

        EntriesRepository result = EntriesRepository.newInstance(fileName);
        Entries entries = result.readDocument();

    }

    @Test(expected = FileNotFoundException.class)
    public void readDocumentShouldReturnFileNotFoundExceptionTest() throws IOException, DocumentProcessException {

        String fileName = "NameTest";

        EntriesRepository result = EntriesRepository.newInstance(fileName);
        Entries entries = result.readDocument();

    }

    @Test
    public void writeDocumentShouldReturnFileNotFoundExceptionTest() throws IOException, DocumentProcessException {

        String fileName = "NameLOLOL";
        EntriesRepository result = EntriesRepository.newInstance(fileName);
        result.writeDocument(null);
    }

    @Test
    public void writeDocumentShouldReturnTest() throws IOException, DocumentProcessException {

        String fileName = "NameLOLOL";
        byte[] key = new byte[32];
        Random rnd = new Random();
        rnd.nextBytes(key);

        EntriesRepository result = EntriesRepository.newInstance(fileName,key);
        result.writeDocument(null);
    }

    @Test(expected = DocumentProcessException.class)
    public void writeDocumentShouldReturnlTest() throws IOException, DocumentProcessException {

        String fileName = null;
        byte[] key = new byte[32];
        Random rnd = new Random();
        rnd.nextBytes(key);

        EntriesRepository result = EntriesRepository.newInstance(fileName);
        result.writeDocument(null);

    }
}
package jpass.data;

import jpass.xml.bind.Entries;
import jpass.xml.bind.Entry;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DataModelTest {
    public DataModel dataModel;

    @Before
    public void Setup() {
        dataModel = DataModel.getInstance();
        dataModel.clear();
        dataModel.setFileName("File");

        Entry entry = new Entry();
        entry.setTitle("EntryTest");
        entry.setUser("UserTest");
        dataModel.getEntries().getEntry().add(entry);

        byte[] pass = new byte[]{'t', 'e', 's', 't'};
        dataModel.setPassword(pass);
    }

    @Test
    public void GetEntriesTest() {
        assertEquals(1, dataModel.getEntries().getEntry().size());
    }

    @Test
    public void SetEntriesTest() {
        Entries entries = new Entries();
        Entry entry = new Entry();
        entry.setTitle("EntryTest");
        entry.setUser("UserTest");
        Entry entry2 = new Entry();

        entries.getEntry().add(entry);
        entries.getEntry().add(entry2);

        dataModel.setEntries(entries);

        assertEquals(2, dataModel.getEntries().getEntry().size());
    }

    @Test
    public void GetFileNameTest() {
        String expectedResult = "File";
        assertEquals(expectedResult, dataModel.getFileName());
    }

    @Test
    public void SetFileNameTest() {
        dataModel.setFileName("NewFile");
        String expectedResult = "NewFile";
        assertEquals(expectedResult, dataModel.getFileName());
    }

    @Test
    public void IsModifiedTest() {
        Boolean expectedResult = false;
        assertEquals(expectedResult, dataModel.isModified());
    }

    @Test
    public void SetModifiedTest() {
        dataModel.setModified(true);
        Boolean expectedResult = true;
        assertEquals(expectedResult, dataModel.isModified());
    }

    @Test
    public void GetPasswordTest() {
        assertNotNull(dataModel.getPassword());
    }

    @Test
    public void SetPasswordTest() {
        byte[] previousPassword = dataModel.getPassword();
        dataModel.setPassword(new byte[]{'t', 'e', 's', 't','s'});

        assertNotEquals(previousPassword, dataModel.getPassword());
    }

    @Test
    public void ClearTest() {
        dataModel.clear();

        assertEquals(null, dataModel.getPassword());
    }

    @Test
    public void GetTitlesTest() {
        List<String> result = dataModel.getTitles();
        assertNotNull("EntryTest",result.get(0));
    }

    @Test
    public void GetEntryByTitleTest() {
        Entry result = dataModel.getEntryByTitle("EntryTest");
        assertNotNull("UserTest",result.getUser());
    }

    @Test
    public void GetEntryByTitleInvalidTitleTest() {
        Entry result = dataModel.getEntryByTitle("EntryT");
        assertNull(result);
    }
}

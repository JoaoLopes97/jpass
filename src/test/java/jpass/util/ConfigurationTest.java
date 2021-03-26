package jpass.util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConfigurationTest {

    public Configuration configuration;
    @Before
    public void setUp(){
        configuration = Configuration.getInstance();
    }

    @Test
    public void ConfigurationIsDarkModeEnabledTest(){

        Boolean result = configuration.is("ui.theme.dark.mode.enabled",false);

        assertFalse(result);
    }
    @Test
    public void ConfigurationGetIntegerClearClipboardOnExitWrongConfigTest(){

        Integer result = configuration.getInteger("clear.clipboard.on.exit.enabled",0);

        assertSame(0,result);
    }

    @Test
    public void ConfigurationIsDefaultPasswordGenerationNullConfigTest(){

        Boolean result = configuration.is("default.password.generation.size",false);

        assertSame(false,result);
    }

    @Test
    public void ConfigurationGetDateFormatTest(){

        String result = configuration.get("date.format","yyyy-MM-dd");

        assertEquals("yyyy-MM-dd",result);
    }

    @Test
    public void ConfigurationGetArrayEntryDetailsTest(){

        String[] defaultValue = new String[]{"TITLE", "MODIFIED"};
        String[] result = configuration.getArray("entry.details",defaultValue);

        assertSame(defaultValue.length,result.length);
    }

    @Test
    public void ConfigurationGetArrayEntryDetailsWrongKeyTest(){

        String[] defaultValue = new String[]{"TITLE", "MODIFIED"};
        String[] result = configuration.getArray("entry.detail",defaultValue);

        assertSame(defaultValue.length,result.length);
    }
}

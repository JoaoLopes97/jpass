package jpass.util;

import org.junit.Before;
import org.junit.Test;

import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DateUtilsTest {


    @Test
    public void shouldFormatValidFormatTest(){

        String validFormat = "dd.MM.yyyy";
        String expectedFormatter = "Value(DayOfMonth,2)'.'Value(MonthOfYear,2)'.'Value(YearOfEra,4,19,EXCEEDS_PAD)";

        DateTimeFormatter formatter = DateUtils.createFormatter(validFormat);

        assertEquals(expectedFormatter,formatter.toString());
    }

   @Test
   public void shouldFormatInvalidFormatTest(){

       String invalidFormat = "yyy mmm dddd";
       String expectedFormatter = "ParseCaseSensitive(false)(Value(Year,4,10,EXCEEDS_PAD)'-'Value(MonthOfYear,2)'-'Value(DayOfMonth,2))[Offset(+HH:MM:ss,'Z')]";

       DateTimeFormatter formatter = DateUtils.createFormatter(invalidFormat);

       assertEquals(expectedFormatter,formatter.toString());
   }

   @Test
    public void shouldFormatNullTest(){

       String expectedFormatter = "ParseCaseSensitive(false)(Value(Year,4,10,EXCEEDS_PAD)'-'Value(MonthOfYear,2)'-'Value(DayOfMonth,2))[Offset(+HH:MM:ss,'Z')]";

       DateTimeFormatter formatter = DateUtils.createFormatter(null);

       assertEquals(expectedFormatter,formatter.toString());
   }

   @Test
    public void shouldFormatEmptyFormatTest(){

        String emptyFormat = "";


       String expectedFormatter = "ParseCaseSensitive(false)(Value(Year,4,10,EXCEEDS_PAD)'-'Value(MonthOfYear,2)'-'Value(DayOfMonth,2))[Offset(+HH:MM:ss,'Z')]";

       DateTimeFormatter formatter = DateUtils.createFormatter(emptyFormat);

       assertEquals(expectedFormatter,formatter.toString());
   }
}

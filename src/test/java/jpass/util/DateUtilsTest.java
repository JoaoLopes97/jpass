package jpass.util;

import org.junit.Test;

import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class DateUtilsTest {

	//region ASSIGNMENT 1

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

       assertNotEquals(expectedFormatter,formatter.toString());
   }
   
   
   @Test
   public void formatIsoDateTimeNullTest(){
	   
	  String dateStringCorrect = "2021-03-02T20:11:58";
	  DateTimeFormatter formatter = DateUtils.createFormatter(null);
	  
	  String result = DateUtils.formatIsoDateTime(dateStringCorrect, formatter);
      
	  String expectedResult = "2021-03-02";
	  
	  assertEquals(result,expectedResult);
  }
     
   @Test
   public void formatIsoDateTimeEmptyTest(){
	   
	  String dateStringCorrect = "2021-03-02T20:11:58";
	  DateTimeFormatter formatter = DateUtils.createFormatter("");
	  
	  String expectedResult = "";
	  String result = DateUtils.formatIsoDateTime(dateStringCorrect, formatter);
      
	  assertEquals(result,expectedResult);
   }
   
   // DateTimeFormatter incorrecto
   @Test
   public void formatIsoDateTimeIncorrectDateCorrectTest(){
	   
	  String dateStringCorrect = "2021-03-02T20:11:58";
	  String invalidFormat = "yyy mmm dddd";
	  DateTimeFormatter formatter = DateUtils.createFormatter(invalidFormat);
	  
	  String expectedResult = "2021-03-02";
	  String result = DateUtils.formatIsoDateTime(dateStringCorrect, formatter);
      
	  assertEquals(result,expectedResult);
  }
   
   @Test
   public void formatIsoDateTimeIncorrectDateIncorrectTest(){
	   
	  String dateStringIncorrect = "2021-03-0:11:58";
	  String invalidFormat = "yyy mmm dddd";
	  DateTimeFormatter formatter = DateUtils.createFormatter(invalidFormat);
	  
	  String expectedResult = "1970-01-01";
	  String result = DateUtils.formatIsoDateTime(dateStringIncorrect, formatter);
      
	  assertEquals(result,expectedResult);
  }
   
   @Test
   public void formatIsoDateTimeIncorrectDateEmptyTest(){
	   
	  String dateStringEmpty = "";
	  String invalidFormat = "yyy mmm dddd";
	  DateTimeFormatter formatter = DateUtils.createFormatter(invalidFormat);
	  
	  String expectedResult = "1970-01-01";
	  String result = DateUtils.formatIsoDateTime(dateStringEmpty, formatter);
      
	  assertEquals(result,expectedResult);
  }
   
   @Test
   public void formatIsoDateTimeIncorrectDateNullTest(){
	   
	  String dateStringEmpty = null;
	  String invalidFormat = "yyy mmm dddd";
	  DateTimeFormatter formatter = DateUtils.createFormatter(invalidFormat);
	  
	  String expectedResult = "1970-01-01";
	  String result = DateUtils.formatIsoDateTime(dateStringEmpty, formatter);
      
	  assertEquals(result,expectedResult);
  }
   
// DateTimeFormatter correcto
   @Test
   public void formatIsoDateTimeCorrectDateCorrectTest(){
	   
	  String dateStringCorrect = "2021-03-02T20:11:58";
	  String validFormat = "dd.MM.yyyy";
	  DateTimeFormatter formatter = DateUtils.createFormatter(validFormat);
	  
	  String expectedResult = "02.03.2021";
	  String result = DateUtils.formatIsoDateTime(dateStringCorrect, formatter);
      
	  assertEquals(result,expectedResult);
  }
   
   @Test
   public void formatIsoDateTimeCorrectDateIncorrectTest(){
	   
	  String dateStringIncorrect = "2021-03-0:11:58";
	  String validFormat = "dd.MM.yyyy";
	  DateTimeFormatter formatter = DateUtils.createFormatter(validFormat);
	  
	  String expectedResult = "01.01.1970";
	  String result = DateUtils.formatIsoDateTime(dateStringIncorrect, formatter);
      
	  assertEquals(result,expectedResult);
  }
   
   @Test
   public void formatIsoDateTimeCorrectDateEmptyTest(){
	   
	  String dateStringEmpty = "";
	  String validFormat = "dd.MM.yyyy";
	  DateTimeFormatter formatter = DateUtils.createFormatter(validFormat);
	  
	  String expectedResult = "01.01.1970";
	  String result = DateUtils.formatIsoDateTime(dateStringEmpty, formatter);
      
	  assertEquals(result,expectedResult);
  }
   
   @Test
   public void formatIsoDateTimeCorrectDateNullTest(){
	   
	  String dateStringNull = null;
	  String validFormat = "dd.MM.yyyy";
	  DateTimeFormatter formatter = DateUtils.createFormatter(validFormat);
	  
	  String expectedResult = "01.01.1970";
	  String result = DateUtils.formatIsoDateTime(dateStringNull, formatter);
      
	  assertEquals(result,expectedResult);
  }
   
   
   
   
   
   
// DateTimeFormatter null
   @Test
   public void formatIsoDateTimeNullDateCorrect(){
	   
	  String dateStringCorrect = "2021-03-02T20:11:58";
	  String nullFormat = null;
	  DateTimeFormatter formatter = DateUtils.createFormatter(nullFormat);
	  
	  String expectedResult = "2021-03-02";
	  String result = DateUtils.formatIsoDateTime(dateStringCorrect, formatter);
      
	  assertEquals(result,expectedResult);
  }
   
   @Test
   public void formatIsoDateTimeNullDateIncorrect(){
	   
	  String dateStringIncorrect = "2021-03-0:11:58";
	  String nullFormat = null;
	  DateTimeFormatter formatter = DateUtils.createFormatter(nullFormat);
	  
	  String expectedResult = "1970-01-01";
	  String result = DateUtils.formatIsoDateTime(dateStringIncorrect, formatter);
      
	  assertEquals(result,expectedResult);
  }
   
   @Test
   public void formatIsoDateTimeNullDateEmpty(){
	   
	  String dateStringEmpty = "";
	  String nullFormat = null;
	  DateTimeFormatter formatter = DateUtils.createFormatter(nullFormat);
	  
	  String expectedResult = "1970-01-01";
	  String result = DateUtils.formatIsoDateTime(dateStringEmpty, formatter);
      
	  assertEquals(result,expectedResult);
  }
   
   @Test
   public void formatIsoDateTimeNullDateNull(){

	  String dateStringNull = null;
	  String nullFormat = null;
	  DateTimeFormatter formatter = DateUtils.createFormatter(nullFormat);

	  String expectedResult = "1970-01-01";
	  String result = DateUtils.formatIsoDateTime(dateStringNull, formatter);
      
	  assertEquals(result,expectedResult);
  }

	//endregion

	//region ASSIGNMENT 5

	@Test
	public void formatIsoDateTimeNullDateNull2(){
		String dateStringNull = "1616697411";
		String nullFormat = null;
		DateTimeFormatter formatter = DateUtils.createFormatter(nullFormat);

		String expectedResult = "1970-01-19";
		String result = DateUtils.formatIsoDateTime(dateStringNull, formatter);

		assertEquals(result,expectedResult);
	}
	//endregion
   
   
   
}

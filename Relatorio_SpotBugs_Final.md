
      
# SpotBugs Report
      
Produced using [SpotBugs](https://spotbugs.github.io)4.1.3.
      
Project: 
			jpass[jpass]
      
## Metrics
      
2502 lines of code analyzed,
	in 75 classes, 
	in 10 packages.
      
<table width="500" cellpadding="5" cellspacing="2">
         <tbody><tr class="tableheader">
            <th align="left">Metric</th>
            <th align="right">Total</th>
            <th align="right">Density*</th>
         </tr>
         <tr class="tablerow0">
            <td>High Priority Warnings</td>
            <td align="right">
            </td><td align="right">NaN</td>
         </tr>
         <tr class="tablerow1">
            <td>Medium Priority Warnings</td>
            <td align="right">17</td>
            <td align="right">6.79</td>
         </tr>
         <tr class="$totalClass">
            <td>
               <b>Total Warnings</b>
            </td>
            <td align="right">
               <b>17</b>
            </td>
            <td align="right">
               <b>6.79</b>
            </td>
         </tr>
      </tbody></table>
      
&#10;         <i>(* Defects per Thousand lines of non-commenting source statements)</i>
      
      
&#10;           
&#10;           
&#10;      
      
## Summary
      
<table width="500" cellpadding="5" cellspacing="2">
         <tbody><tr class="tableheader">
            <th align="left">Warning Type</th>
            <th align="right">Number</th>
         </tr>
         <tr class="tablerow0">
            <td>
               [Bad practice Warnings](#Warnings_BAD_PRACTICE)
            </td>
            <td align="right">6</td>
         </tr>
         <tr class="tablerow1">
            <td>
               [Experimental Warnings](#Warnings_EXPERIMENTAL)
            </td>
            <td align="right">1</td>
         </tr>
         <tr class="tablerow0">
            <td>
               [Malicious code vulnerability Warnings](#Warnings_MALICIOUS_CODE)
            </td>
            <td align="right">1</td>
         </tr>
         <tr class="tablerow1">
            <td>
               [Performance Warnings](#Warnings_PERFORMANCE)
            </td>
            <td align="right">1</td>
         </tr>
         <tr class="tablerow0">
            <td>
               [Dodgy code Warnings](#Warnings_STYLE)
            </td>
            <td align="right">8</td>
         </tr>
         <tr class="tablerow1">
            <td>
               <b>Total</b>
            </td>
            <td align="right">
               <b>17</b>
            </td>
         </tr>
      </tbody></table>
      
&#10;           
&#10;           
&#10;      
      
# Warnings
      
Click on each warning link to see a full description of the issue, and
	    details of how to resolve it.
      
## &#10;         [Bad practice Warnings]()&#10;      
      
<table class="warningtable" width="100%" cellspacing="2" cellpadding="5">
         <tbody><tr class="tableheader">
            <th align="left">Warning</th>
            <th align="left">Priority</th>
            <th align="left">Details</th>
         </tr>
         <tr class="tablerow1">
            <td width="20%" valign="top">
               [Format string should use %n rather than \n](#VA_FORMAT_STRING_USES_NEWLINE)
            </td>
            <td width="10%" valign="top">Medium</td>
            <td width="70%">
               Format string should use %n rather than \n in jpass.ui.helper.FileHelper.handleFileNotFound(JPassFrame, String, byte[])  
&#10;                    
&#10;                    
In file FileHelper.java,
					
						line 338  
In class jpass.ui.helper.FileHelper  
In method jpass.ui.helper.FileHelper.handleFileNotFound(JPassFrame, String, byte[])  
Called method String.format(String, Object[])  
Format string "File not found:\n%s\n\nDo you want to create the file?"  
At FileHelper.java:[line 338]
            </td>
         </tr>
         <tr class="tablerow0">
            <td width="20%" valign="top">
               [Format string should use %n rather than \n](#VA_FORMAT_STRING_USES_NEWLINE)
            </td>
            <td width="10%" valign="top">Medium</td>
            <td width="70%">
               Format string should use %n rather than \n in jpass.ui.helper.FileHelper$1.doInBackground()  
&#10;                    
&#10;                    
In file FileHelper.java,
					
						line 127  
In class jpass.ui.helper.FileHelper$1  
In method jpass.ui.helper.FileHelper$1.doInBackground()  
Called method String.format(String, Object[])  
Format string "An error occured during the %s operation:\n%s"  
At FileHelper.java:[line 127]
            </td>
         </tr>
         <tr class="tablerow1">
            <td width="20%" valign="top">
               [Format string should use %n rather than \n](#VA_FORMAT_STRING_USES_NEWLINE)
            </td>
            <td width="10%" valign="top">Medium</td>
            <td width="70%">
               Format string should use %n rather than \n in jpass.ui.helper.FileHelper$2.doInBackground()  
&#10;                    
&#10;                    
In file FileHelper.java,
					
						line 175  
In class jpass.ui.helper.FileHelper$2  
In method jpass.ui.helper.FileHelper$2.doInBackground()  
Called method String.format(String, Object[])  
Format string "An error occured during the %s operation:\n%s"  
At FileHelper.java:[line 175]
            </td>
         </tr>
         <tr class="tablerow0">
            <td width="20%" valign="top">
               [Format string should use %n rather than \n](#VA_FORMAT_STRING_USES_NEWLINE)
            </td>
            <td width="10%" valign="top">Medium</td>
            <td width="70%">
               Format string should use %n rather than \n in jpass.ui.helper.FileHelper$3.doInBackground()  
&#10;                    
&#10;                    
In file FileHelper.java,
					
						line 235  
In class jpass.ui.helper.FileHelper$3  
In method jpass.ui.helper.FileHelper$3.doInBackground()  
Called method String.format(String, Object[])  
Format string "An error occured during the %s operation:\n%s"  
At FileHelper.java:[line 235]
            </td>
         </tr>
         <tr class="tablerow1">
            <td width="20%" valign="top">
               [Format string should use %n rather than \n](#VA_FORMAT_STRING_USES_NEWLINE)
            </td>
            <td width="10%" valign="top">Medium</td>
            <td width="70%">
               Format string should use %n rather than \n in jpass.ui.helper.FileHelper$4.doInBackground()  
&#10;                    
&#10;                    
In file FileHelper.java,
					
						line 308  
In class jpass.ui.helper.FileHelper$4  
In method jpass.ui.helper.FileHelper$4.doInBackground()  
Called method String.format(String, Object[])  
Format string "An error occured during the %s operation:\n%s"  
At FileHelper.java:[line 308]
            </td>
         </tr>
         <tr class="tablerow0">
            <td width="20%" valign="top">
               [Format string should use %n rather than \n](#VA_FORMAT_STRING_USES_NEWLINE)
            </td>
            <td width="10%" valign="top">Medium</td>
            <td width="70%">
               Format string should use %n rather than \n in jpass.ui.helper.FileHelper$5.doInBackground()  
&#10;                    
&#10;                    
In file FileHelper.java,
					
						line 348  
In class jpass.ui.helper.FileHelper$5  
In method jpass.ui.helper.FileHelper$5.doInBackground()  
Called method String.format(String, Object[])  
Format string "An error occured during the %s operation:\n%s"  
At FileHelper.java:[line 348]
            </td>
         </tr>
      </tbody></table>
      
&#10;           
&#10;           
&#10;      
      
## &#10;         [Experimental Warnings]()&#10;      
      
<table class="warningtable" width="100%" cellspacing="2" cellpadding="5">
         <tbody><tr class="tableheader">
            <th align="left">Warning</th>
            <th align="left">Priority</th>
            <th align="left">Details</th>
         </tr>
         <tr class="tablerow1">
            <td width="20%" valign="top">
               [Method may fail to clean up stream or resource on checked exception](#OBL_UNSATISFIED_OBLIGATION_EXCEPTION_EDGE)
            </td>
            <td width="10%" valign="top">Medium</td>
            <td width="70%">
               new jpass.util.Configuration() may fail to clean up java.io.InputStream on checked exception  
&#10;                    
&#10;                    
In file Configuration.java Configuration.java Configuration.java Configuration.java Configuration.java,
					
						line 53 54 57 58 60  
In class jpass.util.Configuration  
In method new jpass.util.Configuration()  
Reference type java.io.InputStream  
1 instances of obligation remaining  
Obligation to clean up resource created at Configuration.java:[line 53] is not discharged  
Path continues at Configuration.java:[line 54]  
Path continues at Configuration.java:[line 57]  
Path continues at Configuration.java:[line 58]  
Path continues at Configuration.java:[line 60]  
Remaining obligations: {InputStream x 1}
            </td>
         </tr>
      </tbody></table>
      
&#10;           
&#10;           
&#10;      
      
## &#10;         [Malicious code vulnerability Warnings]()&#10;      
      
<table class="warningtable" width="100%" cellspacing="2" cellpadding="5">
         <tbody><tr class="tableheader">
            <th align="left">Warning</th>
            <th align="left">Priority</th>
            <th align="left">Details</th>
         </tr>
         <tr class="tablerow1">
            <td width="20%" valign="top">
               [May expose internal representation by incorporating reference to mutable object](#EI_EXPOSE_REP2)
            </td>
            <td width="10%" valign="top">Medium</td>
            <td width="70%">
               jpass.data.DataModel.setPassword(byte[]) may expose internal representation by storing an externally mutable object into DataModel.password  
&#10;                    
&#10;                    
In file DataModel.java DataModel.java,
					
						line 128 128  
In class jpass.data.DataModel  
In method jpass.data.DataModel.setPassword(byte[])  
Field jpass.data.DataModel.password  
Local variable named password  
At DataModel.java:[line 128]  
At DataModel.java:[line 128]
            </td>
         </tr>
      </tbody></table>
      
&#10;           
&#10;           
&#10;      
      
## &#10;         [Performance Warnings]()&#10;      
      
<table class="warningtable" width="100%" cellspacing="2" cellpadding="5">
         <tbody><tr class="tableheader">
            <th align="left">Warning</th>
            <th align="left">Priority</th>
            <th align="left">Details</th>
         </tr>
         <tr class="tablerow1">
            <td width="20%" valign="top">
               [Method concatenates strings using + in a loop](#SBSC_USE_STRINGBUFFER_CONCATENATION)
            </td>
            <td width="10%" valign="top">Medium</td>
            <td width="70%">
               jpass.ui.GeneratePasswordDialog.actionPerformed(ActionEvent) concatenates strings using + in a loop  
&#10;                    
&#10;                    
In file GeneratePasswordDialog.java,
					
						line 224  
In class jpass.ui.GeneratePasswordDialog  
In method jpass.ui.GeneratePasswordDialog.actionPerformed(ActionEvent)  
At GeneratePasswordDialog.java:[line 224]
            </td>
         </tr>
      </tbody></table>
      
&#10;           
&#10;           
&#10;      
      
## &#10;         [Dodgy code Warnings]()&#10;      
      
<table class="warningtable" width="100%" cellspacing="2" cellpadding="5">
         <tbody><tr class="tableheader">
            <th align="left">Warning</th>
            <th align="left">Priority</th>
            <th align="left">Details</th>
         </tr>
         <tr class="tablerow1">
            <td width="20%" valign="top">
               [Test for circular dependencies among classes](#CD_CIRCULAR_DEPENDENCY)
            </td>
            <td width="10%" valign="top">Medium</td>
            <td width="70%">
               Class jpass.ui.EntryDetailsTable has a circular dependency with other classes  
&#10;                    
&#10;                    
In file EntryDetailsTable.java,
					
						lines 51
						    to 140  
In class jpass.ui.EntryDetailsTable  
In class jpass.ui.EntryDetailsTable$DetailType  
At EntryDetailsTable.java:[lines 51-140]
            </td>
         </tr>
         <tr class="tablerow0">
            <td width="20%" valign="top">
               [Test for circular dependencies among classes](#CD_CIRCULAR_DEPENDENCY)
            </td>
            <td width="10%" valign="top">Medium</td>
            <td width="70%">
               Class jpass.ui.EntryDetailsTable has a circular dependency with other classes  
&#10;                    
&#10;                    
In file EntryDetailsTable.java,
					
						lines 51
						    to 140  
In class jpass.ui.EntryDetailsTable  
In class jpass.ui.action.TableListener  
In class jpass.ui.JPassFrame  
At EntryDetailsTable.java:[lines 51-140]
            </td>
         </tr>
         <tr class="tablerow1">
            <td width="20%" valign="top">
               [Test for circular dependencies among classes](#CD_CIRCULAR_DEPENDENCY)
            </td>
            <td width="10%" valign="top">Medium</td>
            <td width="70%">
               Class jpass.ui.SearchPanel has a circular dependency with other classes  
&#10;                    
&#10;                    
In file SearchPanel.java,
					
						lines 71
						    to 156  
In class jpass.ui.SearchPanel  
In class jpass.ui.SearchPanel$1  
At SearchPanel.java:[lines 71-156]
            </td>
         </tr>
         <tr class="tablerow0">
            <td width="20%" valign="top">
               [Test for circular dependencies among classes](#CD_CIRCULAR_DEPENDENCY)
            </td>
            <td width="10%" valign="top">Medium</td>
            <td width="70%">
               Class jpass.ui.SearchPanel has a circular dependency with other classes  
&#10;                    
&#10;                    
In file SearchPanel.java,
					
						lines 71
						    to 156  
In class jpass.ui.SearchPanel  
In class jpass.ui.SearchPanel$2  
At SearchPanel.java:[lines 71-156]
            </td>
         </tr>
         <tr class="tablerow1">
            <td width="20%" valign="top">
               [Test for circular dependencies among classes](#CD_CIRCULAR_DEPENDENCY)
            </td>
            <td width="10%" valign="top">Medium</td>
            <td width="70%">
               Class jpass.ui.action.CloseListener has a circular dependency with other classes  
&#10;                    
&#10;                    
In file CloseListener.java,
					
						lines 42
						    to 54  
In class jpass.ui.action.CloseListener  
In class jpass.ui.JPassFrame  
At CloseListener.java:[lines 42-54]
            </td>
         </tr>
         <tr class="tablerow0">
            <td width="20%" valign="top">
               [Test for circular dependencies among classes](#CD_CIRCULAR_DEPENDENCY)
            </td>
            <td width="10%" valign="top">Medium</td>
            <td width="70%">
               Class jpass.ui.action.MenuActionType$20 has a circular dependency with other classes  
&#10;                    
&#10;                    
In file MenuActionType.java,
					
						lines 207
						    to 211  
In class jpass.ui.action.MenuActionType$20  
In class jpass.ui.JPassFrame  
In class jpass.ui.action.MenuActionType  
At MenuActionType.java:[lines 207-211]
            </td>
         </tr>
         <tr class="tablerow1">
            <td width="20%" valign="top">
               [Test for circular dependencies among classes](#CD_CIRCULAR_DEPENDENCY)
            </td>
            <td width="10%" valign="top">Medium</td>
            <td width="70%">
               Class jpass.ui.helper.FileHelper has a circular dependency with other classes  
&#10;                    
&#10;                    
In file FileHelper.java,
					
						lines 78
						    to 418  
In class jpass.ui.helper.FileHelper  
In class jpass.ui.helper.FileHelper$4  
At FileHelper.java:[lines 78-418]
            </td>
         </tr>
         <tr class="tablerow0">
            <td width="20%" valign="top">
               [Test for circular dependencies among classes](#CD_CIRCULAR_DEPENDENCY)
            </td>
            <td width="10%" valign="top">Medium</td>
            <td width="70%">
               Class jpass.ui.helper.FileHelper has a circular dependency with other classes  
&#10;                    
&#10;                    
In file FileHelper.java,
					
						lines 78
						    to 418  
In class jpass.ui.helper.FileHelper  
In class jpass.ui.helper.FileHelper$5  
In class jpass.ui.JPassFrame  
At FileHelper.java:[lines 78-418]
            </td>
         </tr>
      </tbody></table>
      
&#10;           
&#10;           
&#10;      
      
&#10;           
&#10;           
&#10;      
      
# &#10;         [Warning Types]()&#10;      
      
## &#10;         [Test for circular dependencies among classes]()&#10;      
   
    
&#10;    This class has a circular dependency with other classes. This makes building these classes
    difficult, as each is dependent on the other to build correctly. Consider using interfaces
    to break the hard dependency.
    
    
     
&#10;           
&#10;           
&#10;      
      
## &#10;         [May expose internal representation by incorporating reference to mutable object]()&#10;      

  
 This code stores a reference to an externally mutable object into the
  internal representation of the object.&nbsp;
   If instances
   are accessed by untrusted code, and unchecked changes to
   the mutable object would compromise security or other
   important properties, you will need to do something different.
  Storing a copy of the object is better approach in many situations.

    
&#10;           
&#10;           
&#10;      
      
## &#10;         [Format string should use %n rather than \n]()&#10;      

&#10;This format string includes a newline character (\n). In format strings, it is generally
 preferable to use %n, which will produce the platform-specific line separator.


     
&#10;           
&#10;           
&#10;      
      
## &#10;         [Method may fail to clean up stream or resource on checked exception]()&#10;      
          
          
&#10;          This method may fail to clean up (close, dispose of) a stream,
          database object, or other
          resource requiring an explicit cleanup operation.
          

          
&#10;          In general, if a method opens a stream or other resource,
          the method should use a try/finally block to ensure that
          the stream or resource is cleaned up before the method
          returns.
          

          
&#10;          This bug pattern is essentially the same as the
          OS_OPEN_STREAM and ODR_OPEN_DATABASE_RESOURCE
          bug patterns, but is based on a different
          (and hopefully better) static analysis technique.
          We are interested is getting feedback about the
          usefulness of this bug pattern.
          For sending feedback, check:
          
          
            
- [contributing guideline](https://github.com/spotbugs/spotbugs/blob/master/CONTRIBUTING.md)
            
- [malinglist](https://github.com/spotbugs/discuss/issues?q=)
          

          
&#10;          In particular,
          the false-positive suppression heuristics for this
          bug pattern have not been extensively tuned, so
          reports about false positives are helpful to us.
          

          
&#10;          See Weimer and Necula, <i>Finding and Preventing Run-Time Error Handling Mistakes</i>, for
          a description of the analysis technique.
          
          
      
&#10;           
&#10;           
&#10;      
      
## &#10;         [Method concatenates strings using + in a loop]()&#10;      

 The method seems to be building a String using concatenation in a loop.
In each iteration, the String is converted to a StringBuffer/StringBuilder,
   appended to, and converted back to a String.
   This can lead to a cost quadratic in the number of iterations,
   as the growing string is recopied in each iteration. 


Better performance can be obtained by using
a StringBuffer (or StringBuilder in Java 1.5) explicitly.


 For example:

    // This is bad
    String s = "";
    for (int i = 0; i &lt; field.length; ++i) {
        s = s + field[i];
    }
    
    // This is better
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i &lt; field.length; ++i) {
        buf.append(field[i]);
    }
    String s = buf.toString();


    
&#10;           
&#10;           
&#10;      
   


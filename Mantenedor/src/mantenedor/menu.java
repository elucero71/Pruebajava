/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenedor;

/**
 *
 * @author Eduardo_Lucero
 *///
import java.text.SimpleDateFormat;
import org.apache.commons.lang.StringUtils;

public class menu 
{
    
     public static void main(String[] args) {
     String date="2017-08-20";
     
     SimpleDateFormat userinput = new SimpleDateFormat("yyyy-MM-dd");
     SimpleDateFormat toconvert = new SimpleDateFormat("yyyyMMdd");

     try
     {
       String reformattedStr = toconvert.format(userinput.parse(date));
      String hoy="DDDD";
      String mana=StringUtils.leftPad(hoy, 12);
           
     
       System.out.println("la fecha es: " + reformattedStr);
       }
       catch(Exception e)
       {
       System.out.println(e.getMessage());
     
       }
     }
     
}

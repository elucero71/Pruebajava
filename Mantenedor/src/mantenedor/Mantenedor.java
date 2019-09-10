/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenedor;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import org.apache.commons.lang.StringUtils;
import java.util.Scanner;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Eduardo_Lucero
 */
public class Mantenedor 
{

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) 
    {
        // TODO code application logic here
    //  Queries myquery =new Queries();
    //  myquery.queryExecute();
        while (true)
        {    
        String opcion1;
        BufferedReader input;
        System.out.println("**************************");
        System.out.println("      Menu Principal");
        System.out.println("**************************");
        System.out.println(" 1: Ingresar");
        System.out.println(" 2: Modificar"); 
        System.out.println(" 3: Eliminar"); 
        System.out.println(" 4: Listar"); 
        System.out.println(" 5: Salir"); 
        try
        {
          input = new BufferedReader(new InputStreamReader(System.in));
          System.out.println("Ingrese la Opcion:"); 
          opcion1=input.readLine();
          opciones(opcion1);
        }
          catch (Exception e) 
        {
          System.out.print("Error: " + e.toString());
        }
        }
        
    }
// MENU    
    public static void opciones(String opcion2) 
    {
      switch (opcion2)  
             {
          case "1":
             queryIngresa();
             break;
          case "2":
             queryModifica();
             break;
          case "3":
             queryBorra();
             break;    
          case "4":
            // Queries myquery =new Queries();
            // String fecha1; 
            // fecha1="20170817"; 
           //  myquery.queryExecute(fecha1);
             queryExecute();
             break;    
          case "5":
             System.exit(0);      
             break;  
          default :
             System.out.println("Opción Invalida");           
             break;
              }
    }
//*****************    
// OPCION 4 CONSULTAR
//*****************
    public static void queryExecute()
    {
        Scanner leer=new Scanner(System.in);
        Connection conn = null;
        SimpleDateFormat userinput = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat toconvert = new SimpleDateFormat("yyyyMMdd");
        Date a = new Date();
        System.out.print(a.getTime());
        try
        {
        //BufferedReader input;
        String userName = "root";
        String password = "elucero";
        String url = "jdbc:mysql://localhost:3306/mysql";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, userName, password);
    
    //input = new BufferedReader(new InputStreamReader(System.in));
    //System.out.println("Ingrese la fecha a consultar :"); 
    //String fecha=input.readLine();
        System.out.println("**************************");
        System.out.println("      Consultar      ");
        System.out.println("**************************");
        System.out.println("Ingrese fecha :"); 
        String fecha=leer.nextLine();
        String reformattedStr = toconvert.format(userinput.parse(fecha));
        PreparedStatement pst = null;
        String query1 ="select * from tbmateria where  V_MATERIA_FECHA = ?";
        pst=conn.prepareStatement(query1);
        pst.setString(1,fecha);
        ResultSet rset;
        rset=pst.executeQuery();
        
        System.out.println("***************************************************************************");
        System.out.println("  Materia   |F. Entrega|    Detalle             |    Observaciones  ");
        System.out.println("***************************************************************************");
        
        while (rset.next()) 
        {
//            String campo1=rset.getString("V_MATERIA_FECHA").trim();
            String campo2=rset.getString("V_MATERIA_MATERIA").trim();
            String campo3=rset.getString("V_MATERIA_DETALLE").trim();
            String campo4=rset.getString("V_MATERIA_FECHA_ENT").trim();
            String campo5=rset.getString("V_MATERIA_OBSERVA").trim();
//            System.out.println("Fecha: " + title + " y Materia: " +campo2);
//            System.out.println(campo2+"    "+campo3 +"     "+campo4+"        "+campo5);
        
            String campo22=StringUtils.rightPad(campo2,12);
            String campo33=StringUtils.rightPad(campo3,24);
            String campo44=StringUtils.rightPad(campo4,10);
            String campo55=StringUtils.rightPad(campo5,50);
            System.out.println(campo22+"|"+campo44 +"|"+campo33+"|"+campo55);

        }
        System.out.println("***************************************************************************");
        rset.close();
        conn.close();
        }

         catch (Exception e) 
        {
         System.out.print("Error: " + e.toString());
        }

    }   
    //**************************
    // OPCION 1
    //**************************
    public static void queryIngresa()
    {
        Scanner leer=new Scanner(System.in);
        Connection conn = null;
        SimpleDateFormat userinput = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat toconvert = new SimpleDateFormat("yyyyMMdd");

        try
        {
        String userName = "root";
        String password = "elucero";
        String url = "jdbc:mysql://localhost:3306/mysql";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, userName, password);
        System.out.println("**************************");
        System.out.println("      Ingresar");
        System.out.println("**************************");
        System.out.println("Ingrese fecha(AAAA-MM-DD):"); 
        String fecha3=leer.nextLine();
    //    try
    //    {
          String reformattedStr = toconvert.format(userinput.parse(fecha3));
    //    }
    //      catch(Exception e)
    //      {
    //       System.out.println("Formato de Fecha Inválido"+ e.getMessage());
    //       }
        System.out.println("Ingrese Materia :"); 
        String materia3=leer.nextLine();
        
        String materia5 = materia3.toUpperCase();
                
        System.out.println("Ingrese Detalle :"); 
        String detalle3=leer.nextLine();
        System.out.println("Ingrese Observaciones :"); 
        String observa3=leer.nextLine();
        System.out.println("Ingrese fecha entrega(AAAA-MM-DD):"); 
        String fechaE3=leer.nextLine();
        String reformattedStr1 = toconvert.format(userinput.parse(fechaE3));
        PreparedStatement pst = null;
        String query1 ="insert into tbmateria (V_MATERIA_FECHA, V_MATERIA_MATERIA, V_MATERIA_DETALLE,V_MATERIA_FECHA_ENT, V_MATERIA_OBSERVA) VALUES  (?,?,?,?,?)";
        pst=conn.prepareStatement(query1);
        pst.setString(1,fecha3);
        pst.setString(2,materia5);
        pst.setString(3,detalle3);
        pst.setString(4,fechaE3);
        pst.setString(5,observa3);
        //ResultSet rset;
        pst.executeUpdate();
        
        System.out.println("****Registro Insetado con Exito***");           
        
        conn.close();
        }

        catch (Exception e) 
        {
             System.out.print("Error: " + e.toString());
        }

    } 
    //**************************
    // OPCION 3 ELIMINAR
    //**************************
    public static void queryBorra()
    {
        Scanner leer=new Scanner(System.in);
        Connection conn = null;
        SimpleDateFormat userinput = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat toconvert = new SimpleDateFormat("yyyyMMdd");

        try
        {
        String userName = "root";
        String password = "elucero";
        String url = "jdbc:mysql://localhost:3306/mysql";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, userName, password);
        System.out.println("**************************");
        System.out.println("      Eliminar");
        System.out.println("**************************");
        
        System.out.println("Ingrese fecha :"); 
        String fecha4=leer.nextLine();
        String reformattedStr = toconvert.format(userinput.parse(fecha4));
        System.out.println("Ingrese Materia :"); 
        String materia4="";
        if(leer.hasNextLine()){
        materia4=leer.nextLine();
        }
        else
        {
        materia4=leer.next();
        
        }
        if(materia4.isEmpty()){
        System.out.println("leído vacío 33");
        }
        if(materia4.equals("")){
        materia4="";
        System.out.println("leído vacío");
         System.out.println(materia4);
        
        }
        
        String query1 ="";
                
        PreparedStatement pst = null;
        String materia6 = materia4.toUpperCase();
        if (materia6.equals(""))
          {
           query1 ="delete from tbmateria where V_MATERIA_FECHA = ?";
           pst=conn.prepareStatement(query1);
           pst.setString(1,fecha4);
        
          }
        else
          { 
           query1 ="delete from tbmateria where V_MATERIA_FECHA = ? AND V_MATERIA_MATERIA =?";
           pst=conn.prepareStatement(query1);
           pst.setString(1,fecha4);
           pst.setString(2,materia6);
          }
        
        //ResultSet rset;
        pst.executeUpdate();
        
        System.out.println("Registro Borrado con Exito");           
        
        conn.close();
        }

        catch (Exception e) 
        {
             System.out.print("Error: " + e.toString());
        }

    }  
    //*******************    
    // OPCION 2 MODIFICAR
    //*******************
    public static void queryModifica()
    {
        Scanner leer=new Scanner(System.in);
        Connection conn = null;
        SimpleDateFormat userinput = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat toconvert = new SimpleDateFormat("yyyyMMdd");

        try
        {
        //BufferedReader input;
        String userName = "root";
        String password = "elucero";
        String url = "jdbc:mysql://localhost:3306/mysql";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, userName, password);
    
    //input = new BufferedReader(new InputStreamReader(System.in));
    //System.out.println("Ingrese la fecha a consultar :"); 
    //String fecha=input.readLine();
        System.out.println("**************************");
        System.out.println("      Modificar      ");
        System.out.println("**************************");
        System.out.println("Ingrese fecha :"); 
        String fecha5=leer.nextLine();
        String reformattedStr = toconvert.format(userinput.parse(fecha5));
        PreparedStatement pst = null;
        String query1 ="select * from tbmateria where  V_MATERIA_FECHA = ?";
        pst=conn.prepareStatement(query1);
        pst.setString(1,fecha5);
        ResultSet rset;
        rset=pst.executeQuery();
        System.out.println("******************************");
        System.out.println("  Materia   |F. Entrega|      ");
        System.out.println("******************************");
        while (rset.next()) 
        {
            String campo2=rset.getString("V_MATERIA_MATERIA").trim();
            String campo3=rset.getString("V_MATERIA_DETALLE").trim();
            String campo4=rset.getString("V_MATERIA_FECHA_ENT").trim();
            String campo5=rset.getString("V_MATERIA_OBSERVA").trim();
        
            String campo22=StringUtils.rightPad(campo2,12);
            String campo33=StringUtils.rightPad(campo3,24);
            String campo44=StringUtils.rightPad(campo4,10);
            String campo55=StringUtils.rightPad(campo5,50);
            System.out.println(campo22+"|"+campo44);

        }
        System.out.println("******************************");
    //    String fecha35=campo44;
        rset.close();
        System.out.println("Ingrese Materia a modificar :"); 
        String materia36="";
        materia36=leer.nextLine();
        System.out.println("Ingrese Nueva Fecha Entrega :"); 
        String fecha36=leer.nextLine();
        System.out.println(materia36+fecha36);
        if ((materia36.equals("")) && (fecha36.equals ("")))
           {
            System.out.println("****Modificacion no procede***");
           }
           else
           {
               //  String reformattedStr = toconvert.format(userinput.parse(fecha36));
            PreparedStatement pst1 = null;
            String query2 ="update tbmateria set V_MATERIA_FECHA_ENT = ? where V_MATERIA_FECHA = ? AND V_MATERIA_MATERIA =?";
            pst1=conn.prepareStatement(query2);
            pst1.setString(1,fecha36);
            pst1.setString(2,fecha5);
            pst1.setString(3,materia36);
        //ResultSet rset;
            pst1.executeUpdate();
            System.out.println("****Registro actualizado con Exito***");
           }   
        
        //rset.close();
        
        conn.close();
        }

         catch (Exception e) 
        {
         System.out.print("Error: " + e.toString());
        }

    }   



}

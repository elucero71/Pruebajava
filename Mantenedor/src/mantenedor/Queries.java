/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenedor;

/**
 *
 * @author Eduardo_Lucero
 */
import java.sql.*;
//import java.io.*;
public class Queries 
{
public void queryExecute()
{
Connection conn = null;
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
    
    PreparedStatement pst = null;
    String query1 ="select * from tbmateria where  V_MATERIA_FECHA = ?";
    pst=conn.prepareStatement(query1);
 //   pst.setString(1,fecha);
    ResultSet rset;
    rset=pst.executeQuery();
    while (rset.next()) 
       {
        String campo1=rset.getString("V_MATERIA_FECHA").trim();
        String campo2=rset.getString("V_MATERIA_MATERIA").trim();
        String campo3=rset.getString("V_MATERIA_DETALLE").trim();
        String campo4=rset.getString("V_MATERIA_FECHA_ENT").trim();
        String campo5=rset.getString("V_MATERIA_OBSERVA").trim();
//            System.out.println("Fecha: " + title + " y Materia: " +campo2);
       System.out.println(campo1 +" "+ campo2+" "+campo3 +" "+campo4+" "+campo5);
       }
       rset.close();
       conn.close();
}

catch (Exception e) 
      {
         System.out.print("Error: " + e.toString());
      }

}    
}

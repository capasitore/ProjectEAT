package DB;

import java.net.URL;
import java.sql.*;

import javax.swing.*;

public class sqliteConnection {

	
	
	public static Connection dbConnector(URL dbFilePath)
	{
		try{
			Class.forName("org.sqlite.JDBC");
//			Connection conn = DriverManager.getConnection("jdbc:sqlite:resource:projecteat.sqlite");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dbFilePath);
//			URL test = this.getClass().getResource("projecteat.sqlite");

//			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + test);
			
			
			JOptionPane.showMessageDialog(null, "Succesfull Connection");
			
			//SearchButton dummy SQL query for testing purpose only
			
		      // Get a statement from the connection
		      Statement stmt = conn.createStatement();
			// Execute the query
		      ResultSet rs = stmt.executeQuery( "SELECT RecipeName FROM Recipe" ) ;
		      System.out.println(rs);
		      
		      // Loop through the result set
		      while( rs.next() )
		    	System.out.println( rs.getString(1) ) ;

		      // Close the result set, statement and the connection
		      rs.close() ;
		      stmt.close() ;
		      conn.close() ;
		     
		      
		      return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
			
			
		}
		
	}
}

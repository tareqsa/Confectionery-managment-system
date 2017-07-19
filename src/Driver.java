import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;


public class Driver 
{
	public Connection conn = null;
	public static Driver driver;
	
	//Connect between the software and the database
	private Driver()
	{
		String url = "jdbc:mysql://localhost:3306/rachelconfectionery?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";


		try
		{
			this.conn = DriverManager.getConnection(url, user,password);
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}

	
	}
	//If the connection is exist, use it, if not, create it
	public static Driver getDatabaseDriver()
	{
		if(driver == null )
		{
			driver = new Driver();
		}
		return driver;
	}
	
	//View table in the window
	public static void viewTable(String tableName , JTable protable , Connection Conn)
	{
		try
		{
			Statement myStmt = Conn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from "+tableName+"");
			protable.setModel(DbUtils.resultSetToTableModel(myRs));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}







}

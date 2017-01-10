import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;


public class Driver 
{

	public static Connection getConnection()
	{
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/rachelconfectionery?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";


		try
		{
			conn = DriverManager.getConnection(url, user,password);
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		return conn;

	}
	public static void viewTable(String tableName , JTable protable , Connection Conn)
	{
		try{
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

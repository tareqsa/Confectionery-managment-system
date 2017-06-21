import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class testTable extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testTable frame = new testTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 680, 326);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		try
		{
//			String 	query = "SELECT `שם מרכיב` , `כמות` FROM `ingredients` JOIN inventory WHERE `שם מוצר`='מעמ' ";
			String 	query = "SELECT ingredients.`שם מרכיב` , ingredients.`כמות` , inventory.`כמות במלאי בקג` FROM `ingredients` ,`inventory` WHERE `שם מוצר`='asd' AND ingredients.`שם מרכיב` = inventory.`שם מרכיב` ";
			System.out.println(query);
			Statement stt = Driver.getDatabaseDriver().conn.createStatement();
			ResultSet rs = stt.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
		catch (Exception e)
		{
		e.printStackTrace();
		}
		
		
	}
}

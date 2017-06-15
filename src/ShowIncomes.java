

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowIncomes extends JFrame
{

	
	private JPanel contentPane;

	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	
	private JTable table;
	Connection conn1;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	
	
	
	
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try
				{
					ShowIncomes frame = new ShowIncomes();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShowIncomes()
	{
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShowIncomes.class.getResource("/conimgs/title_icon.png")));
		setTitle("\u05D4\u05DB\u05E0\u05E1\u05D5\u05EA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 30, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		
		scrollPane_1.setBounds(795, 123, 189, 427);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable()
		{
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			};
			
		};
		table_1.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e) 
			{
				JTable table1 =(JTable) e.getSource();
		        Point p = e.getPoint();
		        int row = table1.rowAtPoint(p);
		        String date = table1.getModel().getValueAt(row, 0).toString();
		        System.out.println(date);
		        String query = "  SELECT `שם פרטי`,`שם משפחה`,`מה הוזמן`,`כמות בקילוגרם`,`עלות`  FROM orders WHERE `תאריך`= '"+date+"'";
		        System.out.println(query);
				try 
				{
					Statement stt2 = (Statement) conn1.createStatement();
					ResultSet rset2 = stt2.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rset2));
					
					DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
					centerRenderr.setHorizontalAlignment(JLabel.CENTER);
					table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
					table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
					table.getColumnModel().getColumn(2).setCellRenderer(centerRenderr);
					table.getColumnModel().getColumn(3).setCellRenderer(centerRenderr);
					table.getColumnModel().getColumn(4).setCellRenderer(centerRenderr);
					
				} 
				catch (SQLException ex) 
				{
					
					   ex.printStackTrace();
			    }
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 123, 775, 427);
		contentPane.add(scrollPane);
		
		table = new JTable()
		{
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			};
			
		};
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		JTableHeader Theader = table.getTableHeader();
		Theader.setBackground(Color.pink);
        Theader.setFont(new Font("Tahoma", Font.BOLD, 12));
		//scrollPane.setColumnHeaderView(table);
		
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(10, 0, 90, 21);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel("\u05DE\u05D7\u05D5\u05D1\u05E8: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(108, 0, 63, 21);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(894, 31, 140, 25);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(863, 11, 146, 25);
		contentPane.add(lblNewLabel_1);
		
		
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 994, 571);
		contentPane.add(lblNewLabel);
		ImageIcon pic = new ImageIcon(ShowIncomes.class.getResource("conimgs/background.jpg"));
		Image tempImage = pic.getImage();
		ImageIcon image= new ImageIcon(tempImage);
		Image Imagetemp = tempImage.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
		lblNewLabel.setIcon(image);
		
		
		lblNewLabel_4.setText(ConMainActivity.username);
		
		conn1 = (Connection) Driver.getConnection();
		
		String query = "  SELECT `תאריך`  FROM orders GROUP BY `תאריך` ";
		try 
		{
			Statement stt1 = (Statement) conn1.createStatement();
			ResultSet rset = stt1.executeQuery(query);
			table_1.setModel(DbUtils.resultSetToTableModel(rset));
			
			DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
			centerRenderr.setHorizontalAlignment(JLabel.CENTER);
			table_1.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
		} 
		catch (SQLException e) 
		{
			
			   e.printStackTrace();
	    }
		
		
		
		setclk();
		
		
	}
	public void setclk()
	{
		Thread clkthread = new Thread()
		{			
			public void run()
			{
				try
				{
					while(true)
					{
						DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
						DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");

						Date date = new Date();
						lblNewLabel_1.setText("\u05EA\u05D0\u05E8\u05D9\u05DA: "+dateFormat1.format(date));
						lblNewLabel_2.setText("\u05E9\u05E2\u05D4: "+dateFormat2.format(date));

						sleep(1000);
					}
				}
				catch(Exception e)
				{

				}
			}
		};
		clkthread.start();


	}
}

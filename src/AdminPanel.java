import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import com.mysql.jdbc.Statement;

import net.proteanit.sql.DbUtils;

import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdminPanel extends JFrame 
{

	private JPanel contentPane;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;

	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane;

	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;

	
	private JEditorPane editorPane;
	private JEditorPane editorPane_1;
	
	private JTextField textField;
	private JTextField textField_1;
	
	private ButtonGroup bg = new ButtonGroup();
	private JButton btnNewButton_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
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
	public AdminPanel() {
		setTitle("\u05D7\u05DC\u05D5\u05DF \u05DE\u05E0\u05D4\u05DC");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminPanel.class.getResource("/conimgs/title_icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 50, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton_1 = new JButton("\u05E2\u05D3\u05DB\u05DF \u05E2\u05E8\u05DA");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int row = table.getSelectedRow();
				
				try
				{
					if (row<0)
						JOptionPane.showMessageDialog(null, "לחץ על הערך ועדכן ואז לחץ על עדכן ערך", "row selection", JOptionPane.ERROR_MESSAGE);
					else
					{
						String valNum = table.getModel().getValueAt(row, 0).toString();
						String dynValue = table.getModel().getValueAt(row, 2).toString();
						String valquery = "UPDATE `dynamic` SET `ערך`='"+dynValue+"' WHERE `מספר משתנה`='"+valNum+"'";
						
						Statement myStmt = (Statement) Driver.getDatabaseDriver().conn.createStatement();
						myStmt.executeUpdate(valquery);
						Driver.viewTable("dynamic", table, Driver.getDatabaseDriver().conn);


						DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
						centerRenderr.setHorizontalAlignment(JLabel.CENTER);
						table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
						table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
						table.getColumnModel().getColumn(2).setCellRenderer(centerRenderr);
						
						JOptionPane.showMessageDialog(null, "הערך החדש עודכן ");

					}
						
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}



			}
		});
		
		btnNewButton_4 = new JButton("\u05DE\u05D7\u05E7 \u05DE\u05E9\u05EA\u05DE\u05E9");
		btnNewButton_4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				int row = table_1.getSelectedRow();

				int response = 0;
				
				try
				{
					if(row<0)
					{
						JOptionPane.showMessageDialog(null, "בחר משתמש", "row selection", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else
					{
						 response = JOptionPane.showConfirmDialog(null, "האם אתה בטוח שאתה רוצה להמשיך?", "Confirm",
							        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					}
				    if (response == JOptionPane.NO_OPTION) 
				    {
				    	return;
				    }
				    else if (response == JOptionPane.YES_OPTION) 
				    {
				    	String userID=(table_1.getModel().getValueAt(row, 0)).toString();
						String userId="userName";
						String userDeleteQuery = "DELETE FROM `login` WHERE  `"+userId+"`= '"+userID+"'";
						
						Statement myStatement = (Statement) Driver.getDatabaseDriver().conn.createStatement();
						myStatement.executeUpdate(userDeleteQuery);
						
						String query = "SELECT userName as 'שם משתמש' , Password as 'סיסמה' , permission as 'הרשאה'  FROM login";
						Statement stt3 = (Statement) Driver.getDatabaseDriver().conn.createStatement();
						ResultSet rset3 = stt3.executeQuery(query);
						table_1.setModel(DbUtils.resultSetToTableModel(rset3));
								
						DefaultTableCellRenderer centerRender_1 = new DefaultTableCellRenderer();
						centerRender_1.setHorizontalAlignment(JLabel.CENTER);
						table_1.getColumnModel().getColumn(0).setCellRenderer(centerRender_1);
						table_1.getColumnModel().getColumn(1).setCellRenderer(centerRender_1);
						table_1.getColumnModel().getColumn(2).setCellRenderer(centerRender_1);
						
						JOptionPane.showMessageDialog(null, "המשתמש נמחק ");

						

				    }
				    
				}
				
				catch(SQLException exc)
				{
					JOptionPane.showMessageDialog(null, "שם משתמש נמצא בשימוש, נא לכניס שם משתמש אחר");
				}

			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(11, 184, 120, 24);
		contentPane.add(btnNewButton_4);
		
		btnNewButton_2 = new JButton("\u05D0\u05D9\u05E9\u05D5\u05E8");
		btnNewButton_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textField.getText().equals("") || textField_1.getText().equals("") )
				{
				    JOptionPane.showMessageDialog(null,"עליך למלא את כל השדות!" ); 
				    
				}
				else
				{
					String per = "";
					if(rdbtnNewRadioButton.isSelected())
					{
						per = "מנהל";
					}
					else if(rdbtnNewRadioButton_1.isSelected())
					{
						per = "עובד";
					}
					String userInsertQuery = "INSERT INTO `login`(`userName`, `Password`, `permission`) VALUES ('" + textField.getText() + "', '" + textField_1.getText() + "', '" + per +"')";
					
					try 
					{
							Statement statement1 = (Statement) Driver.getDatabaseDriver().conn.createStatement();
							statement1.executeUpdate(userInsertQuery);
							
							String query = "SELECT userName as 'שם משתמש' , Password as 'סיסמה' , permission as 'הרשאה'  FROM login";
							Statement stt2 = (Statement) Driver.getDatabaseDriver().conn.createStatement();
							ResultSet rset2 = stt2.executeQuery(query);
							table_1.setModel(DbUtils.resultSetToTableModel(rset2));
									
							DefaultTableCellRenderer centerRender_1 = new DefaultTableCellRenderer();
							centerRender_1.setHorizontalAlignment(JLabel.CENTER);
							table_1.getColumnModel().getColumn(0).setCellRenderer(centerRender_1);
							table_1.getColumnModel().getColumn(1).setCellRenderer(centerRender_1);
							table_1.getColumnModel().getColumn(2).setCellRenderer(centerRender_1);
							
							JOptionPane.showMessageDialog(null, "המשתמש הוכנס למערכת ");
							textField.setText("");
							textField_1.setText("");
							rdbtnNewRadioButton_1.setSelected(true);
		
					}
					
					catch(SQLException exc)
					{
						JOptionPane.showMessageDialog(null, "שם משתמש נמצא בשימוש, נא לכניס שם משתמש אחר");
					}
					

				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(11, 149, 121, 24);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 258, 468, 302);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable()
		{
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			};
			
		};
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		JTableHeader Theader = table_1.getTableHeader();
        Theader.setBackground(Color.pink);
        Theader.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane_1.setViewportView(table_1);
		
		rdbtnNewRadioButton_1 = new JRadioButton("\u05E2\u05D5\u05D1\u05D3");
		rdbtnNewRadioButton_1.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton_2.doClick();
			}
		});
		rdbtnNewRadioButton_1.setHorizontalTextPosition(SwingConstants.LEFT);
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton_1.setBounds(210, 210, 61, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton = new JRadioButton("\u05DE\u05E0\u05D4\u05DC");
		rdbtnNewRadioButton.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton_2.doClick();
			}
		});
		rdbtnNewRadioButton.setHorizontalTextPosition(SwingConstants.LEFT);
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton.setBounds(286, 210, 61, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1.setSelected(true);
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		
		lblNewLabel_11 = new JLabel("\u05D1\u05D7\u05E8 \u05D4\u05E8\u05E9\u05D0\u05D4:");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_11.setBounds(353, 211, 99, 30);
		contentPane.add(lblNewLabel_11);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton_2.doClick();
			}
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if( c == 39)
				{
					e.consume();
					getToolkit().beep();
				    JOptionPane.showMessageDialog(null,"אין להקליד  גרש" );
				}
			}
		});
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_1.setBounds(172, 164, 143, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent arg0) 
			{
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton_2.doClick();
			}
			@Override
			public void keyTyped(KeyEvent arg0)
			{
				char c = arg0.getKeyChar();
				if( c == 39)
				{
					arg0.consume();
					getToolkit().beep();
				    JOptionPane.showMessageDialog(null,"אין להקליד  גרש" );
				}
			}
		});
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setBounds(172, 128, 143, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_10 = new JLabel("\u05D1\u05D7\u05E8 \u05E1\u05D9\u05E1\u05DE\u05D4:");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(357, 170, 99, 30);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_9 = new JLabel("\u05D1\u05D7\u05E8 \u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9:");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(321, 132, 126, 30);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_8 = new JLabel("\u05D4\u05D2\u05D3\u05E8\u05EA \u05DE\u05E9\u05EA\u05DE\u05E9\u05D9\u05DD \u05D7\u05D3\u05E9\u05D9\u05DD \u05D1\u05DE\u05E2\u05E8\u05DB\u05EA:");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(172, 76, 275, 30);
		contentPane.add(lblNewLabel_8);
		
		editorPane_1 = new JEditorPane();
		editorPane_1.setEditable(false);
		editorPane_1.setText(" \u05DE\u05E0\u05D4\u05DC");
		editorPane_1.setFont(new Font("Tahoma", Font.BOLD, 45));
		editorPane_1.setBounds(485, 0, 150, 59);
		contentPane.add(editorPane_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(946, 493, 138, 35);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_7 = new JLabel("\u05E9\u05D9\u05E0\u05D9\u05D9\u05DD \u05E2\u05E8\u05DB\u05D9\u05DD \u05D3\u05D9\u05E0\u05DE\u05D9\u05D9\u05DD:");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(890, 258, 169, 35);
		contentPane.add(lblNewLabel_7);
		
		editorPane = new JEditorPane();
		editorPane.setText("\u05DC\u05D7\u05E5 \u05E9\u05EA\u05D9 \u05DC\u05D7\u05D9\u05E6\u05D5\u05EA \u05E2\u05DC\r\n\u05D4\u05E2\u05E8\u05DA \u05D4\u05E8\u05E6\u05D5\u05D9, \u05D1\u05E6\u05E2 \u05D0\u05EA\r\n\u05D4\u05E9\u05D9\u05E0\u05D5\u05D9 \u05D4\u05E8\u05E6\u05D5\u05D9 \u05D5\u05D0\u05D6 \u05DC\u05D7\u05E5\r\n\u05E2\u05DC \u05E2\u05D3\u05DB\u05DF \u05E2\u05E8\u05DA\r\n ");
		editorPane.setFont(new Font("Tahoma", Font.BOLD, 13));
		editorPane.setBounds(946, 317, 138, 147);
		editorPane.setEditable(false);
		contentPane.add(editorPane);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(604, 314, 332, 246);
		contentPane.add(scrollPane);
		
		table = new JTable()
		{
			public boolean isCellEditable(int row, int column) 
			{
				return column==2;
			};
		};
				
				
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		JTableHeader Theaderr = table.getTableHeader();
        Theaderr.setBackground(Color.pink);
        Theaderr.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane.setViewportView(table);
		
		lblNewLabel_6 = new JLabel("----------------------------------------------------------------------------------");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(594, 240, 500, 14);
		contentPane.add(lblNewLabel_6);
		
		btnNewButton = new JButton("\u05DB\u05E1\u05E4\u05D9\u05DD");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				FinancialWindow newFrame = new FinancialWindow();
				newFrame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(641, 110, 226, 80);
		contentPane.add(btnNewButton);
		
		lblNewLabel_5 = new JLabel("\u05DB\u05E0\u05D9\u05E1\u05D4 \u05DC\u05DB\u05E1\u05E4\u05D9\u05DD:");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(954, 76, 150, 30);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 0, 90, 21);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel("\u05E9\u05DC\u05D5\u05DD \u05DE\u05E0\u05D4\u05DC:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(108, 0, 90, 21);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(984, 28, 120, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(954, 11, 150, 16);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 1094, 571);
		contentPane.add(lblNewLabel);
		
		
		ImageIcon pic1 = new ImageIcon(AdminPanel.class.getResource("conimgs/background.jpg"));
		Image tempImage1 = pic1.getImage();
		Image Imagetemp1 = tempImage1.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image1= new ImageIcon(Imagetemp1);
		lblNewLabel.setIcon(image1);
		
		lblNewLabel_4.setText(ConMainActivity.username);
		
		
		
		
		setclk();

		
		String dyQuery = "SELECT * FROM dynamic";
		try
		{
			Statement stt1 = (Statement) Driver.getDatabaseDriver().conn.createStatement();
			ResultSet rset1 = stt1.executeQuery(dyQuery);
			table.setModel(DbUtils.resultSetToTableModel(rset1));
					
			DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
			centerRenderr.setHorizontalAlignment(JLabel.CENTER);
			table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
			table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
			table.getColumnModel().getColumn(2).setCellRenderer(centerRenderr);
				
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		String logQuery = "SELECT userName as 'שם משתמש' , Password as 'סיסמה' , permission as 'הרשאה'  FROM login";
		try
		{
			Statement stt2 = (Statement) Driver.getDatabaseDriver().conn.createStatement();
			ResultSet rset2 = stt2.executeQuery(logQuery);
			table_1.setModel(DbUtils.resultSetToTableModel(rset2));
					
			DefaultTableCellRenderer centerRender_1 = new DefaultTableCellRenderer();
			centerRender_1.setHorizontalAlignment(JLabel.CENTER);
			table_1.getColumnModel().getColumn(0).setCellRenderer(centerRender_1);
			table_1.getColumnModel().getColumn(1).setCellRenderer(centerRender_1);
			table_1.getColumnModel().getColumn(2).setCellRenderer(centerRender_1);
				
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
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

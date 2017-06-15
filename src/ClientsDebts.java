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

import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.ComponentOrientation;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientsDebts extends JFrame 
{

	private JPanel contentPane;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	
	private JTextField textField;
	private JTextField textField_1;
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	
	public static JTable table;
	
	
	
	Connection conn1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ClientsDebts frame = new ClientsDebts();
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
	public ClientsDebts() 
	{
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientsDebts.class.getResource("/conimgs/title_icon.png")));
		setTitle("\u05D7\u05D5\u05D1\u05D5\u05EA \u05DC\u05E7\u05D5\u05D7\u05D5\u05EA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 30, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 499, 448);
		contentPane.add(scrollPane);
		
		table = new JTable()
		{
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			};
			
		};
		table.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e) 
			{
				JTable table1 =(JTable) e.getSource();
		        Point p = e.getPoint();
		        int row = table1.rowAtPoint(p);
		        int resp = 0;
		        
		        if (e.getClickCount() == 2) 
		        {
		        	resp = JOptionPane.showConfirmDialog(null, "שתי לחיצות על השורה מעבירה אותך לחלון תשלומי חוב , אתה רוצה להמשיך?", "Confirm",
					        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		        	
		        	if (resp == JOptionPane.NO_OPTION) 
				    {
				    	return;
				    }
		        	else if (resp == JOptionPane.YES_OPTION) 
				    {
		        		PayedDebts.debtNum = Integer.parseInt(table1.getModel().getValueAt(row, 0).toString());
			        	PayedDebts.pSum = Float.parseFloat(table1.getModel().getValueAt(row, 4).toString());
			        	PayedDebts.stillNotPayed = Float.parseFloat(table1.getModel().getValueAt(row, 5).toString());
			        	
			        	PayedDebts Pnew = new PayedDebts();
						Pnew.setVisible(true);
			        }
		        		
		        }	
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		JTableHeader Theader = table.getTableHeader();
        Theader.setBackground(Color.pink);
        Theader.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane.setViewportView(table);
		
		btnNewButton_1 = new JButton("\u05DE\u05D7\u05E7 \u05D7\u05D5\u05D1");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int row = table.getSelectedRow();
				int debtId = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
		        int response = 0;
				try
				{
					if(row<0)
					{
						JOptionPane.showMessageDialog(null, "בחר תשלום למחיקה", "row selection", JOptionPane.ERROR_MESSAGE);
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
						Statement stt = (Statement) conn1.createStatement();

				    	String deleteDQuery = "DELETE FROM `debtspayments` WHERE   `מספר חוב` = "+debtId+"";
						stt.executeUpdate(deleteDQuery);
						
				    	String deleteCQuery = "DELETE FROM `clientsdebts` WHERE   `מספר חוב` = "+debtId+"";
						stt.executeUpdate(deleteCQuery);
						
						Driver.viewTable("clientsdebts", table, conn1);
						DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
						centerRenderr.setHorizontalAlignment(JLabel.CENTER);
						table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
						table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
						table.getColumnModel().getColumn(2).setCellRenderer(centerRenderr);
						table.getColumnModel().getColumn(3).setCellRenderer(centerRenderr);
						table.getColumnModel().getColumn(4).setCellRenderer(centerRenderr);
						table.getColumnModel().getColumn(5).setCellRenderer(centerRenderr);
					
						
				    }
				}
				catch (Exception e) 
				{
					// TODO: handle exception
				}
				
				
				}
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(531, 291, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton = new JButton("\u05D0\u05D9\u05E9\u05D5\u05E8");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(textField.getText().equals("") || textField_1.getText().equals("") )
				{
				    JOptionPane.showMessageDialog(null,"עליך למלא את כל השדות!" ); 
				    
				}
				else 
				{
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					LocalDateTime now = LocalDateTime.now();
					String debtsQuery = "INSERT INTO `clientsdebts`(`תאריך ושעה`, `שם מלא`, `חוב`, `שולם`, `לא שולם`) VALUES ('" + dtf.format(now) + "','" + textField.getText() + "','" + textField_1.getText() + "','0','" + textField_1.getText() + "')";
					
					try 
					{
							Statement stt = (Statement) conn1.createStatement();
							stt.executeUpdate(debtsQuery);
							Driver.viewTable("clientsdebts", table, conn1);
							DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
							centerRenderr.setHorizontalAlignment(JLabel.CENTER);
							table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
							table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
							table.getColumnModel().getColumn(2).setCellRenderer(centerRenderr);
							table.getColumnModel().getColumn(3).setCellRenderer(centerRenderr);
							table.getColumnModel().getColumn(4).setCellRenderer(centerRenderr);
							table.getColumnModel().getColumn(5).setCellRenderer(centerRenderr);
					
						
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
					textField.setText("");
					textField_1.setText("");
					
					
					
					
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(680, 290, 89, 23);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton.doClick();
			}
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_ENTER  ))
				{
					e.consume();
					getToolkit().beep();
				    JOptionPane.showMessageDialog(null,"אין להקליד אותיות, רק מספרים" ); 

					
				}
			}
		});
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_1.setBounds(531, 209, 140, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent arg0) 
			{
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton.doClick();
			}
			@Override
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar();
				if(Character.isDigit(c))
				{
					e.consume();
					getToolkit().beep();
				    JOptionPane.showMessageDialog(null,"אין להקליד מספרים, רק אותיות" );
				}
			}
		});
		textField.setBounds(531, 171, 140, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_6 = new JLabel("\u05E1\u05DB\u05D5\u05DD \u05D7\u05D5\u05D1:");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setBounds(681, 209, 103, 25);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_5 = new JLabel("\u05E9\u05DD \u05DE\u05DC\u05D0:");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(681, 166, 103, 25);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 0, 90, 21);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel("\u05DE\u05D7\u05D5\u05D1\u05E8: ");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(108, 0, 63, 21);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(690, 32, 140, 25);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(660, 11, 146, 25);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 814, 571);
		contentPane.add(lblNewLabel);
		
		ImageIcon pic = new ImageIcon(ClientsDebts.class.getResource("conimgs/background.jpg"));
		Image tempImage = pic.getImage();
		Image Imagetemp = tempImage.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image= new ImageIcon(Imagetemp);
		lblNewLabel.setIcon(image);
		
		lblNewLabel_4.setText(ConMainActivity.username);
		
		conn1 = (Connection) Driver.getConnection();
		Driver.viewTable("clientsdebts", table, conn1);
		DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
		centerRenderr.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderr);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderr);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderr);
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderr);
	
		
		
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

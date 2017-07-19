import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import com.mysql.jdbc.Statement;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class PayedDebts extends JFrame
{

	private JPanel contentPane;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_1;
	
	private JComboBox comboBox;
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	
	private JTable table;
	
	public static float pSum;
	public static float stillNotPayed;
	public static int debtNum;
	
	

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
					PayedDebts frame = new PayedDebts();
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
	
	//Constructor
	public PayedDebts() 
	{
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PayedDebts.class.getResource("/conimgs/title_icon.png")));
		setTitle("\u05EA\u05E9\u05DC\u05D5\u05DE\u05D9 \u05D7\u05D5\u05D1");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 30, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(518, 171, 116, 20);
		contentPane.add(comboBox);
		comboBox.addItem("מזומן");
		comboBox.addItem("אשראי");
		comboBox.addItem("ציק");


		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 499, 448);
		contentPane.add(scrollPane);
		
		table = new JTable()
		{
			//All the cells is not editable 
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			};
			
		};
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		JTableHeader Theader = table.getTableHeader();
        Theader.setBackground(Color.pink);
        Theader.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane.setViewportView(table);
		
		btnNewButton_1 = new JButton("\u05DE\u05D7\u05E7 \u05EA\u05E9\u05DC\u05D5\u05DD");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			//Delete payment from the client payments and update the debt in the clientsdebts window 
			public void actionPerformed(ActionEvent arg0)
			{

		        int row = table.getSelectedRow();
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
				    		int id = Integer.parseInt(table.getModel().getValueAt(row, 2).toString());
				    		pSum = pSum - Integer.parseInt(table.getModel().getValueAt(row, 4).toString());
				    		stillNotPayed = stillNotPayed + Integer.parseInt(table.getModel().getValueAt(row, 4).toString());
						 
							try
							{
								Statement stt = (Statement) Driver.getDatabaseDriver().conn.createStatement();
						 
								String queryUp="UPDATE `clientsdebts` SET `שולם`="+pSum+",`לא שולם`="+stillNotPayed+" WHERE `מספר חוב` = "+debtNum+"";
								stt.executeUpdate(queryUp);
								
								String selecQuery = "SELECT * FROM `clientsdebts` ORDER BY `תאריך ושעה` DESC";
								ResultSet rs2 = stt.executeQuery(selecQuery);
								ClientsDebts.table.setModel(DbUtils.resultSetToTableModel(rs2));
								
								//Driver.viewTable("clientsdebts", ClientsDebts.table, Driver.getDatabaseDriver().conn);
								
								DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
								centerRenderr.setHorizontalAlignment(JLabel.CENTER);
								ClientsDebts.table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
								ClientsDebts.table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
								ClientsDebts.table.getColumnModel().getColumn(2).setCellRenderer(centerRenderr);
								ClientsDebts.table.getColumnModel().getColumn(3).setCellRenderer(centerRenderr);
								ClientsDebts.table.getColumnModel().getColumn(4).setCellRenderer(centerRenderr);
								ClientsDebts.table.getColumnModel().getColumn(5).setCellRenderer(centerRenderr);

								String dQuery = "DELETE FROM `debtspayments` WHERE   `מספר תשלום` = "+id+"";
								stt.executeUpdate(dQuery);
								
								String pQuery = " SELECT * FROM `debtspayments` WHERE `מספר חוב` = "+debtNum+" ORDER BY `תאריך ושעה` DESC";
								ResultSet rs = stt.executeQuery(pQuery);
								table.setModel(DbUtils.resultSetToTableModel(rs));


								table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
								table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
								table.getColumnModel().getColumn(2).setCellRenderer(centerRenderr);
								table.getColumnModel().getColumn(3).setCellRenderer(centerRenderr);
								table.getColumnModel().getColumn(4).setCellRenderer(centerRenderr);
							
								JOptionPane.showMessageDialog(null, "התשלום נמחק והחוב עודכן");

							}
							catch (Exception e)
							{
								// TODO: handle exception
							}

					}
				}
				catch (Exception e)
				{
					// TODO: handle exception
				}
			}
				
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(531, 291, 116, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton = new JButton("\u05D0\u05D9\u05E9\u05D5\u05E8");
		btnNewButton.addActionListener(new ActionListener() 
		{
			//If the whole debt payed, show message, if not deduct the payment from the debts and update the debt in clientsdebts window
			public void actionPerformed(ActionEvent arg0) 
			{
				if( textField_1.getText().equals("") )
				{
				    JOptionPane.showMessageDialog(null,"עליך למלא את כל השדות!" ); 
				    
				}
				else 
				{
				

						if((stillNotPayed-(Float.parseFloat(textField_1.getText()))) >= 0)
						{
							if((stillNotPayed-(Float.parseFloat(textField_1.getText()))) == 0)
							{
								JOptionPane.showMessageDialog(null, "החוב שולם במלואו");

							}
						    pSum = pSum + (Float.parseFloat(textField_1.getText()));
						   	stillNotPayed = stillNotPayed - (Float.parseFloat(textField_1.getText()));
						
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
							LocalDateTime now = LocalDateTime.now();
							String debtpayedQuery = "INSERT INTO `debtspayments`(`מספר חוב`, `תאריך ושעה`, `סוג תשלום`, `סכום ששולם`) VALUES ('" + debtNum  + "','" + dtf.format(now) + "','" + comboBox.getSelectedItem().toString() +"','" + textField_1.getText() + "')";
							
							String queryUp="UPDATE `clientsdebts` SET `שולם`="+pSum+",`לא שולם`="+stillNotPayed+" WHERE `מספר חוב` = "+debtNum+"";
	
							
							try 
							{
								Statement stt = (Statement) Driver.getDatabaseDriver().conn.createStatement();
								stt.executeUpdate(debtpayedQuery);
									
								String query = " SELECT * FROM `debtspayments` WHERE `מספר חוב` = "+debtNum+" ORDER BY `תאריך ושעה` DESC";
								ResultSet rs = stt.executeQuery(query);
								table.setModel(DbUtils.resultSetToTableModel(rs));
			
								DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
								centerRenderr.setHorizontalAlignment(JLabel.CENTER);
								table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
								table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
								table.getColumnModel().getColumn(2).setCellRenderer(centerRenderr);
								table.getColumnModel().getColumn(3).setCellRenderer(centerRenderr);
								table.getColumnModel().getColumn(4).setCellRenderer(centerRenderr);
									
								stt.executeUpdate(queryUp);
								
								String seleQuery = "SELECT * FROM `clientsdebts` ORDER BY `תאריך ושעה` DESC";
								ResultSet rs1 = stt.executeQuery(seleQuery);
								ClientsDebts.table.setModel(DbUtils.resultSetToTableModel(rs1));
								//Driver.viewTable("clientsdebts", ClientsDebts.table, Driver.getDatabaseDriver().conn);
									
								ClientsDebts.table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
								ClientsDebts.table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
								ClientsDebts.table.getColumnModel().getColumn(2).setCellRenderer(centerRenderr);
								ClientsDebts.table.getColumnModel().getColumn(3).setCellRenderer(centerRenderr);
								ClientsDebts.table.getColumnModel().getColumn(4).setCellRenderer(centerRenderr);
								ClientsDebts.table.getColumnModel().getColumn(5).setCellRenderer(centerRenderr);
									
								JOptionPane.showMessageDialog(null, "התשלום נרשם והחוב עודכן");
								textField_1.setText("");
									
							} 
							catch (SQLException e) 
							{
								e.printStackTrace();
							}
								
						}
						else
						{
							JOptionPane.showMessageDialog(null,"או שהחוב שולם במלואו או שאתה מנסה להכניס תשלום גדול מהחוב !!" );
							textField_1.setText("");
						}
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
			//If the pressed key is enter, click the button
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton.doClick();
			}
			//If the typed key is not number, show message 
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
		textField_1.setBounds(518, 213, 116, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_6 = new JLabel("\u05E1\u05DB\u05D5\u05DD \u05E9\u05E9\u05D5\u05DC\u05DD:");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setBounds(644, 209, 140, 25);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_5 = new JLabel("\u05D0\u05DE\u05E6\u05E2\u05D9 \u05EA\u05E9\u05DC\u05D5\u05DD:");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(644, 166, 140, 25);
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
		
		//Background image  
		ImageIcon pic = new ImageIcon(PayedDebts.class.getResource("conimgs/background.jpg"));
		Image tempImage = pic.getImage();
		Image Imagetemp = tempImage.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image= new ImageIcon(Imagetemp);
		lblNewLabel.setIcon(image);
		
		lblNewLabel_4.setText(ConMainActivity.username);
		
		//Show the table always 
		try 
		{
			String query = " SELECT * FROM `debtspayments` WHERE `מספר חוב` = "+debtNum+" ORDER BY `תאריך ושעה` DESC";
			Statement stt = (Statement) Driver.getDatabaseDriver().conn.createStatement();
			ResultSet rs = stt.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
			centerRenderr.setHorizontalAlignment(JLabel.CENTER);
			table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
			table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
			table.getColumnModel().getColumn(2).setCellRenderer(centerRenderr);
			table.getColumnModel().getColumn(3).setCellRenderer(centerRenderr);
			table.getColumnModel().getColumn(4).setCellRenderer(centerRenderr);
		}
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		
		setclk();

		
	}
	//Display the clock always 
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

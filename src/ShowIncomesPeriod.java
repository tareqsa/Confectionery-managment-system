import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;

import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ShowIncomesPeriod extends JFrame 
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
	private JTable table;
	private JButton btnNewButton;
	
	
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;

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
					ShowIncomesPeriod frame = new ShowIncomesPeriod();
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
	public ShowIncomesPeriod() 
	{
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShowIncomesPeriod.class.getResource("/conimgs/title_icon.png")));
		setTitle("\u05D4\u05E6\u05D2 \u05EA\u05E7\u05D5\u05E4\u05EA \u05D4\u05DB\u05E0\u05E1\u05D4");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 30, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_15.setForeground(Color.WHITE);
		lblNewLabel_15.setBounds(51, 504, 140, 23);
		contentPane.add(lblNewLabel_15);
		
		lblNewLabel_14 = new JLabel("\u05E9\"\u05D7");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setBounds(20, 504, 46, 23);
		contentPane.add(lblNewLabel_14);
		
		lblNewLabel_13 = new JLabel("\u05E1\u05DB\u05D5\u05DD \u05D4\u05DE\u05E2\"\u05DE:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setBounds(201, 507, 242, 23);
		contentPane.add(lblNewLabel_13);
		
		lblNewLabel_12 = new JLabel("\u05E9\"\u05D7");
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_12.setBounds(20, 538, 46, 23);
		contentPane.add(lblNewLabel_12);
		
		lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_11.setBounds(51, 538, 140, 23);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_10 = new JLabel("\u05E1\u05D4\"\u05DB \u05D4\u05DB\u05E0\u05E1\u05D4 \u05DC\u05EA\u05E7\u05D5\u05E4\u05D4 \u05D0\u05D7\u05E8\u05D9 \u05DE\u05E2\"\u05DE: ");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(201, 537, 239, 23);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_9 = new JLabel("\u05E9\"\u05D7");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(20, 478, 46, 23);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(51, 478, 140, 23);
		contentPane.add(lblNewLabel_8);
		
		
		
		lblNewLabel_7 = new JLabel("\u05E1\u05D4\"\u05DB \u05D4\u05DB\u05E0\u05E1\u05D4 \u05DC\u05EA\u05E7\u05D5\u05E4\u05D4 \u05DC\u05E4\u05E0\u05D9 \u05DE\u05E2\"\u05DE: ");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(201, 478, 242, 23);
		contentPane.add(lblNewLabel_7);
		
		btnNewButton = new JButton("\u05D4\u05E6\u05D2");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(129, 119, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 172, 774, 295);
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
		
		lblNewLabel_6 = new JLabel("\u05E2\u05D3 \u05EA\u05D0\u05E8\u05D9\u05DA: ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(440, 109, 80, 21);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_5 = new JLabel("\u05DE\u05EA\u05D0\u05E8\u05D9\u05DA: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(712, 109, 72, 21);
		contentPane.add(lblNewLabel_5);
		
		JDateChooser dateChooser = new JDateChooser();
		JTextFieldDateEditor editor2 = (JTextFieldDateEditor) dateChooser.getDateEditor();
		editor2.setEditable(false);
		dateChooser.setBounds(597, 109, 105, 33);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser_1.getDateEditor();
		editor.setEditable(false);
		dateChooser_1.setBounds(325, 109, 105, 33);
		contentPane.add(dateChooser_1);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(10, 0, 90, 21);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel("\u05DE\u05D7\u05D5\u05D1\u05E8: ");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(108, 0, 63, 21);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(659, 11, 146, 25);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(690, 32, 140, 25);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 794, 571);
		contentPane.add(lblNewLabel);
		
		ImageIcon pic = new ImageIcon(ShowIncomesPeriod.class.getResource("conimgs/background.jpg"));
		Image tempImage = pic.getImage();
		Image Imagetemp = tempImage.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image= new ImageIcon(Imagetemp);
		lblNewLabel.setIcon(image);
		
		lblNewLabel_4.setText(ConMainActivity.username);
		
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Date dateFromChooser1 = dateChooser.getDate();
				Date dateFromChooser2 = dateChooser_1.getDate();
				if(!(dateChooser.getDate() == null)  && (!(dateChooser_1.getDate() == null)))
				{
					if (!(dateFromChooser2.before(dateFromChooser1)))
					{
						//System.out.println(dateFromChooser1);
	
						String sdate = String.format("%1$tY-%1$tm-%1$td",dateFromChooser1);
						String edate = String.format("%1$tY-%1$tm-%1$td",dateFromChooser2);
						//System.out.println(sdate);
						//String perQuery = "SELECT `שם פרטי`, `שם משפחה FROM `orders` WHERE `תאריך ושעה` BETWEEN '"+sdate+"' AND '"+edate+"'";  
						String incPeriodQuery = "SELECT  `תאריך ושעה`, `שם פרטי`, `שם משפחה`, `מבצע ההזמנה`, `עלות` FROM `orders` WHERE  `תאריך ושעה` BETWEEN '"+sdate+"' AND '"+edate+"'"; 
						String incPeriodSumQuery = "SELECT SUM(`עלות`) FROM `orders` WHERE  `תאריך ושעה` BETWEEN '"+sdate+"' AND '"+edate+"'";
						String vatQuery = "SELECT ערך FROM `dynamic` WHERE `שם משתנה` = 'מעמ'  ";
						try 
						{
						
							Statement stt = (Statement) Driver.getDatabaseDriver().conn.createStatement();
							ResultSet rset = stt.executeQuery(incPeriodQuery);
							int rowsCounter=0;
		
							while(rset.next())
							{
								rowsCounter++;
							}
							rset.first();
							rset.previous();
					    
							if(rowsCounter>0)
							{
								table.setModel(DbUtils.resultSetToTableModel(rset));
								DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
								centerRenderr.setHorizontalAlignment(JLabel.CENTER);
								table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
								table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
								table.getColumnModel().getColumn(2).setCellRenderer(centerRenderr);
								table.getColumnModel().getColumn(3).setCellRenderer(centerRenderr);
								table.getColumnModel().getColumn(4).setCellRenderer(centerRenderr);
								
								
								ResultSet perSumSet = stt.executeQuery(incPeriodSumQuery);
								perSumSet.next();
								String perSum = perSumSet.getString(1);
								lblNewLabel_11.setText(perSum);
								float incAfterVat = Float.parseFloat(perSum);
								//System.out.println(beforeTax);
								
								ResultSet vatValSet = stt.executeQuery(vatQuery);
								vatValSet.next();
								float Vval = Float.parseFloat(vatValSet.getString(1));
								float incBeforeVat = incAfterVat/(1+Vval);
								lblNewLabel_8.setText(String.valueOf(incBeforeVat));
								lblNewLabel_15.setText(String.valueOf((incAfterVat/(1+Vval))*Vval));
							}
					    
							else 
							{
								table.setModel(DbUtils.resultSetToTableModel(rset));
								lblNewLabel_8.setText("0");
								lblNewLabel_11.setText("0");
								lblNewLabel_15.setText("0");
								JOptionPane.showMessageDialog(null,"לא נמצאו נתונים !!" );
							}
							
				    	
						}
						catch(Exception e1)
						{
							e1.printStackTrace();
	
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"תאריך הכניסה לא יכול להיות גדול מתאריך היציאה !!" );
	
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"עליך להזין תאריך כניסה ותאריך יציאה!" );

				}
			
			}
		});

		
		
		
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
						lblNewLabel_2.setText("\u05EA\u05D0\u05E8\u05D9\u05DA: "+dateFormat1.format(date));
						lblNewLabel_1.setText("\u05E9\u05E2\u05D4: "+dateFormat2.format(date));

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

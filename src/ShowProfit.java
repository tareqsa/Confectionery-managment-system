


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class ShowProfit extends JFrame 
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
	
	private JButton btnNewButton;
	
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	

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
					ShowProfit frame = new ShowProfit();
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
	public ShowProfit() 
	{
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShowProfit.class.getResource("/conimgs/title_icon.png")));
		setTitle("\u05D4\u05E6\u05D2 \u05E8\u05D5\u05D5\u05D7");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 70, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser_1.getDateEditor();
		editor.setEditable(false);
		
		lblNewLabel_16 = new JLabel("\u05E9\"\u05D7");
		lblNewLabel_16.setForeground(Color.WHITE);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_16.setBounds(61, 420, 64, 30);
		contentPane.add(lblNewLabel_16);
		
		lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_15.setForeground(Color.WHITE);
		lblNewLabel_15.setBounds(170, 417, 275, 43);
		contentPane.add(lblNewLabel_15);
		
		lblNewLabel_14 = new JLabel("\u05D4\u05E8\u05D5\u05D5\u05D7 \u05DC\u05EA\u05E7\u05D5\u05E4\u05D4 \u05DB\u05D5\u05DC\u05DC \u05DE\u05E2\"\u05DE:");
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_14.setBounds(492, 417, 332, 37);
		contentPane.add(lblNewLabel_14);
		
		lblNewLabel_13 = new JLabel("\u05E9\"\u05D7");
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_13.setBounds(61, 340, 64, 30);
		contentPane.add(lblNewLabel_13);
		
		lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setBounds(170, 334, 275, 43);
		contentPane.add(lblNewLabel_12);
		
		lblNewLabel_11 = new JLabel("\u05E1\u05D4\"\u05DB \u05D4\u05DE\u05E2\"\u05DE \u05DC\u05EA\u05E7\u05D5\u05E4\u05D4:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setBounds(534, 336, 250, 37);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_10 = new JLabel("\u05E9\"\u05D7");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setBounds(61, 293, 64, 30);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(170, 287, 275, 43);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_8 = new JLabel(" \u05D4\u05E8\u05D5\u05D5\u05D7 \u05DC\u05EA\u05E7\u05D5\u05E4\u05D4 \u05DC\u05DC\u05D0 \u05DE\u05E2\"\u05DE: ");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_8.setBounds(492, 289, 323, 36);
		contentPane.add(lblNewLabel_8);
		dateChooser_1.setBounds(222, 178, 107, 30);
		contentPane.add(dateChooser_1);
		
		JDateChooser dateChooser = new JDateChooser();
		JTextFieldDateEditor editor2 = (JTextFieldDateEditor) dateChooser.getDateEditor();
		editor2.setEditable(false);
		dateChooser.setBounds(544, 178, 107, 30);
		contentPane.add(dateChooser);
		
		btnNewButton = new JButton("\u05D4\u05E6\u05D2 \u05E8\u05D5\u05D5\u05D7");
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
						String incExpStDate = String.format("%1$tY-%1$tm-%1$td",dateFromChooser1);
						String incExpEnDate = String.format("%1$tY-%1$tm-%1$td",dateFromChooser2);
						
						//String expStDate = String.format("%1$tY-%1$tm-%1$td",dateFromChooser1);
						//String expEnDate = String.format("%1$tY-%1$tm-%1$td",dateFromChooser2);
						
						String incPeriodSumQuery = "SELECT SUM(`עלות`) FROM `orders` WHERE  `תאריך ושעה` BETWEEN '"+incExpStDate+"' AND '"+incExpEnDate+"'";
						String expPeriodSumQuery = "SELECT SUM(`סכום`) FROM `expenses` WHERE  `תאריך ושעה` BETWEEN '"+incExpStDate+"' AND '"+incExpEnDate+"'";
						String vatQuery = "SELECT ערך FROM `dynamic` WHERE `שם משתנה` = 'מעמ'  ";
	
						try
						{
							Statement stt = (Statement) Driver.getDatabaseDriver().conn.createStatement();
							ResultSet incSet = stt.executeQuery(incPeriodSumQuery);
							incSet.next();
							float incSum = incSet.getFloat(1);
							
							ResultSet expSet = stt.executeQuery(expPeriodSumQuery);
							expSet.next();
							float expSum = expSet.getFloat(1);
							
							float profWthVat = incSum-expSum;
							lblNewLabel_15.setText(String.valueOf(profWthVat));
							
							ResultSet vatValSet = stt.executeQuery(vatQuery);
							vatValSet.next();
							float vatVal = vatValSet.getFloat(1);
							
							float profVatVal = (profWthVat/(1+vatVal))*vatVal;
							lblNewLabel_12.setText(String.valueOf(profVatVal));
							
							float profWithoutVat = (profWthVat/(1+vatVal));
							lblNewLabel_9.setText(String.valueOf(profWithoutVat));
								
						}
						catch(Exception exx)
						{
							exx.printStackTrace();
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
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(36, 185, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		
		lblNewLabel_7 = new JLabel("\u05E2\u05D3 \u05EA\u05D0\u05E8\u05D9\u05DA:");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(357, 178, 100, 30);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_6 = new JLabel("\u05DE\u05EA\u05D0\u05E8\u05D9\u05DA: ");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(678, 178, 100, 30);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_5 = new JLabel("\u05D1\u05D7\u05E8 \u05EA\u05E7\u05D5\u05E4\u05D4 \u05DC\u05D4\u05E6\u05D2\u05EA \u05E8\u05D5\u05D5\u05D7:");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(608, 91, 176, 30);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 0, 90, 21);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel("\u05DE\u05D7\u05D5\u05D1\u05E8:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(108, 0, 63, 21);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(691, 29, 146, 25);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(660, 11, 146, 25);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 804, 571);
		contentPane.add(lblNewLabel);
		
		ImageIcon pic = new ImageIcon(ShowProfit.class.getResource("conimgs/background.jpg"));
		Image tempImage = pic.getImage();
		Image Imagetemp = tempImage.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image= new ImageIcon(Imagetemp);
		lblNewLabel.setIcon(image);
		
		lblNewLabel_4.setText(ConMainActivity.username);

		
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

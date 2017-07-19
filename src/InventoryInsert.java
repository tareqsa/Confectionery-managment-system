import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class InventoryInsert extends JFrame 
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
					InventoryInsert frame = new InventoryInsert();
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
	public InventoryInsert() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(InventoryInsert.class.getResource("/conimgs/title_icon.png")));
		setTitle("\u05D4\u05D5\u05E1\u05E3 \u05DE\u05E8\u05DB\u05D9\u05D1");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 200, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		btnNewButton = new JButton("\u05D0\u05D9\u05E9\u05D5\u05E8");
		btnNewButton.addActionListener(new ActionListener()
		{
			//Insert new ingredient
			public void actionPerformed(ActionEvent e)
			{
				if(textField.getText().equals("") || textField_1.getText().equals(""))
				{
				    JOptionPane.showMessageDialog(null,"עליך למלא את כל השדות!" ); 
				    
				}
				else
				{
					
					String query = "INSERT INTO `inventory`(`שם מרכיב`, `כמות במלאי בקג`) VALUES ('" + textField.getText() + "','" + textField_1.getText() + "') ";
					try 
					{
							Statement stat = (Statement) Driver.getDatabaseDriver().conn.createStatement();
							stat.executeUpdate(query);
							Driver.viewTable("inventory", InventoryWindow.table, Driver.getDatabaseDriver().conn);
							DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
							centerRenderr.setHorizontalAlignment(JLabel.CENTER);
							InventoryWindow.table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
							InventoryWindow.table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
							InventoryWindow.table.getColumnModel().getColumn(2).setCellRenderer(centerRenderr);
							
							JOptionPane.showMessageDialog(null, "המרכיב הוסף");
							textField.setText("");
							textField_1.setText("");
						
					} 
					catch (SQLException exp) 
					{
						exp.printStackTrace();
					}
					
						
				}
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(147, 192, 89, 23);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter()
		{
			//If enter key is pressed, click the button
			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton.doClick();
			}
			//If the typed key is not numbers show message 
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c== KeyEvent.VK_DELETE || c==KeyEvent.VK_ENTER ))
				{
					e.consume();
					getToolkit().beep();
				    JOptionPane.showMessageDialog(null,"אין להקליד אותיות, רק מספרים" );
				}
			}
		});
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_1.setBounds(256, 152, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
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
				if(Character.isDigit(c) || c == 39)
				{
					e.consume();
					getToolkit().beep();
				    JOptionPane.showMessageDialog(null,"אין להקליד מספרים, רק אותיות" );
				}
			}
		});
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setBounds(276, 110, 116, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_6 = new JLabel("\u05DB\u05DE\u05D5\u05EA \u05D1\u05DE\u05DC\u05D0\u05D9 \u05D1\u05E7\"\u05D2: ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(344, 150, 132, 20);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_5 = new JLabel("\u05E9\u05DD \u05DE\u05E8\u05DB\u05D9\u05D1: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(396, 108, 80, 20);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		lblNewLabel_2.setBounds(374, 29, 140, 25);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(344, 11, 140, 25);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 484, 261);
		contentPane.add(lblNewLabel);
		
		//Background image
		ImageIcon pic = new ImageIcon(InventoryInsert.class.getResource("conimgs/background.jpg"));
		Image tempImage = pic.getImage();
		Image Imagetemp = tempImage.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image= new ImageIcon(Imagetemp);
		lblNewLabel.setIcon(image);
		
		lblNewLabel_4.setText(ConMainActivity.username);

		
		
		
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

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import com.mysql.jdbc.Statement;

import java.awt.Color;
import java.awt.ComponentOrientation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;




public class OrdersWindow extends JFrame {

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
    
    private JButton btnNewButton;
    private JButton btnNewButton_1;
	
	private JEditorPane editorPane;
	
	
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	private JTable table1;
	Connection conn2;
	Connection conn3;
	private JTextField textField_7;


	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdersWindow frame = new OrdersWindow();
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
	public OrdersWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(OrdersWindow.class.getResource("/conimgs/title_icon.png")));
		setTitle("\u05D4\u05D6\u05DE\u05E0\u05D5\u05EA");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 50, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("\u05DB\u05DE\u05D5\u05EA \u05D1\u05E7\u05D9\u05DC\u05D5\u05D2\u05E8\u05DD:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setBounds(785, 137, 128, 22);
		contentPane.add(lblNewLabel_12);
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton_1.doClick();
			}
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
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_7.setBounds(690, 138, 90, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		lblNewLabel_11 = new JLabel("\u05D8\u05DC\u05E4\u05D5\u05DF: ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setBounds(430, 137, 109, 22);
		contentPane.add(lblNewLabel_11);
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent arg0) 
			{
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton_1.doClick();
			
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_ENTER  ))
				{
					arg0.consume();
					getToolkit().beep();
				    JOptionPane.showMessageDialog(null,"אין להקליד אותיות, רק מספרים" ); 

					
				}
			}
		});
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_6.setBounds(340, 139, 90, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setBounds(22, 0, 78, 21);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_9 = new JLabel("\u05DE\u05D7\u05D5\u05D1\u05E8: ");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(108, 0, 63, 21);
		contentPane.add(lblNewLabel_9);
		
		btnNewButton_1 = new JButton("\u05D0\u05D9\u05E9\u05D5\u05E8");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("") || textField_4.getText().equals("") || textField_6.getText().equals("") || textField_7.getText().equals(""))
				{
				    JOptionPane.showMessageDialog(null,"עליך למלא את השדות: שם פרטי, שם משפחה, סוג אירוע, מה הוזמן, כמות, עלות וטלפון!" ); 
				    
				}
				else
				{
					//FinancialWindow.incomingPass = Double.parseDouble(textField_4.getText());
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
					LocalDateTime now = LocalDateTime.now();
					conn3 = Driver.getConnection();
					String query = "INSERT INTO `orders`(`תאריך ושעה`, `שם פרטי`, `שם משפחה`, `סוג אירוע`, `מה הוזמן`, `כמות בקילוגרם`,`עלות`, `טלפון`, `מבצע ההזמנה`) VALUES ('" + dtf.format(now) + "','" + textField.getText() + "','" + textField_1.getText() + "','" + textField_2.getText() + "','" + textField_3.getText() + "','" + textField_7.getText() + "','" + textField_4.getText() + "','" + textField_6.getText() + "','" + lblNewLabel_10.getText() + "') ";
					try {
						Statement stt = (Statement) conn3.createStatement();
						stt.executeUpdate(query);
						Driver.viewTable("orders", table1, conn3);

						} catch (SQLException e) {
							e.printStackTrace();
						}
				
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_6.setText("");
						textField_7.setText("");

				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(149, 179, 107, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton = new JButton("\u05E9\u05DC\u05D7 \u05D4\u05D5\u05D3\u05E2\u05D4");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(32, 179, 107, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 213, 1074, 347);
		contentPane.add(scrollPane);
		
		table1 = new JTable();
		table1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		JTableHeader Theader = table1.getTableHeader();
        Theader.setBackground(Color.pink);
        Theader.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        scrollPane.setViewportView(table1);
		
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton_1.doClick();
			}
		});
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_5.setForeground(Color.BLACK);
		textField_5.setBounds(32, 138, 214, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		lblNewLabel_8 = new JLabel("\u05D3\u05D5\u05D0\"\u05DC:");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(266, 137, 94, 22);
		contentPane.add(lblNewLabel_8);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent arg0) 
			{
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton_1.doClick();
			}
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
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_4.setBounds(500, 138, 90, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		lblNewLabel_7 = new JLabel("\u05E2\u05DC\u05D5\u05EA:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(595, 137, 109, 22);
		contentPane.add(lblNewLabel_7);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent arg0) 
			{
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton_1.doClick();
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
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_3.setBounds(920, 138, 90, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_6 = new JLabel("\u05DE\u05D4 \u05D4\u05D5\u05D6\u05DE\u05DF:");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(1015, 137, 80, 22);
		contentPane.add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent arg0) 
			{
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton_1.doClick();
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
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_2.setBounds(500, 105, 90, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_5 = new JLabel("\u05E1\u05D5\u05D2 \u05D0\u05D9\u05E8\u05D5\u05E2:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBackground(Color.WHITE);
		lblNewLabel_5.setBounds(595, 104, 94, 22);
		contentPane.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent arg0) 
			{
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton_1.doClick();
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
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_1.setBackground(Color.WHITE);
		textField_1.setForeground(Color.BLACK);
		textField_1.setBounds(690, 105, 90, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_4 = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(785, 104, 109, 22);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent arg0) 
			{
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton_1.doClick();
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
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setBackground(Color.WHITE);
		textField.setBounds(920, 105, 90, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_3 = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(1015, 104, 80, 22);
		contentPane.add(lblNewLabel_3);
		
		
		
		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBackground(Color.WHITE);
		editorPane.setForeground(Color.BLACK);
		editorPane.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 45));
		editorPane.setText("\u05D4\u05D6\u05DE\u05E0\u05D5\u05EA");
		editorPane.setBounds(467, 0, 177, 59);
		contentPane.add(editorPane);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(984, 28, 120, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(954, 11, 150, 16);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 1094, 571);
		contentPane.add(lblNewLabel);
		
		ImageIcon pic = new ImageIcon(OrdersWindow.class.getResource("conimgs/background.jpg"));
		Image tempImage = pic.getImage();
		Image Imagetemp = tempImage.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image= new ImageIcon(Imagetemp);
		lblNewLabel.setIcon(image);
		
				
		
		
		
		lblNewLabel_10.setText(ConMainActivity.username);

		
		
		setclk();
		conn2 = Driver.getConnection();
		Driver.viewTable("orders", table1, conn2);
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



import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;


public class LogInWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	Connection conn0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInWindow frame = new LogInWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame
	 */
	public LogInWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogInWindow.class.getResource("/conimgs/title_icon.png")));
		setTitle("\u05DB\u05E0\u05D9\u05E1\u05D4 \u05DC\u05DE\u05E2\u05E8\u05DB\u05EA");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 200, 450, 270);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btnNewButton = new JButton("\u05D0\u05D9\u05E9\u05D5\u05E8");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String user = textField.getText();
				String pass = passwordField.getText();
				boolean ok=false;
			
				
				try{
					conn0 = Driver.getConnection(); 
					Statement stat = (Statement) conn0.createStatement();
				    String loginQuery="Select * FROM login ";
				    ResultSet rs = stat.executeQuery(loginQuery);
				    while(rs.next())
				    {
				    	if(user.equals(rs.getString("userName"))&& (pass.equals(rs.getString("Password"))))
				    	{
				    			ok=true;
				    			ConMainActivity.username = rs.getString("userName");
				    			break;    
				    	}
				    		
				    }
				    if(ok)
			    	{
		    			new ConMainActivity();
		    			dispose();
			    	}
				    else
				    {
					    JOptionPane.showMessageDialog(null,"שם משתמש או סיסמה שגויים!" ); 
				    }
				    stat.close();
				    conn0.close();
				    	
				    }		  
				catch(SQLException ex){
				   System.err.println(ex);
				  }
				}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(139, 188, 89, 30);
		contentPane.add(btnNewButton);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(341, 28, 103, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(312, 11, 132, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel("");
	    lblNewLabel_3.setBounds(0, 11, 86, 74);
	    contentPane.add(lblNewLabel_3);
	    
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton.doClick();
			}
		});
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.setBounds(118, 136, 137, 30);
		contentPane.add(passwordField);
		
		lblNewLabel_2 = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D4:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(324, 139, 74, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(288, 101, 86, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					btnNewButton.doClick();
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBackground(Color.WHITE);
		textField.setBounds(118, 95, 137, 30);
		contentPane.add(textField);
		textField.setColumns(10);
	
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 444, 240);
		contentPane.add(lblNewLabel_1);
		
		ImageIcon pic = new ImageIcon(LogInWindow.class.getResource("conimgs/background.jpg"));
		Image tempImage = pic.getImage();
		Image Imagetemp = tempImage.getScaledInstance(lblNewLabel_1.getWidth(),lblNewLabel_1.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image= new ImageIcon(Imagetemp);
		lblNewLabel_1.setIcon(image);
		

		ImageIcon pic1 = new ImageIcon(LogInWindow.class.getResource("conimgs/loginimg.jpg"));
		Image tempImage1 = pic1.getImage();
		Image Imagetemp1 = tempImage1.getScaledInstance(lblNewLabel_3.getWidth(),lblNewLabel_3.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image1= new ImageIcon(Imagetemp1);
		lblNewLabel_3.setIcon(image1);
		
		
		
		
		
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
						lblNewLabel_4.setText("\u05EA\u05D0\u05E8\u05D9\u05DA: "+dateFormat1.format(date));
						lblNewLabel_5.setText("\u05E9\u05E2\u05D4: "+dateFormat2.format(date));

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

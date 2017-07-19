

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JEditorPane;
import java.awt.SystemColor;
import java.awt.Frame;


public class ConMainActivity extends JFrame 
{

	public static String username = "";
	public static String userType = "";

	private JPanel contentPane;

	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;


	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_6;
	





	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					ConMainActivity frame = new ConMainActivity();
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
	public ConMainActivity() 
	{
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConMainActivity.class.getResource("/conimgs/title_icon.png")));
		setTitle("\u05E8\u05D0\u05E9\u05D9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);


		btnNewButton_1 = new JButton("\u05DE\u05D5\u05E6\u05E8\u05D9\u05DD");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setIcon(null);
		btnNewButton_1.addActionListener(new ActionListener()
		{
			//If the button is pressed open the products window
			public void actionPerformed(ActionEvent arg0) 
			{

				ProductsWindow newFrame = new ProductsWindow();
				newFrame.setVisible(true);
			}
		});
		btnNewButton_1.setSize(226, 80);
		btnNewButton_1.setLocation(1125, 150);

		btnNewButton_2 = new JButton("\u05D4\u05D6\u05DE\u05E0\u05D5\u05EA");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener()
		{
			//If the button is pressed open the orders window
			public void actionPerformed(ActionEvent e) 
			{

				OrdersWindow neww = new OrdersWindow();
				neww.setVisible(true);
			}
		});
		btnNewButton_2.setSize(226, 80);
		btnNewButton_2.setLocation(1125, 244);


		btnNewButton_3 = new JButton("\u05DC\u05E7\u05D5\u05D7\u05D5\u05EA");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			//If the button is pressed open the clients window
			public void actionPerformed(ActionEvent e)
			{

				ClientsWindow newFrame = new ClientsWindow();
				newFrame.setVisible(true);
			}
		});
		btnNewButton_3.setSize(226, 80);
		btnNewButton_3.setLocation(1125, 336);

		btnNewButton_4 = new JButton("\u05DE\u05DC\u05D0\u05D9");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.addActionListener(new ActionListener()
		{
			//If the button is pressed open the inventory window
			public void actionPerformed(ActionEvent arg0)
			{

				InventoryWindow newFrame = new InventoryWindow();
				newFrame.setVisible(true);
			}
		});
		btnNewButton_4.setSize(226, 80);
		btnNewButton_4.setLocation(1125, 428);

		btnNewButton_6 = new JButton("\u05E1\u05D9\u05D3\u05D5\u05E8 \u05E2\u05D1\u05D5\u05D3\u05D4");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_6.addActionListener(new ActionListener()
		{
			//If the button is pressed open the workschedule window
			public void actionPerformed(ActionEvent e) 
			{

				WorkScheduleWindow newFrame = new WorkScheduleWindow();
				newFrame.setVisible(true);
			}
		});
		btnNewButton_6.setSize(226, 80);
		btnNewButton_6.setLocation(1125, 520);
		
		btnNewButton = new JButton("\u05D7\u05DC\u05D5\u05DF \u05DE\u05E0\u05D4\u05DC");
		btnNewButton.addActionListener(new ActionListener() 
		{
			//If the button is pressed open the adminpanel window
			public void actionPerformed(ActionEvent arg0) 
			{
				AdminPanel newFrame = new AdminPanel();
				newFrame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(1125, 611, 226, 80);
		contentPane.add(btnNewButton);
		if(userType.equals("ордм"))
		{
			btnNewButton.setVisible(true);
		}
		
		else
		{
			btnNewButton.setVisible(false);

		}	
			
			
		
		JEditorPane dtrpnRachelConfectionery = new JEditorPane();
		dtrpnRachelConfectionery.setEditable(false);
		dtrpnRachelConfectionery.setForeground(SystemColor.activeCaption);
		dtrpnRachelConfectionery.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 70));
		dtrpnRachelConfectionery.setText("Rachel confectionery");
		dtrpnRachelConfectionery.setBounds(204, 53, 764, 80);
		contentPane.add(dtrpnRachelConfectionery);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(1262, 28, 120, 16);
		contentPane.add(lblNewLabel_3);


		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(1229, 12, 150, 16);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(22, 0, 78, 21);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_4 = new JLabel("\u05DE\u05D7\u05D5\u05D1\u05E8: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(108, 0, 63, 21);
		contentPane.add(lblNewLabel_4);


		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_3);
		contentPane.add(btnNewButton_4);
		contentPane.add(btnNewButton_6);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(16, 151, 1098, 540);
		contentPane.add(lblNewLabel_1);
		
		//Window image
		ImageIcon pic = new ImageIcon(ConMainActivity.class.getResource("conimgs/mainactivityimg.jpg"));
		Image tempImage = pic.getImage();
		Image Imagetemp = tempImage.getScaledInstance(lblNewLabel_1.getWidth(),lblNewLabel_1.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image= new ImageIcon(Imagetemp);
		lblNewLabel_1.setIcon(image);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1366, 715);

		contentPane.add(lblNewLabel);
		
		//Background image
		ImageIcon pic1 = new ImageIcon(ConMainActivity.class.getResource("conimgs/background.jpg"));
		Image tempImage1 = pic1.getImage();
		Image Imagetemp1 = tempImage1.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image1= new ImageIcon(Imagetemp1);
		lblNewLabel.setIcon(image1);

		lblNewLabel_5.setText(username);
		

		setclk();
	}
	//Display clock always
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
						lblNewLabel_3.setText("\u05E9\u05E2\u05D4: "+dateFormat2.format(date));

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

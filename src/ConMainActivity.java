

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;
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


public class ConMainActivity extends JFrame {

	private JPanel contentPane;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;





	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConMainActivity frame = new ConMainActivity();
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
	public ConMainActivity() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	    btnNewButton_1 = new JButton("\u05DE\u05D5\u05E6\u05E8\u05D9\u05DD");
		btnNewButton_1.setSize(210, 61);
		btnNewButton_1.setLocation(874, 122);

	    btnNewButton_2 = new JButton("\u05D4\u05D6\u05DE\u05E0\u05D5\u05EA");
		btnNewButton_2.setSize(210, 61);
		btnNewButton_2.setLocation(874, 194);


		btnNewButton_3 = new JButton("\u05DC\u05E7\u05D5\u05D7\u05D5\u05EA");
		btnNewButton_3.setSize(210, 61);
		btnNewButton_3.setLocation(874, 266);

		btnNewButton_4 = new JButton("\u05DE\u05DC\u05D0\u05D9");
		btnNewButton_4.setSize(210, 61);
		btnNewButton_4.setLocation(874, 338);

		btnNewButton_5 = new JButton("\u05DB\u05E1\u05E4\u05D9\u05DD");
		btnNewButton_5.setSize(210, 61);
		btnNewButton_5.setLocation(874, 410);

		btnNewButton_6 = new JButton("\u05E1\u05D9\u05D3\u05D5\u05E8");
		btnNewButton_6.setSize(210, 62);
		btnNewButton_6.setLocation(874, 482);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(984, 28, 120, 16);
		contentPane.add(lblNewLabel_3);


		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(954, 11, 150, 16);
		contentPane.add(lblNewLabel_2);


		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_3);
		contentPane.add(btnNewButton_4);
		contentPane.add(btnNewButton_5);
		contentPane.add(btnNewButton_6);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 122, 854, 422);
		contentPane.add(lblNewLabel_1);
		
		ImageIcon pic = new ImageIcon(ConMainActivity.class.getResource("conimgs/mainactivityimg.jpg"));
		Image tempImage = pic.getImage();
		Image Imagetemp = tempImage.getScaledInstance(lblNewLabel_1.getWidth(),lblNewLabel_1.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image= new ImageIcon(Imagetemp);
		lblNewLabel_1.setIcon(image);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1104, 611);
		contentPane.add(lblNewLabel);
		ImageIcon pic1 = new ImageIcon(ConMainActivity.class.getResource("conimgs/background.jpg"));
		Image tempImage1 = pic1.getImage();
		ImageIcon image1= new ImageIcon(tempImage1);
		Image Imagetemp1 = tempImage1.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
		lblNewLabel.setIcon(image1);





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

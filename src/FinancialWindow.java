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

import java.awt.Color;
import java.awt.ComponentOrientation;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.SystemColor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;

import com.mysql.jdbc.Statement;
import com.toedter.calendar.JMonthChooser;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;





public class FinancialWindow extends JFrame {
	
	//public static double incomingPass;
	
	private JPanel contentPane;
	
	private JEditorPane editorPane;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	
	Connection conn9;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinancialWindow frame = new FinancialWindow();
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
	public FinancialWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FinancialWindow.class.getResource("/conimgs/title_icon.png")));
		setTitle("\u05DB\u05E1\u05E4\u05D9\u05DD");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 50, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("\u05DC\u05E6\u05E4\u05D9\u05D9\u05D4 \u05D1\u05D4\u05DB\u05E0\u05E1\u05D5\u05EA");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
					ShowIncome Fnew = new ShowIncome();
					Fnew.setVisible(true);
			}
		});
		
		btnNewButton_5 = new JButton("\u05D0\u05D9\u05E4\u05D5\u05E1 \u05D4\u05D5\u05E6\u05D0\u05D5\u05EA");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_5.setBounds(503, 363, 150, 20);
		contentPane.add(btnNewButton_5);
		
		btnNewButton_4 = new JButton("\u05D4\u05D6\u05E0\u05D4 \u05D9\u05D3\u05E0\u05D9\u05EA");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(503, 331, 150, 20);
		contentPane.add(btnNewButton_4);
		
		btnNewButton_3 = new JButton("\u05DC\u05E6\u05E4\u05D9\u05D9\u05D4 \u05D1\u05D4\u05D5\u05E6\u05D0\u05D5\u05EA");
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ShowExpenses Fnew = new ShowExpenses();
			    Fnew.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(503, 300, 150, 20);
		contentPane.add(btnNewButton_3);
		
		lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(732, 378, 208, 35);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(732, 228, 208, 35);
		contentPane.add(lblNewLabel_8);
		
		try 
		{
			conn9 = (Connection) Driver.getConnection();
			Statement st = (Statement) conn9.createStatement();
			String query = "SELECT SUM(`עלות`) FROM orders";
			ResultSet rset = st.executeQuery(query);
			
			rset.next();
		    String sum = rset.getString(1);
            
            lblNewLabel_8.setText(sum);
			
		} catch (SQLException e) {
			
			   e.printStackTrace();
	    }
		
		btnNewButton_2 = new JButton("\u05D0\u05D9\u05E4\u05D5\u05E1 \u05D4\u05DB\u05E0\u05E1\u05D5\u05EA");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(503, 213, 150, 20);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_1 = new JButton("\u05D1\u05D7\u05D9\u05E8\u05EA \u05EA\u05E7\u05D5\u05E4\u05D4");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				ShowPeriod Fnew = new ShowPeriod();
			    Fnew.setVisible(true);	
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(503, 182, 150, 20);
		contentPane.add(btnNewButton_1);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(503, 151, 150, 20);
		contentPane.add(btnNewButton);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_7.setBounds(676, 166, 174, 27);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_6 = new JLabel("\u05D4\u05D5\u05E6\u05D0\u05D5\u05EA \u05D7\u05D5\u05D3\u05E9\u05D9\u05D5\u05EA: ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(860, 300, 256, 59);
		contentPane.add(lblNewLabel_6);
		
		
		JLabel lblNewLabel_5 = new JLabel("\u05D4\u05DB\u05E0\u05E1\u05D5\u05EA \u05D7\u05D5\u05D3\u05E9\u05D9\u05D5\u05EA: ");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_5.setBounds(860, 151, 256, 59);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(22, 0, 78, 21);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel("\u05DE\u05D7\u05D5\u05D1\u05E8: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(108, 0, 63, 21);
		contentPane.add(lblNewLabel_3);
		
		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBackground(Color.WHITE);
		editorPane.setForeground(Color.BLACK);
		editorPane.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 45));
		editorPane.setText("\u05DB\u05E1\u05E4\u05D9\u05DD");
		editorPane.setBounds(467, 0, 168, 59);
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
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(0, 0, 1094, 571);
		contentPane.add(lblNewLabel);
		
		ImageIcon pic = new ImageIcon(FinancialWindow.class.getResource("conimgs/background.jpg"));
		Image tempImage = pic.getImage();
		Image Imagetemp = tempImage.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image= new ImageIcon(Imagetemp);
		lblNewLabel.setIcon(image);
		
		
		lblNewLabel_4.setText(ConMainActivity.username);
		
		//tempIncoming = Integer.parseInt(incomingPass);
		//allIncoming =+ tempIncoming;
		//incomingSum = Integer.toString(allIncoming);
		//lblNewLabel_8.setText(Double.toString(incomingPass));

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

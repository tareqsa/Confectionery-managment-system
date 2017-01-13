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
import java.sql.Connection;

import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;





public class ClientsWindow extends JFrame {

	private JPanel contentPane;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	
	
	private JEditorPane editorPane;
	private JLabel lblNewLabel_3;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientsWindow frame = new ClientsWindow();
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
	public ClientsWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField("\u05D4\u05DB\u05E0\u05E1 \u05DE\u05D9\u05DC\u05EA \u05DE\u05E4\u05EA\u05D7 \u05DB\u05D3\u05D9 \u05DC\u05DE\u05E6\u05D5\u05D0 \u05DC\u05E7\u05D5\u05D7 \u05DB\u05DC\u05E9\u05D4\u05D5...");
		textField.setForeground(Color.LIGHT_GRAY);
		textField.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	textField.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		        // nothing
		    }
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(166, 140, 917, 25);
		contentPane.add(textField);
		textField.setColumns(10); 
		
		
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
		
		lblNewLabel_3 = new JLabel("\u05D7\u05E4\u05E9 \u05DC\u05E7\u05D5\u05D7:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(997, 112, 130, 25);
		contentPane.add(lblNewLabel_3);
		
		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBackground(Color.WHITE);
		editorPane.setForeground(Color.BLACK);
		editorPane.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 45));
		editorPane.setText("\u05DC\u05E7\u05D5\u05D7\u05D5\u05EA");
		editorPane.setBounds(467, 0, 177, 59);
		contentPane.add(editorPane);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1094, 571);
		contentPane.add(lblNewLabel);
		
		ImageIcon pic = new ImageIcon(ClientsWindow.class.getResource("conimgs/background.jpg"));
		Image tempImage = pic.getImage();
		Image Imagetemp = tempImage.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image= new ImageIcon(Imagetemp);
		lblNewLabel.setIcon(image);
		
		
		
		
		
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

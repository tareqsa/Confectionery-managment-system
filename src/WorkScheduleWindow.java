import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Statement;
import com.toedter.calendar.JCalendar;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.beans.PropertyChangeEvent;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WorkScheduleWindow extends JFrame 
{

	private JPanel contentPane;
	private JEditorPane editorPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JCalendar calendar;
	private JTextArea textArea;
	
	private JButton btnNewButton;
	
	public static String userType = ""; 
	
	
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
					WorkScheduleWindow frame = new WorkScheduleWindow();
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
	public WorkScheduleWindow() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(WorkScheduleWindow.class.getResource("/conimgs/title_icon.png")));
		setTitle("\u05E1\u05D9\u05D3\u05D5\u05E8 \u05E2\u05D1\u05D5\u05D3\u05D4");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 50, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("\u05E2\u05D3\u05DB\u05D5\u05DF");
		btnNewButton.addActionListener(new ActionListener() 
		{
			//Insert shifts to database 
			public void actionPerformed(ActionEvent arg0) 
			{
				Date datetime = calendar.getDate();
				String date = String.format("%1$tY-%1$tm-%1$td",datetime);
				
				
				String text = textArea.getText();
				
				// using this query to update date message
				String query = "UPDATE `schedule` SET `הודעה`='"+text+"' WHERE `תאריך`='"+date+"'";
				
				//using this query to insert new date for the first time
				String insertQuery = "INSERT INTO `schedule`(`תאריך`, `הודעה`) VALUES ('"+date+"','"+text+"')";
				try
				{		
					Statement stt1 = (Statement) Driver.getDatabaseDriver().conn.createStatement();
					int res = stt1.executeUpdate(query);	
					
					if(res == 0)
						res = stt1.executeUpdate(insertQuery);
						
						

					JOptionPane.showMessageDialog(null, "עודכן");
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(298, 424, 89, 114);
		contentPane.add(btnNewButton);
		//manager permissions 
		if(userType.equals("מנהל"))
		{
			btnNewButton.setVisible(true);
		}
		else
		{
			btnNewButton.setVisible(false);
		}
		textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() 
		{
			//If typed key is ('), show message 
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if( c == 39)
				{
					e.consume();
					getToolkit().beep();
				}
			}
		});
		textArea.setFont(new Font("Tahoma", Font.BOLD, 20));
		textArea.setBounds(404, 424, 347, 114);
		contentPane.add(textArea);
		

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(22, 0, 78, 21);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_3 = new JLabel("\u05DE\u05D7\u05D5\u05D1\u05E8: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(108, 0, 63, 21);
		contentPane.add(lblNewLabel_3);



		calendar = new JCalendar();
		calendar.addPropertyChangeListener(new PropertyChangeListener() 
		{
			//Showing day shifts 
			public void propertyChange(PropertyChangeEvent arg0) 
			{
				Date datetime = calendar.getDate();
				String date = String.format("%1$tY-%1$tm-%1$td",datetime);
				String query = "  SELECT *  FROM schedule WHERE `תאריך`= '"+date+"'";
				try
				{
					Statement stt1 = (Statement) Driver.getDatabaseDriver().conn.createStatement();
					ResultSet rset = stt1.executeQuery(query);
					int counter=0;
					while(rset.next())
						counter++;
					
					rset.previous();
					if(counter>0)
						textArea.setText(rset.getString(2));
					else
						textArea.setText("");

				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		calendar.setBounds(50, 70, 1000, 350);
		contentPane.add(calendar);



		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBackground(Color.WHITE);
		editorPane.setForeground(Color.BLACK);
		editorPane.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 45));
		editorPane.setText("\u05E1\u05D9\u05D3\u05D5\u05E8 \u05E2\u05D1\u05D5\u05D3\u05D4");
		editorPane.setBounds(416, 0, 297, 59);
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

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-30, 0, 1134, 571);
		contentPane.add(lblNewLabel);

		//Background image 
		ImageIcon pic = new ImageIcon(WorkScheduleWindow.class.getResource("conimgs/background.jpg"));
		Image tempImage = pic.getImage();
		Image Imagetemp = tempImage.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image= new ImageIcon(Imagetemp);
		lblNewLabel.setIcon(image);

		lblNewLabel_4.setText(ConMainActivity.username);

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

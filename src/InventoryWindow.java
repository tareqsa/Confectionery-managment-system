import java.awt.EventQueue;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class InventoryWindow extends JFrame 
{

	private JPanel contentPane;
	
	private JEditorPane editorPane;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	public static JTable table;
	
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	
	
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
					InventoryWindow frame = new InventoryWindow();
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
	public InventoryWindow() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(InventoryWindow.class.getResource("/conimgs/title_icon.png")));
		setTitle("\u05DE\u05DC\u05D0\u05D9");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 50, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton_2 = new JButton("\u05E2\u05D3\u05DB\u05DF \u05DE\u05E8\u05DB\u05D9\u05D1");
		btnNewButton_2.addActionListener(new ActionListener()
		{
			//Update ingredients amount 
			public void actionPerformed(ActionEvent arg0)
			{
				int row = table.getSelectedRow();
				
				try
				{
					if (row<0)
						JOptionPane.showMessageDialog(null, "��� �� ����� ����� ���� ��� ��� �� ���� �����", "row selection", JOptionPane.ERROR_MESSAGE);
					else
					{
						String ingrID = table.getModel().getValueAt(row, 0).toString();
						String ingrName = table.getModel().getValueAt(row, 1).toString();
						String ingrAmount1 = table.getModel().getValueAt(row, 2).toString();
						float ingrAmount = Float.parseFloat(ingrAmount1);	
						String query = "UPDATE `inventory` SET `���� ����� ���`='"+ingrAmount+"' WHERE `���� �����`='"+ingrID+"'";
						
						Statement myStmt = (Statement) Driver.getDatabaseDriver().conn.createStatement();
						myStmt.executeUpdate(query);
						Driver.viewTable("inventory", table, Driver.getDatabaseDriver().conn);
			
						DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
						centerRenderr.setHorizontalAlignment(JLabel.CENTER);
						table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
						table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
						table.getColumnModel().getColumn(2).setCellRenderer(centerRenderr);
						
						JOptionPane.showMessageDialog(null, "������ �����");
					}
						
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}


			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(832, 115, 111, 28);
		contentPane.add(btnNewButton_2);
		
		btnNewButton = new JButton("\u05D4\u05D5\u05E1\u05E3 \u05DE\u05E8\u05DB\u05D9\u05D1");
		btnNewButton.addActionListener(new ActionListener() 
		{
			//If the button is pressed, open the insert new ingredient insert
			public void actionPerformed(ActionEvent e) 
			{
				new InventoryInsert();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(973, 115, 111, 28);
		contentPane.add(btnNewButton);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 1074, 409);
		contentPane.add(scrollPane);
		

		table = new JTable()
		{
			//Make just the amount cell editable  
			public boolean isCellEditable(int row, int column) 
			{
				return column==2;
			}
		};
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		JTableHeader Theader = table.getTableHeader();
        Theader.setBackground(Color.pink);
        Theader.setFont(new Font("Tahoma", Font.BOLD, 12));
		
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
		
		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBackground(Color.WHITE);
		editorPane.setForeground(Color.BLACK);
		editorPane.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 45));
		editorPane.setText("\u05DE\u05DC\u05D0\u05D9");
		editorPane.setBounds(492, 0, 133, 59);
		contentPane.add(editorPane);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1094, 571);
		contentPane.add(lblNewLabel);
		
		//Background image 
		ImageIcon pic = new ImageIcon(InventoryWindow.class.getResource("conimgs/background.jpg"));
		Image tempImage = pic.getImage();
		Image Imagetemp = tempImage.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image= new ImageIcon(Imagetemp);
		lblNewLabel.setIcon(image);

		
		
		
		
		lblNewLabel_4.setText(ConMainActivity.username);
		Driver.viewTable("inventory", table, Driver.getDatabaseDriver().conn);
		
		
		DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
		centerRenderr.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderr);
	

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

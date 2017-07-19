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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import com.mysql.jdbc.Statement;

import java.awt.Color;
import java.awt.ComponentOrientation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class ProductsWindow extends JFrame 
{

	private JPanel contentPane;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JEditorPane editorPane;
	public static JTable table;

	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try {
					ProductsWindow frame = new ProductsWindow();
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
	public ProductsWindow() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProductsWindow.class.getResource("/conimgs/title_icon.png")));
		setTitle("\u05DE\u05D5\u05E6\u05E8\u05D9\u05DD");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 50, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton_1 = new JButton("\u05DE\u05D7\u05E7 \u05DE\u05D5\u05E6\u05E8");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			//Delete product 
			public void actionPerformed(ActionEvent e) 
			{
				int row = table.getSelectedRow();

				
				int response = 0;
				try
				{
					if(row<0)
					{
						JOptionPane.showMessageDialog(null, "בחר מוצר", "row selection", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else
					{
						 response = JOptionPane.showConfirmDialog(null, "האם אתה בטוח שאתה רוצה להמשיך?", "Confirm",
							        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					}
				    if (response == JOptionPane.NO_OPTION) 
				    {
				    	return;
				    }
				    else if (response == JOptionPane.YES_OPTION) 
				    {
				    	String proName=(table.getModel().getValueAt(row, 1)).toString();
						String productName="שם מוצר";
						
						String query = "DELETE FROM `ingredients` WHERE  `"+productName+"`= '"+proName+"'";
						Statement myStmt = (Statement) Driver.getDatabaseDriver().conn.createStatement();
						myStmt.executeUpdate(query);
				    	
						String proID=(table.getModel().getValueAt(row, 0)).toString();
						String productId="מספר מוצר";
						
						String query2 = "DELETE FROM `products` WHERE  `"+productId+"`= '"+proID+"'";
						Statement myStmt2 = (Statement) Driver.getDatabaseDriver().conn.createStatement();
						myStmt.executeUpdate(query2);
						
						Driver.viewTable("products", table, Driver.getDatabaseDriver().conn);

						DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
						centerRenderr.setHorizontalAlignment(JLabel.CENTER);
						table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
						table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
						
						JOptionPane.showMessageDialog(null, "נמחק"); 
				    }

				    
				}
				
				catch(Exception ex)
				{
					ex.printStackTrace();
				}

			}
		});
		
		JButton button = new JButton("\u05E6\u05E4\u05D9\u05D9\u05D4 \u05D1\u05DE\u05E8\u05DB\u05D9\u05D1\u05D9 \u05DE\u05D5\u05E6\u05E8");
		button.addActionListener(new ActionListener() 
		{
			//Showing product ingredient 
			public void actionPerformed(ActionEvent arg0) 
			{
				int row = table.getSelectedRow();
				try
				{
					if(row<0)
					{
						JOptionPane.showMessageDialog(null, "בחר מוצר", "row selection", JOptionPane.ERROR_MESSAGE);
						return;
					}
					else 
				    {
				    	String proName=(table.getModel().getValueAt(row, 1)).toString();
				    	new ProductIngredients(proName);
				    }
				    }
				    catch (Exception e)
				    {
				    	e.printStackTrace();
				    }
				}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBounds(655, 95, 177, 28);
		contentPane.add(button);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(850, 95, 100, 28);
		contentPane.add(btnNewButton_1);
		
		btnNewButton = new JButton("\u05D4\u05D5\u05E1\u05E3 \u05DE\u05D5\u05E6\u05E8");
		btnNewButton.addActionListener(new ActionListener() 
		{
			//If button is pressed, open new product window 
			public void actionPerformed(ActionEvent arg0) 
			{
				newProduct np = new newProduct();
				np.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(969, 95, 100, 28);
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
		scrollPane.setBounds(44, 129, 1025, 420);
		contentPane.add(scrollPane);
		
		table = new JTable()
		{
			//All cells is not editable 
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			};
			
		};
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		JTableHeader Theader = table.getTableHeader();
        Theader.setBackground(Color.pink);
        Theader.setFont(new Font("Tahoma", Font.BOLD, 12));
          
		scrollPane.setViewportView(table);
		
		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBackground(Color.WHITE);
		editorPane.setForeground(Color.BLACK);
		editorPane.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 45));
		editorPane.setText("\u05DE\u05D5\u05E6\u05E8\u05D9\u05DD ");
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
		
		//Background image 
		ImageIcon pic = new ImageIcon(ProductsWindow.class.getResource("conimgs/background.jpg"));
		Image tempImage = pic.getImage();
		Image Imagetemp = tempImage.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image= new ImageIcon(Imagetemp);
		lblNewLabel.setIcon(image);
		
		
		lblNewLabel_4.setText(ConMainActivity.username);

		
		//Show the table always 
		Driver.viewTable("products", table, Driver.getDatabaseDriver().conn);
		
		DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
		centerRenderr.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
		
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

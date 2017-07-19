import java.awt.Color;
import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import com.mysql.jdbc.Statement;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Image;

public class ProductIngredients extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductIngredients frame = new ProductIngredients();
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
	//Constructor that take product name and bring its ingredients
	public ProductIngredients(String name)
	{
		this();
		String query = "SELECT `שם מרכיב`,`כמות` FROM `ingredients` WHERE `שם מוצר`='"+name+"'";

		try
		{
			Statement stt2 = (Statement) Driver.getDatabaseDriver().conn.createStatement();
			ResultSet rset2 = stt2.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rset2));

			DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
			centerRenderr.setHorizontalAlignment(JLabel.CENTER);
			table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
			table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//Constructor 
	public ProductIngredients() 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 414, 217);
		contentPane.add(scrollPane);
		setTitle("מרכיבי מוצר");

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setViewportView(table);
		JTableHeader Theader = table.getTableHeader();
        Theader.setBackground(Color.pink);
        Theader.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-11, 0, 457, 272);
		contentPane.add(lblNewLabel);
		
		//Background image 
		ImageIcon pic = new ImageIcon(ProductsWindow.class.getResource("conimgs/background.jpg"));
		Image tempImage = pic.getImage();
		Image Imagetemp = tempImage.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon image= new ImageIcon(Imagetemp);
		lblNewLabel.setIcon(image);
	}
}

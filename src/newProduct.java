import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class newProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newProduct frame = new newProduct();
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
	public newProduct() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(newProduct.class.getResource("/conimgs/title_icon.png")));
		setTitle("\u05D4\u05D5\u05E1\u05E4\u05EA \u05DE\u05D5\u05E6\u05E8");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 200, 717, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 91, 570, 264);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setViewportView(table);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField.setBounds(520, 54, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("\u05E9\u05DD \u05DE\u05D5\u05E6\u05E8");
		lblNewLabel.setBounds(616, 57, 62, 14);
		contentPane.add(lblNewLabel);

		JButton button = new JButton("\u05D4\u05D5\u05E1\u05E4\u05D4");
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				if(textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "עליך להכיס שם מוצר ומרכיביו קודם!" );
				}
				else
				{
				
						// adding new product to products table
						String productName =textField.getText().toString();
						String insertQueryToProducts = "INSERT INTO products (`שם מוצר`) VALUES ('"+productName+"') ";
						Boolean haveIngredients=false;
					try {
							
						//adding the checked ingredients to ingredients table
						for(int i=0; i<table.getRowCount(); i++)
						{
							int ingredientsNumber = Integer.parseInt(table.getValueAt(i, 0).toString());
							String ingredientsName = table.getValueAt(i, 1).toString();
							String quantity = table.getValueAt(i, 2).toString();
							Boolean check = Boolean.valueOf(table.getValueAt(i, 3).toString());
					
							//String insertQueryToIngredients = "INSERT INTO ingredients (`שם מוצר`,`מספר מרכיב`,`שם מרכיב`,כמות` ) VALUES('"+productName+"','"+ingredientsNumber+"','"+ingredientsName+"','"+quantity+"'";
							String insertQueryToIngredients = "INSERT INTO `ingredients`( `שם מוצר`, `מספר מרכיב`, `שם מרכיב`, `כמות`) VALUES ('"+productName+"','"+ingredientsNumber+"','"+ingredientsName+"','"+quantity+"')";
							if(check && !quantity.equals(""))
							{
								try
								{
									Statement stt2 = (Statement) Driver.getDatabaseDriver().conn.createStatement();
									stt2.executeUpdate(insertQueryToIngredients);
									haveIngredients=true;
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}
							}
					
						}
						if(haveIngredients)
						{
							Statement	stt = (Statement) Driver.getDatabaseDriver().conn.createStatement();
							stt.executeUpdate(insertQueryToProducts);
							JOptionPane.showMessageDialog(null, "המוצר נרשם");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "אין להכניס מוצר בלי מרכיבים");
						}
						Driver.viewTable("products", ProductsWindow.table, Driver.getDatabaseDriver().conn);
						DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
						centerRenderr.setHorizontalAlignment(JLabel.CENTER);
						ProductsWindow.table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
						ProductsWindow.table.getColumnModel().getColumn(1).setCellRenderer(centerRenderr);

						dispose();
					}
					catch (SQLIntegrityConstraintViolationException ex1) 
					{
						JOptionPane.showMessageDialog(null, "אי אפשר להשתמש בשם קיים" );
					}
					catch (SQLException e)
					{						
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
		button.setBounds(36, 363, 89, 23);
		contentPane.add(button);

		DefaultTableModel model = new DefaultTableModel()
		{
			public Class<?> getColumnClass(int column)
			{
				switch(column)
				{
				case 0:
					return int.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return Boolean.class;
					default:
						return String.class;
				}
			}
		};
		
		table.setModel(model);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(String.class, centerRenderer);
        table.setDefaultRenderer(int.class, centerRenderer);
        
		model.addColumn("מספר מרכיב");
		model.addColumn("שם מרכיב");
		model.addColumn("כמות");
		model.addColumn("נבחר");

		try
		{
				String query = "SELECT * FROM inventory";
				Statement mySt = (Statement) Driver.getDatabaseDriver().conn.createStatement();
				ResultSet myRs = mySt.executeQuery(query);
				
				int i=0;
				while(myRs.next())
				{
					model.addRow(new Object[0]);
					model.setValueAt(myRs.getInt(1), i, 0);
					model.setValueAt(myRs.getString(2), i, 1);
					model.setValueAt("", i, 2);
					model.setValueAt(false, i, 3);
				i++;
				}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}

import java.awt.EventQueue;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class ProductChooser extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductChooser frame = new ProductChooser();
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
	
	//Constructor 
	public ProductChooser() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProductChooser.class.getResource("/conimgs/title_icon.png")));
		setTitle("\u05DE\u05D5\u05E6\u05E8");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 150, 225, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 189, 315);
		contentPane.add(scrollPane);
		
		table = new JTable()
		{
			//All the cells is not editable 
			public boolean isCellEditable(int row, int column) 
		{
				return false;
		}
		};
		table.addMouseListener(new MouseAdapter() 
		{
			//Choose product from the table and insert its name in the textfield 
			@Override
			public void mousePressed(MouseEvent e)
			{
				JTable table1 =(JTable) e.getSource();
		        Point p = e.getPoint();
		        int row = table1.rowAtPoint(p);
		        if (e.getClickCount() == 2) 
		        {
		        	OrdersWindow.textField_3.setText(table1.getModel().getValueAt(row, 0).toString());
		        	dispose();     	
		        }
			}
		});
		scrollPane.setViewportView(table);
		
		//Show the table always 
		String query = "SELECT `שם מוצר` FROM products";
		try{
		Statement stt = Driver.getDatabaseDriver().conn.createStatement();
		ResultSet myRs = stt.executeQuery(query);
		table.setModel(DbUtils.resultSetToTableModel(myRs));
		DefaultTableCellRenderer centerRenderr = new DefaultTableCellRenderer();
		centerRenderr.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderr);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}

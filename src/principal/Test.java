package principal;

public class Test {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
package tp3;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class tp_p2 {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField id_input;
	private JTextField name_input;
	private JTable table;
	connectionClass cs1 = new connectionClass();
	Connection conn = cs1.conn;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tp_p2 window = new tp_p2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public tp_p2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(27, 10, 436, 253);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(21, 69, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(21, 38, 45, 13);
		panel.add(lblNewLabel_1);
		
		id_input = new JTextField();
		id_input.setBounds(63, 35, 96, 19);
		panel.add(id_input);
		id_input.setColumns(10);
		
		name_input = new JTextField();
		name_input.setBounds(63, 66, 96, 19);
		panel.add(name_input);
		name_input.setColumns(10);
		
		JButton addToBd = new JButton("Add to bd");
		addToBd.setBounds(63, 130, 85, 21);
		addToBd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(id_input.getText());
				String name = name_input.getText();
				
				User u = new User(id,name);
				
				try {
					cs1.createUser(u);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		panel.add(addToBd);
		
		JButton affich = new JButton("afficher");
		affich.setBounds(271, 34, 85, 21);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(236, 69, 166, 151);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel model = new DefaultTableModel();
		Object[]column= {"ID","Name"};
		final Object[]row=new Object[2];
		model.setColumnIdentifiers(column);
		table.setModel(model);		
		affich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String sql="select * from liste";
					PreparedStatement pst=conn.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					while(rs.next())
					{row[0]=rs.getLong("ID");
					row[1]=rs.getString("Name");
					model.addRow(row);
					}
					}
					catch(Exception exp)
					{
					System.out.println(exp);
					}
			}
		});
		panel.add(affich);
		
		
		
		
		
		
		
		
	}
		
	

}

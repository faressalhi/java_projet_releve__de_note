package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;    

public class Cv extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JRadioButton rdbFemme = new JRadioButton("Femme");
	private JRadioButton rdbHomme = new JRadioButton("Homme");
	private ButtonGroup bg = new ButtonGroup();
	private JTable table;
    private JScrollPane sp;    
    private JTextField loisir;
    private String sexe_selec="";
    
    /**
     connexion à la base de données
     * 
     */

 	public static Connection connectDB() throws ClassNotFoundException { 
 		Class.forName("com.mysql.jdbc.Driver"); 
 		Connection conn = null; 
 		try { 
 			conn = 
 			DriverManager.getConnection("jdbc:mysql://localhost:3306/cv", "root", ""); } 
 		catch (SQLException e) { 
 			// TODO Auto-generated catch block 
 			e.printStackTrace(); 
 		} 
 		return conn; 
 	}
 	
 	/**
 	 * 
 	 Méthode d'insertion: get the data from the fields and send them to the DB
 	 */
 	public void insererDB() {
 		Connection conn; 
 		try { 
 		conn = Cv.connectDB(); 
 		Statement stmt = conn.createStatement(); 
 		int rs = stmt.executeUpdate("insert into user(nom, prenom, genre)  values ('"+nom.getText()+"','"+prenom.getText()+"','"+sexe_selec+"')");
 		if (rs!=0) 
 			System.out.println("Personne insérée"); 
 		else System.out.println("erreur d'insertion ! réessayer"); 
 		conn.close(); 
 		} 
 		catch (ClassNotFoundException e) { 
 		// TODO Auto-generated catch block
 			e.printStackTrace(); 
 		} catch (SQLException e) { 
 		// TODO Auto-generated catch block 
 			e.printStackTrace(); 
 		}
 	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cv frame = new Cv();
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
	
	public Cv() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 569, 443);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Informations générales", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(31, 32, 49, 14);
		panel.add(lblNom);
		
		nom = new JTextField();
		nom.setBounds(90, 29, 96, 20);
		panel.add(nom);
		nom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(31, 92, 49, 14);
		panel.add(lblPrenom);
		
		prenom = new JTextField();
		prenom.setBounds(90, 89, 96, 20);
		panel.add(prenom);
		prenom.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(31, 144, 49, 14);
		panel.add(lblGenre);
		
		
		rdbFemme.setBounds(90, 140, 111, 23);
		panel.add(rdbFemme);
		

		rdbHomme.setBounds(262, 140, 111, 23);
		panel.add(rdbHomme);
		
		bg.add(rdbFemme);
		bg.add(rdbHomme);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Projet", null, panel_1, null);
		panel_1.setLayout(null);
		
		
		String data[][]={ {"101","Amit"},    
                {"102","Jai"},    
                {"101","Sachin"}};    
        String column[]={"PROJET","DESCRIPTION"};  
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 42, 490, 97);
		panel_1.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Projet", "Description"
			}
		));
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Loisirs et autres", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblLoisir = new JLabel("Loisir");
		lblLoisir.setBounds(45, 45, 49, 14);
		panel_2.add(lblLoisir);
		
		loisir = new JTextField();
		loisir.setBounds(162, 42, 96, 20);
		panel_2.add(loisir);
		loisir.setColumns(10);
		
		JButton btnAdd = new JButton("+");
		btnAdd.setBounds(86, 88, 89, 23);
		btnAdd.addActionListener(this);
		panel_2.add(btnAdd);
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Boolean test1, test2, test3;
		test1=test2=test3=true;
		
		ArrayList<String> loisirs = new ArrayList<String>();
		
		if ( (nom.getText().isEmpty()) || (prenom.getText().isEmpty()) || (loisir.getText().isEmpty()) ) {
			 test1 = false;
			 System.out.println("Veuillez remplir: nom, prenom et loisir !");
		}
		
		if (!rdbFemme.isSelected() && !rdbHomme.isSelected()) {
			test2 = false;
			System.out.println("Veuillez remplir votre genre !");
			
		}
		if ( rdbHomme.isSelected()){
			sexe_selec = "Homme";
		}
		if (rdbFemme.isSelected()) {
			sexe_selec = "Femme";
		}
		
		if((test1) && (test2)){
					
			insererDB();
					
		}	
	}	
}





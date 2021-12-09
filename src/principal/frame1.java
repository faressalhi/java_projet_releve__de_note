package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.ClasseDAO;
import DAO.ConnectionBD;
import DAO.EtudiantDAO;
import DAO.MatiereDAO;
import DAO.SectionDAO;
import entities.Classe;
import entities.Etudiant;
import entities.Matiere;
import entities.Section;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Scrollbar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class frame1 {

	private JFrame frame;
	private JTextField textField;
	private JPanel panel;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_2_1;
	private JTextField textField_2_2;
	private JTextField textField_2_3;
	private JTextField textField_2_4;
	private JTextField textField_3_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 window = new frame1();
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
	public frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 664, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// creation d'un JTabbedPane
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(28, 11, 581, 394);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(29, 52, 116, 110);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(155, 52, 116, 110);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(281, 52, 116, 110);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(281, 52, 116, 110);

		
		tabbedPane.add("Affichage",panel_1);  
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(21, 73, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(173, 43, 379, 315);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(21, 105, 86, 23);
		panel_1.add(btnNewButton_3);

		String liste_releve[]={"Section","Classe","Etudiant","Matiere","Note"};
		String liste_releve_affichage[]={"Classe","Etudiant"};

		
		JComboBox select_affichage = new JComboBox(liste_releve_affichage);
	    
		select_affichage.setBounds(21, 40, 86, 22);
		panel_1.add(select_affichage);
		
		JLabel lblNewLabel = new JLabel("RELEVE DE NOTES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(258, 18, 251, 14);
		panel_1.add(lblNewLabel);
	    tabbedPane.add("Insertion",panel_2);  
	    panel_2.setLayout(null);
	    
	    JComboBox select_insertion = new JComboBox(liste_releve);
	    
	    select_insertion.setBounds(31, 26, 86, 22);
	    panel_2.add(select_insertion);
	    
	    
	    JPanel panel_5 = new JPanel();
	    panel_5.setBounds(174, 44, 392, 279);
	    panel_2.add(panel_5);
	    panel_5.setLayout(null);
	    panel_5.setVisible(false);
	    
	    
	    JLabel label_1 = new JLabel("New label");
	    label_1.setBounds(60, 40, 115, 14);
	    panel_5.add(label_1);
	    
	    JLabel label_2 = new JLabel("New label");
	    label_2.setBounds(60, 75, 115, 14);
	    panel_5.add(label_2);
	    
	    JLabel label_3 = new JLabel("New label");
	    label_3.setBounds(60, 109, 115, 14);
	    panel_5.add(label_3);
	    
	    JLabel label_4 = new JLabel("New label");
	    label_4.setBounds(60, 141, 115, 14);
	    panel_5.add(label_4);
	    
	    textField_1 = new JTextField();
	    textField_1.setBounds(231, 37, 86, 20);
	    panel_5.add(textField_1);
	    textField_1.setColumns(10);
	    
	    textField_2 = new JTextField();
	    textField_2.setBounds(231, 72, 86, 20);
	    panel_5.add(textField_2);
	    textField_2.setColumns(10);
	    
	    textField_3 = new JTextField();
	    textField_3.setBounds(231, 106, 86, 20);
	    panel_5.add(textField_3);
	    textField_3.setColumns(10);
	    
	    textField_4 = new JTextField();
	    textField_4.setBounds(231, 138, 86, 20);
	    panel_5.add(textField_4);
	    textField_4.setColumns(10);
	    
	    
	    JButton btnInserer = new JButton("Insérer");
	    btnInserer.setBounds(132, 189, 89, 23);
	    panel_5.add(btnInserer); 
	    
	    // recuperer les elements du panel toggle
	    
	    
	    
	    JButton btnNewButton = new JButton("Sélectionner");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		panel_5.setVisible(true);
	    		
	    		String element = (String) select_insertion.getItemAt(select_insertion.getSelectedIndex());
	    		
	    		if (element == "Section") { 
	    			
	    				label_1.setText("Id Section : ");
	    				label_2.setText("Nom Section : ");
	    				
	    				
	    				label_3.setVisible(false);
	    				label_4.setVisible(false);
	    				textField_3.setVisible(false);
	    				textField_4.setVisible(false);
	    				
	    				btnInserer.addActionListener( new ActionListener () {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
								String id_section = textField_1.getText();
			    				String nom_section = textField_2.getText();
								
								
								ConnectionBD cdb = new ConnectionBD();
								Connection connection = null;
								try {
									 connection = cdb.connecter();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								if(id_section.equals("")) {
									System.out.println("remplir le champs");
								} else {
								
								// remplir un objet section
								Section s = new Section();
								s.setId_section(id_section);
								s.setNom_section(nom_section);
								
								// Ajout a la base
								SectionDAO sDAO = new SectionDAO();
								
								
								sDAO.connection = connection;
								try {
									sDAO.ajouteSection(s);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								cdb.deconnecter();
								
								textField_1.setText("");
								textField_2.setText("");
								
								}
								
							}
	    					
	    				});
	    				
	    				
	    		} else if (element == "Classe") {
	    				    				
		    			label_1.setText("Id Classe : ");
	    				label_2.setText("Nom Classe : ");
	    				label_3.setText("Id section : ");
	    				
	    				
	    				label_3.setVisible(true);
	    				textField_3.setVisible(true);
	    				
	    				label_4.setVisible(false);
	    				textField_4.setVisible(false);
	    			
	    				
	    				btnInserer.addActionListener( new ActionListener () {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
								String id_classe = textField_1.getText();
			    				String nom_classe = textField_2.getText();
			    				String id_section_classe = textField_3.getText();
								
								
								ConnectionBD cdb = new ConnectionBD();
								Connection connection = null;
								try {
									 connection = cdb.connecter();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								if(id_classe.equals("")) {
									System.out.println("remplir le champs");
								} else {
								
								// remplir un objet classe
								Classe c = new Classe();
								c.setId_classe(id_classe);
								c.setNom_classe(nom_classe);
								c.setId_Section(id_section_classe);
								
								
								
								// Ajout a la base
								ClasseDAO cDAO = new ClasseDAO();
								cDAO.connection = connection;
								try {
									cDAO.ajouteClasse(c);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								
								cdb.deconnecter();
								
								textField_1.setText("");
								textField_2.setText("");
								textField_3.setText("");

								}
							}
	    					
	    				});
	    				
	    				
	    				
	    		} else if (element == "Etudiant") {
	    			
	    				
		    			label_1.setText("Id Etudiant : ");
	    				label_2.setText("Nom Etudiant : ");
	    				label_3.setText("Prenom Etudiant : ");
	    				label_4.setText("Id classe : ");
	    				
	    				
	    				label_3.setVisible(true);
	    				label_4.setVisible(true);
	    				textField_3.setVisible(true);
	    				textField_4.setVisible(true);
	    			
	    				
	    				
	    				btnInserer.addActionListener( new ActionListener () {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
								String id_etudiant = textField_1.getText();
			    				String nom_etudiant = textField_2.getText();
			    				String prenom_etudiant = textField_3.getText();
			    				String id_classe_etudiant = textField_4.getText();
								
								
								ConnectionBD cdb = new ConnectionBD();
								Connection connection = null;
								try {
									 connection = cdb.connecter();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								if(id_etudiant.equals("")) {
									System.out.println("remplir le champs");
								} else {
								
								// remplir un objet etudiant
								Etudiant et = new Etudiant();
								et.setId_etudiant(id_etudiant);
								et.setNom_etudiant(nom_etudiant);
								et.setPrenom_etudiant(prenom_etudiant);
								et.setId_classe(id_classe_etudiant);
								
								
								
								// Ajout a la base
								EtudiantDAO eDAO = new EtudiantDAO();
								eDAO.connection = connection;
								try {
									eDAO.ajouteEtudiant(et);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								
								cdb.deconnecter();
								
								textField_1.setText("");
								textField_2.setText("");
								textField_3.setText("");
								textField_4.setText("");

								}
							}
	    					
	    				});
	    				
	    				
	
	    		} else if (element == "Matiere") {
	    			
		    			label_1.setText("Id Matiere : ");
	    				label_2.setText("Nom Matiere : ");
	    				label_3.setText("Coef Matiere : ");
	    				

	    				label_3.setVisible(true);
	    				textField_3.setVisible(true);
	    				label_4.setVisible(false);
	    				textField_4.setVisible(false);
	    			
	    				
	    				btnInserer.addActionListener( new ActionListener () {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
								String id_matiere = textField_1.getText();
			    				String nom_matiere = textField_2.getText();
			    				String coef_matiere = textField_3.getText();
								
								
								ConnectionBD cdb = new ConnectionBD();
								Connection connection = null;
								try {
									 connection = cdb.connecter();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								if(id_matiere.equals("")) {
									System.out.println("remplir le champs");
								} else {
								
								// remplir un objet etudiant
								Matiere m = new Matiere();
								m.setId_matiere(id_matiere);
								m.setNom_matiere(nom_matiere);
								m.setCoef_matiere(Float.parseFloat(coef_matiere));
								
								
								
								
								// Ajout a la base
								MatiereDAO mDAO = new MatiereDAO();
								mDAO.connection = connection;
								try {
									mDAO.ajouterMatiere(m);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								
								cdb.deconnecter();
								
								textField_1.setText("");
								textField_2.setText("");
								textField_3.setText("");

								}
							}
	    					
	    				});
	    				
	    				
	    				
	    				
	    				
	    		} else if (element == "Note") {
	    			
		    			label_1.setText("Id Note : ");
	    				label_2.setText("Type note : ");
	    				label_3.setText("Id etudiant : ");
	    				label_4.setText("Id matiere : ");
	    				String id_note = textField_1.getText();
	    				String type_note = textField_2.getText();
	    				String id_note_etudiant = textField_3.getText();
	    				String id_note_matiere = textField_4.getText();
	    				
	    				label_3.setVisible(true);
	    				label_4.setVisible(true);
	    				textField_3.setVisible(true);
	    				textField_4.setVisible(true);
	    				
	    				
	    				btnInserer.addActionListener( new ActionListener () {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
								String id_etudiant = textField_1.getText();
			    				String nom_etudiant = textField_2.getText();
			    				String prenom_etudiant = textField_3.getText();
			    				String id_classe_etudiant = textField_4.getText();
								
								
								ConnectionBD cdb = new ConnectionBD();
								Connection connection = null;
								try {
									 connection = cdb.connecter();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								if(id_etudiant.equals("")) {
									System.out.println("remplir le champs");
								} else {
								
								// remplir un objet etudiant
								Etudiant et = new Etudiant();
								et.setId_etudiant(id_etudiant);
								et.setNom_etudiant(nom_etudiant);
								et.setPrenom_etudiant(prenom_etudiant);
								et.setId_classe(id_classe_etudiant);
								
								
								
								// Ajout a la base
								EtudiantDAO eDAO = new EtudiantDAO();
								eDAO.connection = connection;
								try {
									eDAO.ajouteEtudiant(et);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								
								cdb.deconnecter();
								
								textField_1.setText("");
								textField_2.setText("");
								textField_3.setText("");
								textField_4.setText("");

								}
							}
	    					
	    				});
			
	    				
	    		
	    		}
	    			

	    		
	    		
	    		
	    	}
	    });
	    btnNewButton.setBounds(31, 83, 86, 23);
	    panel_2.add(btnNewButton);
	    
	    
	    
	    
	    
	   
	    tabbedPane.add("Modification",panel_3); 
	    panel_3.setLayout(null);
	    
	    JComboBox select_modification = new JComboBox(liste_releve);
	    select_modification.setBounds(50, 29, 86, 22);
	    panel_3.add(select_modification);
	    
	    
	    JPanel panel_5_1 = new JPanel();
	    panel_5_1.setLayout(null);
	    panel_5_1.setBounds(184, 29, 340, 296);
	    panel_3.add(panel_5_1);
	    panel_5_1.setVisible(false);

	    
	    JLabel label_2_1 = new JLabel("New label");
	    label_2_1.setBounds(47, 55, 96, 14);
	    panel_5_1.add(label_2_1);
	    
	    JLabel label_2_2 = new JLabel("New label");
	    label_2_2.setBounds(47, 90, 86, 14);
	    panel_5_1.add(label_2_2);
	    
	    JLabel label_2_3 = new JLabel("New label");
	    label_2_3.setBounds(47, 124, 86, 14);
	    panel_5_1.add(label_2_3);
	    
	    JLabel label_2_4 = new JLabel("New label");
	    label_2_4.setBounds(47, 156, 86, 14);
	    panel_5_1.add(label_2_4);
	    
	    textField_2_1 = new JTextField();
	    textField_2_1.setColumns(10);
	    textField_2_1.setBounds(211, 52, 86, 20);
	    panel_5_1.add(textField_2_1);
	    
	    textField_2_2 = new JTextField();
	    textField_2_2.setColumns(10);
	    textField_2_2.setBounds(211, 87, 86, 20);
	    panel_5_1.add(textField_2_2);
	    
	    textField_2_3 = new JTextField();
	    textField_2_3.setColumns(10);
	    textField_2_3.setBounds(211, 121, 86, 20);
	    panel_5_1.add(textField_2_3);
	    
	    textField_2_4 = new JTextField();
	    textField_2_4.setColumns(10);
	    textField_2_4.setBounds(211, 153, 86, 20);
	    panel_5_1.add(textField_2_4);
	    
	    JButton btnNewButton_4_1 = new JButton("New button");
	    btnNewButton_4_1.setBounds(136, 225, 89, 23);
	    panel_5_1.add(btnNewButton_4_1);
	    
	    
	    
	    JButton btnNewButton_1 = new JButton("New button");
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    		panel_5_1.setVisible(true);
	    		
	    		String element = (String) select_modification.getItemAt(select_modification.getSelectedIndex());
	    		
	    		if (element == "Section") { 
	    			
	    				label_2_1.setText("Id Section : ");
	    				label_2_2.setText("Nom Section : ");
	    				String id_section = textField_2_1.getText();
	    				String nom_section = textField_2_2.getText();
	    				
	    				label_2_3.setVisible(false);
	    				label_2_4.setVisible(false);
	    				textField_2_3.setVisible(false);
	    				textField_2_4.setVisible(false);
	    				
	    		} else if (element == "Classe") {
	    				    				
		    			label_2_1.setText("Id Classe : ");
	    				label_2_2.setText("Nom Classe : ");
	    				label_2_3.setText("Id section : ");
	    				String id_classe = textField_2_1.getText();
	    				String nom_classe = textField_2_2.getText();
	    				String id_section_classe = textField_2_3.getText();
	    				
	    				label_2_3.setVisible(true);
	    				textField_2_3.setVisible(true);
	    				
	    				label_2_4.setVisible(false);
	    				textField_2_4.setVisible(false);
	    			
	    		} else if (element == "Etudiant") {
	    			
	    				
		    			label_2_1.setText("Id Etudiant : ");
	    				label_2_2.setText("Nom Etudiant : ");
	    				label_2_3.setText("Prenom Etudiant : ");
	    				label_2_4.setText("Id classe : ");
	    				String id_etudiant = textField_2_1.getText();
	    				String nom_etudiant = textField_2_2.getText();
	    				String prenom_etudiant = textField_2_3.getText();
	    				String id_classe_etudiant = textField_2_4.getText();
	    				
	    				label_2_3.setVisible(true);
	    				label_2_4.setVisible(true);
	    				textField_2_3.setVisible(true);
	    				textField_2_4.setVisible(true);
	    				
	
	    		} else if (element == "Matiere") {
	    			
		    			label_2_1.setText("Id Matiere : ");
	    				label_2_2.setText("Nom Matiere : ");
	    				label_2_3.setText("Coef Matiere : ");
	    				String id_matiere = textField_2_1.getText();
	    				String nom_matiere = textField_2_2.getText();
	    				String coef_matiere = textField_2_3.getText();

	    				label_2_3.setVisible(true);
	    				textField_2_3.setVisible(true);
	    				label_2_4.setVisible(false);
	    				textField_2_4.setVisible(false);
	    			
	    		} else if (element == "Note") {
	    			
		    			label_2_1.setText("Id Note : ");
	    				label_2_2.setText("Type note : ");
	    				label_2_3.setText("Id etudiant : ");
	    				label_2_4.setText("Id matiere : ");
	    				String id_note = textField_2_1.getText();
	    				String type_note = textField_2_2.getText();
	    				String id_note_etudiant = textField_2_3.getText();
	    				String id_note_matiere = textField_2_4.getText();
	    				
	    				label_2_3.setVisible(true);
	    				label_2_4.setVisible(true);
	    				textField_2_3.setVisible(true);
	    				textField_2_4.setVisible(true);
	    				
	    		
	    		}
	    	
	    	}
	    });
	    btnNewButton_1.setBounds(50, 131, 89, 23);
	    panel_3.add(btnNewButton_1);
	    
	    
	    
	    
	    tabbedPane.addTab("Suppression", null, panel_4, null);
	    panel_4.setLayout(null);
	    
	    JComboBox select_suppression = new JComboBox(liste_releve);
	    select_suppression.setBounds(24, 34, 86, 22);
	    panel_4.add(select_suppression);
	    
	    
	  
	    
	    JPanel panel_5_2 = new JPanel();
	    panel_5_2.setLayout(null);
	    panel_5_2.setBounds(218, 61, 250, 206);
	    panel_5_2.setVisible(false);
	    panel_4.add(panel_5_2);
	    
	    JLabel label_3_1 = new JLabel("New label");
	    label_3_1.setBounds(10, 31, 78, 14);
	    panel_5_2.add(label_3_1);
	    
	    textField_3_1 = new JTextField();
	    textField_3_1.setColumns(10);
	    textField_3_1.setBounds(141, 28, 86, 20);
	    panel_5_2.add(textField_3_1);
	    
	    JButton btnNewButton_4_2 = new JButton("Supprimer");
	    btnNewButton_4_2.setBounds(84, 154, 89, 23);
	    panel_5_2.add(btnNewButton_4_2);
	    
	    
	    JButton btnNewButton_2 = new JButton("Sélectionner");
	    btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    		panel_5_2.setVisible(true);
	    		
	    		String element = (String) select_suppression.getItemAt(select_suppression.getSelectedIndex());
	    		
	    		if (element == "Section") { 
	    			
	    				label_3_1.setText("Id Section : ");
	    				String id_section = textField_3_1.getText();
	    				
	    				
	    		} else if (element == "Classe") {
	    				    				
		    			label_3_1.setText("Id Classe : ");
	    				String id_classe = textField_3_1.getText();
	    				
	    			
	    		} else if (element == "Etudiant") {
	    			
	    				
		    			label_3_1.setText("Id Etudiant : ");
	    				String id_etudiant = textField_3_1.getText();
	    				
	
	    		} else if (element == "Matiere") {
	    			
		    			label_3_1.setText("Id Matiere : ");
	    				String id_matiere = textField_3_1.getText();
	    			
	    		} else if (element == "Note") {
	    			
		    			label_3_1.setText("Id Note : ");
	    				String id_note = textField_3_1.getText();
	    				
	    		
	    		}
	    			

	    		
	    		
	    	}
	    });
	    
	    btnNewButton_2.setBounds(24, 117, 89, 23);
	    panel_4.add(btnNewButton_2);
	    
	    
	    
	    
	    
	}
}

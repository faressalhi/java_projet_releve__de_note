package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.Affichage;
import DAO.ClasseDAO;
import DAO.ConnectionBD;
import DAO.EtudiantDAO;
import DAO.MatiereDAO;
import DAO.NoteDAO;
import DAO.SectionDAO;
import entities.Classe;
import entities.Etudiant;
import entities.Matiere;
import entities.Note;
import entities.Section;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Scrollbar;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.Border;

import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JToggleButton;

public class frame1 {

	private JFrame frmGestionDesRelevs;
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
	private JTextField textField_3_2;
	private JTextField textField_3_3;
	private JTextField moyenne;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 window = new frame1();
					window.frmGestionDesRelevs.setVisible(true);
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
		frmGestionDesRelevs = new JFrame();
		frmGestionDesRelevs.setFont(new Font("Calisto MT", Font.BOLD, 12));
		frmGestionDesRelevs.setTitle("Gestion des relev\u00E9s de notes");
		frmGestionDesRelevs.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\fares\\Desktop\\2037131.png"));
		frmGestionDesRelevs.getContentPane().setBackground(SystemColor.textText);
		frmGestionDesRelevs.setBackground(UIManager.getColor("RadioButton.darkShadow"));
		frmGestionDesRelevs.setBounds(100, 100, 950, 580);
		frmGestionDesRelevs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDesRelevs.getContentPane().setLayout(null);
		
		// afficher un icone d'erreur dans chaque boite de dialogue d'erreur
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\fares\\Desktop\\error.jpg"); // assign image to a new ImageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH); // scale it smoothly  
		ImageIcon icon = new ImageIcon(newimg);  // assign to a new ImageIcon instance

		
		
		// creation d'un JTabbedPane
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(25, 28, 899, 475);
		frmGestionDesRelevs.getContentPane().add(tabbedPane);
		
		// panel d'affichage
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 128), 3, true), new LineBorder(new Color(0, 0, 0), 3, true)));
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(29, 52, 116, 110);
		
		// panel d'insertion
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(155, 52, 116, 110);

		// panel de modification
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(281, 52, 116, 110);

		// panel de suppression
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(281, 52, 116, 110);

		
		tabbedPane.add("Affichage",panel_1);  
		panel_1.setLayout(null);
		
		// les entres de JComboBox  
		String liste_releve[]={"Section","Classe","Etudiant","Matiere","Note"};
		// les entres de JComboBox  d'affichage
		String liste_releve_affichage[]={"Classe","Etudiant"};
		// les entres de JComboBox  de type de note
		String liste_type_note[]={"DS","Examen"};
		
		JLabel affMoyenne = new JLabel("Moyenne : ");
		affMoyenne.setFont(new Font("Tahoma", Font.BOLD, 13));
		affMoyenne.setForeground(Color.WHITE);
		affMoyenne.setBounds(36, 260, 86, 14);
		panel_1.add(affMoyenne);
		

		// zone de texte pour afficher la moyenne de classe ou d'etudiant
		moyenne = new JTextField();
		moyenne.setBounds(36, 285, 86, 20);
		panel_1.add(moyenne);
		moyenne.setColumns(10);
		
		//JComboBox d'affichage
		JComboBox select_affichage = new JComboBox(liste_releve_affichage);
		select_affichage.setBackground(Color.WHITE);
				
		select_affichage.setBounds(31, 44, 86, 22);
		panel_1.add(select_affichage);
		
		textField = new JTextField();
		textField.setBounds(31, 90, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		// masquer le label et champ de la moyenne
		
		affMoyenne.setVisible(false);
		moyenne.setVisible(false);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(173, 43, 711, 393);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setBackground(Color.BLACK);
		table.setForeground(SystemColor.inactiveCaption);
		scrollPane.setViewportView(table);
		
		
		// bouton afficher pour afficher le panel correspondant au dufferent entres de JComboBox
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
				
				// pour lire l'lelement de JComboBox selectionné
	    		String element = (String) select_affichage.getItemAt(select_affichage.getSelectedIndex());
	    		
	    		if (element == "Classe") {
	    			
	    			String id_classe = textField.getText();
	    			// creer un model pour le JTable
	    			DefaultTableModel model = new DefaultTableModel();
	    			// les noms des colonnes de JTable
	    			Object[]column= {"NomEtudiant","PrenomEtudiant", "NomMatiere", "CoefMatiere" , "ValeurNote", "TypeNote" };
	    			// fixer le nombre de colonne a afficher
	    			final Object[]row=new Object[6];
	    			model.setColumnIdentifiers(column);
	    			// affecter le model au JTable
	    			table.setModel(model);
	    			
	    			
					// Instancier la classe de connexion a la base
					ConnectionBD cdb =  new ConnectionBD();
					try {
						// remplir la variable connection
						Connection connection = cdb.connecter();
						// instancier la classe d'affichage
						Affichage aff = new Affichage();
						// remplir la variable connection de l'affichage
						aff.connection = connection;
						// prendre les note des etudiants d'un classe dans un ResultSet
						ResultSet rs = aff.affichNoteEtudiantClasse(id_classe);
										
						// affichage des donnees stockées dans le ResultSet ligne par ligne
						while(rs.next())
						{row[0]=rs.getString("NomEtudiant");
						row[1]=rs.getString("PrenomEtudiant");
						row[2]=rs.getString("NomMatiere");
						row[3]=rs.getFloat("CoefMatiere");
						row[4]=rs.getFloat("ValeurNote");
						row[5]=rs.getString("TypeNote");
																	
						// ajouter chaque ligne au JTable
						model.addRow(row);
						}
					
					} catch (SQLException e) {
						e.getMessage();
					}
						
				
	    			
	    		} else if (element == "Etudiant") {
	    			
	    			
		    			affMoyenne.setVisible(true);
		    			moyenne.setVisible(true);
	    			
		    			String id_etudiant = textField.getText();
		    			
		    			DefaultTableModel model = new DefaultTableModel();
		    			Object[]column= {"NomEtudiant","PrenomEtudiant", "NomMatiere", "CoefMatiere", "ValeurNote", "TypeNote" };
		    			final Object[]row=new Object[6];
		    			model.setColumnIdentifiers(column);
		    			table.setModel(model);
		    			
						ConnectionBD cdb =  new ConnectionBD();
						ArrayList<Float> coefAL = new ArrayList<Float>();
						ArrayList<Float> notesAL = new ArrayList<Float>();
						Float moyEtud = (float) 0;
						
						try {
							Connection connection = cdb.connecter();
							Affichage aff = new Affichage();
							aff.connection = connection;
							ResultSet rs = aff.affichNoteEtudiant(id_etudiant);
							while(rs.next())
							{row[0]=rs.getString("NomEtudiant");
							row[1]=rs.getString("PrenomEtudiant");
							row[2]=rs.getString("NomMatiere");
							row[3]=rs.getFloat("CoefMatiere");
							row[4]=rs.getFloat("ValeurNote");
							row[5]=rs.getString("TypeNote");
							
							// calcul de la moyenne 
							
							coefAL.add((Float) row[3]);
							if (row[5].equals("DS")) {
								Float a = (float) ((Float) row[4] * (Float) row[3]*0.3);
								System.out.println(a);
								System.out.println((Float) row[3]);
								notesAL.add(a);
							}
								
							else if (row[5].equals("Examen")) {	
								Float a = (float) ((Float) row[4] * (Float) row[3]*0.7);
								notesAL.add(a);
							}
								
							model.addRow(row);
							}
							
							Float sommeCoef = (float) 0;
							for(int i=0; i< coefAL.size(); i++) {
								sommeCoef+=coefAL.get(i);
							}
							
							Float sommeNotes = (float) 0;
							for(int i=0; i< notesAL.size(); i++) {
								sommeNotes+=notesAL.get(i);
							}
							System.out.println(sommeCoef+"    "+ sommeNotes);
							
							moyEtud = (float) (sommeNotes*2/sommeCoef);
							
							moyenne.setText(moyEtud.toString());
							
						} catch (SQLException e) {
							e.getMessage();
						}
					
	    		}

			}
		});
		
		
		btnAfficher.setBounds(31, 135, 86, 23);
		panel_1.add(btnAfficher);

		
		JLabel titre_1 = new JLabel("RELEVE DE NOTES");
		titre_1.setForeground(Color.WHITE);
		titre_1.setBackground(Color.WHITE);
		titre_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 18));
		titre_1.setBounds(399, 18, 251, 14);
		panel_1.add(titre_1);
	    tabbedPane.add("Insertion",panel_2);  
	    panel_2.setLayout(null);
	    
	    JComboBox select_insertion = new JComboBox(liste_releve);
	    
	    select_insertion.setBounds(31, 44, 86, 22);
	    panel_2.add(select_insertion);
	    
	    
	    JPanel panel_5 = new JPanel();
	    panel_5.setBackground(SystemColor.menu);
	    panel_5.setBounds(174, 44, 710, 392);
	    panel_2.add(panel_5);
	    panel_5.setLayout(null);
	    panel_5.setVisible(false);
	    
	    
	    JLabel label_1 = new JLabel("New label");
	    label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	    label_1.setBounds(226, 93, 115, 14);
	    panel_5.add(label_1);
	    
	    JLabel label_2 = new JLabel("New label");
	    label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
	    label_2.setBounds(226, 128, 115, 14);
	    panel_5.add(label_2);
	    
	    JLabel label_3 = new JLabel("New label");
	    label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
	    label_3.setBounds(226, 162, 115, 14);
	    panel_5.add(label_3);
	    
	    JLabel label_4 = new JLabel("New label");
	    label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
	    label_4.setBounds(226, 194, 115, 14);
	    panel_5.add(label_4);
	    
	    textField_1 = new JTextField();
	    textField_1.setBounds(397, 90, 104, 20);
	    panel_5.add(textField_1);
	    textField_1.setColumns(10);
	    
	    textField_2 = new JTextField();
	    textField_2.setBounds(397, 125, 104, 20);
	    panel_5.add(textField_2);
	    textField_2.setColumns(10);
	    
	    textField_3 = new JTextField();
	    textField_3.setBounds(397, 159, 104, 20);
	    panel_5.add(textField_3);
	    textField_3.setColumns(10);
	    
	    textField_4 = new JTextField();
	    textField_4.setBounds(397, 192, 104, 20);
	    panel_5.add(textField_4);
	    textField_4.setColumns(10);
	    
	    
	    JButton btnInserer = new JButton("Insérer");
	    btnInserer.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    	}
	    });
	    btnInserer.setFont(new Font("Verdana", Font.BOLD, 13));
	    btnInserer.setBounds(298, 254, 104, 31);
	    panel_5.add(btnInserer); 
	    
	    JComboBox typeNoteSelect_1 = new JComboBox(liste_type_note);
	    typeNoteSelect_1.setBounds(397, 191, 104, 22);
	    panel_5.add(typeNoteSelect_1);
	    
	    JLabel lblNewLabel_2_2 = new JLabel("Remplir les donn\u00E9es");
	    lblNewLabel_2_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 15));
	    lblNewLabel_2_2.setBounds(273, 41, 169, 20);
	    panel_5.add(lblNewLabel_2_2);
	    
	    // recuperer les elements du panel toggle
	    
	    
	    
	    JButton btnNewButton = new JButton("Remplir");
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
	    				typeNoteSelect_1.setVisible(false);
	    				
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
							        JOptionPane.showMessageDialog(null, "id_section non saisi" , "Erreur.", JOptionPane.PLAIN_MESSAGE, icon);
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
	    				typeNoteSelect_1.setVisible(false);

	    				
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
							        JOptionPane.showMessageDialog(null, "id_classe non saisi" , "Erreur.", JOptionPane.PLAIN_MESSAGE, icon);

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
	    			
	    				typeNoteSelect_1.setVisible(false);

	    				
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
							        JOptionPane.showMessageDialog(null, "id_etudiant non saisi" , "Erreur.", JOptionPane.PLAIN_MESSAGE, icon);

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
	    				typeNoteSelect_1.setVisible(false);

	    				
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
							        JOptionPane.showMessageDialog(null, "id_matiere non saisi" , "Erreur.", JOptionPane.PLAIN_MESSAGE, icon);

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
	    			
		    			label_1.setText("Id etudiant : ");
	    				label_2.setText("Id matiere : ");
	    				label_3.setText("Note : ");
	    				label_4.setText("Type du note : ");
	    				
	    				
	    				label_3.setVisible(true);
	    				label_4.setVisible(true);
	    				textField_3.setVisible(true);
	    				textField_4.setVisible(false);
	    				typeNoteSelect_1.setVisible(true);

	    				
	    				btnInserer.addActionListener( new ActionListener () {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
								String id_note_etudiant = textField_1.getText();
			    				String id_note_matiere = textField_2.getText();
			    				String valeur_note = textField_3.getText();
			    				String type_note = (String) typeNoteSelect_1.getItemAt(typeNoteSelect_1.getSelectedIndex());
								
								
								ConnectionBD cdb = new ConnectionBD();
								Connection connection = null;
								try {
									 connection = cdb.connecter();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								if(id_note_etudiant.equals("") || (id_note_matiere.equals("")) || (type_note.equals(""))) {
									System.out.println("remplir les champs");
							        JOptionPane.showMessageDialog(null, "id_note_etudiant et/ou id_note_matiere et/ou type_note  non saisi" , "Erreur.", JOptionPane.PLAIN_MESSAGE, icon);

								} else {
								
								// remplir un objet etudiant
								Note n = new Note();
								n.setId_etudiant(id_note_etudiant);
								n.setId_matiere(id_note_matiere);
								n.setValeur_note(Float.parseFloat(valeur_note));
								n.setType_note(type_note);
								
								
								// Ajout a la base
								NoteDAO nDAO = new NoteDAO();
								nDAO.connection = connection;
								try {
									nDAO.ajouteNote(n);
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
	    btnNewButton.setBounds(31, 101, 86, 23);
	    panel_2.add(btnNewButton);
	    
	    JLabel titre_2 = new JLabel("RELEVE DE NOTES");
	    titre_2.setForeground(Color.WHITE);
	    titre_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 18));
	    titre_2.setBackground(Color.WHITE);
	    titre_2.setBounds(382, 19, 251, 14);
	    panel_2.add(titre_2);
	    
	    
	    
	    
	    
	   
	    tabbedPane.add("Modification",panel_3); 
	    panel_3.setLayout(null);
	    
	    JComboBox select_modification = new JComboBox(liste_releve);
	    select_modification.setBounds(31, 44, 86, 22);
	    panel_3.add(select_modification);
	    
	    
	    JPanel panel_5_1 = new JPanel();
	    panel_5_1.setBackground(SystemColor.menu);
	    panel_5_1.setLayout(null);
	    panel_5_1.setBounds(174, 44, 710, 392);
	    panel_3.add(panel_5_1);
	    panel_5_1.setVisible(false);

	    
	    JLabel label_2_1 = new JLabel("New label");
	    label_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	    label_2_1.setBounds(206, 92, 96, 14);
	    panel_5_1.add(label_2_1);
	    
	    JLabel label_2_2 = new JLabel("New label");
	    label_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
	    label_2_2.setBounds(206, 127, 86, 14);
	    panel_5_1.add(label_2_2);
	    
	    JLabel label_2_3 = new JLabel("New label");
	    label_2_3.setFont(new Font("Tahoma", Font.BOLD, 12));
	    label_2_3.setBounds(206, 161, 86, 14);
	    panel_5_1.add(label_2_3);
	    
	    JLabel label_2_4 = new JLabel("New label");
	    label_2_4.setFont(new Font("Tahoma", Font.BOLD, 12));
	    label_2_4.setBounds(206, 193, 86, 14);
	    panel_5_1.add(label_2_4);
	    
	    textField_2_1 = new JTextField();
	    textField_2_1.setColumns(10);
	    textField_2_1.setBounds(370, 89, 105, 20);
	    panel_5_1.add(textField_2_1);
	    
	    textField_2_2 = new JTextField();
	    textField_2_2.setColumns(10);
	    textField_2_2.setBounds(370, 124, 105, 20);
	    panel_5_1.add(textField_2_2);
	    
	    textField_2_3 = new JTextField();
	    textField_2_3.setColumns(10);
	    textField_2_3.setBounds(370, 158, 105, 20);
	    panel_5_1.add(textField_2_3);
	    
	    textField_2_4 = new JTextField();
	    textField_2_4.setColumns(10);
	    textField_2_4.setBounds(370, 190, 105, 20);
	    panel_5_1.add(textField_2_4);
	    
	    JButton btnModifier = new JButton("Modifier");
	    btnModifier.setFont(new Font("Verdana", Font.BOLD, 13));
	    btnModifier.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    	
	    	}
	    });
	    btnModifier.setBounds(287, 254, 105, 31);
	    panel_5_1.add(btnModifier);
	    
	    JComboBox typeNoteSelect_2 = new JComboBox(liste_type_note);
	    typeNoteSelect_2.setBounds(370, 190, 105, 22);
	    panel_5_1.add(typeNoteSelect_2);
	    
	    JLabel lblNewLabel_2_1 = new JLabel("Remplir les donn\u00E9es");
	    lblNewLabel_2_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 15));
	    lblNewLabel_2_1.setBounds(241, 37, 169, 20);
	    panel_5_1.add(lblNewLabel_2_1);
	    
	    
	    
	    JButton btnNewButton_1 = new JButton("Remplir");
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    		panel_5_1.setVisible(true);
	    		
	    		String element = (String) select_modification.getItemAt(select_modification.getSelectedIndex());
	    		
	    		if (element == "Section") { 
	    			
	    				label_2_1.setText("Id Section : ");
	    				label_2_2.setText("Nom Section : ");
	    				
	    				typeNoteSelect_2.setVisible(false);
	    				
	    				label_2_3.setVisible(false);
	    				label_2_4.setVisible(false);
	    				textField_2_3.setVisible(false);
	    				textField_2_4.setVisible(false);
	    				
	    				
	    				
	    				
	    				btnModifier.addActionListener( new ActionListener () {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
								String id_section = textField_2_1.getText();
			    				String nom_section = textField_2_2.getText();
								
								
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
							        JOptionPane.showMessageDialog(null, "id_section non saisi" , "Erreur.", JOptionPane.PLAIN_MESSAGE, icon);

								} else {
								
								// remplir un objet section
								Section s = new Section();
								s.setId_section(id_section);
								s.setNom_section(nom_section);
								
								// Ajout a la base
								SectionDAO sDAO = new SectionDAO();
								
								
								sDAO.connection = connection;
								try {
									sDAO.updateSection(s);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								cdb.deconnecter();
								
								textField_2_1.setText("");
								textField_2_2.setText("");
								
								
								}
								
							}
	    					
	    				});
	    				
	    				
	    				
	    				
	    				
	    				
	    				
	    				
	    				
	    		} else if (element == "Classe") {
	    				    				
		    			label_2_1.setText("Id Classe : ");
	    				label_2_2.setText("Nom Classe : ");
	    				label_2_3.setText("Id section : ");
	    				
	    				
	    				label_2_3.setVisible(true);
	    				textField_2_3.setVisible(true);
	    				
	    				label_2_4.setVisible(false);
	    				textField_2_4.setVisible(false);
	    				typeNoteSelect_2.setVisible(false);

	    			
	    				
	    				btnModifier.addActionListener( new ActionListener () {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
								String id_classe = textField_2_1.getText();
			    				String nom_classe = textField_2_2.getText();
			    				String id_section_classe = textField_2_3.getText();
								
								
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
							        JOptionPane.showMessageDialog(null, "id_classe non saisi" , "Erreur.", JOptionPane.PLAIN_MESSAGE, icon);

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
									cDAO.updateClasse(c);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								
								cdb.deconnecter();
								
								textField_2_1.setText("");
								textField_2_2.setText("");
								textField_2_3.setText("");

								}
							}
	    					
	    				});
	    				
	    				
	    		} else if (element == "Etudiant") {
	    			
	    				
		    			label_2_1.setText("Id Etudiant : ");
	    				label_2_2.setText("Nom Etudiant : ");
	    				label_2_3.setText("Prenom Etudiant : ");
	    				label_2_4.setText("Id classe : ");
	    				
	    				
	    				label_2_3.setVisible(true);
	    				label_2_4.setVisible(true);
	    				textField_2_3.setVisible(true);
	    				textField_2_4.setVisible(true);
	    				typeNoteSelect_2.setVisible(false);

	    				
	    					
	    				
	
	    				
	    				btnModifier.addActionListener( new ActionListener () {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
								String id_etudiant = textField_2_1.getText();
			    				String nom_etudiant = textField_2_2.getText();
			    				String prenom_etudiant = textField_2_3.getText();
			    				String id_classe_etudiant = textField_2_4.getText();
								
								
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
							        JOptionPane.showMessageDialog(null, "id_etudiant non saisi" , "Erreur.", JOptionPane.PLAIN_MESSAGE, icon);
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
									eDAO.updateEtudiant(et);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								
								cdb.deconnecter();
								
								textField_2_1.setText("");
								textField_2_2.setText("");
								textField_2_3.setText("");
								textField_2_4.setText("");

								}
							}
	    					
	    				});
	    				
	    				
	    				
	    				
	    		} else if (element == "Matiere") {
	    			
		    			label_2_1.setText("Id Matiere : ");
	    				label_2_2.setText("Nom Matiere : ");
	    				label_2_3.setText("Coef Matiere : ");
	    			

	    				label_2_3.setVisible(true);
	    				textField_2_3.setVisible(true);
	    				label_2_4.setVisible(false);
	    				textField_2_4.setVisible(false);
	    				typeNoteSelect_2.setVisible(false);

	    			
	    				
	    				
	    				btnModifier.addActionListener( new ActionListener () {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
								String id_matiere = textField_2_1.getText();
			    				String nom_matiere = textField_2_2.getText();
			    				String coef_matiere = textField_2_3.getText();
								
								
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
							        JOptionPane.showMessageDialog(null, "id_matiere non saisi" , "Erreur.", JOptionPane.PLAIN_MESSAGE, icon);
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
									mDAO.updateMatiere(m);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								
								cdb.deconnecter();
								
								textField_2_1.setText("");
								textField_2_2.setText("");
								textField_2_3.setText("");

								}
							}
	    					
	    				});
	    				
	    				
	    				
	    				
	    		} else if (element == "Note") {
	    			
		    			label_2_1.setText("Id etudiant : ");
	    				label_2_2.setText("Id matiere : ");
	    				label_2_3.setText("Note : ");
	    				label_2_4.setText("Type note : ");
	    			
	    				
	    				label_2_3.setVisible(true);
	    				label_2_4.setVisible(true);
	    				textField_2_3.setVisible(true);
	    				textField_2_4.setVisible(false);
	    				typeNoteSelect_2.setVisible(true);

	    		
	    				
	    				btnModifier.addActionListener( new ActionListener () {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
								String id_note_etudiant = textField_2_1.getText();
			    				String id_note_matiere = textField_2_2.getText();
			    				String valeur_note = textField_2_3.getText();
			    				String type_note = (String) typeNoteSelect_2.getItemAt(typeNoteSelect_2.getSelectedIndex());

								
								
								ConnectionBD cdb = new ConnectionBD();
								Connection connection = null;
								try {
									 connection = cdb.connecter();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								if(id_note_etudiant.equals("") || (id_note_matiere.equals("")) || (type_note.equals(""))) {
									System.out.println("remplir le champs");
							        JOptionPane.showMessageDialog(null, "id_note_etudiant et/ou id_note_matiere et/ou type_note  non saisi" , "Erreur.", JOptionPane.PLAIN_MESSAGE, icon);

								} else {
								
								// remplir un objet etudiant
								Note n = new Note();
								n.setId_etudiant(id_note_etudiant);
								n.setId_matiere(id_note_matiere);
								n.setValeur_note(Float.parseFloat(valeur_note));
								n.setType_note(type_note);
								
								
								// Ajout a la base
								NoteDAO nDAO = new NoteDAO();
								nDAO.connection = connection;
								try {
									nDAO.updateNote(n);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								
								cdb.deconnecter();
								
								textField_2_1.setText("");
								textField_2_2.setText("");
								textField_2_3.setText("");
								textField_2_4.setText("");

								}
							}
	    					
	    				});
	    				
	    				
	    				
	    				
	    		}
	    	
	    	}
	    });
	    btnNewButton_1.setBounds(31, 101, 86, 23);
	    panel_3.add(btnNewButton_1);
	    
	    JLabel titre_3 = new JLabel("RELEVE DE NOTES");
	    titre_3.setForeground(Color.WHITE);
	    titre_3.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 18));
	    titre_3.setBackground(Color.WHITE);
	    titre_3.setBounds(369, 19, 251, 14);
	    panel_3.add(titre_3);
	    
	    
	    
	    
	    tabbedPane.addTab("Suppression", null, panel_4, null);
	    panel_4.setLayout(null);
	    
	    JComboBox select_suppression = new JComboBox(liste_releve);
	    select_suppression.setBounds(31, 44, 86, 22);
	    panel_4.add(select_suppression);
	    
	    
	  
	    
	    JPanel panel_5_2 = new JPanel();
	    panel_5_2.setBackground(SystemColor.menu);
	    panel_5_2.setLayout(null);
	    panel_5_2.setBounds(174, 44, 710, 392);
	    panel_5_2.setVisible(false);
	    panel_4.add(panel_5_2);
	    
	    JLabel label_3_1 = new JLabel("New label");
	    label_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	    label_3_1.setBounds(254, 101, 78, 14);
	    panel_5_2.add(label_3_1);
	    
	    textField_3_1 = new JTextField();
	    textField_3_1.setColumns(10);
	    textField_3_1.setBounds(385, 98, 102, 20);
	    panel_5_2.add(textField_3_1);
	    
	    JButton btnSuppr = new JButton("Supprimer");
	    btnSuppr.setFont(new Font("Verdana", Font.BOLD, 13));
	    btnSuppr.setBounds(311, 235, 112, 31);
	    panel_5_2.add(btnSuppr);
	    
	    JLabel label_3_2 = new JLabel("New label");
	    label_3_2.setFont(new Font("Tahoma", Font.BOLD, 12));
	    label_3_2.setBounds(254, 148, 78, 14);
	    panel_5_2.add(label_3_2);
	    
	    textField_3_2 = new JTextField();
	    textField_3_2.setBounds(385, 145, 102, 20);
	    panel_5_2.add(textField_3_2);
	    textField_3_2.setColumns(10);
	    
	    JLabel label_3_3 = new JLabel("New label");
	    label_3_3.setFont(new Font("Tahoma", Font.BOLD, 12));
	    label_3_3.setBounds(254, 189, 78, 14);
	    panel_5_2.add(label_3_3);
	    
	    textField_3_3 = new JTextField();
	    textField_3_3.setBounds(385, 186, 102, 20);
	    panel_5_2.add(textField_3_3);
	    textField_3_3.setColumns(10);
	    
	    JComboBox typeNoteSelect_3 = new JComboBox(liste_type_note);
	    typeNoteSelect_3.setBounds(385, 186, 104, 22);
	    panel_5_2.add(typeNoteSelect_3);
	    
	    JLabel lblNewLabel_2 = new JLabel("Remplir les donn\u00E9es");
	    lblNewLabel_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 15));
	    lblNewLabel_2.setBounds(285, 35, 169, 20);
	    panel_5_2.add(lblNewLabel_2);
	    
	    
	    JButton btnNewButton_2 = new JButton("Remplir");
	    btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    		panel_5_2.setVisible(true);
	    		
	    		String element = (String) select_suppression.getItemAt(select_suppression.getSelectedIndex());
	    		
	    		if (element == "Section") { 
	    			
	    				label_3_1.setText("Id Section : ");
	    				
	    				label_3_2.setVisible(false);
	    				textField_3_2.setVisible(false);
	    				label_3_3.setVisible(false);
	    				textField_3_3.setVisible(false);
	    				typeNoteSelect_3.setVisible(false);

	    				
	    				btnSuppr.addActionListener( new ActionListener () {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
								String id_section = textField_3_1.getText();
								
								
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
							        JOptionPane.showMessageDialog(null, "id_section non saisi" , "Erreur.", JOptionPane.PLAIN_MESSAGE, icon);

								} else {
								
								
								// Ajout a la base
								SectionDAO sDAO = new SectionDAO();
								
								
								sDAO.connection = connection;
								try {
									sDAO.deleteSection(id_section);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								cdb.deconnecter();
								
								textField_3_1.setText("");
								textField_3_2.setText("");
								textField_3_3.setText("");

								
								
								}
								
							}
	    					
	    				});
	    				
	    				
	    				
	    				
	    				
	    				
	    				
	    				
	    				
	    		} else if (element == "Classe") {
	    				    				
		    			label_3_1.setText("Id Classe : ");
	    				
	    				
	    				
	    				
	    				label_3_2.setVisible(false);
	    				textField_3_2.setVisible(false);
	    				label_3_3.setVisible(false);
	    				textField_3_3.setVisible(false);
	    				typeNoteSelect_3.setVisible(false);

	    				
	    				btnSuppr.addActionListener( new ActionListener () {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
			    				String id_classe = textField_3_1.getText();
								
								
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
							        JOptionPane.showMessageDialog(null, "id_classe non saisi" , "Erreur.", JOptionPane.PLAIN_MESSAGE, icon);
								} else {
								
								// Ajout a la base
								ClasseDAO cDAO = new ClasseDAO();
								
								
								cDAO.connection = connection;
								try {
									cDAO.deleteClasse(id_classe);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								cdb.deconnecter();
								
								textField_3_1.setText("");
								textField_3_2.setText("");
								textField_3_3.setText("");

								
								
								}
								
							}
	    					
	    				});
	    				
	    				
	    			
	    		} else if (element == "Etudiant") {
	    			
	    				
		    			label_3_1.setText("Id Etudiant : ");
	    				
		
	    				
	    				label_3_2.setVisible(false);
	    				textField_3_2.setVisible(false);
	    				label_3_3.setVisible(false);
	    				textField_3_3.setVisible(false);
	    				typeNoteSelect_3.setVisible(false);

	    				
	    				btnSuppr.addActionListener( new ActionListener () {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
			    				String id_etudiant = textField_3_1.getText();
								
								
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
							        JOptionPane.showMessageDialog(null, "id_etudiant non saisi" , "Erreur.", JOptionPane.PLAIN_MESSAGE, icon);

								} else {
								
								
								// Ajout a la base
								EtudiantDAO eDAO = new EtudiantDAO();
								
								
								eDAO.connection = connection;
								try {
									eDAO.deleteEtudiant(id_etudiant);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								cdb.deconnecter();
								
								textField_3_1.setText("");
								textField_3_2.setText("");
								textField_3_3.setText("");

								
								
								}
								
							}
	    					
	    				});
	    				
	    				
	    				
	    				
	    				
	    				
	    				
	    				
	    				
	
	    		} else if (element == "Matiere") {
	    			
		    			label_3_1.setText("Id Matiere : ");

	    				
	    				label_3_2.setVisible(false);
	    				textField_3_2.setVisible(false);
	    				label_3_3.setVisible(false);
	    				textField_3_3.setVisible(false);
	    				typeNoteSelect_3.setVisible(false);

	    				
	    				btnSuppr.addActionListener( new ActionListener () {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
								String id_matiere = textField_3_1.getText();
								
								
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
							        JOptionPane.showMessageDialog(null, "id_matiere non saisi" , "Erreur.", JOptionPane.PLAIN_MESSAGE, icon);

								} else {
								
								
								// Ajout a la base
								MatiereDAO mDAO = new MatiereDAO();
								
								
								mDAO.connection = connection;
								try {
									mDAO.deleteMatiere(id_matiere);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								cdb.deconnecter();
								
								textField_3_1.setText("");
								textField_3_2.setText("");
								textField_3_3.setText("");

								
								}
								
							}
	    					
	    				});
	    				
	    				
	    				
	    				
	    				
	    			
	    		} else if (element == "Note") {
	    			
		    			label_3_1.setText("Id Etudiant : ");
	    				label_3_2.setText("Id Matiere : ");
	    				label_3_3.setText("Type Note : ");
	    				
	    				label_3_2.setVisible(true);
	    				textField_3_2.setVisible(true);
	    				label_3_3.setVisible(true);
	    				textField_3_3.setVisible(false);
	    				typeNoteSelect_3.setVisible(true);

	    				
	    				btnSuppr.addActionListener( new ActionListener () {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								
			    				String id_etudiant_note = textField_3_1.getText();
			    				String id_matiere_note = textField_3_2.getText();
			    				String type_note = (String) typeNoteSelect_3.getItemAt(typeNoteSelect_3.getSelectedIndex());


								
								
								ConnectionBD cdb = new ConnectionBD();
								Connection connection = null;
								try {
									 connection = cdb.connecter();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								// verifier que les champs necessaires sont saisi
								if((id_etudiant_note.equals("")) || (id_matiere_note.equals("")) || (type_note.equals(""))) {
									System.out.println("remplir les champs");
									// afficher une boite de dialogue d'erreur
							        JOptionPane.showMessageDialog(null, "id_note_etudiant et/ou id_note_matiere et/ou type_note non saisi" , "Erreur.", JOptionPane.PLAIN_MESSAGE, icon);

								} else {
								
								
								// Ajout a la base
								NoteDAO nDAO = new NoteDAO();
								
								nDAO.connection = connection;
								try {
									nDAO.deleteNote(id_etudiant_note, id_matiere_note, type_note);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								cdb.deconnecter();
								
								textField_3_1.setText("");
								textField_3_2.setText("");
								textField_3_3.setText("");

								
								}
								
							}
	    					
	    				});
	    				
	    				
	    		
	    		}
	    			

	    		
	    		
	    	}
	    });
	    
	    btnNewButton_2.setBounds(31, 101, 86, 22);
	    panel_4.add(btnNewButton_2);
	    
	    JLabel titre_4 = new JLabel("RELEVE DE NOTES");
	    titre_4.setForeground(Color.WHITE);
	    titre_4.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 18));
	    titre_4.setBackground(Color.WHITE);
	    titre_4.setBounds(395, 19, 251, 14);
	    panel_4.add(titre_4);
	    
	    JLabel faresNoussema = new JLabel("Fares SALHI & Oussema KALLEL - 2GT3");
	    faresNoussema.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
	    faresNoussema.setForeground(Color.CYAN);
	    faresNoussema.setBackground(Color.YELLOW);
	    faresNoussema.setBounds(688, 516, 236, 14);
	    frmGestionDesRelevs.getContentPane().add(faresNoussema);
	    
	    
	    // bouton pour changer le couleur de fond (noir, blanc) 
	    JToggleButton bNwBtn = new JToggleButton("Changer vers BLANC");
	    bNwBtn.setBounds(780, 11, 144, 23);
	    frmGestionDesRelevs.getContentPane().add(bNwBtn);
	    
	    
	    ItemListener itemListener = new ItemListener() {
	    	 
            // 
            public void itemStateChanged(ItemEvent itemEvent)
            {
 
                // evenement qui se declenche lorsqu'on clique sur le bouton
                int state = itemEvent.getStateChange();
 
                // etat noir ou blanc 
                if (state == ItemEvent.SELECTED) {
                    System.out.println("white");
            		frmGestionDesRelevs.getContentPane().setBackground(SystemColor.WHITE);
                    panel_1.setBackground(Color.WHITE);
                    panel_2.setBackground(Color.WHITE);
                    panel_3.setBackground(Color.WHITE);
                    panel_4.setBackground(Color.WHITE);
                    
            	    titre_1.setForeground(Color.BLACK);
            	    titre_2.setForeground(Color.BLACK);
            	    titre_3.setForeground(Color.BLACK);
            	    titre_4.setForeground(Color.BLACK);
            	    
            	    bNwBtn.setText("Changer vers NOIR");
            	    bNwBtn.setBackground(Color.WHITE);
            	    bNwBtn.setForeground(Color.BLACK);
            	    
            	    affMoyenne.setForeground(Color.BLACK);


                }
                else {
 
                    // else print black in console
                	System.out.println("black");
            		frmGestionDesRelevs.getContentPane().setBackground(SystemColor.textText);
                    panel_1.setBackground(Color.BLACK);
                    panel_2.setBackground(Color.BLACK);
                    panel_3.setBackground(Color.BLACK);
                    panel_4.setBackground(Color.BLACK);
                    
                    titre_1.setForeground(Color.WHITE);
            	    titre_2.setForeground(Color.WHITE);
            	    titre_3.setForeground(Color.WHITE);
            	    titre_4.setForeground(Color.WHITE);
            	    
            	    bNwBtn.setText("Changer vers BLANC");
            	    bNwBtn.setBackground(Color.WHITE);
            	    bNwBtn.setForeground(Color.BLACK);
            	    
            	    affMoyenne.setForeground(Color.WHITE);
            	    

                    
                }
            }
        };
        
	    
        bNwBtn.addItemListener(itemListener);
        
  
	    
	}
}

package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;


public class EmpruntFrame extends JFrame {
	
	

	    private JTextField txtID, txtLivre, txtUtilisateur, txtDateEmprunt, txtDateRetourPrevue;
	    private JButton btnAjouter, btnSupprimer, btnRechercher, btnProlonger;
	    public DefaultTableModel model;
	    public JTable table;

	    public EmpruntFrame() {
	        setTitle("Gestion des Emprunts");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(800, 600);
	        setLayout(new BorderLayout());
	        initialiserComposants();
	        initialiserComposants();
	        
            setVisible(true);
            
	    }
	    
	    public void  initialiserComposants(){
	    	    
		        txtID = new JTextField();
		        txtLivre = new JTextField();
		        txtUtilisateur = new JTextField();
		        txtDateEmprunt = new JTextField();
		        txtDateRetourPrevue = new JTextField();
		        btnAjouter = new JButton("Ajouter");
		       
		        btnSupprimer = new JButton("Supprimer");
		        btnRechercher = new JButton("Rechercher");
		        btnProlonger = new JButton("Prolonger");
		        
	    }
	    public void ajouterComposants() {
	    	  JPanel panelForm = new JPanel(new GridLayout(6, 2));
		        panelForm.add(new JLabel("ID :"));
		        panelForm.add(txtID);
		        panelForm.add(new JLabel("Livre :"));
		        panelForm.add(txtLivre);
		        panelForm.add(new JLabel("Utilisateur :"));
		        panelForm.add(txtUtilisateur);
		        panelForm.add(new JLabel("Date Emprunt :"));
		        panelForm.add(txtDateEmprunt);
		        panelForm.add(new JLabel("Date Retour Prévue :"));
		        panelForm.add(txtDateRetourPrevue);
		        add(panelForm, BorderLayout.NORTH);
		        JPanel panelButtons = new JPanel(new FlowLayout());
		        panelButtons.add(btnAjouter);
		        
		        panelButtons.add(btnSupprimer);
		        panelButtons.add(btnRechercher);
		        panelButtons.add(btnProlonger);
		        add(panelButtons, BorderLayout.SOUTH);

		        
		        JPanel tablePanel = new JPanel(new BorderLayout());
		        model = new DefaultTableModel();
		        model.addColumn("ID");
		        model.addColumn("Livre");
		        model.addColumn("Utilisateur");
		        model.addColumn("Date d'Emprunt");
		        model.addColumn("Date de Retour");
		        JScrollPane scrollPane = new JScrollPane(table);
		        tablePanel.add(scrollPane, BorderLayout.CENTER);
		        add(tablePanel);
	    	
	    }

	    public JButton getBtnAjouter() {
			return btnAjouter;
		}

		public void setBtnAjouter(JButton btnAjouter) {
			this.btnAjouter = btnAjouter;
		}

		public JButton getBtnSupprimer() {
			return btnSupprimer;
		}

		public void setBtnSupprimer(JButton btnSupprimer) {
			this.btnSupprimer = btnSupprimer;
		}

		public JButton getBtnRechercher() {
			return btnRechercher;
		}

		public void setBtnRechercher(JButton btnRechercher) {
			this.btnRechercher = btnRechercher;
		}

		public JButton getBtnProlonger() {
			return btnProlonger;
		}

		public void setBtnProlonger(JButton btnProlonger) {
			this.btnProlonger = btnProlonger;
		}

		public String getTxtID() {
	        return txtID.getText();
	    }

	    public String getTxtLivre() {
	        return txtLivre.getText();
	    }

	    public String getTxtUtilisateur() {
	        return txtUtilisateur.getText();
	    }

	    public String getTxtDateEmprunt() {
	        return txtDateEmprunt.getText();
	    }

	    public String getTxtDateRetourPrevue() {
	        return txtDateRetourPrevue.getText();
	    }

	    public void setTableEmprunts(DefaultTableModel model) {
	    	table.setModel(model);
	    }

	   
	}



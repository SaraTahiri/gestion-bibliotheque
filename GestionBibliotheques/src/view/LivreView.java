package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LivreView extends JFrame {

    private JTabbedPane tabbedPaneLivre;
    private JLabel titreLabel, auteurLabel, anneePubLabel, genreLabel;
    private JTextField titreField, auteurField, annePubField, genreField, searchTextField;
    private JButton addButton, modifyButton, deleteButton, resetButton, searchButton;
    private DefaultTableModel tableModel;
    public JTable livreTable;

    public LivreView() {
        this.setTitle("Gestion des Livres");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initialiserComposantes();
        this.addComposantes();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    // Méthode pour ajouter un livre dans la table
    public void ajouterLivreDansTable(String titre, String auteur, String annee, String genre) {
        tableModel.addRow(new Object[]{titre, auteur, annee, genre});
    }

    public void initialiserComposantes() {
        tabbedPaneLivre = new JTabbedPane();

        titreLabel = new JLabel("Titre:");
        auteurLabel = new JLabel("Auteur:");
        anneePubLabel = new JLabel("Année de Publication:");
        genreLabel = new JLabel("Genre:");

        titreField = new JTextField(15);
        auteurField = new JTextField(15);
        annePubField = new JTextField(15);
        genreField = new JTextField(15);

        addButton = new JButton("Ajouter");
        modifyButton = new JButton("Modifier");
        deleteButton = new JButton("Supprimer");
        resetButton = new JButton("Réinitialiser");
        searchButton = new JButton("Rechercher");
        
        searchTextField = new JTextField(15);

        // Initialisation de la JTable avec un modèle par défaut
        tableModel = new DefaultTableModel(new String[]{"Isbn" ,"Titre", "Auteur", "Année", "Genre"}, 0);
        livreTable = new JTable(tableModel);
    }

    public void addComposantes() {
        // Panneau de formulaire
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBorder(BorderFactory.createTitledBorder("Informations du Livre"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Marges autour des composants
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Champs de formulaire
        gbc.gridx = 0; gbc.gridy = 0; panelForm.add(titreLabel, gbc);
        gbc.gridx = 1; panelForm.add(titreField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panelForm.add(auteurLabel, gbc);
        gbc.gridx = 1; panelForm.add(auteurField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panelForm.add(anneePubLabel, gbc);
        gbc.gridx = 1; panelForm.add(annePubField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; panelForm.add(genreLabel, gbc);
        gbc.gridx = 1; panelForm.add(genreField, gbc);

        // Boutons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        buttonPanel.add(addButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(resetButton);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; panelForm.add(buttonPanel, gbc);
        // Composants de recherche
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 1; panelForm.add(new JLabel("Rechercher:"), gbc);
        gbc.gridx = 1; panelForm.add(searchTextField, gbc);

        gbc.gridx = 2; panelForm.add(searchButton, gbc);

        // Panneau de la table
        JScrollPane scrollPane = new JScrollPane(livreTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Liste des Livres"));
        
//        // Panneau de recherche
//        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
//        searchPanel.setBorder(BorderFactory.createTitledBorder("Recherche"));
//        searchPanel.add(new JLabel("Rechercher:"));
//        searchPanel.add(searchTextField);
//        searchPanel.add(searchButton);

        // Panneau principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(panelForm, BorderLayout.NORTH); // Formulaire au Nord
        panelPrincipal.add(scrollPane, BorderLayout.CENTER); // Table au Centre
        //panelPrincipal.add(searchPanel,BorderLayout.SOUTH); //Barre recherche au sud

        // Ajouter au TabbedPane
        tabbedPaneLivre.addTab("Livres", panelPrincipal);
        this.add(tabbedPaneLivre);
    }

    public JTextField getTitreField() {
        return titreField;
    }

    public JTextField getAuteurField() {
        return auteurField;
    }

    public JTextField getAnnePubField() {
        return annePubField;
    }

    public JTextField getGenreField() {
        return genreField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getModifyButton() {
        return modifyButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }
    
    public JTextField getSearchField() {
    	return searchTextField;
    }
    
    public JButton getSearchButton() {
    	return searchButton;
    }
}

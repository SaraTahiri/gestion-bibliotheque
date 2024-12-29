package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;

public class EmpruntView extends JFrame {
    private JPanel mainPanel;
    private JTextField idUserField, titreLivreField, dateEmpruntField, dateRetourField, joursSuppField, rechercherField;
    private JButton ajouterButton, modifierButton, supprimerButton, prolongerButton, rechercherButton, afficherButton, resetButton;
    private JTable empruntsTable;
    private DefaultTableModel tableModel;

    public EmpruntView() {
        setTitle("Gestion des Emprunts");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialiserComposants();
        ajouterComposants();
        setLocationRelativeTo(null);
    }

    // Méthode pour ajouter un emprunt dans la table
    public void ajouterEmpruntDansTable(int idEmprunt, int idUser, String titre, LocalDate dateEmprunt, LocalDate dateRetour) {
        tableModel.addRow(new Object[]{idEmprunt, idUser, titre, dateEmprunt.toString(), dateRetour.toString()});
    }

    public void initialiserComposants() {
        // Champs de texte
        idUserField = new JTextField();
        titreLivreField = new JTextField();
        dateEmpruntField = new JTextField();
        dateRetourField = new JTextField();
        joursSuppField = new JTextField();
        rechercherField = new JTextField();

        // Boutons
        ajouterButton = new JButton("Ajouter");
        modifierButton = new JButton("Modifier");
        supprimerButton = new JButton("Supprimer");
        prolongerButton = new JButton("Prolonger");
        rechercherButton = new JButton("Rechercher");
        afficherButton = new JButton("Afficher");
        resetButton = new JButton("Réinitialiser");

        // Table des emprunts
        String[] columnNames = {"Id Emprunt", "Id Utilisateur", "Titre Livre", "Date Emprunt", "Date Retour"};
        tableModel = new DefaultTableModel(columnNames, 0);
        empruntsTable = new JTable(tableModel);
        empruntsTable.setFillsViewportHeight(true);
    }

    public void ajouterComposants() {
        mainPanel = new JPanel(new BorderLayout());

        // Panel pour les champs de saisie
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Informations de l'Emprunt"));
        inputPanel.add(new JLabel("ID Utilisateur :"));
        inputPanel.add(idUserField);
        inputPanel.add(new JLabel("Titre Livre :"));
        inputPanel.add(titreLivreField);
        inputPanel.add(new JLabel("Date Emprunt (yyyy-MM-dd) :"));
        inputPanel.add(dateEmpruntField);
        inputPanel.add(new JLabel("Date Retour (yyyy-MM-dd) :"));
        inputPanel.add(dateRetourField);
        inputPanel.add(new JLabel("Jours Supplémentaires :"));
        inputPanel.add(joursSuppField);
        inputPanel.add(new JLabel("Rechercher par Titre :"));
        inputPanel.add(rechercherField);

        // Panel pour les boutons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Actions"));
        buttonPanel.add(ajouterButton);
        buttonPanel.add(modifierButton);
        buttonPanel.add(supprimerButton);
        buttonPanel.add(prolongerButton);
        buttonPanel.add(rechercherButton);
        buttonPanel.add(afficherButton);
        buttonPanel.add(resetButton);

        // Panel pour la table
        JScrollPane tableScrollPane = new JScrollPane(empruntsTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("Liste des Emprunts"));

        // Ajout des composants au panel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Définir le panel principal comme contenu de la fenêtre
        setContentPane(mainPanel);
    }

    // Getters pour les composants
    
    public JPanel getMainPanel() {
    	return mainPanel;
    }
    
    public JTextField getIdUserField() {
        return idUserField;
    }

    public JTextField getTitreLivreField() {
        return titreLivreField;
    }

    public JTextField getDateEmpruntField() {
        return dateEmpruntField;
    }

    public JTextField getDateRetourField() {
        return dateRetourField;
    }

    public JTextField getJoursSuppField() {
        return joursSuppField;
    }

    public JTextField getRechercherField() {
        return rechercherField;
    }

    public JButton getAjouterButton() {
        return ajouterButton;
    }

    public JButton getModifierButton() {
        return modifierButton;
    }

    public JButton getSupprimerButton() {
        return supprimerButton;
    }

    public JButton getProlongerButton() {
        return prolongerButton;
    }

    public JButton getRechercherButton() {
        return rechercherButton;
    }

    public JButton getAfficherButton() {
        return afficherButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JTable getEmpruntsTable() {
        return empruntsTable;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}

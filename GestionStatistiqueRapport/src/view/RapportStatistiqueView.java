package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RapportStatistiqueView extends JFrame {
    private JButton btnGenererRapport;
    private JTextArea textAreaRapport;

    public RapportStatistiqueView() {
        setTitle("Rapport et Statistiques");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new BorderLayout());

        // Zone de texte pour afficher le rapport
        textAreaRapport = new JTextArea();
        textAreaRapport.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaRapport);
        add(scrollPane, BorderLayout.CENTER);

        // Bouton pour générer les rapports
        JPanel panel = new JPanel();
        btnGenererRapport = new JButton("Générer Rapport");
        panel.add(btnGenererRapport);
        add(panel, BorderLayout.SOUTH);
    }

    // Méthode pour ajouter un listener au bouton
    public void addGenererRapportListener(ActionListener listener) {
        btnGenererRapport.addActionListener(listener);
    }

    // Méthode pour afficher le rapport dans la textArea
    public void setRapportText(String rapport) {
        textAreaRapport.setText(rapport);
    }
}


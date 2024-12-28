/*package view;

import javax.swing.*;
import java.awt.*;
import controller.UtilisateurController;
import model.UtilisateurModel;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("EMSI-Gestion de la Bibliothèque");

        // Configuration de la fenêtre principale
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre

        // Création du JTabbedPane principal
        JTabbedPane tabbedPanePrincipal = new JTabbedPane();

        // Onglet pour la gestion des Utilisateurs
        UtilisateurFrame utilisateurFrame = new UtilisateurFrame();  // Créer l'instance de la vue Utilisateur
        tabbedPanePrincipal.addTab("Utilisateurs", utilisateurFrame);  // Ajouter l'onglet Utilisateurs

        // Onglet pour la gestion des Retours (intégration de ta vue RetourFrame)
        tabbedPanePrincipal.addTab("Retours", new RetourFrame());  // Ajouter l'onglet Retours

        // Onglet pour la gestion des Emprunts (onglet vide pour l'instant)
        tabbedPanePrincipal.addTab("Emprunts", creerOngletVide("Emprunts"));  // Onglet des emprunts

        // Ajouter le JTabbedPane à la fenêtre principale
        add(tabbedPanePrincipal, BorderLayout.CENTER);

        // Initialiser le modèle (UtilisateurModel) et le contrôleur (UtilisateurController)
        UtilisateurModel model = new UtilisateurModel("users.csv");
        new UtilisateurController(model, utilisateurFrame);  // Lier le modèle et la vue avec le contrôleur

        setVisible(true);
    }

    // Méthode pour créer un onglet vide (pour les autres fonctionnalités à ajouter)
    private JPanel creerOngletVide(String titre) {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Onglet " + titre + " en construction..."));
        return panel;
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	
            new MainFrame();  // Lancer la fenêtre principale
        });
    } */


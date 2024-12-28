/*package view;

import javax.swing.SwingUtilities;
import controller.RetourController;
import controller.UtilisateurController;
import model.RetourModel;
import model.UtilisateurModel;
import model.Utilisateur;
import model.Livre;
import model.Retour;

public class TestUtilisateurRetourFrame {*/
   /* public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	 new MainFrame();
            // Initialiser le modèle pour les utilisateurs
            UtilisateurModel utilisateurModel = new UtilisateurModel("users.csv");
            UtilisateurFrame utilisateurView = null; // Déclarez la variable ici

            // Initialiser le modèle pour les retours
            RetourModel retourModel = new RetourModel("retours.csv");
            RetourFrame retourView = null; // Déclarez la variable ici

            try {
                // Ajouter des utilisateurs prédéfinis
                Utilisateur utilisateur1 = new Utilisateur( "Meryem", "meryem@gmail.com", "password", "Admin");
                Utilisateur utilisateur2 = new Utilisateur( "Sara", "sara@gmail.com", "password", "Bibliothecaire");
                utilisateurModel.ajouterUtilisateur(utilisateur1);
                utilisateurModel.ajouterUtilisateur(utilisateur2);

                // Ajouter des livres prédéfinis
                Livre livre1 = new Livre( "Java Programming", "John Doe","prog");
                Livre livre2 = new Livre( "Data Structures", "Jane Doe","prog");

                // Ajouter des retours prédéfinis
                retourModel.ajouterRetour(new Retour("E1", utilisateur1, livre1, "2024-01-01", "2024-01-10", "2024-01-09"));
                retourModel.ajouterRetour(new Retour("E2", utilisateur2, livre2, "2024-02-01", "2024-02-10", "2024-02-09"));

                // Initialisez la vue UtilisateurFrame
                utilisateurView = new UtilisateurFrame();
                // Passez la vue et le modèle au contrôleur
                new UtilisateurController(utilisateurModel, utilisateurView);

                // Initialisez la vue RetourFrame
                retourView = new RetourFrame();
                // Passez la vue et le modèle au contrôleur
                new RetourController(retourModel, retourView);

            } catch (Exception e) {
                System.err.println("Erreur : " + e.getMessage());
            }

            // Vérifiez que les vues sont bien initialisées
            if (utilisateurView != null && retourView != null) {
                // Les contrôleurs sont déjà initialisés dans le bloc try-catch
            }
        });
    }*/
	
	/*package view;

	import javax.swing.SwingUtilities;
	import controller.RetourController;
	import controller.UtilisateurController;
	import model.RetourModel;
	import model.UtilisateurModel;
	import model.Utilisateur;
	import model.Livre;
	import model.Retour;

	public class TestUtilisateurRetourFrame {
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            // Initialiser le modèle pour les utilisateurs
	            UtilisateurModel model = new UtilisateurModel("users.csv");
	            UtilisateurFrame view = null; // Déclarez la variable ici

	            try {
	                // Ajouter des utilisateurs prédéfinis
	                model.ajouterUtilisateur(new Utilisateur( "Meryem", "Meryem@gmail.com", "newPass123", "Admin"));
	                model.ajouterUtilisateur(new Utilisateur( "Sara", "Sara@gmail.com", "password", "Admin"));
	                model.ajouterUtilisateur(new Utilisateur("Salma", "Salma@gmail.com", "admin123", "Admin"));
	                model.ajouterUtilisateur(new Utilisateur("Bob", "bob@outlook.com", "password", "Membre"));

	                // Initialisez la vue UtilisateurFrame
	                view = new UtilisateurFrame();
	                // Passez la vue et le modèle au contrôleur
	                new UtilisateurController(model, view);

	                // Recharger le tableau des utilisateurs
	                view.rechargerTable(model.getListe().stream()
	                    .map(u -> new Object[]{u.getId(), u.getNom(), u.getEmail(), u.getMotDePasse(), u.getRole()})
	                    .toArray(Object[][]::new));

	            } catch (Exception e) {
	                System.err.println("Erreur : " + e.getMessage());
	            }

	            // Initialiser le modèle pour les retours
	            RetourModel modelRetour = new RetourModel("retours.csv");
	            RetourFrame viewRetour = null;

	            try {
	                Utilisateur utilisateur1 = new Utilisateur( "Meryem", "Meryem@gmail.com", "newPass123", "Admin");
	                Utilisateur utilisateur2 = new Utilisateur( "Sara", "Sara@gmail.com", "password", "Admin");
	                Livre livre1 = new Livre( "Java Programming", "John Doe", "prog");
	                Livre livre2 = new Livre( "Data Structures", "Jane Doe", "prog");

	                // Ajouter des retours prédéfinis
	                modelRetour.ajouterRetour(new Retour( idEmprunt,utilisateur1, livre1, "2024-01-01", "2024-01-10", "2024-01-09"));
	                modelRetour.ajouterRetour(new Retour( idEmprunt,utilisateur2, livre2, "2024-02-01", "2024-02-10", "2024-02-09"));

	                // Initialisez la vue RetourFrame
	                viewRetour = new RetourFrame();
	                // Passez la vue et le modèle au contrôleur
	                new RetourController(modelRetour, viewRetour);

	                // Recharger le tableau des retours
	                viewRetour.setEmpruntsData(modelRetour.getRetours().stream()
	                    .map(r -> new Object[]{r.getIdEmprunt(), r.getUtilisateur().getNom(), r.getLivre().getTitre(), r.getDateEmprunt(), r.getDateRetourPrevue(), r.getDateRetourEffective()})
	                    .toArray(Object[][]::new));

	            } catch (Exception e) {
	                System.err.println("Erreur : " + e.getMessage());
	            }

	            // Initialisation de la vue principale (MainFrame)
	            new MainFrame();
	        });
	    }
	}

   */
	


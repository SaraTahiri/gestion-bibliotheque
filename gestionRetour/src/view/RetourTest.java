
package view ; 

import controller.RetourController;
import model.ModeleEmprunt;
import model.Retour;
import model.RetourModel;

public class RetourTest {
    public static void main(String[] args) {
        // Chemin vers le fichier CSV
        
        // Créer le modèle des retours
        RetourModel retourModel = new RetourModel("retours.csv");

        // Charger les emprunts depuis le fichier CSV
        retourModel.chargerDepuisEmprunts("emprunts.csv");

     // Créer l'interface utilisateur
     RetourFrame frame = new RetourFrame();

     // Connecter le contrôleur
     RetourController controller = new RetourController(frame, retourModel);

     // Mettre à jour la table avec les données des retours
     controller.updateTableData();
        // Afficher la fenêtre
        frame.setVisible(true);
    }
}


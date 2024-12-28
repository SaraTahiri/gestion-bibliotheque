package controller;

import model.RapportStatistiques;
import view.RapportStatistiqueView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RapportStatistiqueController {
    private RapportStatistiqueView vue;
    private RapportStatistiques rapportStatistique;

    public RapportStatistiqueController(RapportStatistiqueView vue, RapportStatistiques rapportStatistique) {
        this.vue = vue;
        this.rapportStatistique = rapportStatistique;

        // Ajouter un listener au bouton pour générer le rapport
        vue.addGenererRapportListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genererRapport();
            }
        });
    }

    // Méthode pour générer le rapport
    private void genererRapport() {
        String rapport = rapportStatistique.genererRapport(); // Générer le rapport depuis le modèle
        vue.setRapportText(rapport); // Afficher le rapport dans la vue
    }
}

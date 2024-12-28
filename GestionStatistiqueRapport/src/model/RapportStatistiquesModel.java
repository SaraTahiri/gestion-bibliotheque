package model;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class RapportStatistiquesModel implements RapportStatistiqueInterface {

    // Méthode pour obtenir les livres les plus empruntés
    @Override
    public String genererRapportLivresPlusEmpruntes(String empruntCsvFile) {
        Map<String, Integer> livresEmpruntes = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(empruntCsvFile))) {
            String line;
            br.readLine(); // Ignorer l'en-tête

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 5) continue;
                
                String titreLivre = parts[1];  // Le titre du livre est en 2ème position
                livresEmpruntes.put(titreLivre, livresEmpruntes.getOrDefault(titreLivre, 0) + 1);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier CSV des emprunts : " + e.getMessage());
        }

        StringBuilder rapport = new StringBuilder("Livres les plus empruntés:\n");
        livresEmpruntes.forEach((livre, count) -> rapport.append(livre).append(": ").append(count).append(" emprunt(s)\n"));
        return rapport.toString();
    }

    // Méthode pour obtenir les utilisateurs les plus actifs
    @Override
    public String genererRapportUtilisateursPlusActifs(String empruntCsvFile) {
        Map<Integer, Integer> utilisateursActifs = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(empruntCsvFile))) {
            String line;
            br.readLine(); // Ignorer l'en-tête

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 5) continue;

                int idUtilisateur = Integer.parseInt(parts[2]);  // L'ID utilisateur est en 3ème position
                utilisateursActifs.put(idUtilisateur, utilisateursActifs.getOrDefault(idUtilisateur, 0) + 1);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier CSV des emprunts : " + e.getMessage());
        }

        StringBuilder rapport = new StringBuilder("Utilisateurs les plus actifs:\n");
        utilisateursActifs.forEach((idUtilisateur, count) -> rapport.append("Utilisateur " + idUtilisateur).append(": ").append(count).append(" emprunt(s)\n"));
        return rapport.toString();
    }

    // Méthode pour générer un rapport général
    @Override
    public String genererRapportGeneral(String empruntCsvFile) {
        String rapportLivres = genererRapportLivresPlusEmpruntes(empruntCsvFile);
        String rapportUtilisateurs = genererRapportUtilisateursPlusActifs(empruntCsvFile);
        return "Rapport Général:\n" + rapportLivres + "\n" + rapportUtilisateurs;
    }

    // Méthode pour calculer les pénalités
    @Override
    public String genererRapportPenalites(List<Retour> retours) {
        Map<Integer, Double> penalitesTotales = new HashMap<>();
        
        for (Retour retour : retours) {
            LocalDate dateRetourPrevue = retour.getDateRetourPrevue();
            LocalDate dateRetourEffective = retour.getDateRetourEffective();
            if (dateRetourEffective != null && dateRetourEffective.isAfter(dateRetourPrevue)) {
                long joursDeRetard = java.time.temporal.ChronoUnit.DAYS.between(dateRetourPrevue, dateRetourEffective);
                double penalite = joursDeRetard * 50;  // 50 dirhams par jour de retard
                penalitesTotales.put(retour.getIdEmprunt(), penalitesTotales.getOrDefault(retour.getIdEmprunt(), 0.0) + penalite);
            }
        }

        StringBuilder rapport = new StringBuilder("Pénalités totales:\n");
        penalitesTotales.forEach((idEmprunt, penalite) -> rapport.append("Emprunt " + idEmprunt + ": ").append(penalite).append(" dirhams\n"));
        return rapport.toString();
    }
}

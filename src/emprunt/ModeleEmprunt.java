package emprunt;

import java.time.LocalDate;
import exeption.EmpruntNotFoundException;
import exeption.InvalidLoanException;

import java.io.*;
import java.util.*;


public class ModeleEmprunt implements IEmprunt {
    private ArrayList<Emprunt> emprunts = new ArrayList<>();
    private String csvFileName;

    public ModeleEmprunt(String csvFileName) {
        this.csvFileName = csvFileName;
        this.lireCSV();
    }

    

    @Override
    public void ajouterEmprunt(Emprunt emprunt) throws InvalidLoanException {
        if (emprunt.getDateEmprunt() == null || emprunt.getDateRetourPrevue() == null) {
            throw new InvalidLoanException("Les dates d'emprunt et de retour doivent être définies.");
        }
        emprunts.add(emprunt);
        sauvegarderCSV();
    }

    @Override
    public void supprimerEmprunt(int id) throws EmpruntNotFoundException {
        Emprunt emprunt = rechercherEmpruntParID(id);
        if (emprunt == null) {
            throw new EmpruntNotFoundException("Emprunt avec ID " + id + " introuvable.");
        }
        emprunts.remove(emprunt);
        sauvegarderCSV();
    }
    @Override
    public Emprunt rechercherEmpruntParID(int id) throws EmpruntNotFoundException {
        return emprunts.stream()
            .filter(e -> e.getId() == id)
            .findFirst()
            .orElseThrow(() -> new EmpruntNotFoundException("Emprunt avec ID " + id + " introuvable"));
    }
    


    @Override
    public Emprunt consulterEmprunt(int id) {
        return emprunts.stream()
                .filter(emprunt -> emprunt.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void prolongerEmprunt(int id, int joursSupplementaires) {
        Emprunt emprunt = consulterEmprunt(id);
        if (emprunt != null) {
        	LocalDate nouvelleDate = ((LocalDate) emprunt.getDateRetourPrevue()).plusDays(joursSupplementaires);
            emprunt.setDateRetourPrevue(nouvelleDate);
            System.out.println("Emprunt prolongé : " + emprunt);
        } else {
            System.out.println("Emprunt non trouvé.");
        }
    }

    @Override
    public ArrayList<Emprunt> listerEmprunt() {
    	
    	return emprunts;
    	
    	
    }
    @Override
   public void sauvegarderCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFileName))) {
            writer.write("id;livre;utilisateur;dateEmprunt;dateRetour");
            for (Emprunt emprunt : emprunts) {
                writer.newLine();
                writer.write(emprunt.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
   public void lireCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFileName))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                Emprunt emprunt = new Emprunt();
                emprunt.setIduser(Integer.parseInt(parts[1]));
                emprunt.setLivre((parts[2]));
                emprunt.setDateEmprunt(LocalDate.parse(parts[3]));
                emprunt.setDateRetourPrevue(LocalDate.parse(parts[4]));
                emprunts.add(emprunt);
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier CSV: " + e.getMessage());
        }
    }
}




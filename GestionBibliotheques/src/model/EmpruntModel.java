package model;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import exceptions.EmpruntNotFoundException;
import exceptions.InvalidLoanException;

public class EmpruntModel implements EmpruntModelInterface {
	private ArrayList<Emprunt> emprunts = new ArrayList<>();
	private String csvFileName;
	private LivreModel livreModel;

	public EmpruntModel() {
		super();
	}

	public EmpruntModel(String csvFileName) {
		super();
		this.csvFileName = csvFileName;
	}
	
	public EmpruntModel(String csvFileName, LivreModel model) {
		super();
		this.csvFileName = csvFileName;
		this.livreModel=model;
	}

	@Override
	public void ajouterEmprunt(Emprunt emprunt) throws EmpruntNotFoundException {
	    Livre livre = livreModel.rechercherParTitre(emprunt.getTitreLivre());
	    if (livre == null) {
	        throw new EmpruntNotFoundException("Le livre '" + emprunt.getTitreLivre() + "' n'existe pas.");
	    }

	    if (livre.getQuantite() <= 0) {
	        throw new EmpruntNotFoundException("Le livre '" + emprunt.getTitreLivre() + "' n'est plus disponible.");
	    }

	    if (emprunts.contains(emprunt)) {
	        throw new EmpruntNotFoundException("L'emprunt existe déjà.");
	    }

	    emprunts.add(emprunt);
	    livre.setQuantite(livre.getQuantite() - 1);
	    livreModel.sauvegarderCSV();
	    this.sauvegarderCSV();
	}


	@Override
    public void supprimerEmprunt(int id) throws EmpruntNotFoundException {
        Emprunt emprunt = rechercherEmpruntParID(id);
        if (emprunt == null) {
            throw new EmpruntNotFoundException("L'emprunt avec l'ID " + id + " n'existe pas.");
        }

        Livre livre = livreModel.rechercherParTitre(emprunt.getTitreLivre());
        if (livre != null) {
            livre.setQuantite(livre.getQuantite() + 1);
            livreModel.sauvegarderCSV();
        }

        emprunts.remove(emprunt);
        this.sauvegarderCSV();
    }

	@Override
	public Emprunt consulterEmprunt(int id) throws EmpruntNotFoundException{
		// TODO Auto-generated method stub
		Emprunt emprunt = rechercherEmpruntParID(id);
		if(emprunt != null) {
			return emprunt;
		}else {
			throw new EmpruntNotFoundException("Emprunt avec l'ID " + id + " non trouvé.");
		}
	}

	@Override
    public Emprunt rechercherEmpruntParID(int id) throws EmpruntNotFoundException {
        return emprunts.stream()
                .filter(e -> e.getIdEmprunt() == id)
                .findFirst()
                .orElseThrow(() -> new EmpruntNotFoundException("Emprunt avec l'ID " + id + " non trouvé."));
    }

	@Override
	public void prolongerEmprunt(int id, int joursSupp) throws EmpruntNotFoundException{
		// TODO Auto-generated method stub
			Emprunt emprunt = rechercherEmpruntParID(id);
			if(emprunt != null) {
				LocalDate newDateRetour = emprunt.getDateRetour().plusDays(joursSupp);
				emprunt.setDateRetour(newDateRetour);
				this.sauvegarderCSV();
			}else {
				throw new EmpruntNotFoundException("Emprunt avec l'ID " + id + " non trouvé.");
			}
	}

	@Override
	public ArrayList<Emprunt> listerEmprunt() {
		// TODO Auto-generated method stub
		return emprunts;
	}

	@Override
	public void lireCSV() {
		// TODO Auto-generated method stub
		emprunts.clear();
		Set<Integer> ids = new HashSet<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(csvFileName));
			br.readLine();
			String line;
			while((line=br.readLine()) != null) {
				String[] words = line.split(";");
				if(words.length<5) continue;
				
				int id = Integer.parseInt(words[0]);
				int idUser = Integer.parseInt(words[1]);
				String titre = words[2];
				LocalDate dateE = LocalDate.parse(words[3]);
				LocalDate dateR = LocalDate.parse(words[4]);
				
				if(!ids.contains(id)) {
					ids.add(id);
					Emprunt emprunt = new Emprunt();
					emprunt.setIdEmprunt(id);
					emprunt.setIdUtilisateur(idUser);
					emprunt.setTitreLivre(titre);
					emprunt.setDateEmprunt(dateE);
					emprunt.setDateRetour(dateR);
					
					emprunts.add(emprunt);
				}
			}
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sauvegarderCSV() {
		// TODO Auto-generated method stub
		supprimerDoublons();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(csvFileName));
			bw.write("Id;IdUtilisateur;TitreLivre;DateEmprunt;DateRetour");
			for(Emprunt emprunt : emprunts) {
				bw.newLine();
				bw.write(emprunt.getIdEmprunt() + ";" + emprunt.getIdUtilisateur() + ";" + emprunt.getTitreLivre() + ";" + emprunt.getDateEmprunt() + ";" + emprunt.getDateRetour());
			}
			bw.close();
		}catch(IOException e) {
			System.err.println("Erreur lors de la sauvegarde du fichier");
		}
	}

	public void supprimerDoublons() {
		Set<String> empruntUnique = new HashSet<>();
		emprunts.removeIf(emprunt -> !empruntUnique.add(emprunt.getIdUtilisateur()+emprunt.getTitreLivre()+emprunt.getDateEmprunt()+emprunt.getDateRetour()));
	}

	@Override
    public void modifierEmprunt(int id, int idUser, String nouveauTitre, LocalDate nouvelleDateEmprunt, LocalDate nouvelleDateRetour)
            throws EmpruntNotFoundException {
        Emprunt emprunt = rechercherEmpruntParID(id);
        if (emprunt == null) {
            throw new EmpruntNotFoundException("L'emprunt avec l'ID " + id + " n'existe pas.");
        }

        Livre ancienLivre = livreModel.rechercherParTitre(emprunt.getTitreLivre());
        Livre nouveauLivre = livreModel.rechercherParTitre(nouveauTitre);

        if (nouveauLivre == null || nouveauLivre.getQuantite() <= 0) {
            throw new EmpruntNotFoundException("Le nouveau livre '" + nouveauTitre + "' n'est pas disponible.");
        }

        // Rendre l'ancien livre
        if (ancienLivre != null) {
            ancienLivre.setQuantite(ancienLivre.getQuantite() + 1);
        }

        // Décrémenter la quantité du nouveau livre
        nouveauLivre.setQuantite(nouveauLivre.getQuantite() - 1);

        // Mettre à jour l'emprunt
        emprunt.setIdUtilisateur(idUser);
        emprunt.setTitreLivre(nouveauTitre);
        emprunt.setDateEmprunt(nouvelleDateEmprunt);
        emprunt.setDateRetour(nouvelleDateRetour);

        livreModel.sauvegarderCSV();
        this.sauvegarderCSV();
    }

	@Override
    public ArrayList<Emprunt> rechercherEmpruntParTitre(String titre) {
        ArrayList<Emprunt> empruntsTrouves = new ArrayList<>();
        for (Emprunt emprunt : emprunts) {
            if (emprunt.getTitreLivre().equalsIgnoreCase(titre)) {
                empruntsTrouves.add(emprunt);
            }
        }
        return empruntsTrouves;
    }
	
}

package model;

import java.io.*;
import java.util.*;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import exceptions.LivreNotFoundException;

public class LivreModel implements LivreModelInterface {

	private ArrayList<Livre> liste=new ArrayList<Livre>();
	private String csvFileName;
	
	
	public LivreModel() {
		super();
	}

	public LivreModel(String csvFileName) {
		super();
		this.csvFileName = csvFileName;
	}

	@Override
	public void ajouterLivre(Livre livre) throws LivreNotFoundException{
		// TODO Auto-generated method stub
		if(liste.contains(livre)) {
			throw new LivreNotFoundException("Le livre existe deja");
		}
		liste.add(livre);
		this.sauvegarderCSV();
	}

	@Override
	public void modifierLivre(int isbn, String nvTitre, String nvAuteur, String nvGenre, int nvAnneePub) throws LivreNotFoundException {
		// TODO Auto-generated method stub
		Livre livre = rechercherParId(isbn);
		if(livre != null) {
			livre.setTitre(nvTitre);
			livre.setAuteur(nvAuteur);
			livre.setGenre(nvGenre);
			livre.setAnneePublication(nvAnneePub);
		}
		else {
			throw new LivreNotFoundException(isbn);
		}
	}

	@Override
	public void supprimerLivre(int isbn) throws LivreNotFoundException{
		// TODO Auto-generated method stub
		Livre livre = rechercherParId(isbn);
		if(livre != null) {
			liste.remove(livre);
		}else {
			throw new LivreNotFoundException(isbn);
		}
	}

	@Override
	public void trierListesLivre() {
		// TODO Auto-generated method stub
		Collections.sort(liste);
	}

	@Override
	public Livre rechercherParId(int isbn) {
		// TODO Auto-generated method stub
		Optional<Livre> livre=liste.stream().filter(t->t.getIsbn()==isbn).findFirst();
		if(livre.isPresent())
			return livre.get();
		return null;
	}

	@Override
	public void listerLivres() {
		// TODO Auto-generated method stub
		System.out.println(liste);
	}

	@Override
	public void sauvegarderCSV() {
	    try {
	        BufferedWriter bw = new BufferedWriter(new FileWriter(csvFileName));
	        bw.write("Id;Titre;Auteur;Annee Publication;Genre");
	        for (Livre livre : liste) {
	            bw.newLine();
	            bw.write(livre.getIsbn() + ";" + livre.getTitre() + ";" + livre.getAuteur() + ";" + 
	                     livre.getAnneePublication() + ";" + livre.getGenre());
	        }
	        bw.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void lireCSV() {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new FileReader(csvFileName));
			br.readLine();
			String line;
			while((line=br.readLine())!=null) {
				String[] words= line.split(";");
				int id = Integer.parseInt(words[0]);
				String titre= words[1];
				String auteur= words[2];
				int anneePub= Integer.parseInt(words[3]);
				String genre= words[4];
				Livre livre= new Livre();
				livre.setIsbn(id);
				livre.setTitre(titre);
				livre.setAuteur(auteur);
				livre.setAnneePublication(anneePub);
				livre.setGenre(genre);
				liste.add(livre);
			}
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}


}

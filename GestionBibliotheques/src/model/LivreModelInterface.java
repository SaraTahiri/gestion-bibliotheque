package model;

import exceptions.LivreNotFoundException;

public interface LivreModelInterface {

	public void ajouterLivre(Livre livre) throws LivreNotFoundException;
	public void modifierLivre(int isbn, String nvTitre, String nvAuteur, String nvGenre, int nvAnneePub) throws LivreNotFoundException;
	public void supprimerLivre(int isbn) throws LivreNotFoundException;
	public void trierListesLivre();
	public Livre rechercherParId(int isbn);
	public void listerLivres();
	public void sauvegarderCSV();
	public void lireCSV();
}

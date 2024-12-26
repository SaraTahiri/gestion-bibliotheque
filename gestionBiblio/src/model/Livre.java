package model;

public class Livre {
	 public Livre(int id, String titre, String auteur, String genre) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.genre = genre;
	}

	private int id;
	private static int compteur = 1;
    private String titre;
    private String auteur;
    private String genre;

    public Livre( String titre, String auteur, String genre) {
    	 this.id = compteur++;
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return id + ";" + titre + ";" + auteur + ";" + genre;
    }
}

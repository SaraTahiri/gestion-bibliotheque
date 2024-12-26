package model;

public class Membre extends Utilisateur {
    public Membre(String nom, String email , String motDePasse) {
        super(nom,email, motDePasse, "Membre");
    }
}

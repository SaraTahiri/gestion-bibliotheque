package model;

public class Bibliothecaire extends Utilisateur {
    public Bibliothecaire(String nom,String email, String motDePasse) {
        super(nom, email,motDePasse, "Bibliothecaire");
    }
}
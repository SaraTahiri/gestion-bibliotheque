package model;

public class Admin extends Utilisateur {
    public Admin(String nom, String email ,String motDePasse) {
        super(nom,email, motDePasse, "Admin");
    }
}
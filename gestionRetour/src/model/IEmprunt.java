package model;

import java.util.ArrayList;

import exception.EmpruntNotFoundException;
import exception.InvalidLoanException;

public interface IEmprunt {
	
	void ajouterEmprunt(Emprunt emprunt)throws InvalidLoanException;
    void supprimerEmprunt(int id)throws EmpruntNotFoundException;;
    Emprunt consulterEmprunt(int id);
    public Emprunt rechercherEmpruntParID(int id) throws EmpruntNotFoundException;
    void prolongerEmprunt(int id, int joursSupp);
    public  ArrayList<Emprunt> listerEmprunt();
    void lireCSV();
    void sauvegarderCSV();

}
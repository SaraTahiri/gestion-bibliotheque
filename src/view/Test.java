package view;
import controller.EmpruntController;
import emprunt.ModeleEmprunt;

public class Test {

	public static void main(String[] args) {
	 new EmpruntFrame();
	 
	  ModeleEmprunt modele = new ModeleEmprunt("emprunts.csv");
      EmpruntFrame view = new EmpruntFrame();
      new EmpruntController(modele, view);
  }
	 

	}



package emprunt;

public class Livre {
  private int id ;
  private String nom;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
@Override
public String toString() {
	return "Livre [id=" + id + ", nom=" + nom + "]";
}
  
}

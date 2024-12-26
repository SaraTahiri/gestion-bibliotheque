package emprunt;

import java.time.LocalDate;


public class Emprunt {
	    private int id;
	    private static int conteur=1;
	    private LocalDate dateEmprunt;
	    private LocalDate dateRetourPrevue;
	  
	    private int  Iduser;
	    private  String livre;
	    
	    public Emprunt() {
	    	super();
	    }
        
	    public Emprunt( int id, int Iduser, String livre, LocalDate dateEmprunt,LocalDate dateRetourPrevue) {
	        this.id=conteur++;
	        this.Iduser = Iduser;
	        this.livre = livre;
	     
	        this.dateEmprunt = dateEmprunt;
	        this.dateRetourPrevue = dateRetourPrevue;
	    }

	  

		public int getIduser() {
			return Iduser;
		}

		public void setIduser(int iduser) {
			Iduser = iduser;
		}

		public String getLivre() {
			return livre;
		}

		public void setLivre(String livre) {
			this.livre = livre;
		}

		public int getId() {
	        return id;
	    }
	     
	    public void setId(int id) {
	    	this.id=id;
	    }
	   

	   


		
       
		public LocalDate getDateEmprunt() {
	        return dateEmprunt;
	    }
	    public void setDateEmprunt(LocalDate dateEmprunt) {
	    	this.dateEmprunt=dateEmprunt;
	    }

	    public LocalDate getDateRetourPrevue() {
	        return dateRetourPrevue;
	    }

	    public void setDateRetourPrevue(LocalDate dateRetourPrevue) {
	        this.dateRetourPrevue = dateRetourPrevue;
	    }

		@Override
		public String toString() {
			return   id + ";"  + livre + ";" + Iduser +  
					";" + dateEmprunt + ";" + dateRetourPrevue ;
		}

		

	    
	    }
	



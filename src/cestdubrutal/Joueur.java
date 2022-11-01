package cestdubrutal;

public class Joueur {
	private String pseudo = new String();
	private String programme = new String();
	
	public Joueur(String pseudo, String programme) {
		this.pseudo = pseudo;
		this.programme = programme;
	}
	
	
	//methode attribuer pseudo sert à rien car quand on créer un joueur on lui donne un pseudo direct
	//methode qui retourne le pseudo d'un joueur
	public String getPseudo() {
		return(this.pseudo);
	}
	
	//methode qui retourne le programme d'un joueur
	public String getProgramme() {
		return(this.programme);
	}
	
	public void choisirProgramme() {
		
	}
	
	public void déclarerForfait() {
		
	}
	
}

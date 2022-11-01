package cestdubrutal;

public class Partie {
	
	//creer un tableau avec toutes les branches de l'UTT en final(non modifiable)
	
	private boolean estTerminé;
	
	
	public static void main(String[] args) {
		//test d'affichage
		System.out.println("Hello");
		
		//test d'instanciation d'un joueur
		String pseudo = new String();
		String programme = new String();
		
		pseudo = "Chivouille";
		programme = "ISI";
		
		Joueur matthieu = new Joueur(pseudo, programme);
		System.out.println(matthieu.getPseudo());
		

	}
}

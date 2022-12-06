package cestdubrutal;

import java.util.Scanner;

import cestdubrutal.Joueur.Programme;

//Commentaire par rapport au diagramme de classe
//Pas d'attribuer pseudo ni programme car dans la création du jouer car création


public class Joueur {
	static public enum Programme{ISI, RT, A2I ,GI, GM, MTE, MM}
	
	//Attributs
	private String pseudo;
	private Programme programme;
	private Eleve[] tabEleve;
	
	Scanner sc = new Scanner(System.in);
	
	//Constructeur
	public Joueur() {		
//		System.out.println("Mettre le pseudo du joueur:");
//		this.pseudo = sc.nextLine();
//		
//		
//		System.out.println("Renseigner le programme du joueur (1 pour ISI, 2 pour RT...");
//		String p=sc.nextLine();
//		
//		
//		switch(p) {
//		case "1":
//			this.programme= Programme.ISI;
//		case "2":
//			this.programme= Programme.RT;
//		case "3":
//			this.programme= Programme.A2I;
//		case "4":
//			this.programme= Programme.GI;
//		default:
//			this.programme= Programme.ISI;
//			//à continuer	
//		}
		
		//création des eleves associé à un joueur
		this.setTabEleve(new Eleve[20]);
		for(int i=0;i<20;i++) {
			this.getTabEleve()[i]=new Eleve();
		}
		
		
		//attribuer point direct (changer valeur borne car sinon chiant i<20)
		//construction des élèves
		for(int i=0;i<2;i++) {
//			System.out.println("int force, int dexterite, int resistance, int constitution, int initiative");
//			int force=sc.nextInt();
//			int dexterite=sc.nextInt();
//			int resistance=sc.nextInt();
//			int constitution = sc.nextInt();
//			int initiave= sc.nextInt();
//			this.getTabEleve()[i].CharacteristiqueEleve.attribuerPoints(force, dexterite, resistance, constitution, initiave);

			this.getTabEleve()[i].CharacteristiqueEleve.attribuerPoints(10, 10, 10, 10, 10);
			
			//choix strat
			System.out.println("Choix Strat 1: Attaque 2: Defense 3: Aléatoire");
			int choix = sc.nextInt();
			switch(choix) {
			case 1:
				this.getTabEleve()[i].setStrat(Eleve.Strategie.Attaquer);
				break;
			case 2:
				this.getTabEleve()[i].setStrat(Eleve.Strategie.Soigner);
				break;
			case 3:
				this.getTabEleve()[i].setStrat(Eleve.Strategie.Aleatoire);
				break;
			}
			//ajouter un aléatoire avec une fonction de Eleve si aléatoire...
			
		}
	}
	
	public void choixReserviste() {

	}
	
	//methode attribuer pseudo sert à rien car quand on créer un joueur on lui donne un pseudo direct
	//methode qui retourne le pseudo d'un joueur
	public String getPseudo() {
		return(this.pseudo);
	}
	
	//methode qui retourne le programme d'un joueur
	public String getProgramme() {
		return(this.programme.toString());
	}
	
	public void déclarerForfait() {
		System.out.println("Le joueur :"+ this.pseudo+ "déclare forfait");
		//mettre fin à la partie
		System.exit(1);
	}

	public Eleve[] getTabEleve() {
		return tabEleve;
	}

	public void setTabEleve(Eleve[] tabEleve) {
		this.tabEleve = tabEleve;
	}

	
	
//	public void placerJoueurNonReserviste(){
//		for(Eleve i:this.tabEleve) {
//			System.out.println("Quelle Zone? 1 BU...");
//			int choixZone=sc.nextInt();
//			switch(choixZone) {
//			case 1:
//				tabZI[0]
//			}
//		}
//	}
	
	
}

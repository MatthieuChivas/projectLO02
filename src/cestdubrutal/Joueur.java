package cestdubrutal;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

import cestdubrutal.Joueur.Programme;

//Commentaire par rapport au diagramme de classe
//Pas d'attribuer pseudo ni programme car dans la création du jouer car création


public class Joueur {
	static public enum Programme{ISI, RT, A2I ,GI, GM, MTE, MM}
	
	//Attributs
	private String pseudo;
	private Programme programme;
	private ArrayList<Eleve> tabEleve= new ArrayList(20);
	
	Scanner sc = new Scanner(System.in);
	
	//Constructeur
	public Joueur() {		
		System.out.println("Mettre votre pseudo:");
		this.pseudo = sc.nextLine();
		
		
		System.out.println(pseudo + " Renseigner votre programme");
		int p=8;// entré dans la boucle while
		while(p<=0 || p>=8) {
			System.out.println("ISI:1 RT:2 A2I:3 GI:4 GM:5 MTE:6 MM:7");
			int p1=sc.nextInt();
			if(p1<=0 || p1>=8) {
				System.out.println("erreur");
			}
			else {
				if(p1==1) {
					this.programme= Programme.ISI;
					p=p1;
				}
				if(p1==2) {
					this.programme= Programme.RT;
					p=p1;
				}
				if(p1==3) {
					this.programme= Programme.A2I;
					p=p1;
				}
				if(p1==4) {
					this.programme= Programme.GI;
					p=p1;
				}
				if(p1==5) {
					this.programme= Programme.GM;
					p=p1;
				}
				if(p1==6) {
					this.programme= Programme.MTE;
					p=p1;
				}
				if(p1==7) {
					this.programme= Programme.MM;
					p=p1;
				}
			}
			
		}
				
		System.out.println("Vous avez choisi "+programme);	
		
		//création des eleves associé à un joueur
		for(int i=0;i<20;i++) {
			this.tabEleve.add(new Eleve());
		}
		
		//construction des élèves
		//pour l'instant tout est automatique
		for(int i=0; i<=14; i++) {
			this.tabEleve.get(i).CharacteristiqueEleve.attribuerPoints(0, 0, 0, 0, 0);
			this.tabEleve.get(i).setStrat(Eleve.Strategie.Aleatoire);
			if(tabEleve.get(i).Strat == Eleve.Strategie.Aleatoire) {
				double x = Math.random();
				if(x<=0.5) {
					this.tabEleve.get(i).setStrat(Eleve.Strategie.Attaquer);
				}
				else {
					this.tabEleve.get(i).setStrat(Eleve.Strategie.Soigner);
				}
			}
			System.out.println("l'etudiant (" + i + ") a comme strategie: " + tabEleve.get(i).Strat);
		}
		for(int i=15; i<=18; i++) {
			this.tabEleve.get(i).CharacteristiqueEleve.attribuerPoints(1, 1, 1, 1, 1);
			this.tabEleve.get(i).setStrat(Eleve.Strategie.Aleatoire);
			if(tabEleve.get(i).Strat == Eleve.Strategie.Aleatoire) {
				double x = Math.random();
				if(x<=0.5) {
					this.tabEleve.get(i).setStrat(Eleve.Strategie.Attaquer);
				}
				else {
					this.tabEleve.get(i).setStrat(Eleve.Strategie.Soigner);
				}
			}
			System.out.println("l'etudiant d'elite (" + i + ") a comme strategie: " + tabEleve.get(i).Strat);
		}
		this.tabEleve.get(19).CharacteristiqueEleve.attribuerPoints(2, 2, 2, 10, 2);
		this.tabEleve.get(19).setStrat(Eleve.Strategie.Aleatoire);
		if(tabEleve.get(19).Strat == Eleve.Strategie.Aleatoire) {
			double x = Math.random();
			if(x<=0.5) {
				this.tabEleve.get(19).setStrat(Eleve.Strategie.Attaquer);
			}
			else {
				this.tabEleve.get(19).setStrat(Eleve.Strategie.Soigner);
			}
		}
		System.out.println("maitre du gobi (19) a comme strategie: " + tabEleve.get(19).Strat);
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

	public ArrayList<Eleve> getTabEleve() {
		return tabEleve;
	}
	
	public Eleve getTabEleve(int e) {
		return tabEleve.get(e);
	}

	public void setTabEleve(ArrayList<Eleve> tabEleve) {
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

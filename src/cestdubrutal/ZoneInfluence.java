package cestdubrutal;

import java.util.*;


public class ZoneInfluence {

	static public enum ZoneInflu{BU, BDE, ADMIN, HALLESINDUS,HALLESPORTIVE}
	final static public int NBZONEINFLUENCE=5;
	
	//indice du tableau qui s'incrémente quand on ajoute un élève et qui se décrémente quand tué élève
	public int indiceTabEleve=0;
	
	private ZoneInflu nom;
	private int nombreEtudiant;
	private ArrayList<Eleve> tabEleveZone;
	private boolean controle;
	
	public ZoneInfluence(ZoneInflu nom) {
		this.nom=nom;
		this.nombreEtudiant=0;
		this.controle=false;
		this.tabEleveZone = new ArrayList<Eleve>(); //ici aucun Eleve n'est construit!! : ce qu'on pourrait faire c'est deux tableaux un associé au j1 et un au j2
	}
	
	public void ajouterEleve(Eleve eleveAAjouter) {
		this.tabEleveZone.add(eleveAAjouter);
		this.indiceTabEleve++;
	}
	
	public void rangerListeMeilleurInitiative() {
		ArrayList<Eleve> tabRange = new ArrayList<Eleve>();
		for(int i=10; i>=0; i--) { //i initiative du plus grand au plus petit
			for(int j=0; j<tabEleveZone.size(); j++) {//j parcours de la liste
				if(tabEleveZone.get(j).CharacteristiqueEleve.getInitiative()==i) {
					tabRange.add(tabEleveZone.get(j));
				}
			}
		}
		this.tabEleveZone = tabRange;
	}
	
	//return vrai si les deux eleves de l'indice 
	public boolean indiceEleveMemeJoueur(int ind1, int ind2, Joueur j1, Joueur j2) {
		//entier stock si j1 ou j2
		int j=2;
		
		//on regarde si l'eleve correspondant à l'indice1 vient du j1 ou j2
		for(int i=0; i<=j1.getTabEleve().size()-1; i++) {
			if(this.tabEleveZone.get(ind1)==j1.getTabEleve(i)) {
				j=1;
		}
		}
		
		if(j==1){
			for(int i=0;i<j1.getTabEleve().size()-1;i++) {
				if(this.tabEleveZone.get(ind2)==j1.getTabEleve(i)) {
					return true;
			}
		}
			return false;
		}
		else{
			for(int i=0;i<j2.getTabEleve().size()-1;i++) {
				if(this.tabEleveZone.get(ind2)==j2.getTabEleve(i)) {
					return true;
			}
		}
			return false;
		}
		
	
}
	//voir si les élèves d'une zone appartiennent au même joeur
	//return true : si les 2 joueurs sont presents
	//return false : si 1 joueurs est present
	public boolean isEnnemieZI(Joueur j1, Joueur j2) {
		boolean deuxJoueur=false;
		for(int i=0; i<tabEleveZone.size(); i++) {
			for(int k=0; k<tabEleveZone.size()-1; k++) {

				if(!indiceEleveMemeJoueur(i, k, j1, j2)) {
					deuxJoueur=true;
				}
			}
		}
		return(deuxJoueur);
		
	}
	
	
	public void consulterECTS() {
		
	}

	public ZoneInflu getNom() {
		return nom;
	}

	public void setNom(ZoneInflu nom) {
		this.nom = nom;
	}

	public int getNombreEtudiant() {
		return nombreEtudiant;
	}

	public void setNombreEtudiant(int nombreEtudiant) {
		this.nombreEtudiant = nombreEtudiant;
	}

	public ArrayList<Eleve> getTabEleveZone() {
		return tabEleveZone;
	}
	
	public Eleve getTabEleveZone(int e) {
		return tabEleveZone.get(e);
	}

	public void setTabEleveZone(Eleve tabEleveZone) {
		this.tabEleveZone.add(tabEleveZone);
	}

	public boolean isControle(Joueur j1, Joueur j2) {
		if (isEnnemieZI(j1,j2)) {
			this.controle=false;
			return controle;
		}
		else {
			this.controle=true;
			return controle;
		}
	}

	public void setControle(boolean controle) {
		this.controle = controle;
	}
}

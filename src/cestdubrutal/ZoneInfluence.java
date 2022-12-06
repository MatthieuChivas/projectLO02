package cestdubrutal;

public class ZoneInfluence {

	static public enum ZoneInflu{BU, BDE, ADMIN, HALLESINDUS,HALLESPORTIVE}
	final static public int NBZONEINFLUENCE=5;
	//indice du tableau qui s'incrémente quand on ajoute un élève et qui se décrémente quand tué élève
	public int indiceTabEleve=0;
	
	private ZoneInflu nom;
	private int nombreEtudiant;
	private Eleve[] tabEleveZone;
	private boolean controle;
	
	public ZoneInfluence(ZoneInflu nom) {
		this.nom=nom;
		this.nombreEtudiant=0;
		this.controle=false;
		this.tabEleveZone = new Eleve[20]; //ici aucun Eleve n'est construit!!
	}
	
	public void ajouterEleve(Eleve eleveAAjouter) {
		this.tabEleveZone[indiceTabEleve]=eleveAAjouter;
		this.indiceTabEleve++;
	}
	
	public void rangerListeMeilleurInitiative() {
		Eleve temp;
		for(int i=0;i<indiceTabEleve-2;i++) {
			System.out.println("i:"+i);
			for(int k=indiceTabEleve-1;k>i;k--) {
				System.out.println("k: "+k);
				if(this.tabEleveZone[k].CharacteristiqueEleve.getInitiative()>this.tabEleveZone[k-1].CharacteristiqueEleve.getInitiative()) {
					temp=this.tabEleveZone[k];
					this.tabEleveZone[k]=this.tabEleveZone[k-1];
					this.tabEleveZone[k-1]=temp;
				}
			}
	}
}
	public static void main(String[] args) {
//test tableau
		ZoneInfluence A= new ZoneInfluence(ZoneInflu.ADMIN);
		Joueur j1=new Joueur();
		Joueur j2=new Joueur();
		A.ajouterEleve(j1.tabEleve[0]);
		A.ajouterEleve(j1.tabEleve[1]);
		A.ajouterEleve(j2.tabEleve[0]);
		A.ajouterEleve(j2.tabEleve[1]);
//		
//		Eleve e1=new Eleve();
//		Eleve e2=new Eleve();
//		Eleve e3=new Eleve();
////		Eleve e4=new Eleve();
////		Eleve e5=new Eleve();
////		
//		e1.CharacteristiqueEleve.attribuerPoints(10, 10, 10, 10, 10);
//		e2.CharacteristiqueEleve.attribuerPoints(10, 10, 10, 10, 1);
//		e3.CharacteristiqueEleve.attribuerPoints(10, 10, 10, 10, 20);
//		e4.CharacteristiqueEleve.attribuerPoints(10, 10, 10, 10, 8);
//		e5.CharacteristiqueEleve.attribuerPoints(10, 10, 10, 10, 60);
//		
//		e1.setECTS(1);
//		e2.setECTS(2);
//		e3.setECTS(3);
//		e4.setECTS(4);
//		e5.setECTS(5);
//
//		
//		A.ajouterEleve(e1);
//		A.ajouterEleve(e2);
//		A.ajouterEleve(e3);
////		A.ajouterEleve(e4);
//		A.ajouterEleve(e5);
//		
//		A.rangerListeMeilleurInitiative();
//		System.out.println("caca");
//		for(int i =0;i<5;i++) {
//			System.out.println(A.tabEleveZone[i].getECTS());
//			System.out.println(A.tabEleveZone[i].CharacteristiqueEleve.getInitiative());
//		}
		if(A.indiceEleveMemeJoueur(0,1,j1,j2)) {
			System.out.println("Réussi");
		}
		else {
			System.out.println("Pasréussi");
		}
	}
	
	//return vrai si meme joueur
	public boolean indiceEleveMemeJoueur(int indice1, int indice2, Joueur j1, Joueur j2) {
		//entier stock si j1 ou j2
		int j=2;
		
		//on regarde si l'eleve correspondant à l'indice1 vient du j1 ou j2
		for(int i=0;i<j1.tabEleve.length;i++) {
			if(this.getTabEleveZone()[indice1]==j1.tabEleve[i]) {
				j=1;
		}
		}
		
		if(j==1){
			for(int i=0;i<j1.tabEleve.length;i++) {
				if(this.getTabEleveZone()[indice2]==j1.tabEleve[i]) {
					return true;
			}
		}
			return false;
		}
		else{
			for(int i=0;i<j2.tabEleve.length;i++) {
				if(this.getTabEleveZone()[indice2]==j2.tabEleve[i]) {
					return true;
			}
		}
			return false;
		}
		
	
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

	public Eleve[] getTabEleveZone() {
		return tabEleveZone;
	}

	public void setTabEleveZone(Eleve[] tabEleveZone) {
		this.tabEleveZone = tabEleveZone;
	}

	public boolean isControle() {
		return controle;
	}

	public void setControle(boolean controle) {
		this.controle = controle;
	}
}

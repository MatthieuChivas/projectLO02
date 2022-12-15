package cestdubrutal;

import java.util.Scanner;
import java.util.ArrayList;

import cestdubrutal.Joueur.Programme;
import cestdubrutal.ZoneInfluence.ZoneInflu;

//joueur/élève/charactéristique + Partie Strategie Zoneinfluence
public class Partie {
	private boolean estTerminé;
	
	static Scanner sc= new Scanner(System.in);
	
	//création de la partie
	public Partie() {
		this.estTerminé=false;		
	}
	
	public ArrayList<ZoneInfluence> zonesCtrl(ArrayList<ZoneInfluence> zones, Joueur j1, Joueur j2) {
		ArrayList<ZoneInfluence> tab= new ArrayList<ZoneInfluence>();
		for(int i=0; i<zones.size(); i++) {
			if(zones.get(i).isControle(j1, j2)) {
				tab.add(zones.get(i));
			}
		}
		return(tab);
	}
	
	public ArrayList<ZoneInfluence> zonesNonCtrl(ArrayList<ZoneInfluence> zones, Joueur j1, Joueur j2) {
		ArrayList<ZoneInfluence> tab= new ArrayList<ZoneInfluence>();
		for(int i=0; i<zones.size(); i++) {
			if(!zones.get(i).isControle(j1, j2)) {
				tab.add(zones.get(i));
			}
		}
		return(tab);
	}
	
	//démarage de la partie
	public static void main(String[] args) {
		//---------------
		//ETAPE 1
		Partie p1 = new Partie();
		
		
		//création joueur :
		Joueur j1= new Joueur();
		Joueur j2= new Joueur();
		
		//choix réserviste :
		//j1.choixReserviste();
		//j2.choixReserviste();
		
		
		//------------
		//ETAPE 2
		ArrayList<ZoneInfluence> tabZI = new ArrayList<ZoneInfluence>(5);
		tabZI.add(new ZoneInfluence(ZoneInflu.BU));
		tabZI.add(new ZoneInfluence(ZoneInflu.BDE));
		tabZI.add(new ZoneInfluence(ZoneInflu.ADMIN));
		tabZI.add(new ZoneInfluence(ZoneInflu.HALLESINDUS));
		tabZI.add(new ZoneInfluence(ZoneInflu.HALLESPORTIVE));
		
		//pour les deux joueurs on va placer les eleves a placer qui ne sont pas réserviste
		//plutot comme ça : pour chaque zone influence : on va placer un nombre de joueur et on choisi ensuite les indexs
		//FAIRE UNE FONCTION CAR dépend du joueur!!
		int nombreEleveZI;
//		for(int i=0;i<2;i++) {
//			for(ZoneInfluence ZI:tabZI) {
//				System.out.println("Combien d'eleve sur :"+ ZI.getNom().toString());
//				nombreEleveZI=sc.nextInt();
//				//au minimum un!!
//				
//				for(int eleve=0;eleve<nombreEleveZI;eleve++) {
//					//vérif qu'il est pas réserviste
//					//vérif qu'il ne soit pas déjà autre part (à l'arriver de cette zone on change un attribut et on le remodif a chaque changement)
//					System.out.println("Indice eleve :");
//					if(i==0) {
//					ZI.ajouterEleve(j1.getTabEleve(sc.nextInt()));//vu que ya j1 faire fonction avec en parametre le joueur!!
//					}
//					else if(i==1) {
//					ZI.ajouterEleve(j2.getTabEleve(sc.nextInt()));
//					}
//					}
//				
//				
//			}
//			}
		
		for(int i=0; i< tabZI.size(); i++) {
			System.out.println(j1.getPseudo() + " Combien d'eleve sur : "+ tabZI.get(i).getNom());
			int x = (int)(Math.random()*4)+1;//minimum 1 Eleve par zone
			System.out.println(x);
		}
		
		for(int i=0; i< tabZI.size(); i++) {
			System.out.println(j2.getPseudo() + " Combien d'eleve sur : "+ tabZI.get(i).getNom());
			int x = (int)(Math.random()*4)+1;
			System.out.println(x);
		}
		
		
//		tabZI[0].ajouterEleve(j1.getTabEleve()[0]);
//		tabZI[0].ajouterEleve(j2.getTabEleve()[0]);
//		
//		tabZI[1].ajouterEleve(j1.getTabEleve()[1]);
//		tabZI[1].ajouterEleve(j2.getTabEleve()[1]);

		
		//----------
		//ETAPE 3 : Mélééé
		
		//presque fini faut juste changer tout les déplacemnet dans les liste en indice et pas direct en : 
		
		//cette liste stocke les indices des joueurs adverse
		int[] indiceJoueurAdverse=new int[20];
		
		//ajouter un while avec le flag de l'adversaire 
		
		//tester dans toutes les zones d'influences : remplacer le 2 par 5 i.e : ZoneInfluence.NBZONEINFLUENCE!!
		for(int indiceZoneInflu=0;indiceZoneInflu<5;indiceZoneInflu++) {
			//mettre le flag et lui dire de break si c'est le cas!
			
			//System.out.println("ZI"+indiceZoneInflu);
			
			//ordonne la liste en fonction des meilleurs initiative 
			tabZI.get(indiceZoneInflu).rangerListeMeilleurInitiative();
			
			//pour chaque élève on va attaquer ou soigner les autres
			for(int indiceEleve=0;indiceEleve<tabZI.get(indiceZoneInflu).indiceTabEleve;indiceEleve++) {
				System.out.println(tabZI.get(indiceZoneInflu).getTabEleveZone(indiceEleve).getStrat());
				
				//pour les joueurs avec comme Strat attaquer
				if(tabZI.get(indiceZoneInflu).getTabEleveZone(indiceEleve).getStrat()==Eleve.Strategie.Attaquer) {
					//aléatoire fonctionne OK sinon passer au suivant (break;)
					//trouver le moins de crédit ECTS parmi l'ennemie
					//donc regarder la liste un par un
					//regarder si pas le même joueur stocker dans une liste temporaire (récuperer une liste d'indice plus simple!)
					//créer une fonction qui 
					
					
					int indiceCombat=0;
					
					//tester si l'élève n'est pas mort?
					//on regarde pour tous les élèves de la Zone Influence
					for(int j=0;j<tabZI.get(indiceZoneInflu).indiceTabEleve;j++) {
						
						//si l'élève est mort continue
						if(tabZI.get(indiceZoneInflu).getTabEleveZone(j).isVire()) {
							continue;
						}
						
						//si l'élève n'appartient pas au même joueur 
						if(!(tabZI.get(indiceZoneInflu).indiceEleveMemeJoueur(indiceEleve, j, j1, j2))) {
							
							//on stocke dans une liste pour pouvoir avoir les indices des joueurs à attaquer
							indiceJoueurAdverse[indiceCombat]=j;
							indiceCombat++;
							System.out.println(indiceCombat);
						}}
						
						//TROUVER LE PLUS FAIBLE EN ECTS
						//si indiceJoueurAdverse=1 enlever ECTS à lui
						if(indiceCombat==1) {
							tabZI.get(indiceZoneInflu).getTabEleveZone(indiceJoueurAdverse[0]).setECTS(tabZI.get(indiceZoneInflu).getTabEleveZone(indiceJoueurAdverse[0]).getECTS()-10);
							//verif si le reuf est plus à l'UTT
							tabZI.get(indiceZoneInflu).getTabEleveZone(indiceJoueurAdverse[0]).estilvire();
						}
						else if(indiceCombat>1){
							
							//trouver le plus faible en ECTS pour lui enlever des ECTS
							int indiceMinEcts=indiceJoueurAdverse[0];
							for(int indiceComb=1;indiceComb<indiceCombat;indiceComb++) {
								if(tabZI.get(indiceZoneInflu).getTabEleveZone(indiceJoueurAdverse[indiceMinEcts]).getECTS()>tabZI.get(indiceZoneInflu).getTabEleveZone(indiceJoueurAdverse[indiceComb]).getECTS()) {
									indiceMinEcts=indiceJoueurAdverse[indiceComb+1];
								}
							//lui enlever des ECTS
							//-----------------------------
							//faire fonction qui calcul combien perd l'ennemie en entrée élève qui attaque et élève qui prend dans sa gueuele!
							tabZI.get(indiceZoneInflu).getTabEleveZone(indiceMinEcts).setECTS(tabZI.get(indiceZoneInflu).getTabEleveZone(indiceMinEcts).getECTS()-10);
							//verif si le reuf est plus à l'UTT
							tabZI.get(indiceZoneInflu).getTabEleveZone(indiceMinEcts).estilvire();
														
						}							
						}
						indiceCombat=0;
						
						
					}
				
					
					
				//-------	
				//fonction qui test si y'a encore des adversaires sur la map (si c'est pas le cas on break !!)
				//argument d'entrée : la map en question, le joueur en question
				//argument retour : un booléean : vrai si y'a des adversaires (joueur qui n'est pas le joueur que l'on passe en argument), faux si non
				
				//le but c'est de l'utiliser et de changer un flag et de sortir du while de zone d'influence !!
				//ici il faut changer le controle de la Zoned'influence en TRUE!!
			}
				
				

				//On fait pas comme dans l'énoncé vu qu'ils sont déjà stocké par liste d'initiative (quand même plus dur car je sais pas comment sortir de tous si y'a un mort)
				//Nous on va faire simple : on va juste vérif à chaque attaque s'il reste des joueurs en vie (faut faire une boucle while au début pour faire un tour de toute les zones) puis checker ici si 
			}
		
		
		//---------------
		//Mouvement des troupes
		for(int i=0;i<2;i++) {
			for(ZoneInfluence ZI:tabZI) {
				System.out.println("Combien d'élève réserviste sur :"+ ZI.getNom().toString());
				nombreEleveZI=sc.nextInt();
				//au minimum un!!
				
				for(int eleve=0;eleve<nombreEleveZI;eleve++) {
					//vérif qu'il est réserviste
					//vérif qu'il ne soit pas déjà autre part (à l'arriver de cette zone on change un attribut et on le remodif a chaque changement)
					//if()
					System.out.println("Indice eleve :");
					if(i==0) {
					ZI.ajouterEleve(j1.getTabEleve(sc.nextInt()));//vu que ya j1 faire fonction avec en parametre le joueur!!
					}
					else if(i==1) {
					ZI.ajouterEleve(j2.getTabEleve(sc.nextInt()));
					}
					}
				
				
			}
			}
		
		//faire pareil avec le j2!
		//demander s'il veut faire des mouvements sur les réservistes
//		int reponse;
//		for(Eleve el:j1.getTabEleve()) {
//			if(el.isReserviste()){
//				System.out.println("Est ce que tu veux le mettre?");
//				reponse=sc.nextInt();
//				if(reponse==1) {
//					//fonction qui fait une liste de toute les zones non contrôlé! avec en argument un tableau de zone d'influence : retour un tableau avec les indices de ceux pas contrôlé!
//					
//						
//					}
//				}
//			}
		//fonction qui fait une liste de toute les zones  contrôlé! avec en argument un tableau de zone d'influence : retour un tableau avec les indices de ceux contrôlé!
		//on fait une fonction qui fait zone par zone controlé et on demande au joueur s'il veut déplacer ses joueurs et quelle strat
		
		
		
		
		}//main
}//class

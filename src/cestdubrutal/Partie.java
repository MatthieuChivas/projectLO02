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
		System.out.println("\n");
		for(int i=0; i< tabZI.size(); i++) {
			int x = (int)(Math.random()*4)+1;
			System.out.println(j1.getPseudo() + " vous avez "+ x + " eleve(s) sur :" + tabZI.get(i).getNom());
			for(int j=0; j<x; j++) {
				int eleve = (int)(Math.random()*20);
				boolean aucunMemeEleve = false;
				while(!aucunMemeEleve) {
					aucunMemeEleve = true;
					for(int k=0; k<=i ; k++) {
						if(tabZI.get(k).dejaEleve(j1.getTabEleve(eleve))) {
							eleve=eleve+1;
							if(eleve==20) {
								eleve=0;
							}
							aucunMemeEleve = false;
						}
					}
				}
				System.out.println("l'eleve numero : " + eleve);
				tabZI.get(i).setTabEleveZone(j1.getTabEleve(eleve));
			}
			tabZI.get(i).rangerListeMeilleurInitiative();//a la fin on range chaque zone
		}
		
		System.out.println("\n");
		for(int i=0; i< tabZI.size(); i++) {
			int x = (int)(Math.random()*4)+1;
			System.out.println(j2.getPseudo() + " vous avez "+ x + " eleve(s) sur :" + tabZI.get(i).getNom());
			for(int j=0; j<x; j++) {
				int eleve = (int)(Math.random()*20);
				boolean aucunMemeEleve = false;
				while(!aucunMemeEleve) {
					aucunMemeEleve = true;
					for(int k=0; k<=i ; k++) {
						if(tabZI.get(k).dejaEleve(j2.getTabEleve(eleve))) {
							eleve=eleve+1;
							if(eleve==20) {
								eleve=0;
							}
							aucunMemeEleve = false;
						}
					}
				}
				System.out.println("l'eleve numero : " + eleve);
				tabZI.get(i).setTabEleveZone(j2.getTabEleve(eleve));
			}
			tabZI.get(i).rangerListeMeilleurInitiative();//a la fin on range chaque zone
		}

		
		//----------
		//ETAPE 3 : Mélééé
		int indiceZone=0;
				while(!(tabZI.get(indiceZone).isControle(j1, j2))) {
					
					//ordonne la liste en fonction des meilleurs initiative 
					tabZI.get(indiceZoneInflu).rangerListeMeilleurInitiative();
					
					int indiceElev=0;
					
					//tant que la zone n'est pas controlé et on a pas fait le tour de tout les élèves on continue à faire jouer les élèves un part un 
					while(!(tabZI.get(indiceZone).isControle(j1, j2) || indiceElev<tabZI.get(indiceZone).getTabEleveZone().size())){
						
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
							for(int j=0;j<tabZI.get(indiceZoneInflu).getTabEleveZone().size();j++) {
								
								//.remove() dès qu'il est mort pas ce problème là car avec les tableaux ! 
//								//si l'élève est mort continue car il ne peut pas attaquer
//								if(tabZI.get(indiceZoneInflu).getTabEleveZone(j).isVire()) {
//									continue;
//								}
								
								if(j1.testEleve(tabZI.get(indiceZoneInflu).getTabEleveZone().get(j))){
									//faire une fonction qui trouve la liste des élèves appartenant à un joueur (l'inverse cool de source)
									ArrayList<Eleve> listEleveAdverse = tabZI.get(indiceZoneInflu).trouverEleveMemeJoueur(j2);
								}
								else{
									ArrayList<Eleve> listEleveAdverse = tabZI.get(indiceZoneInflu).trouverEleveMemeJoueur(j1);
								}
								
								//ranger la liste selon plus faible en ECTS:
								listEleveAdverse.trierCrshECTS();
								
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
						
									}}}
						
						indiceElev++;
					}
					
					
					//si jamais la zone n'est controlé on sort de la boucle
					if(!(tabZI.get(indiceZone).isControle(j1, j2))) {
						break;
					}
					
					//pour repasser sur toutes les zones
					indiceZone++;
					if(indiceZone==4) {
						indiceZone=0;
					}
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

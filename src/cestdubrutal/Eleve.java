package cestdubrutal;

public class Eleve implements Strategie {
	static public enum Strategie{Attaquer, Soigner, Aleatoire};
	
	public Strategie Strat;
	public Characteristique CharacteristiqueEleve;
	private int ECTS;
	private boolean vire;
	private boolean reserviste;
	
	
	public Eleve() {
		this.CharacteristiqueEleve = new Characteristique();
		this.setECTS(30);
		this.setVire(false);
		this.setReserviste(true);
		this.Strat=Strategie.Aleatoire;
	}
	
	public void changerStrat(Strategie Nouvellestrat) {
		this.Strat=Nouvellestrat;
	}
	
	public void chosirZoneInfluence() {
		
	}
	
	public void choisirStrategie() {
		
	}
	
	public void redeployer() {
		
	}

	public int getECTS() {
		return ECTS;
	}

	public void setECTS(int eCTS) {
		ECTS = eCTS;
	}

	public boolean isVire() {
		return vire;
	}

	public void setVire(boolean vire) {
		this.vire = vire;
	}

	public boolean isReserviste() {
		return reserviste;
	}

	public void setReserviste(boolean reserviste) {
		this.reserviste = reserviste;
	}

	public Strategie getStrat() {
		return Strat;
	}

	public void setStrat(Strategie strat) {
		this.Strat = strat;
	}

	public void estilvire() {
		if(this.ECTS<=0) {
			this.setVire(true);
		}	
	}
	
	public void combattre(Eleve e){
		//Strat.jouer(this, e);
	}

	public void jouer(Eleve eleve1, Eleve eleve2) {
		
	}
}

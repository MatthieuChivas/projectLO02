package cestdubrutal;

public class Characteristique {
	private int force;
	private int dexterite;
	private int resistance;
	private int constitution;
	private int initiative;
	
	public Characteristique() {
		this.setForce(0);
		this.setDexterite(0);
		this.setResistance(0);
		this.setConstitution(0);
		this.setInitiative(0);
}
	
	//But de cette fonction est de remplir le nombre de point au départ
	//Donc on laisse le choix de quelle characteristique modifier et à combien le modifier
	public void attribuerPoints(int force, int dexterite, int resistance, int constitution, int initiative) {
			this.setForce(force);
			this.setDexterite(dexterite);
			this.setResistance(resistance);
			this.setConstitution(constitution);
			this.setInitiative(initiative);
	}

	public int getForce() {
		return force;
	}
	
	public void setForce(int force) {
		if(this.force+force<=10) {
		this.force = force;
		}
	}

	public int getDexterite() {
		return dexterite;
	}

	public void setDexterite(int dexterite) {
		if(this.dexterite+dexterite<=10) {
		this.dexterite = dexterite;
		}
	}

	public int getResistance() {
		return resistance;
	}

	public void setResistance(int resistance) {
		if(this.resistance+resistance<=10) {
		this.resistance = resistance;
		}
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		if(this.constitution+constitution<=30) {
		this.constitution = constitution;
		}
	}

	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		if(this.initiative+initiative<=10) {
		this.initiative = initiative;
		}
	}
}

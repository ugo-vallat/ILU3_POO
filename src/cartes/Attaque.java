package cartes;

public class Attaque extends Bataille {

	public Attaque(Type t, int n) {
		super(t,n);
	}
	
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("attaque : ");
		switch(this.getType()) {
		case FEU:
			str.append("FeuRouge");
			break;
		case ESSENCE:
			str.append("PanneEssence");
			break;
		case CREVAISON:
			str.append("Crevaison");
			break;
		case ACCIDENT:
			str.append("Accident");
			break;
		default:
			str.replace(0, str.length(), "Error : undifined type");
		}
		return str.toString();
	}

}

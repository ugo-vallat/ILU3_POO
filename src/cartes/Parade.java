package cartes;

public class Parade extends Bataille {

	public Parade(Type t, int n) {
		super(t,n);
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("parade : ");
		switch(this.getType()) {
		case FEU:
			str.append("FeuVert");
			break;
		case ESSENCE:
			str.append("Essence");
			break;
		case CREVAISON:
			str.append("RoueDeSecours");
			break;
		case ACCIDENT:
			str.append("Réparation");
			break;
		default:
			str.replace(0, str.length(), "Error : undifined type");
		}
		return str.toString();
	}
}

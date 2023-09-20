package cartes;

public class Botte extends Probleme {

	public Botte(Type t, int n) {
		super(t,n);
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("botte : ");
		switch(this.getType()) {
		case FEU:
			str.append("Prioritaire");
			break;
		case ESSENCE:
			str.append("Citerne");
			break;
		case CREVAISON:
			str.append("Increvable");
			break;
		case ACCIDENT:
			str.append("AsDuVolant");
			break;
		default:
			str.replace(0, str.length(), "Error : undifined type");
		}
		return str.toString();
	}

}

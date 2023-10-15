package cartes;

public abstract class Probleme extends Carte {
	private Type type;

	protected Probleme(Type t, int n) {
		super(n);
		this.type = t;
	}
	
	public Type getType() {
		return type;
	}
	
	public enum Type {
		FEU, ESSENCE, CREVAISON, ACCIDENT;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && this.type == ((Probleme)obj).type;
	}

}

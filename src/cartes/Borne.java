package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int km, int n) {
		super(n);
		this.km = km;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && this.km == ((Borne) obj).km;
	}
	
	@Override
	public String toString() {
		return ("Borne : "+km);
	}

}

package cartes;

public abstract class Carte {
	private int nombre;

	protected Carte(int n) {
		this.nombre = n;
	}
	
	public int getNombre() {
		return nombre;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		return obj != null 
				&& obj.getClass() == this.getClass();
	}
	
	

}

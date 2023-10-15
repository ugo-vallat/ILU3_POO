package cartes;

import java.util.ArrayList;
import java.util.List;

import cartes.Probleme.Type;
import utils.Utils;

public class JeuDeCartes {
	private Carte[] typesDeCartes;
	private List<Carte> listeCartes;

	public JeuDeCartes() {
		creer_liste_types();
		creer_liste_cartes();
		listeCartes = Utils.melangerV1(listeCartes);
	}
	
	public List<Carte> getCartes() {
		List<Carte> l = new ArrayList<>();
		l.addAll(listeCartes);
		return l;
	}
	
	
	private void creer_liste_types() {
		typesDeCartes = new Carte[19];
		typesDeCartes[0] = new Botte(Type.FEU, 1);
		typesDeCartes[1] = new Botte(Type.ESSENCE, 1);
		typesDeCartes[2] = new Botte(Type.CREVAISON, 1);
		typesDeCartes[3] = new Botte(Type.ACCIDENT, 1);
		
		typesDeCartes[4] = new Attaque(Type.FEU, 5);
		typesDeCartes[5] = new Attaque(Type.ESSENCE, 3);
		typesDeCartes[6] = new Attaque(Type.CREVAISON, 3);
		typesDeCartes[7] = new Attaque(Type.ACCIDENT, 3);
		typesDeCartes[8] = new DebutLimite(4);
		
		typesDeCartes[9] = new Parade(Type.FEU, 14);
		typesDeCartes[10] = new Parade(Type.ESSENCE, 6);
		typesDeCartes[11] = new Parade(Type.CREVAISON, 6);
		typesDeCartes[12] = new Parade(Type.ACCIDENT, 6);
		typesDeCartes[13] = new FinLimite(6);
		
		typesDeCartes[14] = new Borne(25, 10);
		typesDeCartes[15] = new Borne(50, 10);
		typesDeCartes[16] = new Borne(75, 10);
		typesDeCartes[17] = new Borne(100, 12);
		typesDeCartes[18] = new Borne(200, 4);	
	}
	
	private void creer_liste_cartes() {
		listeCartes = new ArrayList<>();
		for (Carte c : typesDeCartes) {
			for (int i = 0; i < c.getNombre(); i++)
				listeCartes.add(c);
		}	
	}
	
	public boolean checkCount() {
		int nb;
		for(Carte c : listeCartes) {
			nb = 0;
			for(Carte e : listeCartes) {
				if (e.equals(c)) nb++;
			}
			if (nb != c.getNombre()) return false;
		}
		return true;
	}
		
	
	
	

}

package jeu;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import cartes.*;

public class Sabot implements Iterable<Carte>{
	private Carte []sabot;
	private int nbCartes;
	private int nbOperations = 0;
	
	public Sabot(int size) {
		if (size < 0 || size > 110)
			throw new IllegalArgumentException();
		this.sabot = new Carte[size];
	}
	
	public int getNnCartes() {
		return nbCartes;
	}
	
	private void ajouterCarte(Carte c) {
		if (nbCartes >= sabot.length)
			throw new IndexOutOfBoundsException();
		sabot[nbCartes++] = c;
		nbOperations++;
	}
	
	public void ajouterFamilleCarte(Carte carte, int nb) {
		for(int i= 0; i < nb; i++)
			ajouterCarte(carte);
	}
	
	public void ajouterFamilleCarte(Carte...carte) {
		for (Carte c : carte)
			ajouterCarte(c);
	}
	
	public Carte piocher() {
		Iterator<Carte> ite = iterator();
		Carte carte = null;
		if(ite.hasNext()) {
			carte = ite.next();
			ite.remove();
		}
		
		return carte;
	}
	
	
	
	
	@Override
	public Iterator<Carte> iterator() {
		return new SabotIterator();
	}
	
	
	
//############################## ITERATOR ##############################
	
	private class SabotIterator implements Iterator<Carte> {
		private int posIte = 0;
		private int nbOperationsRef;
		private boolean next = false;
		
		public SabotIterator() {
			this.nbOperationsRef = nbOperations;
		}
		
		@Override
		public boolean hasNext() {
			testOperations();
			return posIte < nbCartes;
		}
		
		@Override
		public Carte next() {
			testOperations();
			if (!hasNext()) throw new IllegalStateException();
			next = true;
			return sabot[posIte++];
		}
		
		@Override
		public void remove() {
			testOperations();
			if(!next) throw new IllegalStateException();
			for(int i = --posIte; i < nbCartes-1; i++)
				sabot[i] = sabot[i+1];
			next = false;
			nbCartes--;
			nbOperations++;
			nbOperationsRef++;
		}
		
		private void testOperations() {
			if (this.nbOperationsRef != nbOperations)
					throw new ConcurrentModificationException();
		}
		
		
	}
	
	

}

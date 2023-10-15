package testJeu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jeu.Sabot;
import cartes.*;
import java.util.ArrayList;
import java.util.Iterator;



class TestSabot {
	private Sabot sabot;
	private List<Carte> specialCards = new ArrayList<>();
	
	@BeforeEach
	void setUp() throws Exception {
		this.sabot = new Sabot(14);
		for(Probleme.Type t : Probleme.Type.values()) {
			specialCards.add(new Attaque(t, 3));
			specialCards.add(new Parade(t, 3));
			specialCards.add(new Botte(t, 3));
		}
		specialCards.add(new DebutLimite(3));
		specialCards.add(new FinLimite(3));
	}

	@Test
	void test_nb_cartes() {
		assertEquals(0, sabot.getNnCartes());
	}
	
	@Test
	void test_ajouter_famille_cartes_1() {
		sabot.ajouterFamilleCarte(specialCards.get(0), 1);
		assertEquals(1, sabot.getNnCartes());
		sabot.ajouterFamilleCarte(specialCards.get(3), 4);
		assertEquals(5, sabot.getNnCartes());
	}
	
	@Test
	void test_ajouter_famille_cartes_2() {
		sabot.ajouterFamilleCarte(specialCards.get(0), specialCards.get(1));
		assertEquals(2, sabot.getNnCartes());
	}
	
	@Test
	void test_piocher() {
		sabot.ajouterFamilleCarte(specialCards.get(0), specialCards.get(1));
		assertEquals(specialCards.get(0), sabot.piocher());
		assertEquals(1, sabot.getNnCartes());
		assertEquals(specialCards.get(1), sabot.piocher());
		assertEquals(0, sabot.getNnCartes());
		assertEquals(null, sabot.piocher());
	}
	
	@Test
	void test_max_sabot_exception() {
		for (Carte c : specialCards)
			sabot.ajouterFamilleCarte(c,1);
		try {
			sabot.ajouterFamilleCarte(specialCards.get(0));
			fail("Aucune exception levée");
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
	}
	
	@Test
	void test_add_remove_all() {
		for (Carte c : specialCards) 
			sabot.ajouterFamilleCarte(c,1);
		assertEquals(14, sabot.getNnCartes());
		for(int i = 0; i < 14; i++) {
			assertEquals(specialCards.get(i), sabot.piocher());
			assertEquals(13-i, sabot.getNnCartes());
		}
	}
	
	
	
	
	

}

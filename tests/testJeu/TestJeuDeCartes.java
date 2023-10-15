package testJeu;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cartes.Carte;
import cartes.JeuDeCartes;

class TestJeuDeCartes {
	private JeuDeCartes jdc;
	
	@BeforeEach
	void setUp() {
		jdc = new JeuDeCartes();
	}

	@Test
	void test_afficher_cartes() {
		for(Carte c : jdc.getCartes())
			System.out.println(c.toString());
	}
	
	@Test
	void test_exemplaires() {
		assertTrue(jdc.checkCount());
	}
	
	@Test
	void testOccurenceJeu() {
		assertTrue(jdc.checkCount());
	}
	

}

package testsFonctionnels;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jeu.Sabot;
import cartes.Carte;

class testSabot {
	private Sabot sabot;
	private Carte []allSpecialCards;
	
	@BeforeEach
	void setUp() throws Exception {
		this.sabot = new Sabot(14);
		
	}

	@Test
	void sabot_ajouter_1() {
		
	}
	

}

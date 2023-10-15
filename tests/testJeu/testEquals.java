package testJeu;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Probleme.Type;

class testEquals {

	@Test
	void test_borne() {
		Borne b1 = new Borne(10, 3);
		Borne b2 = new Borne(10, 3);
		Borne b3 = new Borne(20, 3);
		DebutLimite dl = new DebutLimite(2);
		assertTrue(b1.equals(b1));
		assertTrue(b1.equals(b2));
		assertFalse(b1.equals(b3));
		assertFalse(b1.equals(dl));
	}
	
	@Test
	void test_limite() {
		DebutLimite dl1 = new DebutLimite(2);
		DebutLimite dl2 = new DebutLimite(3);
		FinLimite fl1 = new FinLimite(2);
		FinLimite fl2 = new FinLimite(3);
		Parade p = new Parade(Type.ACCIDENT, 3);
		
		assertTrue(dl1.equals(dl1));
		assertTrue(dl1.equals(dl2));
		assertTrue(fl1.equals(fl2));
		assertFalse(dl1.equals(p));
		assertFalse(dl1.equals(fl1));
	}
	
	@Test
	void test_probleme() {
		Attaque att1 = new Attaque(Type.ACCIDENT, 3);
		Attaque att2 = new Attaque(Type.ACCIDENT, 3);
		Attaque att3 = new Attaque(Type.FEU, 3);
		Parade par1 = new Parade(Type.ACCIDENT, 3);
		Botte bot1 = new Botte(Type.ACCIDENT, 3);
		
		assertTrue(att1.equals(att1));
		assertTrue(att1.equals(att2));
		assertTrue(par1.equals(par1));
		assertTrue(bot1.equals(bot1));
		
		assertFalse(att1.equals(att3));
		assertFalse(att1.equals(par1));
		assertFalse(par1.equals(bot1));
		
	}

}

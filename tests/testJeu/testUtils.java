package testJeu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cartes.Carte;
import cartes.JeuDeCartes;


import utils.*;

class testUtils {
	JeuDeCartes jeu;
	
	@BeforeEach
	void init() {
		jeu =  new JeuDeCartes();
	}
	
	@Test
	void testMelangerV1() {
		//init list
		List<Carte> listeJeuRef = jeu.getCartes();
		List<Carte> listeJeu;
		
		//test 1
		listeJeu = new ArrayList<>();
		listeJeu.addAll(listeJeuRef);
		listeJeu = Utils.melangerV1(listeJeu);
		assertTrue(Utils.verifierMelange(listeJeu, listeJeuRef));
		
		//test 2
		listeJeu = new ArrayList<>();
		listeJeu.addAll(listeJeuRef);
		listeJeu = Utils.melangerV1(listeJeu);
		assertTrue(Utils.verifierMelange(listeJeu, listeJeuRef));
		
		//test 3
		listeJeu = new ArrayList<>();
		listeJeu.addAll(listeJeuRef);
		listeJeu = Utils.melangerV1(listeJeu);
		assertTrue(Utils.verifierMelange(listeJeu, listeJeuRef));
	}
	
	@Test
	void testMelangerV2() {
		//init list
		List<Carte> listeJeuRef = jeu.getCartes();
		List<Carte> listeJeu;
		
		//test 1
		listeJeu = new ArrayList<>();
		listeJeu.addAll(listeJeuRef);
		listeJeu = Utils.melangerV2(listeJeu);
		assertTrue(Utils.verifierMelange(listeJeu, listeJeuRef));
		
		//test 2
		listeJeu = new ArrayList<>();
		listeJeu.addAll(listeJeuRef);
		listeJeu = Utils.melangerV2(listeJeu);
		assertTrue(Utils.verifierMelange(listeJeu, listeJeuRef));
		
		//test 3
		listeJeu = new ArrayList<>();
		listeJeu.addAll(listeJeuRef);
		listeJeu = Utils.melangerV2(listeJeu);
		assertTrue(Utils.verifierMelange(listeJeu, listeJeuRef));
	}
	
	
	@Test
	void testRassembler() {
		List<Integer> lRef = new ArrayList<>();
		List<Integer> l;
		//test with empty list
		l = Utils.rassembler(lRef);
		assertTrue(Utils.verifierRassemblement(l));
		assertTrue(Utils.verifierMelange(l, lRef));
		System.out.println("[testRassembler] Ref : " + lRef.toString() + 
				"\n[testRassembler] output : " + l.toString());
		
		//test 1
		lRef = new ArrayList<>();
		Collections.addAll(lRef, 1,1,2,1,3);
		l = Utils.rassembler(lRef);
		assertTrue(Utils.verifierRassemblement(l));
		assertTrue(Utils.verifierMelange(l, lRef));
		System.out.println("[testRassembler] Ref : " + lRef.toString() + 
				"\n[testRassembler] output : " + l.toString());
		
		//test 2
		lRef = new ArrayList<>();
		Collections.addAll(lRef, 1,4,3,2);
		l = Utils.rassembler(lRef);
		assertTrue(Utils.verifierRassemblement(l));
		assertTrue(Utils.verifierMelange(l, lRef));
		System.out.println("[testRassembler] Ref : " + lRef.toString() + 
				"\n[testRassembler] output : " + l.toString());
		
		//test 3
		lRef = new ArrayList<>();
		Collections.addAll(lRef, 1,1,2,3,1);
		l = Utils.rassembler(lRef);
		assertTrue(Utils.verifierRassemblement(l));
		assertTrue(Utils.verifierMelange(l, lRef));
		System.out.println("[testRassembler] Ref : " + lRef.toString() + 
				"\n[testRassembler] output : " + l.toString());
		
	}
	

}

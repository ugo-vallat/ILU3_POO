package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;


public class Utils {
	private static Random rand = new Random();

	public static <T> T extraireV1(List<T> liste) {
		int i = rand.nextInt(liste.size());
		T carte = liste.get(i);
		liste.remove(i);
		return carte;
	}
	
	public static <T> T extraireV2(List<T> liste) {
		int ind = rand.nextInt(liste.size());
		ListIterator<T> ite = liste.listIterator();
		for(int i = 0; i < ind; i++)
			if(ite.hasNext()) ite.next();
		T carte = ite.next();
		ite.remove();
		return carte;
	}
	
	public static <T> List<T> melangerV1(List<T> liste) {
		List<T> listeMelangee = new ArrayList<>();
		while (!liste.isEmpty()) {
			listeMelangee.add(extraireV1(liste));
		}
		return listeMelangee;
	}
	
	public static <T> List<T> melangerV2(List<T> liste) {
		List<T> listeMelangee = new ArrayList<>();
		while (!liste.isEmpty()) {
			listeMelangee.add(extraireV2(liste));
		}
		return listeMelangee;
	}
	
	public static <T> boolean verifierMelange(List<T> l1, List<T> l2) {
		for(T e : l1) {
			if(Collections.frequency(l1, e) != Collections.frequency(l2, e)) return false;
		}
		for(T e : l2) {
			if(Collections.frequency(l1, e) != Collections.frequency(l2, e)) return false;
		}
		return true;
	}
	
	public static <T> List<T> rassembler(List<T> liste) {
		List<T> lr = new ArrayList<>();
		int pos;
		for(T e : liste) {
			if((pos = lr.indexOf(e)) != -1) {
				lr.add(pos, e);
			} else lr.add(e);
		}
		return lr;
	}
	
	public static <T> boolean verifierRassemblement(List<T> liste) {
		if(liste.isEmpty()) return true;
		T cur = liste.get(0);
		List<T> subListe;
		for(T e : liste) {
			if(!e.equals(cur)) {
				subListe = liste.subList(liste.indexOf(e), liste.size());
				for(T se : subListe) 
					if(se.equals(cur)) return false;
				cur = e;
			}
		}
		return true;
	}
	
	
	

}

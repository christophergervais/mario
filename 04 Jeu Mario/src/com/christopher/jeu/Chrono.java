package com.christopher.jeu;
//la classe Chrono appelle la méthode run() qui est une boucle infini qui repeint la scene a intervalle régulier d'environ 3 ms

public class Chrono implements Runnable { 
	
	// ************VARIABLES******//	
	private final int PAUSE =1; //tps de pause entre 2 boucle (3ms)

	
	// ************METHODES******//
	public void run() { //obligatoire car on implemente 
		while(true) { //boucle infini volontaire
			Main.scene.repaint(); //a chaque tour, on appelle la fonction paintcomponent() qui est ds la classe scene 

			try { //cet instruction peut mal s'exécuter ds le programme
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {}
		}
	}

}

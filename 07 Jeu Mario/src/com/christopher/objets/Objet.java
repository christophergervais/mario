package com.christopher.objets;

import com.christopher.jeu.Main;

public class Objet {
	// ************VARIABLES******//
	private int largeur;
	private int longueur;
	private int x;
	private int y;
	
	// ************Constructeur******//
	public Objet(int x, int y, int largeur, int longueur) {
	this.x = x;
	this.y = y;
	this.largeur = largeur;
	this.longueur = longueur;
	}

	
	// ************GETTER******//
	public int getLargeur() {
		return largeur;
	}

	public int getLongueur() {
		return longueur;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	
	// ************SETTER**********//
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	// ************METHODES**********//
	public void deplacement() {
		if(Main.scene.getxPos()>=0) {
			this.x = this.x - Main.scene.getDx();
		}
	}
	
}

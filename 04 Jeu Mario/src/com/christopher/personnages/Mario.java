package com.christopher.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Mario extends Personnage { //mario herite de personnage il doitt maintenant être construit 
	
	
	/*RAPPEL DU CONSTRUCTEUR  PERSONNAGE --> public Personnage(int x, int y, int largeur, int hauteur) { 
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.marche = true;
		this.versDroite = true;
		this.compteur = 0;
	}*/
	// ************VARIABLES******//
	private Image imgMario;
	private ImageIcon icoMario;
	
	// ************CONSTRUCTEUR******//
	public Mario(int x, int y) {
		
		super (x, y, 28, 50);
		this.icoMario = new ImageIcon("src/images/marioMarcheDroite.png");
		this.imgMario = icoMario.getImage();
	}
	
	// ************GUETTERS******//
	public Image getImgMario() {
		return imgMario;
	}
	
	
}

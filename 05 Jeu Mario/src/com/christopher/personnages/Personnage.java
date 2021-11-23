package com.christopher.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.christopher.jeu.Main;

public class Personnage {
	
	// ************VARIABLES******//
	private int largeur, hauteur; //dimension du personnage
	private int x, y; //position à l'ecran
	private boolean marche;
	private boolean versDroite; //sera vrai quand le perso est tourné vers la droite
	private int compteur; //compter les pas du perso
	
	// ************CONSTRUCTEUR******//
	public Personnage(int x, int y, int largeur, int hauteur) { //lorsqu'on créé un perso on donne sa position et dimension
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.marche = true; //valeur par défaut
		this.versDroite = true; //valeur par défaut
		this.compteur = 0; //valeur par défaut
	}
	//ensuite on insere les guetteur et setters qui permette d'accéder aux différentes variables
	
	
	// ************GUETTERS******//
	public int getLargeur() {  //acces dimensions
		return largeur;
	}

	public int getHauteur() { //acces dimensions
		return hauteur;
	}

	public int getX() { //acces positino
		return x;
	}

	public int getY() { //acces position...
		return y;
	}

	public boolean isMarche() {
		return marche;
	}

	public boolean isVersDroite() {
		return versDroite;
	}

	public int getCompteur() {
		return compteur;
	}

	
	// ************SETTERS******//
	public void setLargeur(int largeur) { //modifier dimensions (mais pas besoin)
		this.largeur = largeur;
	}

	public void setHauteur(int hauteur) { //modifier dimensions (mais pas besoin)
		this.hauteur = hauteur;
	}

	public void setX(int x) { //modifier position 
		this.x = x;
	}

	public void setY(int y) { //modifier position 
		this.y = y;
	}

	public void setMarche(boolean marche) {
		this.marche = marche;
	}

	public void setVersDroite(boolean versDroite) {
		this.versDroite = versDroite;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}
	
	
	
	// ************METHODES******//
	
	public Image marche(String nom, int frequence) {
		String str;
		ImageIcon ico;
		Image img;
		
		if (this.marche==false || Main.scene.getxPos()<=0) { //si le perso est arrete ou si on est completement à gauche
			if(this.versDroite == true) {str = "/images/"+ nom +"ArretDroite.png";}
			else {str = "/images/"+ nom +"ArretGauche.png";}
		}else {
			this.compteur++;
			if(this.compteur / frequence ==0) {
				if(this.versDroite == true) {str = "/images/"+nom+"ArretDroite.png";}
				else {str = "/images/"+nom+"ArretGauche.png";}
			}else {
				if(this.versDroite == true) {str = "/images/"+nom+"MarcheDroite.png";}
				else {str = "/images/"+nom+"MarcheGauche.png";}
			}
			if(this.compteur == 2*frequence) {this.compteur =0;}//division de compteur par la frequence est égale à 2 on remet le compteur a 0		
		}
		//affichage de l'image du personnage
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}

}

package com.christopher.personnages;

import java.awt.Image;


import javax.swing.ImageIcon;

import com.christopher.jeu.Main;

public class Mario extends Personnage { //mario herite de personnage il doit maintenant être construit 
	
	
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
	private boolean saut; //true si mario saute
	private int compteurSaut; //durée et hauteur du saut
	
	// ************CONSTRUCTEUR******//
	public Mario(int x, int y) {
		
		super (x, y, 28, 50);
		this.icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
		this.imgMario = icoMario.getImage();
		this.saut = false;
		this.compteurSaut = 0;
	}
	
	// ************GETTERS******//
	public Image getImgMario() {
		return imgMario;
	}

	public boolean isSaut() {
		return saut;
	}

	
	// ************SETTER******//
	public void setSaut(boolean saut) {
		this.saut = saut;
	}
	
	//**** METHODES ****//	
    public Image saute(){
		
	    ImageIcon ico;
	    Image img;
	    String str;
	
		this.compteurSaut++;
		// Montée du saut		
		if(this.compteurSaut <= 35){
			if(this.getY() > Main.scene.getHauteurPlafond()){
				this.setY(this.getY() - 4);//tanque que la tete de mario est plus grand que la hauteur du plafond ca veut dire qu'il touche pas le plafond
				}else{
					this.compteurSaut = 36;
					}			
			if(this.isVersDroite() == true){
				str = "/images/marioSautDroite.png";
				}else{
					str = "/images/marioSautGauche.png";
					}	
			
		// Retombée du saut
		}else if(this.getY() + this.getHauteur() < Main.scene.getySol()){
			this.setY(this.getY() + 1);
			if(this.isVersDroite() == true){
				str = "/images/marioSautDroite.png";
				}else{
					str = "/images/marioSautGauche.png";
					}
			
		// Saut terminé	
		}else{				
			if(this.isVersDroite() == true){
				str = "/images/marioArretDroite.png";
				}else{
					str = "/images/marioArretGauche.png";
					}	
			this.saut = false;
			this.compteurSaut = 0;
		}
		// Affichage de l'image de mario
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
	
	
}

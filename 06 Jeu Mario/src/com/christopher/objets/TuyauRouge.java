package com.christopher.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

public class TuyauRouge extends Objet {

	// ************VARIABLE**********//
	private Image imgTuyauRouge;
	private ImageIcon icoTuyauRouge;
	
	// ************CONSTRUCTEUR**********//
	public TuyauRouge(int x, int y) {
		super(x, y, 43, 65); //les largeurs et hauteurs  sont toujours les mêmes, 
		this.icoTuyauRouge = new ImageIcon(getClass().getResource("/images/tuyauRouge.png"));
		this.imgTuyauRouge = this.icoTuyauRouge.getImage();
	}


	
	// ************GETTER**********//
	public Image getImgTuyauRouge() {
		return imgTuyauRouge;
	}	
	
	
	// ************SETTER**********//
	
	
	
	// ************SETTER**********//
	
}
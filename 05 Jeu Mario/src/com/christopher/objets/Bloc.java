package com.christopher.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Bloc extends Objet {

	// ************VARIABLE**********//
		private Image imgBloc;
		private ImageIcon icoBloc;
		
		// ************CONSTRUCTEUR**********//
		public Bloc(int x, int y) {
			super(x, y, 43, 65); //les largeurs et hauteurs  sont toujours les mêmes, 
			this.icoBloc = new ImageIcon(getClass().getResource("/images/bloc.png"));
			this.imgBloc = this.icoBloc.getImage();
		}


		
		// ************GETTER**********//
		public Image getImgBloc() {
			return imgBloc;
		}	
		
		
		// ************SETTER**********//
		
		
		
		// ************SETTER**********//
}
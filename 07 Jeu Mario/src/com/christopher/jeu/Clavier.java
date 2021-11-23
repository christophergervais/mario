package com.christopher.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener {

	//**** METHODES **//
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){ // flèche droite
		   
        	if(Main.scene.getxPos() == -1){ 
        		Main.scene.setxPos(0);     // Réinitialisation de setxPos
        		Main.scene.setxFond1(-50); // Réinitialisation de xFond1
        		Main.scene.setxFond2(750); // Réinitialisation de xFond2
        	}
        	Main.scene.mario.setMarche(true);
        	Main.scene.mario.setVersDroite(true);
			Main.scene.setDx(1);  // Déplacement du fond vers la gauche lors de l'appui sur la touche "flèche droite"
			
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){ // flèche gauche
			Main.scene.mario.setMarche(true);
        	Main.scene.mario.setVersDroite(false);
			Main.scene.setDx(-1); // Déplacement du fond vers la droite lors de l'appui sur la touche "flèche gauche"
			}
		// mario saute
        if(e.getKeyCode() == KeyEvent.VK_SPACE){      	
        	Main.scene.mario.setSaut(true);       		
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Main.scene.mario.setMarche(false);
		Main.scene.setDx(0);// Remise à 0 de la variable dx de la l'objet scene 
		}                   // lors du relâchement des touches
	                                                           
	@Override
	public void keyTyped(KeyEvent e) {}

//	@Override
//	public void keyPressed(KeyEvent e) { // quan on appuie sur la touche
//		if(e.getKeyCode()== (KeyEvent.VK_RIGHT)) {
//			if(Main.scene.getxPos()==-1) {
//				Main.scene.setxPos(0);
//				Main.scene.setxFond1(-50);
//				Main.scene.setxFond2(750);			
//			}
//			Main.scene.mario.setMarche(true);
//			Main.scene.mario.setVersDroite(true);	
//			Main.scene.setDx(1); //oblige d'avoir un getteur opur acceder au dx (il était prive ds scene)
//		}else if (e.getKeyCode()== (KeyEvent.VK_LEFT)) {
//			System.out.println("Detectée gauche");
//			Main.scene.mario.setMarche(true);
//			Main.scene.mario.setVersDroite(false);	
//			Main.scene.setDx(-1);
//			
//			//mario saute
//			if(e.getKeyCode()==(KeyEvent.VK_LEFT)) {
//				System.out.println("Detectée saut");
//				Main.scene.mario.setSaut(true);
//			}
//		}
//		
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) { //quand on relache la touche
//		Main.scene.mario.setMarche(false);
//		Main.scene.setDx(0); // on veut que l'écran s'arrete donc la translation revient à 0
//		
//		
//	}
//	@Override
//	public void keyTyped(KeyEvent e) { // on ne s'en sert pas
//		// TODO Auto-generated method stub
//		
//	}

}

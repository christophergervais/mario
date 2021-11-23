package com.christopher.jeu;

import javax.swing.JFrame; //clase importée pour faire la fenetre

public class Main {
	
	public static Scene scene; //une variable de type Scene (la classe a été créé juste avant) static car elle doit etre accessible de toute les classes sans avoir a instancier scene ds la classe correspondante

	public static void main(String[] args) {
		// creation de la classe  fenetre, importer la classe (javax.swing.JFrame)
		JFrame fenetre = new JFrame("Jeu Mario");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //quand on clique sur la croix on ferme programme
		fenetre.setSize(700, 360);				//taille
		fenetre.setLocationRelativeTo(null);	//centre à l'écran
		fenetre.setResizable(true);
		fenetre.setAlwaysOnTop(true);
		
		//creatin du conteneur
		scene = new Scene();//instanciaiotion de l'objet scene
		fenetre.setContentPane(scene);
		fenetre.setVisible(true);

		
		

	}

}

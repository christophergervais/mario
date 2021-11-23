//classe la plus importante car elle contient le moteur de l'appli et la partie graphique
package com.christopher.jeu;

import java.awt.Graphics;
import java.awt.Image;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.christopher.objets.Bloc;
import com.christopher.objets.TuyauRouge;
import com.christopher.personnages.Mario;

public class Scene extends JPanel {
	// variable images, declaration des éléments

	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;

	//private ImageIcon icoMario;// une variable qui contient //code provisoire car remplacé par notre objet mario créé partie 04
	//private Image imgMario; // et un variable qui est l'image //code provisoire car remplacé par notre objet mario créé partie 04
	
	private ImageIcon icoDepart;
	private Image imgDepart; // une variable qui contient et un variable qui est l'image //code provisoire
	
	private ImageIcon icoChateau1 = new ImageIcon(getClass().getResource("/images/chateau1.png"));
	private Image imgChateau1; // une variable qui contient et un variable qui est l'image //code provisoire
	
	//position des éléments graphique
	private int xFond1; // abscisse coin supérieur gauche de l'image de fond //code provisoire
	private int xFond2; // 
	
	private int dx; // permet de déplacer ecran sur les abscises
	private int xPos; // permet de repérer les position X des éléments du jeu entre -1 et 10.000
	
	//la classe Mario a été créé (04 jeu mario), nous pouvons l'intancier.
	public Mario mario; //import package personnage qui contient Mario
	

	//les classes Objet puis TuyauRouge et Bloc ont été créés (05 jeu mario), nous pouvons les intanciers.
	public TuyauRouge tuyauRouge1;
	public Bloc bloc1;
	
	
	
	
	
	

	// ************CONSTRUCTEUR******//
	public Scene() {
		super(); // appel au contructeur de la superclass qui herite de JPanel
		
		//initialisation de la position 
		this.xFond1 = -50;
		this.xFond2 = 750; //place a la suite de xfond1 
		this.dx = 0;
		this.xPos = -1; //normalement à zéron mais on peut modifier plus facilement 
		
		//création des objets images
		icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png")); // on récupère l'image de fond
		this.imgFond1 = icoFond.getImage(); // on récupère l'image mise ds la variable icoFond1
		this.imgFond2 = icoFond.getImage(); // on récupère l'image mise ds la variable icoFond2


		
		//on lui ajoute le chateau
		this.imgChateau1 =  icoChateau1.getImage();
		
		//on lui ajoute le panneau de départ 
		icoDepart = new ImageIcon(getClass().getResource("/images/depart.png"));
		imgDepart = icoDepart.getImage(); 
		
		//on lui ajoute mario (04jeu)
		mario = new Mario(300,245);
		
		//ajout des blocs et tuyau
		tuyauRouge1 = new TuyauRouge(600, 230);
		bloc1 = new Bloc(400, 180);
		
		//ajout de l'ecoute au clavier
		this.setFocusable(true); //déclare un focus permanent
		this.requestFocusInWindow(); //recuperer le focus
		this.addKeyListener(new Clavier()); //on a relié la classe Clavier à la classe Scene (ecouteur de clavier ajouté)
		


		//ajout du chrono 
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
		
		
	}

	// ************GETTERS******//
	public int getDx() {
		return dx;
	}
	
	public int getxPos() {
		return xPos;
	}
	
	public int getxFond1() {
		return xFond1;
	}	
	
	public int getxFond2() {
		return xFond2;
	}
	// ************SETERS******//
	public void setxFond1(int xFond1) {
		this.xFond1 = xFond1;
	}

	public void setxFond2(int xFond2) {
		this.xFond2 = xFond2;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	
	// ************METHODES******//
	public void deplacementFond() { // on y gère le déplacement du fond
		
		if(this.xPos>=0) { // le chateau est le point de départ on bloque le fait d'aller vers l gauche si xPos <0, on autorise si xPos>=0
			this.xPos = this.xPos+this.dx;
			this.xFond1 = this.xFond1 - this.dx; // methode pour faire translater le fond vers la gauche(c'est le fond qui bouge, pas le perso sinon il sortirait de l'écran). On l'utulisera												// dans notre boucle
			this.xFond2 = this.xFond2 - this.dx;
		}
		if(this.xFond1 == -800) { //si toute l'image est à gauche alors
			this.xFond1 =800; // ça signifie que c'est xfond2 qui est à l'écran, donc on doit ajouter xfond 1juste après le xFond2, nous avons notre décors infini !
		}else if (this.xFond2 == -800) {
			this.xFond2 = 800; 
		}else if (this.xFond1 == 800) {
			this.xFond1 = -800; 
		}else if (this.xFond2 == 800) {
			this.xFond2 = -800; 
		} 
		
	}





	public void paintComponent(Graphics g) { //on 'peint' les images qu'on a mis ds ds variables img[nom]
		super.paintComponent(g);
		Graphics g2 = (Graphics2D) g;
 
		this.deplacementFond(); // à chaque fois qu'on peint l'écran, on fait appel a cette methode

		g2.drawImage(this.imgFond1, this.xFond1, 0, null); // dessin img de fond
		g2.drawImage(this.imgFond2, this.xFond2, 0, null); // dessin img de fond
		//g2.drawImage(this.mario.getImgMario(), 300, 245, null); // code provisoire
		g2.drawImage(this.mario.marche("mario",25), 300, 245, null); // code provisoire
		g2.drawImage(imgChateau1, 10 - this.xPos, 95, null); // on ajoute le chateau1, on a rajouté ensuite le (- this.xPos) pour bloquer le chateau
		g2.drawImage(imgDepart, 220 - this.xPos, 234, null); //on ajoute le panneau depart, on a rajouté ensuite le (- this.xPos) pour bloquer le panneau depart
		g2.drawImage(this.tuyauRouge1.getImgTuyauRouge(),this.tuyauRouge1.getX()- this.xPos,this.tuyauRouge1.getY(),null);
		g2.drawImage(this.bloc1.getImgBloc(),this.bloc1.getX()- this.xPos,this.bloc1.getY(),null);
	}

}

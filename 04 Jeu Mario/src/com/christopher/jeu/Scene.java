//classe la plus importante car elle contient le moteur de l'appli et la partie graphique
package com.christopher.jeu;

import java.awt.Graphics;
import java.awt.Image;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.christopher.personnages.Mario;

public class Scene extends JPanel {
	// variable images, declaration des �l�ments

	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;

	//private ImageIcon icoMario;// une variable qui contient //code provisoire car remplac� par notre objet mario cr�� partie 04
	//private Image imgMario; // et un variable qui est l'image //code provisoire car remplac� par notre objet mario cr�� partie 04
	
	private ImageIcon icoDepart;
	private Image imgDepart; // une variable qui contient et un variable qui est l'image //code provisoire
	
	private ImageIcon icoChateau1 = new ImageIcon(getClass().getResource("/images/chateau1.png"));
	private Image imgChateau1; // une variable qui contient et un variable qui est l'image //code provisoire
	
	//position des �l�ments graphique
	private int xFond1; // abscisse coin sup�rieur gauche de l'image de fond //code provisoire
	private int xFond2; // 
	
	private int dx; // permet de d�placer ecran sur les abscises
	private int xPos; // permet de rep�rer les position X des �l�ments du jeu entre -1 et 10.000
	
	//la classe Mario a �t� cr�� (04 jeu mario), nous pouvons l'intancier.
	public Mario mario; //import package personnage qui contient Mario
	
	
	
	
	
	

	// ************CONSTRUCTEUR******//
	public Scene() {
		super(); // appel au contructeur de la superclass qui herite de JPanel
		
		//initialisation de la position 
		this.xFond1 = -50;
		this.xFond2 = 750; //place a la suite de xfond1 
		this.dx = 0;
		this.xPos = -1; //normalement � z�ron mais on peut modifier plus facilement 
		
		//cr�ation des objets images
		icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png")); // on r�cup�re l'image de fond
		this.imgFond1 = icoFond.getImage(); // on r�cup�re l'image mise ds la variable icoFond1
		this.imgFond2 = icoFond.getImage(); // on r�cup�re l'image mise ds la variable icoFond2


		
		//on lui ajoute le chateau
		this.imgChateau1 =  icoChateau1.getImage();
		
		//on lui ajoute le panneau de d�part 
		icoDepart = new ImageIcon(getClass().getResource("/images/depart.png"));
		imgDepart = icoDepart.getImage(); 
		
		//on lui ajoute mario (04jeu)
		mario = new Mario(300,245);

		//ajout de l'ecoute au clavier
		this.setFocusable(true); //d�clare un focus permanent
		this.requestFocusInWindow(); //recuperer le focus
		this.addKeyListener(new Clavier()); //on a reli� la classe Clavier � la classe Scene (ecouteur de clavier ajout�)
		
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
	public void deplacementFond() { // on y g�re le d�placement du fond
		
		if(this.xPos>=0) { // le chateau est le point de d�part on bloque le fait d'aller vers l gauche si xPos <0, on autorise si xPos>=0
			this.xPos = this.xPos+this.dx;
			this.xFond1 = this.xFond1 - this.dx; // methode pour faire translater le fond vers la gauche(c'est le fond qui bouge, pas le perso sinon il sortirait de l'�cran). On l'utulisera												// dans notre boucle
			this.xFond2 = this.xFond2 - this.dx;
		}
		if(this.xFond1 == -800) { //si toute l'image est � gauche alors
			this.xFond1 =800; // �a signifie que c'est xfond2 qui est � l'�cran, donc on doit ajouter xfond 1juste apr�s le xFond2, nous avons notre d�cors infini !
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
 
		this.deplacementFond(); // � chaque fois qu'on peint l'�cran, on fait appel a cette methode

		g2.drawImage(this.imgFond1, this.xFond1, 0, null); // dessin img de fond
		g2.drawImage(this.imgFond2, this.xFond2, 0, null); // dessin img de fond
		//g2.drawImage(this.mario.getImgMario(), 300, 245, null); // code provisoire
		g2.drawImage(this.mario.marche("mario",25), 300, 245, null); // code provisoire
		g2.drawImage(imgChateau1, 10 - this.xPos, 95, null); // on ajoute le chateau1, on a rajout� ensuite le (- this.xPos) pour bloquer le chateau
		g2.drawImage(imgDepart, 220 - this.xPos, 234, null); //on ajoute le panneau depart, on a rajout� ensuite le (- this.xPos) pour bloquer le panneau depart
	}

}

package com.beffa.pauwels.risk;

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.Toolkit;
import javax.swing.*;

/**
 * Cette classe gère l'affichage et les interactions utilisateurs-jeu On utilise
 * JavaSwing pour nos composants graphiques
 * 
 * @author vince
 *
 */

public class Menu extends JFrame implements MouseListener {

	// Initialisation des paramètres
	private JPanel menu;
	private JPanel jeu;

	private JLabel background;
	private JLabel map;

	private boolean verifNom;
	private boolean verifNbJoueurMin;

	private JLabel findutour;

	int nbJoueurs;

	private JLabel jouer;
	private JLabel close;

	private JLabel deuxJ;
	private JLabel troisJ;
	private JLabel quatreJ;
	private JLabel cinqJ;
	private JLabel sixJ;

	private JLabel action;
	private JLabel mouvement;

	private JLabel mute;
	private boolean isMute = false;

	private JLabel BtnplusSoldatRenfort;
	private JLabel BtnplusCavalierRenfort;
	private JLabel BtnplusCanonRenfort;

	private JLabel BtnmoinsSoldatRenfort;
	private JLabel BtnmoinsCavalierRenfort;
	private JLabel BtnmoinsCanonRenfort;

	private JLabel BtnplusSoldatTerritoire;
	private JLabel BtnplusCavalierTerritoire;
	private JLabel BtnplusCanonTerritoire;

	private JLabel BtnmoinsSoldatTerritoire;
	private JLabel BtnmoinsCavalierTerritoire;
	private JLabel BtnmoinsCanonTerritoire;

	private JLabel BtnplusSoldatAction;
	private JLabel BtnplusCavalierAction;
	private JLabel BtnplusCanonAction;

	private JLabel BtnmoinsSoldatAction;
	private JLabel BtnmoinsCavalierAction;
	private JLabel BtnmoinsCanonAction;

	private JTextField SoldatRenfort;
	private JTextField CavalierRenfort;
	private JTextField CanonRenfort;

	private JTextField SoldatTerritoire;
	private JTextField CavalierTerritoire;
	private JTextField CanonTerritoire;

	private JTextField SoldatAction;
	private JTextField CavalierAction;
	private JTextField CanonAction;

	/////

	private JTextField joueur1TextField;
	private JTextField joueur2TextField;
	private JTextField joueur3TextField;
	private JTextField joueur4TextField;
	private JTextField joueur5TextField;
	private JTextField joueur6TextField;

	private JLabel contour;
	private JLabel cadre;

	private JTextArea nom1;
	private JTextArea nom2;
	private JTextArea nom3;
	private JTextArea nom4;
	private JTextArea nom5;
	private JTextArea nom6;

	private JTextArea warning;

	private JLabel commencer;

	private JLabel refresh;

	private JLabel off;

	private JLabel jeton1;
	private JLabel jeton2;
	private JLabel jeton3;
	private JLabel jeton4;
	private JLabel jeton5;
	private JLabel jeton6;

	private JLabel[] hitboxes;

	// private boolean peutTransferer = false;
	private int ceTerritoire = 99;
	private JTextArea informations;
	private JTextArea indications;

	public Risk risk;
	public Audio son;
	public Combat combat;

	/**
	 * Contructeur dans lequel on instancie les classes Risk, Combat et audio
	 * Réglage de la JFrame
	 */
	public Menu() {

		son = new Audio();
		son.start();

		risk = new Risk();
		combat = new Combat();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(d);
		int l = d.width;
		int h = d.height;

		this.setTitle("RISK");
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);

		this.setLayout(null);
		this.setContentPane(menu());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	/**
	 * JPanel du menu, inclu les boutons jouer , quitter, et toute l'interface pour
	 * sélectionner le nombre de joueurs
	 * 
	 * @return
	 */
	private JPanel menu() {
		menu = new JPanel();
		menu.setLayout(null);

		// BACKGROUND
		background = new JLabel();
		background.setIcon(new ImageIcon("Images/FondMenu.jpg"));
		background.setBounds(0, 0, 1920, 1080);

		// BOUTON JOUER
		jouer = new JLabel();
		jouer.setIcon(new ImageIcon("Images/Jouer.png"));
		jouer.setBounds(780, 350, 350, 224);
		jouer.addMouseListener(this);
		background.add(jouer);

		// BOUTON QUITTER
		close = new JLabel();
		close.setBounds(780, 650, 350, 224);
		close.setIcon(new ImageIcon("Images/Quitter.png"));
		close.addMouseListener(this);
		background.add(close);

		// NOMBRE DE JOUEURS
		deuxJ = new JLabel("Deux Joueurs");
		deuxJ.setIcon(new ImageIcon("Images/Deuxbtn.png"));
		deuxJ.setBounds(230, 320, 260, 166);

		troisJ = new JLabel("Trois Joueurs");
		troisJ.setIcon(new ImageIcon("Images/Troisbtn.png"));
		troisJ.setBounds(530, 320, 260, 166);

		quatreJ = new JLabel("Quatre Joueurs");
		quatreJ.setIcon(new ImageIcon("Images/Quatrebtn.png"));
		quatreJ.setBounds(830, 320, 260, 166);

		cinqJ = new JLabel("Cinq Joueurs");
		cinqJ.setIcon(new ImageIcon("Images/Cinqbtn.png"));
		cinqJ.setBounds(1130, 320, 260, 166);

		sixJ = new JLabel("Six Joueurs");
		sixJ.setIcon(new ImageIcon("Images/Sixbtn.png"));
		sixJ.setBounds(1430, 320, 260, 166);

		deuxJ.setVisible(false);
		troisJ.setVisible(false);
		quatreJ.setVisible(false);
		cinqJ.setVisible(false);
		sixJ.setVisible(false);

		background.add(deuxJ);
		background.add(troisJ);
		background.add(quatreJ);
		background.add(cinqJ);
		background.add(sixJ);

		deuxJ.addMouseListener(this);
		troisJ.addMouseListener(this);
		quatreJ.addMouseListener(this);
		cinqJ.addMouseListener(this);
		sixJ.addMouseListener(this);

		// NOMS DES JOUEURS
		joueur1TextField = new JTextField("Joueur 1");
		joueur2TextField = new JTextField("Joueur 2");
		joueur3TextField = new JTextField("Joueur 3");
		joueur4TextField = new JTextField("Joueur 4");
		joueur5TextField = new JTextField("Joueur 5");
		joueur6TextField = new JTextField("Joueur 6");
		joueur1TextField.setBounds(740, 600, 190, 75);
		joueur2TextField.setBounds(740, 700, 190, 75);
		joueur3TextField.setBounds(740, 800, 190, 75);
		joueur4TextField.setBounds(990, 600, 190, 75);
		joueur5TextField.setBounds(990, 700, 190, 75);
		joueur6TextField.setBounds(990, 800, 190, 75);
		joueur1TextField.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		joueur2TextField.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		joueur3TextField.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		joueur4TextField.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		joueur5TextField.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		joueur6TextField.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		joueur1TextField.setVisible(false);
		joueur2TextField.setVisible(false);
		joueur3TextField.setVisible(false);
		joueur4TextField.setVisible(false);
		joueur5TextField.setVisible(false);
		joueur6TextField.setVisible(false);
		background.add(joueur1TextField);
		background.add(joueur2TextField);
		background.add(joueur3TextField);
		background.add(joueur4TextField);
		background.add(joueur5TextField);
		background.add(joueur6TextField);
		joueur1TextField.setBackground(Color.LIGHT_GRAY);
		joueur2TextField.setBackground(Color.LIGHT_GRAY);
		joueur3TextField.setBackground(Color.LIGHT_GRAY);
		joueur4TextField.setBackground(Color.LIGHT_GRAY);
		joueur5TextField.setBackground(Color.LIGHT_GRAY);
		joueur6TextField.setBackground(Color.LIGHT_GRAY);

		// COMMENCER
		commencer = new JLabel("");
		commencer.setIcon(new ImageIcon("Images/Commencer.png"));
		commencer.setBounds(850, 900, 220, 147);
		commencer.setVisible(false);
		commencer.addMouseListener(this);
		background.add(commencer);

		// verifNom
		warning = new JTextArea();
		warning.setEditable(false);
		warning.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		warning.setOpaque(false);
		warning.setBounds(790, 540, 400, 50);
		warning.setVisible(false);
		background.add(warning);

		menu.add(background);
		return menu;
	}

	/**
	 * JPanel du jeu, avec la carte du jeu, le tableau d'unités et tout l'affichage
	 * présent en jeu
	 * 
	 * @return
	 */
	private JPanel jeu() {
		jeu = new JPanel();
		jeu.setLayout(null);

		background = new JLabel();
		background.setBounds(0, 0, 1920, 1080);
		background.setIcon(new ImageIcon("Images/fondneutre.jpg"));
		jeu.add(background);

		mute = new JLabel();
		// mute.setBounds(1870, 5, 50, 50);
		// mute.setIcon(new ImageIcon("Images/mute.png"));
		mute.addMouseListener(this);
		background.add(mute);

		cadre = new JLabel();
		cadre.setBounds(590, 925, 694, 146);
		cadre.setIcon(new ImageIcon("Images/cadre.png"));
		background.add(cadre);

		// -------------------------- BOUTTONS PLUS ET
		// MOINS-----------------------
		// RENFORT
		BtnplusSoldatRenfort = new JLabel();
		BtnplusSoldatRenfort.setBounds(250, 23, 35, 35);
		BtnplusSoldatRenfort.setIcon(new ImageIcon("Images/Btnplus.png"));
		BtnplusSoldatRenfort.addMouseListener(this);
		cadre.add(BtnplusSoldatRenfort);

		BtnmoinsSoldatRenfort = new JLabel();
		BtnmoinsSoldatRenfort.setBounds(180, 23, 35, 35);
		BtnmoinsSoldatRenfort.setIcon(new ImageIcon("Images/Btnmoins.png"));
		BtnmoinsSoldatRenfort.addMouseListener(this);
		cadre.add(BtnmoinsSoldatRenfort);

		BtnplusCavalierRenfort = new JLabel();
		BtnplusCavalierRenfort.setBounds(250, 63, 35, 35);
		BtnplusCavalierRenfort.setIcon(new ImageIcon("Images/Btnplus.png"));
		BtnplusCavalierRenfort.addMouseListener(this);
		cadre.add(BtnplusCavalierRenfort);

		BtnmoinsCavalierRenfort = new JLabel();
		BtnmoinsCavalierRenfort.setBounds(180, 63, 35, 35);
		BtnmoinsCavalierRenfort.setIcon(new ImageIcon("Images/Btnmoins.png"));
		BtnmoinsCavalierRenfort.addMouseListener(this);
		cadre.add(BtnmoinsCavalierRenfort);

		BtnplusCanonRenfort = new JLabel();
		BtnplusCanonRenfort.setBounds(250, 103, 35, 35);
		BtnplusCanonRenfort.setIcon(new ImageIcon("Images/Btnplus.png"));
		BtnplusCanonRenfort.addMouseListener(this);
		cadre.add(BtnplusCanonRenfort);

		BtnmoinsCanonRenfort = new JLabel();
		BtnmoinsCanonRenfort.setBounds(180, 103, 35, 35);
		BtnmoinsCanonRenfort.setIcon(new ImageIcon("Images/Btnmoins.png"));
		BtnmoinsCanonRenfort.addMouseListener(this);
		cadre.add(BtnmoinsCanonRenfort);

		// TERRITOIRE
		BtnplusSoldatTerritoire = new JLabel();
		BtnplusSoldatTerritoire.setBounds(440, 23, 35, 35);
		BtnplusSoldatTerritoire.setIcon(new ImageIcon("Images/Btnplus.png"));
		BtnplusSoldatTerritoire.addMouseListener(this);
		cadre.add(BtnplusSoldatTerritoire);

		BtnmoinsSoldatTerritoire = new JLabel();
		BtnmoinsSoldatTerritoire.setBounds(370, 23, 35, 35);
		BtnmoinsSoldatTerritoire.setIcon(new ImageIcon("Images/Btnmoins.png"));
		BtnmoinsSoldatTerritoire.addMouseListener(this);
		cadre.add(BtnmoinsSoldatTerritoire);

		BtnplusCavalierTerritoire = new JLabel();
		BtnplusCavalierTerritoire.setBounds(440, 63, 35, 35);
		BtnplusCavalierTerritoire.setIcon(new ImageIcon("Images/Btnplus.png"));
		BtnplusCavalierTerritoire.addMouseListener(this);
		cadre.add(BtnplusCavalierTerritoire);

		BtnmoinsCavalierTerritoire = new JLabel();
		BtnmoinsCavalierTerritoire.setBounds(370, 63, 35, 35);
		BtnmoinsCavalierTerritoire.setIcon(new ImageIcon("Images/Btnmoins.png"));
		BtnmoinsCavalierTerritoire.addMouseListener(this);
		cadre.add(BtnmoinsCavalierTerritoire);

		BtnplusCanonTerritoire = new JLabel();
		BtnplusCanonTerritoire.setBounds(440, 103, 35, 35);
		BtnplusCanonTerritoire.setIcon(new ImageIcon("Images/Btnplus.png"));
		BtnplusCanonTerritoire.addMouseListener(this);
		cadre.add(BtnplusCanonTerritoire);

		BtnmoinsCanonTerritoire = new JLabel();
		BtnmoinsCanonTerritoire.setBounds(370, 103, 35, 35);
		BtnmoinsCanonTerritoire.setIcon(new ImageIcon("Images/Btnmoins.png"));
		BtnmoinsCanonTerritoire.addMouseListener(this);
		cadre.add(BtnmoinsCanonTerritoire);

		// ACTION
		BtnplusSoldatAction = new JLabel();
		BtnplusSoldatAction.setBounds(622, 23, 35, 35);
		BtnplusSoldatAction.setIcon(new ImageIcon("Images/Btnplus.png"));
		BtnplusSoldatAction.addMouseListener(this);
		cadre.add(BtnplusSoldatAction);

		BtnmoinsSoldatAction = new JLabel();
		BtnmoinsSoldatAction.setBounds(552, 23, 35, 35);
		BtnmoinsSoldatAction.setIcon(new ImageIcon("Images/Btnmoins.png"));
		BtnmoinsSoldatAction.addMouseListener(this);
		cadre.add(BtnmoinsSoldatAction);

		BtnplusCavalierAction = new JLabel();
		BtnplusCavalierAction.setBounds(622, 63, 35, 35);
		BtnplusCavalierAction.setIcon(new ImageIcon("Images/Btnplus.png"));
		BtnplusCavalierAction.addMouseListener(this);
		cadre.add(BtnplusCavalierAction);

		BtnmoinsCavalierAction = new JLabel();
		BtnmoinsCavalierAction.setBounds(552, 63, 35, 35);
		BtnmoinsCavalierAction.setIcon(new ImageIcon("Images/Btnmoins.png"));
		BtnmoinsCavalierAction.addMouseListener(this);
		cadre.add(BtnmoinsCavalierAction);

		BtnplusCanonAction = new JLabel();
		BtnplusCanonAction.setBounds(622, 103, 35, 35);
		BtnplusCanonAction.setIcon(new ImageIcon("Images/Btnplus.png"));
		BtnplusCanonAction.addMouseListener(this);
		cadre.add(BtnplusCanonAction);

		BtnmoinsCanonAction = new JLabel();
		BtnmoinsCanonAction.setBounds(552, 103, 35, 35);
		BtnmoinsCanonAction.setIcon(new ImageIcon("Images/Btnmoins.png"));
		BtnmoinsCanonAction.addMouseListener(this);
		cadre.add(BtnmoinsCanonAction);

		// ----------------------TEXTFIELD-----------------------
		// RENFORT
		SoldatRenfort = new JTextField("0");
		SoldatRenfort.setOpaque(false);
		SoldatRenfort.setEditable(false);
		SoldatRenfort.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		SoldatRenfort.setBounds(215, 23, 35, 35);
		cadre.add(SoldatRenfort);

		CavalierRenfort = new JTextField("0");
		CavalierRenfort.setOpaque(false);
		CavalierRenfort.setEditable(false);
		CavalierRenfort.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		CavalierRenfort.setBounds(215, 63, 35, 35);
		cadre.add(CavalierRenfort);

		CanonRenfort = new JTextField("0");
		CanonRenfort.setOpaque(false);
		CanonRenfort.setEditable(false);
		CanonRenfort.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		CanonRenfort.setBounds(215, 103, 35, 35);
		cadre.add(CanonRenfort);

		// TERRITOIRE
		SoldatTerritoire = new JTextField("0");
		SoldatTerritoire.setOpaque(false);
		SoldatTerritoire.setEditable(false);
		SoldatTerritoire.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		SoldatTerritoire.setBounds(405, 23, 35, 35);
		cadre.add(SoldatTerritoire);

		CavalierTerritoire = new JTextField("0");
		CavalierTerritoire.setOpaque(false);
		CavalierTerritoire.setEditable(false);
		CavalierTerritoire.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		CavalierTerritoire.setBounds(405, 63, 35, 35);
		cadre.add(CavalierTerritoire);

		CanonTerritoire = new JTextField("0");
		CanonTerritoire.setOpaque(false);
		CanonTerritoire.setEditable(false);
		CanonTerritoire.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		CanonTerritoire.setBounds(405, 103, 35, 35);
		cadre.add(CanonTerritoire);

		// ACTION
		SoldatAction = new JTextField("0");
		SoldatAction.setOpaque(false);
		SoldatAction.setEditable(false);
		SoldatAction.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		SoldatAction.setBounds(587, 23, 35, 35);
		cadre.add(SoldatAction);

		CavalierAction = new JTextField("0");
		CavalierAction.setOpaque(false);
		CavalierAction.setEditable(false);
		CavalierAction.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		CavalierAction.setBounds(587, 63, 35, 35);
		cadre.add(CavalierAction);

		CanonAction = new JTextField("0");
		CanonAction.setOpaque(false);
		CanonAction.setEditable(false);
		CanonAction.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		CanonAction.setBounds(587, 103, 35, 35);
		cadre.add(CanonAction);

		map = new JLabel();
		map.setBounds(5, 5, 1910, 920);
		map.setIcon(new ImageIcon("Images/map3.png"));
		background.add(map);

		nom1 = new JTextArea();
		nom1.setEditable(false);
		nom1.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		nom1.setOpaque(false);
		nom1.setText(joueur1TextField.getText());
		nom1.setBounds(50, 930, 190, 75);

		nom2 = new JTextArea();
		nom2.setEditable(false);
		nom2.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		nom2.setOpaque(false);
		nom2.setText(joueur2TextField.getText());
		nom2.setBounds(50, 980, 190, 75);

		nom3 = new JTextArea();
		nom3.setEditable(false);
		nom3.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		nom3.setOpaque(false);
		nom3.setText(joueur3TextField.getText());
		nom3.setBounds(50, 1030, 190, 75);

		nom4 = new JTextArea();
		nom4.setEditable(false);
		nom4.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		nom4.setOpaque(false);
		nom4.setText(joueur4TextField.getText());
		nom4.setBounds(230, 930, 190, 75);

		nom5 = new JTextArea();
		nom5.setEditable(false);
		nom5.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		nom5.setOpaque(false);
		nom5.setText(joueur5TextField.getText());
		nom5.setBounds(230, 980, 190, 75);

		nom6 = new JTextArea();
		nom6.setEditable(false);
		nom6.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		nom6.setOpaque(false);
		nom6.setText(joueur6TextField.getText());
		nom6.setBounds(230, 1030, 190, 75);

		background.add(nom1);
		background.add(nom2);

		if (nbJoueurs == 3) {
			background.add(nom3);
		}
		if (nbJoueurs == 4) {
			background.add(nom3);
			background.add(nom4);
		}
		if (nbJoueurs == 5) {
			background.add(nom3);
			background.add(nom4);
			background.add(nom5);
		}
		if (nbJoueurs == 6) {
			background.add(nom3);
			background.add(nom4);
			background.add(nom5);
			background.add(nom6);
		}

		contour = new JLabel();
		contour.setBounds(40, 900, 210, 95);
		contour.setIcon(new ImageIcon("Contour/contourRouge.png"));
		background.add(contour);

		action = new JLabel();
		action.setBounds(1480, 950, 100, 100);
		action.setIcon(new ImageIcon("Images/action.png"));
		action.addMouseListener(this);
		background.add(action);

		mouvement = new JLabel();
		mouvement.setBounds(1620, 950, 100, 100);
		mouvement.setIcon(new ImageIcon("Images/mouvement.png"));
		mouvement.addMouseListener(this);
		background.add(mouvement);

		findutour = new JLabel();
		findutour.setBounds(1760, 950, 100, 100);
		findutour.setIcon(new ImageIcon("Images/findutour.png"));
		findutour.addMouseListener(this);
		background.add(findutour);

		refresh = new JLabel();
		refresh.setBounds(1340, 950, 100, 100);
		refresh.setIcon(new ImageIcon("Images/refresh.png"));
		refresh.addMouseListener(this);
		background.add(refresh);

		off = new JLabel();
		off.setBounds(-10, -10, 100, 100);
		off.setIcon(new ImageIcon("Images/off.png"));
		off.addMouseListener(this);
		map.add(off);

		informations = new JTextArea("");
		informations.setBounds(375, 925, 215, 145);
		informations.setOpaque(false);
		informations.setEditable(false);
		informations.setFont(new Font("Times New Roman", Font.BOLD, 24));
		background.add(informations);

		indications = new JTextArea("Placez vos renforts");
		indications.setBounds(630, 890, 900, 25);
		indications.setOpaque(false);
		indications.setEditable(false);
		indications.setFont(new Font("Times New Roman", Font.BOLD, 24));
		map.add(indications);

		// CREATION HITBOXES
		hitboxes = new JLabel[42];
		for (int index = 0; index < 42; index++) {
			hitboxes[index] = new JLabel(Integer.toString(index));
			hitboxes[index].setName(Integer.toString(index));
			hitboxes[index].addMouseListener(m);
			map.add(hitboxes[index]);
		}
		setBoundsHitboxes();

		// ENLEVER BOUTONS DE TEST:
		BtnplusSoldatRenfort.setVisible(false);
		BtnmoinsSoldatRenfort.setVisible(false);
		BtnmoinsSoldatTerritoire.setVisible(false);
		BtnmoinsCavalierTerritoire.setVisible(false);
		BtnmoinsCanonTerritoire.setVisible(false);

		jeu.repaint();
		return jeu;
	}

	/**
	 * Renvoi le nombre de joueur selectionne
	 * 
	 * @return
	 */
	public int getNbJoueurs() {
		return nbJoueurs;
	}

	/**
	 * Modifie le nombre de joueur
	 * 
	 * @param nbJoueurs
	 */
	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

	// EVENT MOUSE LISTENER

	// JETON MOUSE LISTENER
	/**
	 * Mouse Listener uniquement pour gérer les cliques sur les territoires
	 */
	MouseListener m = new MouseListener() {
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			for (int i = 0; i < 42; i++) {
				if (e.getSource() == hitboxes[i]) {
					if (hitboxes[i].getName().equals(risk.listeTerritoires.get(i).getId2())) {
						ceTerritoire = i;
						informations.setText(risk.listeTerritoires.get(i).getNom() + "\n" + "Joueur "
								+ (risk.listeTerritoires.get(i).getOccupant().getIdJoueur() + 1));
						actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
						actualiserJTextFieldAction(SoldatAction, CavalierAction, CanonAction);

						if (risk.renfortTermine()) {
							if (risk.getD() == null) {
								risk.setD(risk.listeTerritoires.get(ceTerritoire));
								indications.setText("Territoire départ: " + risk.getD().getNom());
							} else if (risk.getA() == null) {
								risk.setA(risk.listeTerritoires.get(ceTerritoire));
								indications.setText("Territoire départ: " + risk.getD().getNom() + "   "
										+ "Territoire arrivé: " + risk.getA().getNom());
							}
						}
					}
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

	};

	// BOUTONS MOUSE LISTENER

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	/**
	 * Mettre en surbrillance les boutons lorsque la souris entre dans leur hitbox
	 */
	@Override
	public void mouseEntered(MouseEvent e) {

		if (e.getSource() == jouer) {
			jouer.setIcon(new ImageIcon("Images/JouerHover.png"));
		}
		if (e.getSource() == close) {
			close.setIcon(new ImageIcon("Images/QuitterHover.png"));
		}
		if (e.getSource() == commencer) {
			commencer.setIcon(new ImageIcon("Images/CommencerHover.png"));
		}
		if (e.getSource() == deuxJ) {
			deuxJ.setIcon(new ImageIcon("Images/DeuxbtnHover.png"));
		}
		if (e.getSource() == troisJ) {
			troisJ.setIcon(new ImageIcon("Images/TroisbtnHover.png"));
		}
		if (e.getSource() == quatreJ) {
			quatreJ.setIcon(new ImageIcon("Images/QuatrebtnHover.png"));
		}
		if (e.getSource() == cinqJ) {
			cinqJ.setIcon(new ImageIcon("Images/CinqbtnHover.png"));
		}
		if (e.getSource() == sixJ) {
			sixJ.setIcon(new ImageIcon("Images/SixbtnHover.png"));
		}

	}

	@Override
	/**
	 * Enlever la surbrillance des boutons lorsqu'on est pas dessus
	 */
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == jouer) {
			jouer.setIcon(new ImageIcon("Images/Jouer.png"));
		}
		if (e.getSource() == close) {
			close.setIcon(new ImageIcon("Images/Quitter.png"));
		}
		if (e.getSource() == commencer) {
			commencer.setIcon(new ImageIcon("Images/Commencer.png"));
		}
		if (e.getSource() == deuxJ) {
			deuxJ.setIcon(new ImageIcon("Images/Deuxbtn.png"));
		}
		if (e.getSource() == troisJ) {
			troisJ.setIcon(new ImageIcon("Images/Troisbtn.png"));
		}
		if (e.getSource() == quatreJ) {
			quatreJ.setIcon(new ImageIcon("Images/Quatrebtn.png"));
		}
		if (e.getSource() == cinqJ) {
			cinqJ.setIcon(new ImageIcon("Images/Cinqbtn.png"));
		}
		if (e.getSource() == sixJ) {
			sixJ.setIcon(new ImageIcon("Images/Sixbtn.png"));
		}
	}

	@Override
	/**
	 * Gestion des evenements de souris sur les boutons
	 */
	public void mousePressed(MouseEvent e) {

		if (e.getSource() == jouer) {
			deuxJ.setVisible(true);
			troisJ.setVisible(true);
			quatreJ.setVisible(true);
			cinqJ.setVisible(true);
			sixJ.setVisible(true);
			commencer.setVisible(true);
			jouer.setVisible(false);
			close.setVisible(false);
		}
		if (e.getSource() == close || e.getSource() == off) {
			System.exit(0);
		}
		if (e.getSource() == findutour) {
			if (risk.renfortTermine() == true) {
				risk.finDeTour();
				risk.ajoutAutoRenforts();
				actualiserJTextFieldRenfort(SoldatRenfort, CavalierRenfort, CanonRenfort);
				actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
				actualiserJTextFieldAction(SoldatAction, CavalierAction, CanonAction);
				if (risk.tour == 0) {
					contour.setBounds(40, 900, 210, 95);
					contour.setIcon(new ImageIcon("Contour/contourRouge.png"));
				}
				if (risk.tour == 1) {
					contour.setBounds(40, 950, 210, 95);
					contour.setIcon(new ImageIcon("Contour/contourBleu.png"));
				}

				if (risk.tour == 2) {
					contour.setBounds(40, 1000, 210, 95);
					contour.setIcon(new ImageIcon("Contour/contourVert.png"));
				}

				if (risk.tour == 3) {
					contour.setBounds(220, 900, 210, 95);
					contour.setIcon(new ImageIcon("Contour/contourOrange.png"));
				}

				if (risk.tour == 4) {
					contour.setBounds(220, 950, 210, 95);
					contour.setIcon(new ImageIcon("Contour/contourViolet.png"));
				}
				if (risk.tour == 5) {
					contour.setBounds(220, 1000, 210, 95);
					contour.setIcon(new ImageIcon("Contour/contourBlanc.png"));
				}
			} else {
				indications.setText("Placez d'abord vos renforts !");
			}
		}
		if (e.getSource() == commencer) {

			// VERIFICATION LONGUEUR DES NOM
			ArrayList<JTextField> j = new ArrayList<JTextField>();
			j.add(joueur1TextField);
			j.add(joueur2TextField);
			j.add(joueur3TextField);
			j.add(joueur4TextField);
			j.add(joueur5TextField);
			j.add(joueur6TextField);

			verifNom(j);
			verifNbJoueurMin(nbJoueurs);

			if (verifNbJoueurMin == false) {
				warning.removeAll();
				warning.setText("Choisissez le nombre de joueurs");
				warning.setVisible(true);
				return;
			} else if (verifNom == false) {
				warning.removeAll();
				warning.setText("Réduisez la taille de vos noms");
				warning.setForeground(Color.WHITE);
				warning.setVisible(true);
				return;
			} else {
				this.remove(menu);
				this.setContentPane(jeu());
				this.revalidate();
			}

			if (nbJoueurs == 2) {
				risk.listeJoueurs.add(new Joueur(joueur1TextField.getText(), 0));
				risk.listeJoueurs.add(new Joueur(joueur2TextField.getText(), 1));
				risk.distribuerRenfortsDebut();
				actualiserJTextFieldRenfort(SoldatRenfort, CavalierRenfort, CanonRenfort);
				actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
				risk.attribuerTerritoires();
				attribuerCouleurs();
			}
			if (nbJoueurs == 3) {
				risk.listeJoueurs.add(new Joueur(joueur1TextField.getText(), 0));
				risk.listeJoueurs.add(new Joueur(joueur2TextField.getText(), 1));
				risk.listeJoueurs.add(new Joueur(joueur3TextField.getText(), 2));
				risk.distribuerRenfortsDebut();
				actualiserJTextFieldRenfort(SoldatRenfort, CavalierRenfort, CanonRenfort);
				actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
				risk.attribuerTerritoires();
				attribuerCouleurs();

			}
			if (nbJoueurs == 4) {
				risk.listeJoueurs.add(new Joueur(joueur1TextField.getText(), 0));
				risk.listeJoueurs.add(new Joueur(joueur2TextField.getText(), 1));
				risk.listeJoueurs.add(new Joueur(joueur3TextField.getText(), 2));
				risk.listeJoueurs.add(new Joueur(joueur4TextField.getText(), 3));
				risk.distribuerRenfortsDebut();
				actualiserJTextFieldRenfort(SoldatRenfort, CavalierRenfort, CanonRenfort);
				actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
				risk.attribuerTerritoires();
				attribuerCouleurs();

			}
			if (nbJoueurs == 5) {
				risk.listeJoueurs.add(new Joueur(joueur1TextField.getText(), 0));
				risk.listeJoueurs.add(new Joueur(joueur2TextField.getText(), 1));
				risk.listeJoueurs.add(new Joueur(joueur3TextField.getText(), 2));
				risk.listeJoueurs.add(new Joueur(joueur4TextField.getText(), 3));
				risk.listeJoueurs.add(new Joueur(joueur5TextField.getText(), 4));
				risk.distribuerRenfortsDebut();
				actualiserJTextFieldRenfort(SoldatRenfort, CavalierRenfort, CanonRenfort);
				actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
				risk.attribuerTerritoires();
				attribuerCouleurs();

			}
			if (nbJoueurs == 6) {
				risk.listeJoueurs.add(new Joueur(joueur1TextField.getText(), 0));
				risk.listeJoueurs.add(new Joueur(joueur2TextField.getText(), 1));
				risk.listeJoueurs.add(new Joueur(joueur3TextField.getText(), 2));
				risk.listeJoueurs.add(new Joueur(joueur4TextField.getText(), 3));
				risk.listeJoueurs.add(new Joueur(joueur5TextField.getText(), 4));
				risk.listeJoueurs.add(new Joueur(joueur6TextField.getText(), 5));
				risk.distribuerRenfortsDebut();
				actualiserJTextFieldRenfort(SoldatRenfort, CavalierRenfort, CanonRenfort);
				actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
				risk.attribuerTerritoires();
				attribuerCouleurs();

			}
		}
		/*
		 * Gestion des evenements attaquer et deplacer
		 */
		if (risk.sonTour() == true && risk.premierTour == false && risk.renfortTermine() == true) {
			mouvement.setVisible(true);
			action.setVisible(true);
			if (e.getSource() == mouvement) {
				if (risk.peutDeplacer(risk.getD(), risk.getA())) {
					risk.deplacer(risk.getD(), risk.getA());
					mouvement.setVisible(false);
					afficherNbUnite(risk.getD().listeUnites);
					afficherNbUnite(risk.getD().listeUnitesAction);
					afficherNbUnite(risk.getA().listeUnites);
					afficherNbUnite(risk.getA().listeUnitesAction);
					actualiserJTextFieldRenfort(SoldatRenfort, CavalierRenfort, CanonRenfort);
					actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
					actualiserJTextFieldAction(SoldatAction, CavalierAction, CanonAction);
				} else {
					indications.setText("Vous ne pouvez pas vous deplacer sur ce territoire");
				}
			}
			if (e.getSource() == action) {
				if (risk.peutAttaquer(risk.getD(), risk.getA())) {
					if (risk.getD().getListeUnitesAction().size() <= 3) {

						System.out.println("Taille liste unite ACTION ATT" + risk.getD().getListeUnitesAction().size());
						System.out.println(
								"Taille liste unite BATAILLE ATT" + risk.getD().getListeUnitesBataille().size());

						risk.getD().setListeUnitesBataille(risk.getD().getListeUnitesAction());

						System.out.println(
								"Taille liste unite BATAILLE ATT" + risk.getD().getListeUnitesBataille().size());
						combat.combattre(risk.getD(), risk.getA());
						risk.getD().getListeUnitesAction().clear();
						attribuerCouleurs();
						action.setVisible(false);
						actualiserJTextFieldRenfort(SoldatRenfort, CavalierRenfort, CanonRenfort);
						actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
						actualiserJTextFieldAction(SoldatAction, CavalierAction, CanonAction);
					} else {
						indications.setText("Placez au maximum 3 unites dans action");
					}
				} else {
					indications.setText("Vous ne pouvez pas attaquer ce territoire");

				}
			}

		}
		/*
		 * Actualiser les territoires selectionnes
		 */
		if (e.getSource() == refresh) {
			risk.refreshSelection(indications);
			attribuerCouleurs();
			actualiserJTextFieldRenfort(SoldatRenfort, CavalierRenfort, CanonRenfort);
			actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
			actualiserJTextFieldAction(SoldatAction, CavalierAction, CanonAction);
		}
		if (e.getSource() == deuxJ) {
			nbJoueurs = 2;
			joueur1TextField.setVisible(true);
			joueur2TextField.setVisible(true);
			joueur3TextField.setVisible(false);
			joueur4TextField.setVisible(false);
			joueur5TextField.setVisible(false);
			joueur6TextField.setVisible(false);
		}
		if (e.getSource() == troisJ) {
			nbJoueurs = 3;
			joueur1TextField.setVisible(true);
			joueur2TextField.setVisible(true);
			joueur3TextField.setVisible(true);
			joueur4TextField.setVisible(false);
			joueur5TextField.setVisible(false);
			joueur6TextField.setVisible(false);
		}
		if (e.getSource() == quatreJ) {
			nbJoueurs = 4;
			joueur1TextField.setVisible(true);
			joueur2TextField.setVisible(true);
			joueur3TextField.setVisible(true);
			joueur4TextField.setVisible(true);
			joueur5TextField.setVisible(false);
			joueur6TextField.setVisible(false);
		}
		if (e.getSource() == cinqJ) {
			nbJoueurs = 5;
			joueur1TextField.setVisible(true);
			joueur2TextField.setVisible(true);
			joueur3TextField.setVisible(true);
			joueur4TextField.setVisible(true);
			joueur5TextField.setVisible(true);
			joueur6TextField.setVisible(false);
		}

		if (e.getSource() == sixJ) {
			nbJoueurs = 6;
			joueur1TextField.setVisible(true);
			joueur2TextField.setVisible(true);
			joueur3TextField.setVisible(true);
			joueur4TextField.setVisible(true);
			joueur5TextField.setVisible(true);
			joueur6TextField.setVisible(true);
		}

		// BOUTONS DU TABLEAU : RENFORTS , TERRITOIRE , ACTION

		if (e.getSource() == BtnplusSoldatRenfort) {
			risk.ajouterSoldatRenfort(risk.listeJoueurs.get(risk.tour).getRenforts());
			actualiserJTextFieldRenfort(SoldatRenfort, CavalierRenfort, CanonRenfort);
		}
		if (e.getSource() == BtnplusCavalierRenfort) {
			risk.echangerSoldatContreCavalier(risk.listeJoueurs.get(risk.tour).getRenforts());
			actualiserJTextFieldRenfort(SoldatRenfort, CavalierRenfort, CanonRenfort);
		}
		if (e.getSource() == BtnplusCanonRenfort) {
			risk.echangerSoldatContreCanon(risk.listeJoueurs.get(risk.tour).getRenforts());
			actualiserJTextFieldRenfort(SoldatRenfort, CavalierRenfort, CanonRenfort);
		}
		if (e.getSource() == BtnmoinsCavalierRenfort) {
			risk.echangerCavalierContreSoldat(risk.listeJoueurs.get(risk.tour).getRenforts());
			actualiserJTextFieldRenfort(SoldatRenfort, CavalierRenfort, CanonRenfort);
		}
		if (e.getSource() == BtnmoinsCanonRenfort) {
			risk.echangerCanonContreSoldat(risk.listeJoueurs.get(risk.tour).getRenforts());
			actualiserJTextFieldRenfort(SoldatRenfort, CavalierRenfort, CanonRenfort);
		}
		if (e.getSource() == BtnplusSoldatTerritoire) {
			if (peutTransferer()) {
				risk.transfererSoldat(risk.listeJoueurs.get(risk.tour).getRenforts(),
						risk.listeTerritoires.get(ceTerritoire).getListeUnites());
				actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
				actualiserJTextFieldRenfort(SoldatRenfort, CavalierRenfort, CanonRenfort);

			}
		}
		if (e.getSource() == BtnplusCavalierTerritoire) {
			if (peutTransferer()) {
				risk.transfererCavalier(risk.listeJoueurs.get(risk.tour).getRenforts(),
						risk.listeTerritoires.get(ceTerritoire).getListeUnites());
				actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
				actualiserJTextFieldRenfort(SoldatRenfort, CavalierRenfort, CanonRenfort);
			}
		}
		if (e.getSource() == BtnplusCanonTerritoire) {
			if (peutTransferer()) {
				risk.transfererCanon(risk.listeJoueurs.get(risk.tour).getRenforts(),
						risk.listeTerritoires.get(ceTerritoire).getListeUnites());
				actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
				actualiserJTextFieldRenfort(SoldatRenfort, CavalierRenfort, CanonRenfort);
			}
		}
		if (e.getSource() == BtnplusSoldatAction) {
			if (risk.listeTerritoires.get(ceTerritoire).getListeUnites().size() > 1 && peutTransferer() == true
					&& risk.renfortTermine()) {
				risk.transfererSoldatAction(risk.listeTerritoires.get(ceTerritoire).getListeUnites(),
						risk.listeTerritoires.get(ceTerritoire).getListeUnitesAction());
				actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
				actualiserJTextFieldAction(SoldatAction, CavalierAction, CanonAction);
			} else {
				indications.setText("Vous ne pouvez pas effectuer d'actions");
			}
		}
		if (e.getSource() == BtnplusCavalierAction) {
			if (risk.listeTerritoires.get(ceTerritoire).getListeUnites().size() > 1 && peutTransferer() == true
					&& risk.renfortTermine()) {
				risk.transfererCavalierAction(risk.listeTerritoires.get(ceTerritoire).getListeUnites(),
						risk.listeTerritoires.get(ceTerritoire).getListeUnitesAction());
				actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
				actualiserJTextFieldAction(SoldatAction, CavalierAction, CanonAction);
			} else {
				indications.setText("Vous ne pouvez pas effectuer d'actions");
			}
		}
		if (e.getSource() == BtnplusCanonAction) {
			if (risk.listeTerritoires.get(ceTerritoire).getListeUnites().size() > 1 && peutTransferer() == true
					&& risk.renfortTermine()) {
				risk.transfererCanonAction(risk.listeTerritoires.get(ceTerritoire).getListeUnites(),
						risk.listeTerritoires.get(ceTerritoire).getListeUnitesAction());
				actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
				actualiserJTextFieldAction(SoldatAction, CavalierAction, CanonAction);
			} else {
				indications.setText("Vous ne pouvez pas effectuer d'actions");
			}
		}
		if (e.getSource() == BtnmoinsSoldatAction) {
			if (risk.listeTerritoires.get(ceTerritoire).getListeUnitesAction().size() > 0 && peutTransferer() == true
					&& risk.renfortTermine()) {
				risk.transfererSoldat(risk.listeTerritoires.get(ceTerritoire).getListeUnitesAction(),
						risk.listeTerritoires.get(ceTerritoire).getListeUnites());
				actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
				actualiserJTextFieldAction(SoldatAction, CavalierAction, CanonAction);
			} else {
				indications.setText("Vous ne pouvez pas effectuer d'actions");
			}
		}
		if (e.getSource() == BtnmoinsCavalierAction) {
			if (risk.listeTerritoires.get(ceTerritoire).getListeUnitesAction().size() > 0 && peutTransferer() == true
					&& risk.renfortTermine()) {
				risk.transfererCavalier(risk.listeTerritoires.get(ceTerritoire).getListeUnitesAction(),
						risk.listeTerritoires.get(ceTerritoire).getListeUnites());
				actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
				actualiserJTextFieldAction(SoldatAction, CavalierAction, CanonAction);
			} else {
				indications.setText("Vous ne pouvez pas effectuer d'actions");
			}
		}
		if (e.getSource() == BtnmoinsCanonAction) {
			if (risk.listeTerritoires.get(ceTerritoire).getListeUnitesAction().size() > 0 && peutTransferer() == true
					&& risk.renfortTermine()) {
				risk.transfererCanon(risk.listeTerritoires.get(ceTerritoire).getListeUnitesAction(),
						risk.listeTerritoires.get(ceTerritoire).getListeUnites());
				actualiserJTextFieldTerritoire(SoldatTerritoire, CavalierTerritoire, CanonTerritoire);
				actualiserJTextFieldAction(SoldatAction, CavalierAction, CanonAction);
			} else {
				indications.setText("Vous ne pouvez pas effectuer d'actions");
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	// VERIFICATIONS
	/**
	 * Verifie qu'il y a au moins deux joueurs
	 * 
	 * @param nj
	 * @return
	 */
	public boolean verifNbJoueurMin(int nj) {
		if (nj < 2) {
			return verifNbJoueurMin = false;
		}
		return verifNbJoueurMin = true;
	}

	/**
	 * Verifie que la taille des noms n'est pas trop grande
	 * 
	 * @param j
	 * @return
	 */
	public boolean verifNom(ArrayList<JTextField> j) {
		for (int i = 0; i < j.size(); i++) {
			if (j.get(i).getText().length() >= 10) {
				return verifNom = false;
			}
		}
		return verifNom = true;
	}

	// AFFICHE EN CONSOLE LES UNITES DUNE LISTE
	/**
	 * Affiche en console le nombre d'unites différentes d'une liste d'unite
	 * 
	 * @param l
	 */
	public void afficherNbUnite(ArrayList<Unite> l) {
		int soldat = 0;
		int cavalier = 0;
		int canon = 0;

		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getType() == 0) {
				soldat++;
			}
			if (l.get(i).getType() == 1) {
				cavalier++;
			}
			if (l.get(i).getType() == 2) {
				canon++;
			}
		}
		System.out.println("Soldat: " + soldat + "Cavalier: " + cavalier + "Canon: " + canon);
	}

	// RENVOI UN STRING DU NOMBRE DE TROUPES
	/**
	 * Compter les soldats et convertir le nombre de soldats en string pour pouvoir
	 * l'afficher
	 * 
	 * @param l
	 * @return
	 */
	public String afficherNbSoldat(ArrayList<Unite> l) {
		int soldat = 0;
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getType() == 0) {
				soldat++;
			}
		}
		return Integer.toString(soldat);
	}

	/**
	 * Compter les cavaliers et convertir le nombre de soldats en string pour
	 * pouvoir l'afficher
	 * 
	 * @param l
	 * @return
	 */
	public String afficherNbCavalier(ArrayList<Unite> l) {
		int cavalier = 0;
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getType() == 1) {
				cavalier++;
			}
		}
		return Integer.toString(cavalier);
	}

	/**
	 * Compter les canons et convertir le nombre de soldats en string pour pouvoir
	 * l'afficher
	 * 
	 * @param l
	 * @return
	 */
	public String afficherNbCanon(ArrayList<Unite> l) {
		int canon = 0;
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getType() == 2) {
				canon++;
			}
		}
		return Integer.toString(canon);
	}

	/**
	 * Actualiser les textfields du tableau d'unites renforts (affichage)
	 */
	public void actualiserJTextFieldRenfort(JTextField textfield1, JTextField textfield2, JTextField textfield3) {
		for (int j = 0; j < risk.listeJoueurs.size(); j++) {
			if (risk.listeJoueurs.get(j).getIdJoueur() == risk.tour) {
				textfield1.setText(afficherNbSoldat(risk.listeJoueurs.get(j).getRenforts()));
				textfield2.setText(afficherNbCavalier(risk.listeJoueurs.get(j).getRenforts()));
				textfield3.setText(afficherNbCanon(risk.listeJoueurs.get(j).getRenforts()));
			}
		}
	}

	/**
	 * Actualiser les textfields du tableau d'unites territoire (affichage)
	 */
	public void actualiserJTextFieldTerritoire(JTextField textfield1, JTextField textfield2, JTextField textfield3) {
		for (int j = 0; j < risk.listeTerritoires.size(); j++) {
			if (risk.listeTerritoires.get(j).getId() == ceTerritoire) {
				textfield1.setText(afficherNbSoldat(risk.listeTerritoires.get(j).getListeUnites()));
				textfield2.setText(afficherNbCavalier(risk.listeTerritoires.get(j).getListeUnites()));
				textfield3.setText(afficherNbCanon(risk.listeTerritoires.get(j).getListeUnites()));
			}
		}
	}

	/**
	 * Actualiser les textfields du tableau d'unites action (affichage)
	 */
	public void actualiserJTextFieldAction(JTextField textfield1, JTextField textfield2, JTextField textfield3) {
		for (int j = 0; j < risk.listeTerritoires.size(); j++) {
			if (risk.listeTerritoires.get(j).getId() == ceTerritoire) {
				textfield1.setText(afficherNbSoldat(risk.listeTerritoires.get(j).getListeUnitesAction()));
				textfield2.setText(afficherNbCavalier(risk.listeTerritoires.get(j).getListeUnitesAction()));
				textfield3.setText(afficherNbCanon(risk.listeTerritoires.get(j).getListeUnitesAction()));
			}
		}
	}

	/**
	 * Affichage des hitboxes des territoires
	 */
	public void setBoundsHitboxes() {
		hitboxes[0].setBounds(800, 115, 50, 50); // ISLANDE
		hitboxes[1].setBounds(970, 105, 50, 50); // SCANDINAVIE
		hitboxes[2].setBounds(760, 270, 50, 50); // GRANDE BRETAGNE
		hitboxes[3].setBounds(830, 340, 50, 50); // EUROPE DE OUEST
		hitboxes[4].setBounds(955, 380, 50, 50);// EUROPE DU SUD
		hitboxes[5].setBounds(940, 230, 50, 50);// EUROPE DU NORD
		hitboxes[6].setBounds(1100, 230, 50, 50);// UKRAINE
		hitboxes[7].setBounds(1005, 455, 50, 50); // EGYPTE
		hitboxes[8].setBounds(855, 475, 50, 50); // AFRIQUE DU NORD
		hitboxes[9].setBounds(1075, 565, 50, 50); // AFRIQUE DE LEST
		hitboxes[10].setBounds(1010, 610, 50, 50); // CONGO
		hitboxes[11].setBounds(1020, 780, 50, 50); // AFRIQUE DU SUD
		hitboxes[12].setBounds(1210, 770, 50, 50); // MADAGASCAR
		hitboxes[13].setBounds(1150, 450, 50, 50); // MOYEN ORIENT
		hitboxes[14].setBounds(1360, 470, 50, 50); // INDE
		hitboxes[15].setBounds(1260, 335, 50, 50); // AFGANISTAN
		hitboxes[16].setBounds(1270, 135, 50, 50); // OURAL
		hitboxes[17].setBounds(1370, 90, 50, 50); // SIBERIE
		hitboxes[18].setBounds(1520, 510, 50, 50); // SIAM
		hitboxes[19].setBounds(1540, 375, 50, 50); // CHINE
		hitboxes[20].setBounds(1515, 50, 50, 50); // YAKOUTI
		hitboxes[21].setBounds(1515, 315, 50, 50); // MONGOLIE
		hitboxes[22].setBounds(1700, 270, 50, 50); // JAPON
		hitboxes[23].setBounds(1665, 70, 50, 50); // KAMCHATKA
		hitboxes[24].setBounds(1500, 165, 50, 50); // IRKUTSK
		hitboxes[25].setBounds(130, 80, 50, 50); // ALASKA
		hitboxes[26].setBounds(300, 80, 50, 50); // TERRITOIRE DU NORD
		hitboxes[27].setBounds(285, 210, 50, 50); // ALBERTA
		hitboxes[28].setBounds(400, 160, 50, 50); // ONTARIO
		hitboxes[29].setBounds(650, 90, 50, 50); // GROENLAND
		hitboxes[30].setBounds(530, 160, 50, 50); // QUEBEC
		hitboxes[31].setBounds(290, 310, 50, 50); // ETATS DE LOUEST
		hitboxes[32].setBounds(415, 340, 50, 50); // ETATS DE LEST
		hitboxes[33].setBounds(290, 400, 50, 50);// AMERIQUE CENTRALE
		hitboxes[34].setBounds(430, 450, 50, 50);// VENEZUELA
		hitboxes[35].setBounds(580, 525, 50, 50);// BRESIL
		hitboxes[36].setBounds(400, 590, 50, 50);// PEROU
		hitboxes[37].setBounds(480, 720, 50, 50);// ARGENTINE
		hitboxes[38].setBounds(1500, 620, 50, 50);// INDONESIE
		hitboxes[39].setBounds(1700, 550, 50, 50);// NOUVELLE GUINEE
		hitboxes[40].setBounds(1620, 720, 50, 50); // AUSTRALIE DE LOUEST
		hitboxes[41].setBounds(1770, 770, 50, 50); // AUSTRALIE DE LEST

	}

	/**
	 * Attribuer les couleurs en fonction de l'occupant du territoire
	 */
	public void attribuerCouleurs() {
		for (int i = 0; i < risk.listeTerritoires.size(); i++) {
			for (int j = 0; j < risk.listeJoueurs.size(); j++) {
				if (risk.listeTerritoires.get(i).getOccupant().getIdJoueur() == j) {
					hitboxes[i].setIcon(new ImageIcon("Jeton/Jeton" + j + ".png"));
				}
			}
		}
	}

	/**
	 * Verifie si un joueur peut transferer ses unites sur un territoire
	 * 
	 * @return
	 */
	public boolean peutTransferer() {
		if (risk.listeTerritoires.get(ceTerritoire).getOccupant().getIdJoueur() == risk.tour) {
			return true;

		} else {
			return false;
		}
	}

}

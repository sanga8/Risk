package com.beffa.pauwels.risk;

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.Toolkit;
import javax.swing.*;

public class Menu implements MouseListener {

	private JFrame f;

	private JPanel menu;
	private JPanel jeu;

	private JLabel background;
	private JLabel map;

	private boolean verifnom;
	private boolean verifj;

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

	private ArrayList<JLabel> hitboxes;
	
	Risk risk = new Risk();
	public Menu() {
		
		f = new JFrame();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		f.setPreferredSize(d);
		f.setTitle("RISK");
		f.setUndecorated(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(true);

		f.setLayout(null);
		f.setContentPane(menu());
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);

	}

	private JPanel menu() {
		menu = new JPanel();
		menu.setLayout(null);

		// BACKGROUND
		background = new JLabel();
		background.setIcon(new ImageIcon("Images/fondRisk.jpg"));
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

		// COMMENCER
		commencer = new JLabel("");
		commencer.setIcon(new ImageIcon("Images/Commencer.png"));
		commencer.setBounds(850, 900, 220, 147);
		commencer.setVisible(false);
		commencer.addMouseListener(this);
		background.add(commencer);

		// verifnom
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

	private JPanel jeu() {
		jeu = new JPanel();
		jeu.setLayout(null);

		background = new JLabel();
		background.setBounds(0, 0, 1920, 1080);
		background.setIcon(new ImageIcon("Images/fondneutre.jpg"));
		jeu.add(background);
		
		
		cadre = new JLabel();
		cadre.setIcon(new ImageIcon("Images/cadre.png"));
		cadre.setBounds(590, 925, 694, 146);
		background.add(cadre);
		
		// BOUTTONS PLUS ET MOINS
		// RENFORT
		BtnplusSoldatRenfort = new JLabel();
		BtnplusSoldatRenfort.setBounds(250, 23, 35, 35);
		BtnplusSoldatRenfort.setIcon(new ImageIcon("Images/Btnplus.png"));
		cadre.add(BtnplusSoldatRenfort);

		BtnmoinsSoldatRenfort = new JLabel();
		BtnmoinsSoldatRenfort.setBounds(180, 23, 35, 35);
		BtnmoinsSoldatRenfort.setIcon(new ImageIcon("Images/Btnmoins.png"));
		cadre.add(BtnmoinsSoldatRenfort);

		BtnplusCavalierRenfort = new JLabel();
		BtnplusCavalierRenfort.setBounds(250, 63, 35, 35);
		BtnplusCavalierRenfort.setIcon(new ImageIcon("Images/Btnplus.png"));
		cadre.add(BtnplusCavalierRenfort);

		BtnmoinsCavalierRenfort = new JLabel();
		BtnmoinsCavalierRenfort.setBounds(180, 63, 35, 35);
		BtnmoinsCavalierRenfort.setIcon(new ImageIcon("Images/Btnmoins.png"));
		cadre.add(BtnmoinsCavalierRenfort);

		BtnplusCanonRenfort = new JLabel();
		BtnplusCanonRenfort.setBounds(250, 103, 35, 35);
		BtnplusCanonRenfort.setIcon(new ImageIcon("Images/Btnplus.png"));
		cadre.add(BtnplusCanonRenfort);

		BtnmoinsCanonRenfort = new JLabel();
		BtnmoinsCanonRenfort.setBounds(180, 103, 35, 35);
		BtnmoinsCanonRenfort.setIcon(new ImageIcon("Images/Btnmoins.png"));
		cadre.add(BtnmoinsCanonRenfort);

		// TERRITOIRE
		BtnplusSoldatTerritoire = new JLabel();
		BtnplusSoldatTerritoire.setBounds(440, 23, 35, 35);
		BtnplusSoldatTerritoire.setIcon(new ImageIcon("Images/Btnplus.png"));
		cadre.add(BtnplusSoldatTerritoire);

		BtnmoinsSoldatTerritoire = new JLabel();
		BtnmoinsSoldatTerritoire.setBounds(370, 23, 35, 35);
		BtnmoinsSoldatTerritoire.setIcon(new ImageIcon("Images/Btnmoins.png"));
		cadre.add(BtnmoinsSoldatTerritoire);

		BtnplusCavalierTerritoire = new JLabel();
		BtnplusCavalierTerritoire.setBounds(440, 63, 35, 35);
		BtnplusCavalierTerritoire.setIcon(new ImageIcon("Images/Btnplus.png"));
		cadre.add(BtnplusCavalierTerritoire);

		BtnmoinsCavalierTerritoire = new JLabel();
		BtnmoinsCavalierTerritoire.setBounds(370, 63, 35, 35);
		BtnmoinsCavalierTerritoire.setIcon(new ImageIcon("Images/Btnmoins.png"));
		cadre.add(BtnmoinsCavalierTerritoire);

		BtnplusCanonTerritoire = new JLabel();
		BtnplusCanonTerritoire.setBounds(440, 103, 35, 35);
		BtnplusCanonTerritoire.setIcon(new ImageIcon("Images/Btnplus.png"));
		cadre.add(BtnplusCanonTerritoire);

		BtnmoinsCanonTerritoire = new JLabel();
		BtnmoinsCanonTerritoire.setBounds(370, 103, 35, 35);
		BtnmoinsCanonTerritoire.setIcon(new ImageIcon("Images/Btnmoins.png"));
		cadre.add(BtnmoinsCanonTerritoire);

		// ACTION
		BtnplusSoldatAction = new JLabel();
		BtnplusSoldatAction.setBounds(622, 23, 35, 35);
		BtnplusSoldatAction.setIcon(new ImageIcon("Images/Btnplus.png"));
		cadre.add(BtnplusSoldatAction);

		BtnmoinsSoldatAction = new JLabel();
		BtnmoinsSoldatAction.setBounds(552, 23, 35, 35);
		BtnmoinsSoldatAction.setIcon(new ImageIcon("Images/Btnmoins.png"));
		cadre.add(BtnmoinsSoldatAction);

		BtnplusCavalierAction = new JLabel();
		BtnplusCavalierAction.setBounds(622, 63, 35, 35);
		BtnplusCavalierAction.setIcon(new ImageIcon("Images/Btnplus.png"));
		cadre.add(BtnplusCavalierAction);

		BtnmoinsCavalierAction = new JLabel();
		BtnmoinsCavalierAction.setBounds(552, 63, 35, 35);
		BtnmoinsCavalierAction.setIcon(new ImageIcon("Images/Btnmoins.png"));
		cadre.add(BtnmoinsCavalierAction);

		BtnplusCanonAction = new JLabel();
		BtnplusCanonAction.setBounds(622, 103, 35, 35);
		BtnplusCanonAction.setIcon(new ImageIcon("Images/Btnplus.png"));
		cadre.add(BtnplusCanonAction);

		BtnmoinsCanonAction = new JLabel();
		BtnmoinsCanonAction.setBounds(552, 103, 35, 35);
		BtnmoinsCanonAction.setIcon(new ImageIcon("Images/Btnmoins.png"));
		cadre.add(BtnmoinsCanonAction);

		// TEXTFIELD
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
		nom1.setBounds(90, 930, 190, 75);

		nom2 = new JTextArea();
		nom2.setEditable(false);
		nom2.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		nom2.setOpaque(false);
		nom2.setText(joueur2TextField.getText());
		nom2.setBounds(90, 980, 190, 75);

		nom3 = new JTextArea();
		nom3.setEditable(false);
		nom3.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		nom3.setOpaque(false);
		nom3.setText(joueur3TextField.getText());
		nom3.setBounds(90, 1030, 190, 75);

		nom4 = new JTextArea();
		nom4.setEditable(false);
		nom4.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		nom4.setOpaque(false);
		nom4.setText(joueur4TextField.getText());
		nom4.setBounds(270, 930, 190, 75);

		nom5 = new JTextArea();
		nom5.setEditable(false);
		nom5.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		nom5.setOpaque(false);
		nom5.setText(joueur5TextField.getText());
		nom5.setBounds(270, 980, 190, 75);

		nom6 = new JTextArea();
		nom6.setEditable(false);
		nom6.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		nom6.setOpaque(false);
		nom6.setText(joueur6TextField.getText());
		nom6.setBounds(270, 1030, 190, 75);

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
		contour.setIcon(new ImageIcon("Images/contour.png"));
		contour.setBounds(80, 900, 210, 95);
		
		
		
		action = new JLabel();
		action.setBounds(1380, 950, 100, 100);
		action.setIcon(new ImageIcon("Images/action.png"));
		action.addMouseListener(this);
		background.add(action);
		
		mouvement = new JLabel();
		mouvement.setBounds(1580, 950, 100, 100);
		mouvement.setIcon(new ImageIcon("Images/mouvement.png"));
		mouvement.addMouseListener(this);
		background.add(mouvement);
		
		findutour = new JLabel();
		findutour.setBounds(1780, 950, 100, 100);
		findutour.setIcon(new ImageIcon("Images/findutour.png"));
		findutour.addMouseListener(this);
		background.add(findutour);
		
		// CREATION HIBOXES
		hitboxes = new ArrayList<JLabel>();
		for (int i = 0; i < 2; i++) {
			hitboxes.add(new JLabel());
			hitboxes.get(i).setIcon(new ImageIcon("Images/test.png"));
			hitboxes.get(i).addMouseListener(this);
			map.add(hitboxes.get(i));
		}

		hitboxes.get(0).setBounds(1580, 750, 40, 40);
		hitboxes.get(1).setBounds(1780, 750, 40, 40);

		background.add(contour);

		jeu.repaint();
		return jeu;
	}

	public int getNbJoueurs() {
		return nbJoueurs;
	}

	// EVENT MOUSE LISTENER
	@Override
	public void mouseClicked(MouseEvent e) {
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
		if (e.getSource() == close) {
			System.exit(0);
		}
		if (e.getSource() == findutour) {
			risk.finDeTour();
			if (risk.tour == 0) {
				contour.setBounds(80, 900, 210, 95);
			}
			if (risk.tour == 1) {
				contour.setBounds(80, 950, 210, 95);
			}

			if (risk.tour == 2) {
				contour.setBounds(80, 1000, 210, 95);
			}

			if (risk.tour == 3) {
				contour.setBounds(260, 900, 210, 95);
			}

			if (risk.tour == 4) {
				contour.setBounds(260, 950, 210, 95);
			}
			if (risk.tour == 5) {
				contour.setBounds(260, 1000, 210, 95);
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
			verifj(nbJoueurs);

			if (verifj == false) {
				warning.removeAll();
				warning.setText("Choisissez le nombre de joueurs");
				warning.setVisible(true);
				return;
			} else if (verifnom == false) {
				warning.removeAll();
				warning.setText("Réduisez la taille de vos noms");
				warning.setVisible(true);
				return;
			} else {
				f.remove(menu);
				f.setContentPane(jeu());
				f.revalidate();
			}

			if (nbJoueurs == 2) {
				risk.listeJoueurs.add(new Joueur(joueur1TextField.getText(), 1));
				risk.listeJoueurs.add(new Joueur(joueur2TextField.getText(), 2));
			}
			if (nbJoueurs == 3) {
				risk.listeJoueurs.add(new Joueur(joueur1TextField.getText(), 1));
				risk.listeJoueurs.add(new Joueur(joueur2TextField.getText(), 2));
				risk.listeJoueurs.add(new Joueur(joueur3TextField.getText(), 3));
			}
			if (nbJoueurs == 4) {
				risk.listeJoueurs.add(new Joueur(joueur1TextField.getText(), 1));
				risk.listeJoueurs.add(new Joueur(joueur2TextField.getText(), 2));
				risk.listeJoueurs.add(new Joueur(joueur3TextField.getText(), 3));
				risk.listeJoueurs.add(new Joueur(joueur4TextField.getText(), 4));
			}
			if (nbJoueurs == 5) {
				risk.listeJoueurs.add(new Joueur(joueur1TextField.getText(), 1));
				risk.listeJoueurs.add(new Joueur(joueur2TextField.getText(), 2));
				risk.listeJoueurs.add(new Joueur(joueur3TextField.getText(), 3));
				risk.listeJoueurs.add(new Joueur(joueur4TextField.getText(), 4));
				risk.listeJoueurs.add(new Joueur(joueur5TextField.getText(), 5));
			}
			if (nbJoueurs == 6) {
				risk.listeJoueurs.add(new Joueur(joueur1TextField.getText(), 1));
				risk.listeJoueurs.add(new Joueur(joueur2TextField.getText(), 2));
				risk.listeJoueurs.add(new Joueur(joueur3TextField.getText(), 3));
				risk.listeJoueurs.add(new Joueur(joueur4TextField.getText(), 4));
				risk.listeJoueurs.add(new Joueur(joueur5TextField.getText(), 5));
				risk.listeJoueurs.add(new Joueur(joueur6TextField.getText(), 6));
			}
		}
		/*
		 * if (e.getSource() == action) {
		 * 
		 * }
		 * 
		 * // ACTION for (int i = 0; i < 42; i++) { if (e.getSource() ==
		 * hitboxes.get(i)) { for (int j = 0; j < risk.listeJoueurs.size();
		 * j++) { if (risk.listeJoueurs.get(j).getIdJoueur() ==
		 * risk.tour + 1) { for (int h = 0; h < 42; h++) { if
		 * (hitboxes.indexOf(h) ==
		 * risk.listeJoueurs.get(j).getTerritoiresPossedes().indexOf(h)) {
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * } } } } } }
		 */

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
	}

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
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	// VERIFICATIONS
	public boolean verifj(int nj) {
		if (nj < 2) {
			return verifj = false;
		}
		return verifj = true;
	}

	public boolean verifNom(ArrayList<JTextField> j) {
		for (int i = 0; i < j.size(); i++) {
			if (j.get(i).getText().length() >= 10) {
				return verifnom = false;
			}
		}
		return verifnom = true;
	}

}

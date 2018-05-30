package com.beffa.pauwels.risk;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.*;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
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

	private JLabel Btnplus;
	private JLabel Btnmoins;

	private JTextField joueur1TextField;
	private JTextField joueur2TextField;
	private JTextField joueur3TextField;
	private JTextField joueur4TextField;
	private JTextField joueur5TextField;
	private JTextField joueur6TextField;

	private JLabel contour;

	private JTextArea nom1;
	private JTextArea nom2;
	private JTextArea nom3;
	private JTextArea nom4;
	private JTextArea nom5;
	private JTextArea nom6;

	private JTextArea warning;

	private JLabel commencer;

	public Menu() {

		f = new JFrame();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		f.setPreferredSize(d);
		f.setTitle("RISK");
		f.setUndecorated(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);

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

		Btnplus = new JLabel();
		Btnplus.setBounds(480, 960, 35, 35);
		Btnplus.setIcon(new ImageIcon("Images/Btnplus.png"));
		background.add(Btnplus);

		Btnmoins = new JLabel();
		Btnmoins.setBounds(550, 960, 35, 35);
		Btnmoins.setIcon(new ImageIcon("Images/Btnmoins.png"));
		background.add(Btnmoins);

		findutour = new JLabel();
		findutour.setBounds(1780, 950, 100, 100);
		findutour.setIcon(new ImageIcon("Images/findutour.png"));
		findutour.addMouseListener(this);
		background.add(findutour);

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
			Main.risk.finDeTour();
			if (Main.risk.tour == 0) {
				contour.setBounds(80, 900, 210, 95);
			}
			if (Main.risk.tour == 1) {
				contour.setBounds(80, 950, 210, 95);
			}

			if (Main.risk.tour == 2) {
				contour.setBounds(80, 1000, 210, 95);
			}

			if (Main.risk.tour == 3) {
				contour.setBounds(260, 900, 210, 95);
			}

			if (Main.risk.tour == 4) {
				contour.setBounds(260, 950, 210, 95);
			}
			if (Main.risk.tour == 5) {
				contour.setBounds(260, 1000, 210, 95);
			}
		}
		if (e.getSource() == commencer) {

			// verifnomICATION LONGUEUR DES NOMS
			ArrayList<JTextField> j = new ArrayList<JTextField>();
			j.add(joueur1TextField);
			j.add(joueur2TextField);
			j.add(joueur3TextField);
			j.add(joueur4TextField);
			j.add(joueur5TextField);
			j.add(joueur6TextField);

			verifNom(j);
			verifj(nbJoueurs);

			if (nbJoueurs == 2) {

				Main.risk.listeJoueurs.add(new Joueur(j.get(0).getText(), 1));
				Main.risk.listeJoueurs.add(new Joueur(j.get(1).getText(), 2));
			}
			if (nbJoueurs == 3) {
				Main.risk.listeJoueurs.add(new Joueur(joueur1TextField.getText(), 1));
				Main.risk.listeJoueurs.add(new Joueur(joueur2TextField.getText(), 2));
				Main.risk.listeJoueurs.add(new Joueur(joueur3TextField.getText(), 3));
			}
			if (nbJoueurs == 4) {
				Main.risk.listeJoueurs.add(new Joueur(joueur1TextField.getText(), 1));
				Main.risk.listeJoueurs.add(new Joueur(joueur2TextField.getText(), 2));
				Main.risk.listeJoueurs.add(new Joueur(joueur3TextField.getText(), 3));
				Main.risk.listeJoueurs.add(new Joueur(joueur4TextField.getText(), 4));
			}
			if (nbJoueurs == 5) {

				Main.risk.listeJoueurs.add(new Joueur(joueur1TextField.getText(), 1));
				Main.risk.listeJoueurs.add(new Joueur(joueur2TextField.getText(), 2));
				Main.risk.listeJoueurs.add(new Joueur(joueur3TextField.getText(), 3));
				Main.risk.listeJoueurs.add(new Joueur(joueur4TextField.getText(), 4));
				Main.risk.listeJoueurs.add(new Joueur(joueur5TextField.getText(), 5));
			}
			if (nbJoueurs == 6) {
				Main.risk.listeJoueurs.add(new Joueur(joueur1TextField.getText(), 1));
				Main.risk.listeJoueurs.add(new Joueur(joueur2TextField.getText(), 2));
				Main.risk.listeJoueurs.add(new Joueur(joueur3TextField.getText(), 3));
				Main.risk.listeJoueurs.add(new Joueur(joueur4TextField.getText(), 4));
				Main.risk.listeJoueurs.add(new Joueur(joueur5TextField.getText(), 5));
				Main.risk.listeJoueurs.add(new Joueur(joueur6TextField.getText(), 6));
			}

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

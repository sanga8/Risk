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

import javax.imageio.ImageIO;
import javax.swing.*;

public class Menu implements MouseListener {
	private JFrame f;

	private JPanel menu;
	private JPanel jeu;

	private JLabel background;
	private JLabel map;

	int nbJoueurs;

	private JLabel jouer;
	private JLabel close;

	private JLabel deuxJ;
	private JLabel troisJ;
	private JLabel quatreJ;
	private JLabel cinqJ;
	private JLabel sixJ;

	private JTextField joueur1TextField;
	private JTextField joueur2TextField;
	private JTextField joueur3TextField;
	private JTextField joueur4TextField;
	private JTextField joueur5TextField;
	private JTextField joueur6TextField;

	private JLabel go;

	public Menu() {

		f = new JFrame();
		f.setTitle("RISK");
		f.setUndecorated(true);
		f.setPreferredSize(new Dimension(1920, 1080));
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
		background.setIcon(new ImageIcon("Images/Fond.png"));

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
		joueur1TextField = new JTextField("Arthas Menethil");
		joueur2TextField = new JTextField("Joueur 2");
		joueur3TextField = new JTextField("Joueur 3");
		joueur4TextField = new JTextField("Joueur 4");
		joueur5TextField = new JTextField("Joueur 5");
		joueur6TextField = new JTextField("Joueur 6");
		joueur1TextField.setBounds(750, 600, 190, 75);
		joueur2TextField.setBounds(750, 700, 190, 75);
		joueur3TextField.setBounds(750, 800, 190, 75);
		joueur4TextField.setBounds(1000, 600, 190, 75);
		joueur5TextField.setBounds(1000, 700, 190, 75);
		joueur6TextField.setBounds(1000, 800, 190, 75);
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

		go = new JLabel("");
		go.setIcon(new ImageIcon("Images/Commencer.png"));
		go.setBounds(830, 850, 350, 224);
		go.setVisible(false);
		go.addMouseListener(this);
		background.add(go);

		menu.add(background);
		return menu;
	}
	
	private JPanel jeu() {
		jeu = new JPanel();
		
		//background = new JLabel();
		//background.setBounds(0, 0, 1920, 1080);
		//background.setIcon(new ImageIcon("Images/Fond.png"));
		//jeu.add(background);
		
		map = new JLabel();
		map.setBounds(20, 20, 1920, 880);
		map.setIcon(new ImageIcon("Images/map.jpg"));
		jeu.add(map);
		
		System.out.println("CHARGEMENT DU JEU");

		return jeu;
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
			go.setVisible(true);
			jouer.setVisible(false);
			close.setVisible(false);
		}
		if (e.getSource() == close) {
			System.exit(0);
		}
		if (e.getSource() == go) {
			f.remove(menu);
			f.setContentPane(jeu());
			f.revalidate();
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

}

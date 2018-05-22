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
	

	private JLabel background;

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
		
		background.setBounds(0, 0, 1920 , 1080);

		// BOUTON JOUER
		jouer = new JLabel();
		jouer.setIcon(new ImageIcon("Images/Jouer.png"));
		jouer.setBounds(780, 350, 350, 224);
		jouer.addMouseListener(this);
		menu.add(jouer);

		// BOUTON QUITTER
		close = new JLabel();
		close.setBounds(780, 650, 350, 224);
		close.setIcon(new ImageIcon("Images/Quitter.png"));
		close.addMouseListener(this);
		menu.add(close);

		

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
		
		menu.add(deuxJ);
		menu.add(troisJ);
		menu.add(quatreJ);
		menu.add(cinqJ);
		menu.add(sixJ);

		deuxJ.addMouseListener(this);
		troisJ.addMouseListener(this);
		quatreJ.addMouseListener(this);
		cinqJ.addMouseListener(this);
		sixJ.addMouseListener(this);

		// NOMS DES JOUEURS
		joueur1TextField = new JTextField(" Joueur 1 ");
		joueur2TextField = new JTextField(" Joueur 2 ");
		joueur3TextField = new JTextField(" Joueur 3 ");
		joueur4TextField = new JTextField(" Joueur 4 ");
		joueur5TextField = new JTextField(" Joueur 5 ");
		joueur6TextField = new JTextField(" Joueur 6 ");
		joueur1TextField.setVisible(false);
		joueur2TextField.setVisible(false);
		joueur3TextField.setVisible(false);
		joueur4TextField.setVisible(false);
		joueur5TextField.setVisible(false);
		joueur6TextField.setVisible(false);
		menu.add(joueur1TextField);
		menu.add(joueur2TextField);
		menu.add(joueur3TextField);
		menu.add(joueur4TextField);
		menu.add(joueur5TextField);
		menu.add(joueur6TextField);
		
		menu.add(background);
		return menu;
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
			
			jouer.setVisible(false);
			close.setVisible(false);
		}
		if (e.getSource() == close) {
			System.exit(0);
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

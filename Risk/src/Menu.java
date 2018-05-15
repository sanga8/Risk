import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu extends JFrame{
	
  private JButton jouer; 
  private JComboBox combo;
  private String[] nbjoueurs = { "Deux joueurs", "Trois joueurs" , "Quatre joueurs", "Cinq joueurs", "Six joueurs"};

  private JTextField joueur1TextField;
  private JTextField joueur2TextField;
  private JTextField joueur3TextField;
  private JTextField joueur4TextField;
  private JTextField joueur5TextField;
  private JTextField joueur6TextField;
  
  
  public Menu(){
	
	  setTitle("RISK");
	  setPreferredSize(new Dimension(300, 100));
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setLocationRelativeTo(null);
	  setResizable(false);
		
	  add(nbJoueurs());
	  
	 
	  
	  
	  pack();
	  setVisible(true);
	  
	}
  

  private JPanel nbJoueurs(){

		JPanel nbJoueurs = new JPanel();
		
		combo = new JComboBox(nbjoueurs);
		jouer = new JButton("Jouer");
		
		
		
		nbJoueurs.add(combo);	
		nbJoueurs.add(jouer);
		
		
		
		
		
		return nbJoueurs;  	
  }
  
  private JPanel nomJoueurs(){
	  
	  	JPanel nomJoueurs = new JPanel();
		nomJoueurs.setPreferredSize(new Dimension(300,300));
		
	
		if ( combo.getSelectedItem() == combo.getItemAt(0) ) {
			joueur3TextField = new JTextField("William");
			nomJoueurs.add(joueur3TextField);
		}
		if (combo.getSelectedItem() == combo.getItemAt(1)) {
			joueur4TextField = new JTextField("Georgy");
			nomJoueurs.add(joueur4TextField);
		}
		if (combo.getSelectedItem() == combo.getItemAt(2)) {
			joueur5TextField = new JTextField("Cyrus");
			nomJoueurs.add(joueur5TextField);
		}
		if (combo.getSelectedItem() == combo.getItemAt(3)) {
			joueur6TextField = new JTextField("Cyrus");
			nomJoueurs.add(joueur6TextField);
		}

	
		return nomJoueurs;
	  
  }

	
  public void actionPerformed(ActionEvent e) {
	  
}
  
  
  
  
  
  
  
  
  
  
  
  
  
}
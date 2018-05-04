import java.awt.GridLayout;

import javax.swing.*;

public class Menu extends JFrame{
	
  private JButton bouton = new JButton("Jouer !");  
  String[] nbjoueurs = {"Deux joueurs", "Trois joueurs", "Quatre joueurs", "Cinq joueurs"};
  private JComboBox combo = new JComboBox(nbjoueurs);
  
  GridLayout GL = new GridLayout (2,1);
  
  public Menu(){
	  
	JPanel pan = new JPanel();  
	  
    this.setTitle("Risk");
    this.setSize(300, 100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    
    this.setLayout(GL);  
    this.setContentPane(pan);
    
    pan.add(combo);
    pan.add(bouton);
    
   
    
    this.setVisible(true);
    
    
  }      
}
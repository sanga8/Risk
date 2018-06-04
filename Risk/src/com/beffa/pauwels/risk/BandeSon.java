package com.beffa.pauwels.risk;

import java.applet.Applet;
import java.applet.AudioClip;

import javax.print.DocFlavor.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BandeSon {
	
public void MusiqueMenu(){
	
	java.net.URL url = Main.class.getResource("Sons/AOE3_Theme.wav");
	
    final AudioClip clip = Applet.newAudioClip(url);
    clip.play();

		
	}
	public void StopMusique(){
		java.net.URL url = Menu.class.getResource("AOE3_Theme.WAV");
		
	    final AudioClip clip = Applet.newAudioClip(url);
	    clip.stop();
		
	}
	

}

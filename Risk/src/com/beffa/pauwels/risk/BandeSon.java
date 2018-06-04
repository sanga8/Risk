package com.beffa.pauwels.risk;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class BandeSon{
	
	public static void main(String[] args) {
		File Clap = new File("Sons/AOE3_Theme.wav");
		PlaySound(Clap);
	}

	public static void PlaySound(File Sound) {
        try {
        	Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();


        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

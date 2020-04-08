package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015
public class _06_IPodShuffle implements ActionListener{
	
	ArrayList<Song> songs = new ArrayList<Song>();
	
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		Song demoSong = new Song("demo.mp3");
		songs.add(demoSong);
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton();
		
		panel.add(button);
		frame.add(panel);
		button.setText("Surprise Me!");
		button.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Ipod shuffle");
		frame.pack();
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
		System.out.println(args);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < songs.size(); i++) {
			songs.get(i).stop();
		}
		Random randy = new Random();
		int songPlay = randy.nextInt(songs.size());
		songs.get(songPlay).play();
		
	}
}
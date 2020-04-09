package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	
	JFrame frame = new JFrame("THE MAN THAT HANGS");
	JPanel panel = new JPanel();
	JLabel lifesOut = new JLabel();
	JLabel wordOut = new JLabel();
	int lifes = 5;
	String word;
	String lines;
	Stack<String> words = new Stack<String>();
	Utilities utis = new Utilities();
	ArrayList<Character> wordList = new ArrayList<Character>();
	
	void runOnce() {
		panel.add(lifesOut);
		panel.add(wordOut);
		frame.add(panel);
		frame.setVisible(true);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
		run();
	}
	
	void run() {
		lifes = 5;
		words = new Stack<String>();
		
		int numOfWords = Integer.parseInt(JOptionPane.showInputDialog("Enter number of words: "));
		for (int i = 0; i < numOfWords; i++) {
			boolean gotWord = false;
			while (!gotWord) {
				String a = utis.readRandomLineFromFile("dictionary.txt");
				if (!words.contains(a)) {
					gotWord = true;
					words.push(a);
				}
			}
			
		}
		
		word = words.pop();
		lines = "";
		for (int i = 0; i < word.length(); i++) {
			lines = lines + "_";
		}
		wordOut.setText(" Word: " + lines);
		lifesOut.setText("Lifes: " + lifes);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char keyVal = e.getKeyChar();
		wordList = new ArrayList<Character>();
		for (int i = 0; i < word.length(); i++) {
			wordList.add(word.charAt(i));
		}
		if (wordList.indexOf(keyVal) == -1) {
			lifes = lifes - 1;
			lifesOut.setText("Lifes: " + lifes);
		}
		else {
			while (wordList.indexOf(keyVal) != -1) {
				wordList.set(wordList.indexOf(keyVal), '_');
				lines = lines.substring(0, wordList.indexOf(keyVal) - 1) + keyVal + lines.substring(wordList.indexOf(keyVal) + 1);
				wordOut.setText(" Word: " + lines);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

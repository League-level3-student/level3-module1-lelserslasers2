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
	ArrayList<Character> inverseWordList = new ArrayList<Character>();
	int numOfWords;
	boolean gameReapeat = true;
	boolean newWord = true;
	boolean lockA = false;
	boolean lockB = false;
	
	void runOnce() {
		panel.add(lifesOut);
		panel.add(wordOut);
		frame.add(panel);
		frame.setVisible(true);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
		runPerGame();
	}
	
	void runPerGame() {
		while (gameReapeat) {
		lifes = 5;
		words = new Stack<String>();
		
		numOfWords = Integer.parseInt(JOptionPane.showInputDialog("Enter number of words: "));
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
		
		runPerWord();
		
		lockA = true;
		while (lockA) {
			//System.out.print("!");
		}
		
		String a = JOptionPane.showInputDialog("Play again? (y/n)");
		if (a == "n") {
			gameReapeat = false;
		}
		}
	}
	
	void runPerWord() {
		for (int u = 0; u < words.size(); u++) {
			frame.pack();
			lifes = 5;
			inverseWordList = new ArrayList<Character>();
			
			word = words.pop();
			lines = "";
			for (int i = 0; i < word.length(); i++) {
				lines = lines + "_";
				inverseWordList.add('_');
			}
			lines = inverseWordList.toString();
			wordOut.setText(" Word: " + lines);
			lifesOut.setText("Lifes: " + lifes);
			frame.pack();
		
			for (int i = 0; i < word.length(); i++) {
				wordList.add(word.charAt(i));
			}
			lockB = true;
			while (lockB) {
				//System.out.print(".");
			}
		}
		lockA = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char keyVal = e.getKeyChar();
		if (wordList.indexOf(keyVal) == -1) {
			lifes = lifes - 1;
			lifesOut.setText("Lifes: " + lifes);
			 
			if (lifes < 1) {
				System.out.println("YOU LOSE!");
				JOptionPane.showMessageDialog(null, "YOU LOSE");
				lockB = false;
				
			}
		}
		else {
			
			while (wordList.indexOf(keyVal) != -1) {
				inverseWordList.set(wordList.indexOf(keyVal), keyVal);
				wordList.set(wordList.indexOf(keyVal), '_');
				
				lines = inverseWordList.toString();
				wordOut.setText(" Word: " + lines);
			}
			
		}
		
		if (!inverseWordList.contains('_')) {
			System.out.println("YOU WIN");
			JOptionPane.showMessageDialog(null, "YOU WIN");
			lockB = false;
		}
		
		frame.pack();
		
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

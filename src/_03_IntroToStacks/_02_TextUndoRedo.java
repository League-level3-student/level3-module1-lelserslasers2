package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	
	JFrame frame = new JFrame("STAK-ED");
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<String> undoList = new Stack<String>();
	
	
	void run() {
		panel.add(label);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(this);
		frame.pack();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if ((e.getKeyCode() == KeyEvent.VK_BACK_SPACE)) {
			if (label.getText().length() > 0) {
				undoList.push(label.getText().substring(label.getText().length() - 1, label.getText().length()));
				label.setText(label.getText().substring(0, label.getText().length() - 1));
			}
		}
		else if(e.getKeyChar() == '`') {
			if(undoList.size() > 0) {
				String popVal = undoList.pop();
				label.setText(label.getText() + popVal);
			}
		}
		else {
			label.setText(label.getText() + e.getKeyChar());
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

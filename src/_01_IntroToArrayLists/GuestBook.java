package _01_IntroToArrayLists;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuestBook implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addBut = new JButton();
	JButton viewBut = new JButton();
	ArrayList<String> names = new ArrayList<String>(0);
	
	void run() {
		
	
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
		addBut.setText("Add Name");
		viewBut.setText("View Names");
		addBut.addActionListener(this);
		viewBut.addActionListener(this);
		
		frame.setTitle("The Book of Guests");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
		
		panel.add(addBut);
		panel.add(viewBut);
		frame.add(panel);
		frame.pack();
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton pressed = (JButton)e.getSource();
		if(pressed == addBut) {
			names.add(JOptionPane.showInputDialog("Enter new Guest name: "));
		}
		else {
			JFrame disFrame = new JFrame();
			JPanel disPanel = new JPanel();
			JLabel disLabel = new JLabel();
			String guestList = "Guests:";
			
			disFrame.setTitle("Guest List");
			disFrame.setVisible(true);
			
			for (int i = 0; i < names.size(); i++) {
				guestList = guestList + " " + names.get(i);
				if(i + 1 == names.size()) {
					guestList = guestList + ".";
				}
				else if(i + 2 == names.size()) {
					guestList = guestList + ", and";
				}
				else {
					guestList = guestList + ",";
				}
			}
			
			disLabel.setText(guestList);
			
			disPanel.add(disLabel);
			disFrame.add(disPanel);
			disFrame.pack();
			//JOptionPane.showMessageDialog(null, "Guests: " + names);
		}
		
	}
}

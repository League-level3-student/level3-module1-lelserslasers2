package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * 
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	
	HashMap<Integer, String> log = new HashMap<Integer, String>();
	JFrame frame = new JFrame("Search That Log");
	JPanel panel = new JPanel();
	JButton addEntry = new JButton();
	JButton searchID = new JButton();
	JButton viewList = new JButton();
	JButton removeEntry = new JButton();
	
	void run() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addEntry.setText("Add Entry");
		searchID.setText("Search by ID");
		viewList.setText("View All");
		removeEntry.setText("Remove Entry");
		
		addEntry.addActionListener(this);
		searchID.addActionListener(this);
		viewList.addActionListener(this);
		removeEntry.addActionListener(this);
		
		panel.add(addEntry);
		panel.add(searchID);
		panel.add(viewList);
		panel.add(removeEntry);
		frame.add(panel);
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		JButton buttonClicked = (JButton)event.getSource();
		
		if (buttonClicked == addEntry) {
			int a = Integer.parseInt(JOptionPane.showInputDialog("Enter ID: "));
			String b = JOptionPane.showInputDialog("Enter name for ID: " + a);
			log.put(a, b);
			JOptionPane.showMessageDialog(null, "Sucsesfully added " + b + " with an ID of " + a);
			System.out.println("Sucsesfully added " + b + " with an ID of " + a);
		}
		else if (buttonClicked == searchID) {
			int a = Integer.parseInt(JOptionPane.showInputDialog("Enter ID number to search for: "));
			String b = log.get(a);
			if (b != null) {
				JOptionPane.showMessageDialog(null, "ID: " + a + " Name: " + b);
				System.out.println("ID: " + a + " Name: " + b);
			}
			else {
				JOptionPane.showMessageDialog(null, "There is no user with an ID of " + a);
				System.out.println("There is no user with an ID of " + a);
			}
		}
		else if (buttonClicked == viewList) {
			System.out.println("");
			for(Integer i : log.keySet()) {
				System.out.println("ID: " + i + " Name: " + log.get(i));
			}
		}
		else if (buttonClicked == removeEntry) {
			int a = Integer.parseInt(JOptionPane.showInputDialog("Enter ID number to remove: "));
			String b = log.get(a);
			if (b != null) {
				log.remove(a);
				JOptionPane.showMessageDialog(null, "Sucsesfully removed " + b + " with an ID of " + a);
				System.out.println("Sucsesfully removed " + b + " with an ID of " + a);
			}
			else {
				JOptionPane.showMessageDialog(null, "There is no user with an ID of " + a);
				System.out.println("There is no user with an ID of " + a);
			}
		}
		else {
			System.out.println("ALERT");
			System.out.println("ALERT");
			System.out.println("ALERT: WE HAVE A ROGUE BUTTON");
			System.out.println("ALERT");
			System.out.println("THE BUTTON MAY BE ARMED");
		}
		
	}
	
}

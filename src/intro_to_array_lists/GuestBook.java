package intro_to_array_lists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names".
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton nameButton = new JButton("Add Name");
	JButton viewButton = new JButton("View Names");
	JTextArea textField = new JTextArea(1, 40);
	ArrayList<String> names = new ArrayList<String>();
	
	public static void main(String[] args) {
		new GuestBook().start();
	}
	
	public void start() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		frame.setTitle("Guest book");
		
		panel.add(nameButton);
		panel.add(viewButton);
		nameButton.addActionListener(this);
		viewButton.addActionListener(this);
		
		panel.add(textField);
		textField.setText("<descripton field>");
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clickedButton = (JButton)e.getSource();
		
		if( clickedButton == nameButton ) {
			String newName = JOptionPane.showInputDialog("Please enter a name: ");
			names.add(newName);
			textField.setText("Added name: " + newName);
		} else if( clickedButton == viewButton ) {
			String namesList = "";
			
			if( names.size() <= 0 ) {
				namesList = "There are no guests.";
			} else {
			
				for( int i = 1; i <= names.size(); ++i ) {
					namesList += "Guest #" + i + ": " + names.get(i - 1);
					if( i != names.size() ) {
						namesList += "\n";
					}
				}
			}

			textField.setText(namesList);
			System.out.println(namesList);
			frame.pack();
		}
	}
	
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
}

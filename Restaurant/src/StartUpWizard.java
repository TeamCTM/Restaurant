

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class StartUpWizard {
	public static void main(String[] args){
		String first_name;
		first_name=JOptionPane.showInputDialog("First Name");
		
	
		String restaurant_name;
		restaurant_name=JOptionPane.showInputDialog("Restaurant Name");
			
		String sentence;
		sentence="Hello, "+first_name+". Welcome to Restaurant Genie! "
		+ "I look forward to helping you make "+restaurant_name+" a "
		+ "successful business! Click 'OK' to get started!";
		
		JOptionPane.showMessageDialog(null, sentence);
		System.exit(0);
	}
}

 
         

import static org.junit.Assert.*;

import org.junit.Test;
public class JUnitTest {
	Main main = new Main();
	//float testSum=(float) 13.19; //10.99
	@Test
	public void testUserInput() {
		
		main.main(null); //load GUI
        
		//Tests the user input is only an alphanumeric string
        String rex = "^[a-zA-Z0-9]*$";
        assertTrue("First Name contains invalid characters (0-9, A-Z)", main._firstName.matches(rex));
        assertTrue("Resturant Name contains invalid characters (0-9, A-Z)", main._resturantName.matches(rex));
        
        //add square table to panel and tests that it is showing
        Table newTable = new Table(400,400);
		Main.frame.getContentPane().add(newTable);
		assertTrue("Sqaure table failed to show", newTable.isShowing());
		
		//add square table to panel and tests that it is showing
        CircleTable circleTable = new CircleTable();
		Main.frame.getContentPane().add(circleTable);
		assertTrue("Circle table failed to show", circleTable.isShowing());
	}

}

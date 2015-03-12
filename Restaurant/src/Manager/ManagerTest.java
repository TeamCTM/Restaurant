package Manager;

import static org.junit.Assert.*;

import org.junit.Test;

public class ManagerTest {
	ManagerAction managerAction=new ManagerAction();
	
	float sum = managerAction.Calculate(managerAction.userInput); 
	float testSum=(float) 13.19; //10.99
	@Test
	public void testSum() {
		 assertEquals(sum, testSum, 0.01);
	}

}

package Manager;
import javax.swing.JOptionPane;
import java.util.Scanner;


public class ManagerAction {
	
	private int _total;
	private int _tax;
	private int _bill,_tip;
	private String _customerName,_familyName;
	
	public static void main(String args[]){
		

		
	Scanner user_input=new Scanner(System.in);
	int _total;
	_total=user_input.next();
	String _familyName;
	

	}
	
	
	
	
	


	
	public void calculateBill(){
		
		_bill=_tax+_total;
		_tip= (int) (_bill * (0.2));
		System.out.println("The total is: " +_bill);
		System.out.println("The suggested tip is: " +_tip);
				
		JOptionPane.showMessageDialog ( 
				   null, "Put your message here" );
		
	}
}


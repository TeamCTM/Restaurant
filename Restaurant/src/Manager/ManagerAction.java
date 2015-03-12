package Manager;
import javax.swing.JOptionPane;

import java.util.Scanner;


public class ManagerAction {
	
	public float userInput;
	public static void main(String args[]){
		/*
	Scanner user_input=new Scanner(System.in);
	String _total;
	_total= user_input.next();
	String _familyName;
	*/
		
		/*
	_bill=_tax + _total;
	
	_tip= (int) (_bill * (0.2));
	System.out.println("The total is: " +_bill);
	System.out.println("The suggested tip is: " +_tip);
			
	JOptionPane.showMessageDialog ( 
			   null, "Put your message here" );
	
	*/
		
	//	String total = JOptionPane.showInputDialog(null  ,"What is the total?:");

	}
	public ManagerAction()
	{
	 	String input = "";
        
        String rex = "^(?:\\d+|\\d{1,3}(?:,\\d{1,3})*)(?:\\.\\d{2})?$"; //"^[1-9]\\d*$";
       
        do{
         input = JOptionPane.showInputDialog(null  ,"What is the total?:");
        }while(!input.matches(rex));
        
        userInput = Float.parseFloat(input);
	}
	
	public float Calculate(float beforeTax)
	{
        
         float total = (float)(beforeTax + (beforeTax * 0.2));
        // System.out.println(total);
         
         return total;
	}
}


package Guis;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MenuWizard {



	public class Menu {

		private JFrame frame;
		private JPanel panelMenu;
		private JPanel panelBreakfast;
		private JPanel panelLunch;
		private JPanel panelDinner;
		private JPanel panelDessert;
		private JPanel panelDrinks;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;
		private JTextField textField_5;
		private JTextField textField_6;
		private JTextField textField_7;
		private JTextField textField_8;
		private JTextField textField_9;
		private JTextField textField_10;
		private JTextField textField_11;
		private JTextField textField_12;
		private JTextField textField_13;
		private JTextField textField_14;
		private JTextField textField_15;
		private JTextField textField_16;
		private JTextField textField_17;
		private JTextField textField_18;
		private JTextField textField_19;
		
		/**
		 * Launch the application.
		 */
		public void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Menu window = new Menu();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public Menu() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(new CardLayout(0, 0));
			
			final JPanel panelMenu = new JPanel();
			panelMenu.setLayout(null);
			panelMenu.setVisible(true);
			frame.getContentPane().add(panelMenu, "name_5760109625776");
			
			final JPanel panelBreakfast = new JPanel();
			panelBreakfast.setLayout(null);
			frame.getContentPane().add(panelBreakfast, "name_5760509930983");
			panelBreakfast.setVisible(false);
			
			final JPanel panelLunch = new JPanel();
			panelLunch.setLayout(null);
			frame.getContentPane().add(panelLunch, "name_5761133772477");
			panelLunch.setVisible(false);
			
			final JPanel panelDinner = new JPanel();
			panelDinner.setLayout(null);
			frame.getContentPane().add(panelDinner, "name_5761884836569");
			panelDinner.setVisible(false);
			
			final JPanel panelDessert = new JPanel();
			panelDessert.setLayout(null);
			frame.getContentPane().add(panelDessert, "name_5762768791392");
			panelDessert.setVisible(false);
			
			final JPanel panelDrinks = new JPanel();
			panelDrinks.setLayout(null);
			frame.getContentPane().add(panelDrinks, "name_5763918764729");
			panelDrinks.setVisible(false);
			
			
			
			JLabel label = new JLabel("Welcome to Menu Builder");
			label.setBounds(134, 11, 290, 14);
			panelMenu.add(label);
			
			JLabel label_1 = new JLabel("Create a Menu for the following categories: ");
			label_1.setBounds(89, 24, 321, 14);
			panelMenu.add(label_1);
			
			JButton button = new JButton("Breakfast");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelBreakfast.setVisible(true);

					panelMenu.setVisible(false);
				}
			});
			button.setBounds(165, 60, 89, 23);
			panelMenu.add(button);
			
			JButton button_1 = new JButton("Lunch");
			button_1.setBounds(165, 94, 89, 23);
			panelMenu.add(button_1);
			
			JButton button_2 = new JButton("Dinner");
			button_2.setBounds(165, 128, 89, 23);
			panelMenu.add(button_2);
			
			JButton button_3 = new JButton("Dessert");
			button_3.setBounds(165, 162, 89, 23);
			panelMenu.add(button_3);
			
			JButton button_4 = new JButton("Drinks");
			button_4.setBounds(165, 196, 89, 23);
			panelMenu.add(button_4);
			
			
			
			JLabel label_2 = new JLabel("Breakfast Items");
			label_2.setBounds(162, 11, 96, 14);
			panelBreakfast.add(label_2);
			
			JLabel label_3 = new JLabel("Name ");
			label_3.setBounds(21, 49, 46, 14);
			panelBreakfast.add(label_3);
			
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(21, 69, 247, 20);
			panelBreakfast.add(textField);
			
			JLabel label_4 = new JLabel("Price");
			label_4.setBounds(326, 49, 46, 14);
			panelBreakfast.add(label_4);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(291, 69, 61, 20);
			panelBreakfast.add(textField_1);
			
			JButton button_5 = new JButton("Add");
			button_5.setBounds(362, 99, 55, 23);
			panelBreakfast.add(button_5);
			
			JButton button_6 = new JButton("Done");
			button_6.setBounds(174, 193, 89, 23);
			panelBreakfast.add(button_6);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(21, 100, 247, 20);
			panelBreakfast.add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(291, 100, 61, 20);
			panelBreakfast.add(textField_3);
			
			
			JLabel label_5 = new JLabel("Lunch Items");
			label_5.setBounds(162, 11, 96, 14);
			panelLunch.add(label_5);
			
			JLabel label_6 = new JLabel("Name ");
			label_6.setBounds(21, 49, 46, 14);
			panelLunch.add(label_6);
			
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(21, 69, 247, 20);
			panelLunch.add(textField_4);
			
			JLabel label_7 = new JLabel("Price");
			label_7.setBounds(326, 49, 46, 14);
			panelLunch.add(label_7);
			
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(291, 69, 61, 20);
			panelLunch.add(textField_5);
			
			JButton button_7 = new JButton("Add");
			button_7.setBounds(362, 99, 55, 23);
			panelLunch.add(button_7);
			
			JButton button_8 = new JButton("Done");
			button_8.setBounds(174, 193, 89, 23);
			panelLunch.add(button_8);
			
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(21, 100, 247, 20);
			panelLunch.add(textField_6);
			
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(291, 100, 61, 20);
			panelLunch.add(textField_7);
			
			
			
			JLabel label_8 = new JLabel("Dinner Items");
			label_8.setBounds(162, 11, 96, 14);
			panelDinner.add(label_8);
			
			JLabel label_9 = new JLabel("Name ");
			label_9.setBounds(21, 49, 46, 14);
			panelDinner.add(label_9);
			
			textField_8 = new JTextField();
			textField_8.setColumns(10);
			textField_8.setBounds(21, 69, 247, 20);
			panelDinner.add(textField_8);
			
			JLabel label_10 = new JLabel("Price");
			label_10.setBounds(326, 49, 46, 14);
			panelDinner.add(label_10);
			
			textField_9 = new JTextField();
			textField_9.setColumns(10);
			textField_9.setBounds(291, 69, 61, 20);
			panelDinner.add(textField_9);
			
			JButton button_9 = new JButton("Add");
			button_9.setBounds(362, 99, 55, 23);
			panelDinner.add(button_9);
			
			JButton button_10 = new JButton("Done");
			button_10.setBounds(174, 193, 89, 23);
			panelDinner.add(button_10);
			
			textField_10 = new JTextField();
			textField_10.setColumns(10);
			textField_10.setBounds(21, 100, 247, 20);
			panelDinner.add(textField_10);
			
			textField_11 = new JTextField();
			textField_11.setColumns(10);
			textField_11.setBounds(291, 100, 61, 20);
			panelDinner.add(textField_11);
			
			
			
			JLabel label_11 = new JLabel("Dessert Items");
			label_11.setBounds(162, 11, 96, 14);
			panelDessert.add(label_11);
			
			JLabel label_12 = new JLabel("Name ");
			label_12.setBounds(21, 49, 46, 14);
			panelDessert.add(label_12);
			
			textField_12 = new JTextField();
			textField_12.setColumns(10);
			textField_12.setBounds(21, 69, 247, 20);
			panelDessert.add(textField_12);
			
			JLabel label_13 = new JLabel("Price");
			label_13.setBounds(326, 49, 46, 14);
			panelDessert.add(label_13);
			
			textField_13 = new JTextField();
			textField_13.setColumns(10);
			textField_13.setBounds(291, 69, 61, 20);
			panelDessert.add(textField_13);
			
			JButton button_11 = new JButton("Add");
			button_11.setBounds(362, 99, 55, 23);
			panelDessert.add(button_11);
			
			JButton button_12 = new JButton("Done");
			button_12.setBounds(174, 193, 89, 23);
			panelDessert.add(button_12);
			
			textField_14 = new JTextField();
			textField_14.setColumns(10);
			textField_14.setBounds(21, 100, 247, 20);
			panelDessert.add(textField_14);
			
			textField_15 = new JTextField();
			textField_15.setColumns(10);
			textField_15.setBounds(291, 100, 61, 20);
			panelDessert.add(textField_15);
			
			
			JLabel lblDrinkItems = new JLabel("Drink Items");
			lblDrinkItems.setBounds(162, 11, 96, 14);
			panelDrinks.add(lblDrinkItems);
			
			JLabel label_15 = new JLabel("Name ");
			label_15.setBounds(21, 49, 46, 14);
			panelDrinks.add(label_15);
			
			textField_16 = new JTextField();
			textField_16.setColumns(10);
			textField_16.setBounds(21, 69, 247, 20);
			panelDrinks.add(textField_16);
			
			JLabel label_16 = new JLabel("Price");
			label_16.setBounds(326, 49, 46, 14);
			panelDrinks.add(label_16);
			
			textField_17 = new JTextField();
			textField_17.setColumns(10);
			textField_17.setBounds(291, 69, 61, 20);
			panelDrinks.add(textField_17);
			
			JButton button_13 = new JButton("Add");
			button_13.setBounds(362, 99, 55, 23);
			panelDrinks.add(button_13);
			
			JButton button_14 = new JButton("Done");
			button_14.setBounds(174, 193, 89, 23);
			panelDrinks.add(button_14);
			
			textField_18 = new JTextField();
			textField_18.setColumns(10);
			textField_18.setBounds(21, 100, 247, 20);
			panelDrinks.add(textField_18);
			
			textField_19 = new JTextField();
			textField_19.setColumns(10);
			textField_19.setBounds(291, 100, 61, 20);
			panelDrinks.add(textField_19);
		}

	}
}

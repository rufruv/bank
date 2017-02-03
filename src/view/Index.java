package view;

import javax.swing.JOptionPane;
import enums.ButtIndex2;
import controller.CustomerController;
import controller.AdminController;

public class Index {
	
	public static void main(String[] args) {
		ButtIndex2[] buttons = {ButtIndex2.CLOSE,ButtIndex2.MEMBER,ButtIndex2.ADMIN};
		ButtIndex2 select = (ButtIndex2)JOptionPane.showInputDialog(
					null,
					"INDEX PAGE",
					"SELECT INDEX MENU",  // order
					JOptionPane.QUESTION_MESSAGE,  // type
					null,  // icon
					buttons, // Array of choice
					buttons[0] // default
					);
			
			switch(select){
			case CLOSE:return;
			case MEMBER: new CustomerController().start(); break;
			case ADMIN: new AdminController().start(); break;
			}
		}		
	}


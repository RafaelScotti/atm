package ui;

import java.util.ArrayList;
import atm.IKeypad;
import atm.Keypad;

public class MainMenu implements Menu {

	private IKeypad keypad = new Keypad();
	ArrayList<String> mainMenuList = new ArrayList<>();
	
	
	public MainMenu() {

		mainMenuList.add("View my balance");
		mainMenuList.add("Withdraw cash");
		mainMenuList.add("Deposit funds");
		mainMenuList.add("Exit");
	}
	
	@Override
	public int show() {
		System.out.println("\n-----Main menu-----");
		for(int i = 1; i <= mainMenuList.size(); i++) {
			System.out.println(i + " - " + mainMenuList.get(i-1));
		}
		System.out.println("Enter a choice: ");
		int op = keypad.getInput();
		return op;
	}

	@Override
	public void addItem(String title) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeItem(String title) {
		// TODO Auto-generated method stub
	}
	

}

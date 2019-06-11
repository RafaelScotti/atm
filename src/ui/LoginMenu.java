package ui;

import atm.IKeypad;
import atm.Keypad;

public class LoginMenu extends TipoMenu{

	IKeypad keypad = new Keypad();
	
	
	@Override
	public int show() {
		return 0;
		
	}


}

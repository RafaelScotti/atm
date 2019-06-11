package ui;

public class Menu {
	private TipoMenu tipoMenu;
	public Menu(TipoMenu tm) {
		this.tipoMenu = tm;
	}
	
	public int show() {
		return tipoMenu.show();
	}
}

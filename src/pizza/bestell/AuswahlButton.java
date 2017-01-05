package pizza.bestell;

import java.util.ArrayList;

import javax.swing.JRadioButton;

import pizza.pizza.Zutaten;

public class AuswahlButton extends JRadioButton {
	private Zutaten z;

	public AuswahlButton(String text, ArrayList<AuswahlButton> list, Zutaten z) {
		super(text);
		this.z = z;
		list.add(this);
	}

	public Zutaten getZutat() {
		return z;
	}
}

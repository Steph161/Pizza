
package pizza.bestell;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import layout.TableLayout;
import pizza.pizza.Size;
import pizza.pizza.Zutaten;

public class ExtraZutaten extends JPanel {

	private ArrayList<AuswahlButton> buttons;
	private int maxClicked;
	private boolean disabled = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Bestellung frame = new Bestellung();
					ExtraZutaten intFrame = new ExtraZutaten();
					frame.setContentPane(intFrame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExtraZutaten() {
		this.maxClicked = 7;
		setBounds(100, 100, 450, 300);
		int numZutaten = Zutaten.values().length;
		int height = (int) Math.ceil(Math.sqrt(numZutaten));
		int width = numZutaten / height;
		if (numZutaten % height != 0) {
			width++;
		}
		this.buttons = new ArrayList<>(numZutaten);
		double[] rows = new double[height];
		double[] cols = new double[width];

		Arrays.fill(rows, TableLayout.FILL);
		Arrays.fill(cols, TableLayout.FILL);

		this.setLayout(new TableLayout(new double[][] { cols, rows }));
		Zutaten[] zutaten = Zutaten.values();
		for (int w = 0; w < width; w++) {
			for (int h = 0; h < height && w * height + h < numZutaten; h++) {
				Zutaten z = zutaten[h + w * height];
				this.add(new AuswahlButton(z.name(), buttons, z), getConstraints(w, h));
			}
		}

		for (AuswahlButton btn : buttons) {
			btn.addActionListener(buttonClicked);
		}

	}

	/**
	 * Berechnet die Constraints für das Layout abh&auml;ngig von der Position
	 * 
	 * @param w
	 *            Die Spalte
	 * @param h
	 *            Die Zeile
	 * @return
	 */
	private String getConstraints(int w, int h) {
		return w + "," + h + ",c,c";
	}

	private ActionListener buttonClicked = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int check = checkAusgewaehlt();
		}
	};

	private int checkAusgewaehlt() {
		int check = 0;
		for (AuswahlButton btn : buttons) {
			if (btn.isSelected()) {
				check++;
			}
		}
		if (check >= maxClicked) {
			for (AuswahlButton btn : buttons) {
				if (!btn.isSelected()) {
					btn.setEnabled(false);
				}
			}
			disabled = true;
		} else if (check < maxClicked && disabled) {
			disabled = false;
			for (AuswahlButton btn : buttons) {
				if (!btn.isEnabled()) {
					btn.setEnabled(true);
				}
			}
		}
		check = maxClicked - check;
		if (check == 0) {
			enableButtons(false);
		} else if (check > 0) {
			enableButtons(true);
		} else if (check < 0) {
			enableButtons(false);
			JOptionPane.showMessageDialog(null, "Zu viele Zutaten!!!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		return maxClicked - check;
	}
	private void enableButtons(boolean enabled){
		this.disabled = !enabled;
		for(AuswahlButton btn : buttons){
			if(!btn.isSelected()){
				btn.setEnabled(enabled);
			}
		}
	}

	public ArrayList<Zutaten> getAusgewaehlt() {
		ArrayList<Zutaten> ret = new ArrayList<>(maxClicked);
		for (AuswahlButton btn : buttons) {
			if (btn.isSelected()) {
				ret.add(btn.getZutat());
			}
		}
		return ret;
	}

	public void setMaxZutaten(int maxZutaten) {
		this.maxClicked = maxZutaten;
		checkAusgewaehlt();
	}

	public void setMaxZutaten(Size maxZutaten) {
		setMaxZutaten(maxZutaten.getMax());
	}

}

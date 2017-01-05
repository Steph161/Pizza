package pizza.bestell;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JPanel;

import layout.TableLayout;
import pizza.pizza.Zutaten;

public class ExtraZutaten extends JPanel {

	private ArrayList<AuswahlButton> buttons;
	private int maxClicked;
	private boolean disabled = false;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Bestellung frame = new Bestellung();
					ExtraZutaten intFrame = new ExtraZutaten(3, e -> frame.setContentPane(new JPanel()));
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
	public ExtraZutaten(int maxZutaten, ActionListener finish) {
		this.maxClicked = maxZutaten;
		setBounds(100, 100, 450, 300);
		int numZutaten = Zutaten.values().length;
		int height = (int) Math.ceil(Math.sqrt(numZutaten));
		int width = numZutaten / height;
		if (numZutaten % height != 0) {
			width++;
		}
		this.buttons = new ArrayList<>(numZutaten);
		double[] rows = new double[height + 1];
		double[] cols = new double[width];

		Arrays.fill(rows, TableLayout.FILL);
		Arrays.fill(cols, TableLayout.FILL);

		this.setLayout(new TableLayout(new double[][] { cols, rows }));
		Zutaten[] zutaten = Zutaten.values();
		for (int h = 0; h < width; h++) {
			for (int w = 0; w < height && h * height + w < numZutaten; w++) {
				Zutaten z = zutaten[w + h * height];
				this.add(new AuswahlButton(z.name(), buttons, z), getConstraints(h, w));
			}
		}

		btnClose = new JButton("Finish");
		btnClose.addActionListener(finish);
		this.add(btnClose, width / 2 + "," + height + ",f,c");
		for (AuswahlButton btn : buttons) {
			btn.addActionListener(buttonClicked);
		}

	}

	private String getConstraints(int h, int w) {
		return w + "," + h + ",c,c";
	}

	private ActionListener buttonClicked = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int clicked = 0;
			for (AuswahlButton btn : buttons) {
				if (btn.isSelected()) {
					clicked++;
				}
			}
			if (clicked >= maxClicked) {
				for (AuswahlButton btn : buttons) {
					if (!btn.isSelected()) {
						btn.setEnabled(false);
					}
				}
				disabled = true;
			} else if (clicked < maxClicked && disabled) {
				disabled = false;
				for (AuswahlButton btn : buttons) {
					if (!btn.isEnabled()) {
						btn.setEnabled(true);
					}
				}
			}
		}
	};
	
	private ArrayList<Zutaten> getAusgewaehlt(){
		ArrayList<Zutaten> ret = new ArrayList<>(maxClicked);
		for(AuswahlButton btn : buttons){
			if(btn.isSelected()){
				ret.add(btn.getZutat());
			}
		}
		return ret;
	}

}

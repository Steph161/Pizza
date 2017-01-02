package pizza.bestell;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import layout.TableLayout;
import pizza.pizza.Zutaten;

import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.JCheckBox;

public class ExtraZutaten extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExtraZutaten frame = new ExtraZutaten();
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
		setBounds(100, 100, 450, 300);
		int numZutaten = Zutaten.values().length;

		int width = (int) Math.ceil(Math.sqrt(numZutaten));
		int height = numZutaten / width;
		if (numZutaten % width != 0) {
			height++;
		}

		double[] rows = new double[width];
		double[] cols = new double[height];
		
		Arrays.fill(rows, TableLayout.FILL);
		Arrays.fill(cols, TableLayout.FILL);

		getContentPane().setLayout(new TableLayout(new double[][] { cols, rows }));

	}

}

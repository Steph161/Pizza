package pizza.bestell;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import pizza.pizza.Typ;
import layout.TableLayout;

public class Bestellung extends JFrame {

	private JPanel mainBestellFrame;
	private ExtraZutaten extraZutatenFrame;
	private JRadioButton btnSmall, btnNormal, btnXXL;
	private ButtonGroup groupSize;
	private JComboBox<Typ> types;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bestellung frame = new Bestellung();
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
	public Bestellung() {
		setTitle("Bestellung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(640, 480);
		setMinimumSize(new Dimension(450, 300));
		mainBestellFrame = new JPanel();
		mainBestellFrame.setBorder(new EmptyBorder(5, 5, 5, 5));

		double f = TableLayout.FILL;
		int height = 30;
		int width = 100;

		double[] col = new double[] { width, width, width, width, f };
		double[] row = new double[] { 20, height, height, f, height, f, height, f, height, height };
		double[][] size = new double[][] { col, row };

		mainBestellFrame.setLayout(new TableLayout(size));
		setContentPane(mainBestellFrame);

		// Buttons
		mainBestellFrame.add(getBtnSmall(), "1, 2, c, c");
		mainBestellFrame.add(getBtnNormal(), "2, 2, c, c");
		mainBestellFrame.add(getBtnXXL(), "3, 2, c, c");

		// Button Labels
		mainBestellFrame.add(new JLabel("Small"), "1, 1, c, c");
		mainBestellFrame.add(new JLabel("Normal"), "2, 1, c, c");
		mainBestellFrame.add(new JLabel("XXL"), "3, 1, c, c");

		// Pizzen Dropdown List
		mainBestellFrame.add(getTypes(), "1,4,3,c");
		mainBestellFrame.add(new JLabel("Pizzen:  ", JLabel.RIGHT), "0,4,f,c");

	}

	private JRadioButton getBtnSmall() {
		if (btnSmall == null) {
			btnSmall = new JRadioButton();
			getGroupSize().add(btnSmall);
		}
		return btnSmall;
	}

	private JRadioButton getBtnNormal() {
		if (btnNormal == null) {
			btnNormal = new JRadioButton();
			getGroupSize().add(btnNormal);
		}
		return btnNormal;
	}

	private JRadioButton getBtnXXL() {
		if (btnXXL == null) {
			btnXXL = new JRadioButton();
			getGroupSize().add(btnXXL);
		}
		return btnXXL;
	}

	private ButtonGroup getGroupSize() {
		if (groupSize == null) {
			groupSize = new ButtonGroup();
		}
		return groupSize;
	}

	private JComboBox<Typ> getTypes() {
		if (types == null) {
			types = new JComboBox<>(Typ.values());
		}
		return types;
	}

}

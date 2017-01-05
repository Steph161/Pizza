package pizza.bestell;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pizza.getraenk.gTyp;
import pizza.pizza.Size;
import pizza.pizza.Typ;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JComboBox;

public class Bestellung extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JPanel panelZutaten;

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
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Auswahl Gr��e
		JRadioButton rdbtnSmall = new JRadioButton("small");
		buttonGroup.add(rdbtnSmall);
		rdbtnSmall.setBounds(16, 55, 75, 34);
		contentPane.add(rdbtnSmall);
		
		JRadioButton rdbtnNormal = new JRadioButton("normal");
		buttonGroup.add(rdbtnNormal);
		rdbtnNormal.setBounds(16, 92, 75, 34);
		contentPane.add(rdbtnNormal);
		
		JRadioButton rdbtnXxl = new JRadioButton("XXL");
		buttonGroup.add(rdbtnXxl);
		rdbtnXxl.setBounds(16, 129, 75, 34);
		contentPane.add(rdbtnXxl);
		
		JLabel lblPizzabestellung = new JLabel("Pizzabestellung");
		lblPizzabestellung.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPizzabestellung.setBounds(16, 11, 153, 23);
		contentPane.add(lblPizzabestellung);
		
		JLabel lblPizzen = new JLabel("Pizzen:");
		lblPizzen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPizzen.setBounds(16, 194, 57, 23);
		contentPane.add(lblPizzen);
		
		JComboBox comboBox = new JComboBox(Typ.values());		
		comboBox.setBounds(71, 196, 142, 20);
		contentPane.add(comboBox);
		
		
		JLabel lblGetraenke = new JLabel("Getr�nke");
		lblGetraenke.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGetraenke.setBounds(459, 12, 106, 20);
		contentPane.add(lblGetraenke);
		
		JRadioButton rdbtnSmalll = new JRadioButton("small (0,25l)");
		buttonGroup_1.add(rdbtnSmalll);
		rdbtnSmalll.setBounds(459, 61, 109, 23);
		contentPane.add(rdbtnSmalll);
		
		JRadioButton rdbtnNormalll = new JRadioButton("normall (0,5l)");
		buttonGroup_1.add(rdbtnNormalll);
		rdbtnNormalll.setBounds(459, 98, 109, 23);
		contentPane.add(rdbtnNormalll);
		
		JLabel lblGetraenk = new JLabel("Getr�nk:");
		lblGetraenk.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGetraenk.setBounds(459, 196, 62, 18);
		contentPane.add(lblGetraenk);
		
		JComboBox comboBox_1 = new JComboBox(gTyp.values());
		comboBox_1.setBounds(531, 196, 136, 20);
		contentPane.add(comboBox_1);
		
//		panelZutaten = new ExtraZutaten();
//		panelZutaten.setBounds(16, 274, 362, 278);
//		contentPane.add(panelZutaten);
	}
}

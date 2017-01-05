package pizza.best;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
		
		//Auswahl Größe
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(71, 196, 142, 20);
		contentPane.add(comboBox);
	}
}

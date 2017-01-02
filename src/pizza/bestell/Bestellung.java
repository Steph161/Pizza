package pizza.bestell;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Bestellung extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup sizeButtons = new ButtonGroup();

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
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{16, 0, 0, 0, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JRadioButton rdbtnSmall = new JRadioButton("small");
		sizeButtons.add(rdbtnSmall);
		GridBagConstraints gbc_rdbtnSmall = new GridBagConstraints();
		gbc_rdbtnSmall.anchor = GridBagConstraints.WEST;
		gbc_rdbtnSmall.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnSmall.gridx = 1;
		gbc_rdbtnSmall.gridy = 1;
		contentPane.add(rdbtnSmall, gbc_rdbtnSmall);
		
		JRadioButton rdbtnNormal = new JRadioButton("normal");
		sizeButtons.add(rdbtnNormal);
		GridBagConstraints gbc_rdbtnNormal = new GridBagConstraints();
		gbc_rdbtnNormal.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNormal.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNormal.gridx = 1;
		gbc_rdbtnNormal.gridy = 2;
		contentPane.add(rdbtnNormal, gbc_rdbtnNormal);
		
		JRadioButton rdbtnXxl = new JRadioButton("XXL");
		sizeButtons.add(rdbtnXxl);
		GridBagConstraints gbc_rdbtnXxl = new GridBagConstraints();
		gbc_rdbtnXxl.anchor = GridBagConstraints.WEST;
		gbc_rdbtnXxl.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnXxl.gridx = 1;
		gbc_rdbtnXxl.gridy = 3;
		contentPane.add(rdbtnXxl, gbc_rdbtnXxl);
		
		JLabel lblPizza = new JLabel("Pizza:");
		GridBagConstraints gbc_lblPizza = new GridBagConstraints();
		gbc_lblPizza.anchor = GridBagConstraints.WEST;
		gbc_lblPizza.insets = new Insets(0, 0, 5, 5);
		gbc_lblPizza.gridx = 1;
		gbc_lblPizza.gridy = 5;
		contentPane.add(lblPizza, gbc_lblPizza);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 5;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 5;
		contentPane.add(comboBox, gbc_comboBox);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 53;
		gbc_textField.gridy = 27;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
	}

}

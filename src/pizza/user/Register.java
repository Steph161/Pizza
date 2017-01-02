package pizza.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 294, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setBounds(34, 8, 46, 14);
		contentPane.add(lblVorname);
		
		textField = new JTextField();
		textField.setBounds(114, 5, 158, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNachname = new JLabel("Nachname:");
		lblNachname.setBounds(30, 33, 54, 14);
		contentPane.add(lblNachname);
		
		textField_1 = new JTextField();
		textField_1.setBounds(114, 30, 158, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setBounds(36, 58, 43, 14);
		contentPane.add(lblAdresse);
		
		textField_2 = new JTextField();
		textField_2.setBounds(114, 55, 158, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setBounds(38, 83, 20, 14);
		contentPane.add(lblOrt);
		
		textField_3 = new JTextField();
		textField_3.setBounds(114, 80, 158, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPlz = new JLabel("PLZ:");
		lblPlz.setBounds(38, 108, 21, 14);
		contentPane.add(lblPlz);
		
		textField_4 = new JTextField();
		textField_4.setBounds(114, 105, 158, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}
}

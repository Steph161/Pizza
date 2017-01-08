package pizza.user;

import static org.junit.Assert.assertNotEquals;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pizza.bestell.Bestellung;
import pizza.test.TestRegister;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtTel;
	private ArrayList<Kunde> kunden;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 192, 80);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtTel = new JTextField();
		txtTel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					Login.this.changer();
				}
			}
		});
		txtTel.setBounds(73, 11, 93, 20);
		contentPane.add(txtTel);
		txtTel.setColumns(10);

		JLabel lblNummer = new JLabel("Nummer:");
		lblNummer.setBounds(10, 13, 65, 17);
		contentPane.add(lblNummer);

		readKunden();
		// TODO Kunden einlesen
	}

	protected void changer() {

		if (checkUser(txtTel.getText())) {
			Bestellung b = new Bestellung();
			b.setVisible(true);
			this.dispose();
		} else {
			Kunde tmp = createUser(txtTel.getText());
			if (tmp == null) {
				System.out.println("123");
			}
			this.dispose();
		}

		// TODO Einloggen falls Kunde mit Nummer vorhanden, sonst neuen Kunden
		// anlegen

	}

	/**
	 * Checks if user with number exists, and creates a new if not
	 * 
	 * @param phoneNumer
	 */
	private boolean checkUser(String phoneNumer) {
		for (Kunde k : kunden) {
			if (k.getNummer().equals(phoneNumer)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Opens new Register Window
	 * 
	 * @param number
	 */
	private Kunde createUser(String number) {
		Register r = new Register("12345678").showRegister();
		BufferedWriter b;
		Kunde k = null;

		try {
			b = new BufferedWriter(new FileWriter("pizza.txt", true));
			// TODO Kunde von Register getten und mit BufferedWriter in Datei
			// schreiben
			// this.setVisible(false);
//			k = r.getKundeAndClose();
			// b.write(r.getKundeAndClose().toString());
			b.newLine();
			b.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return k;

	}

	/**
	 * Liest Kunden ein
	 */
	private void readKunden() {
		kunden = new ArrayList<>();
		File f = new File("pizza.txt");
		BufferedReader b;
		String line;
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			b = new BufferedReader(new FileReader("pizza.txt"));

			while ((line = b.readLine()) != null) {
				if (line.equals("")) {
					continue;
				}
				Kunde k = Kunde.valueOf(line);
				kunden.add(k);
			}
			b.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}

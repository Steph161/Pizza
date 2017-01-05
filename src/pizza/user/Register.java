package pizza.user;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import layout.TableLayout;
import layout.TableLayoutConstraints;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txtVorname;
	private JTextField txtNachname;
	private JTextField txtAdresse;
	private JTextField txtOrt;
	private JTextField txtPlz;
	private String nummer;
	private boolean ready = false;

	/**
	 * Create the frame.
	 */
	public Register(String nummer) {
		this.nummer = nummer;
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 294, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final double f = TableLayout.FILL;
		contentPane.setLayout(new TableLayout(new double[][] { { 125, f }, { f, f, f, f, f } }));

		JLabel lblVorname = new JLabel("Vorname: ");
		lblVorname.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblVorname, new TableLayoutConstraints("0,0,c,c"));

		txtVorname = new JTextField();
		contentPane.add(txtVorname, new TableLayoutConstraints("1,0,f,c"));
		txtVorname.setColumns(10);

		JLabel lblNachname = new JLabel("Nachname: ");
		lblNachname.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNachname, new TableLayoutConstraints("0,1,c,c"));

		txtNachname = new JTextField();
		contentPane.add(txtNachname, new TableLayoutConstraints("1,1,f,c"));
		txtNachname.setColumns(10);

		JLabel lblAdresse = new JLabel("Adresse: ");
		lblAdresse.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblAdresse, new TableLayoutConstraints("0,2,c,c"));

		txtAdresse = new JTextField();
		contentPane.add(txtAdresse, new TableLayoutConstraints("1,2,f,c"));
		txtAdresse.setColumns(10);

		JLabel lblOrt = new JLabel(" Ort: ");
		lblOrt.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblOrt, new TableLayoutConstraints("0,3,c,c"));

		txtOrt = new JTextField();
		contentPane.add(txtOrt, new TableLayoutConstraints("1,3,f,c"));
		txtOrt.setColumns(10);

		JLabel lblPlz = new JLabel("PLZ: ");
		lblPlz.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblPlz, new TableLayoutConstraints("0,4,c,c"));

		txtPlz = new JTextField();
		contentPane.add(txtPlz, new TableLayoutConstraints("1,4,f,c"));
		txtPlz.setColumns(10);

		txtVorname.addKeyListener(new JumpToOnEnter(txtNachname));
		txtNachname.addKeyListener(new JumpToOnEnter(txtAdresse));
		txtAdresse.addKeyListener(new JumpToOnEnter(txtOrt));
		txtOrt.addKeyListener(new JumpToOnEnter(txtPlz));
		txtPlz.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					ready = true;
				}
			}
		});

	}

	public Kunde getKundeAndClose() {
		Kunde k = null;
		while (!ready) {
			delay();
			try {
				int plz = Integer.parseInt(txtPlz.getText());

				k = new Kunde(nummer, txtVorname.getText(), txtNachname.getText(), txtAdresse.getText(),
						txtOrt.getText(), plz);
			} catch (NullPointerException | NumberFormatException e) {
				ready = false;
				JOptionPane.showMessageDialog(this, "Please fill out all Fields, PLZ may only contain numbers", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		}
		this.dispose();
		return k;
	}

	private void delay() {
		do {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!ready);
	}

}

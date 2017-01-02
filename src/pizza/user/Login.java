package pizza.user;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtTel;

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
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					Login.changer();
				}
			}
		});
		txtTel.setBounds(73, 11, 93, 20);
		contentPane.add(txtTel);
		txtTel.setColumns(10);
		
		JLabel lblNummer = new JLabel("Nummer:");
		lblNummer.setBounds(10, 13, 65, 17);
		contentPane.add(lblNummer);
	}
	protected static void changer() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Checks if user with number exists, and creates a new if not
	 * @param phoneNumer
	 */
	private void checkUser(String phoneNumer){
		File f = new File("D:\\3CHEL\\FSST\\Pizza\\pizza.txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Opens new Register Window
	 * @param number
	 */
	private void createUser(String number){
		Register r = new Register();

	}

 }

package pizza.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import pizza.user.Kunde;
import pizza.user.Login;
import pizza.user.Register;

public class Main {

	public static void main(String[] args) {
		Login login = new Login();
		login.setVisible(true);
		Kunde k = login.doLogin();
		login.dispose();
		if(k == null){
			//Register
			Register r = new Register(login.getNummer());
			r.setVisible(true);
			k = r.getKundeAndClose();
			try(BufferedWriter br = new BufferedWriter(new FileWriter("pizza.txt",true))){
				br.write(k.toString());
				br.write(System.lineSeparator());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}

}
